package com.hbst.basessm_1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hbst.basessm_1.dao.IBaseDao;
import com.hbst.basessm_1.util.constant.CodeConstant;
import com.hbst.basessm_1.util.exception.BusinessException;

import net.sf.json.JSONObject;

@Repository("baseDao")
public class BaseDao implements IBaseDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private long ROW_NUMBER = 0;
	
	private long ZERO = 0;
	
	
	public boolean insert(String statement, Object parameter) {
		
		if (null == parameter || null == statement) {
			throw new IllegalArgumentException(" Parameter Is Null.");
		}
		ROW_NUMBER = sqlSessionTemplate.insert(statement, parameter);
		return ROW_NUMBER > ZERO ? true : false;
	}
	

	
	
	public boolean update(String statement, Object parameter) {
		
		if (null == parameter || null == statement) {
			throw new IllegalArgumentException(" Parameter Is Null.");
		}
		ROW_NUMBER = sqlSessionTemplate.update(statement, parameter);
		return ROW_NUMBER > ZERO ? true : false;
	}
	
	public boolean delete(String statement, Object parameter) {
		
		if (null == parameter || null == statement) {
			throw new IllegalArgumentException(" Parameter Is Null.");
		}
		ROW_NUMBER = sqlSessionTemplate.delete(statement, parameter);
		return ROW_NUMBER > ZERO ? true : false;
	}
	
	public Object findOneByCustom(String statement, Object parameter) {
		
		if (null == parameter || null == statement) {
			throw new IllegalArgumentException(" Parameter Is Null.");
		}
		return sqlSessionTemplate.selectOne(statement, parameter);
	}
 
	public <T> List<T> findListByCustom(String statement, Object parameter) {
		

		if (null == parameter || null == statement) {
			throw new IllegalArgumentException(" Parameter Is Null.");
		}
		return sqlSessionTemplate.selectList(statement, parameter);
	}
	@SuppressWarnings("unchecked")
	public  Map<String,Object> findPageByCustom(String statement, Object parameter) {
		

		if (null == parameter || null == statement) {
			throw new IllegalArgumentException(" Parameter Is Null.");
		}
		HashMap<String,Object> retMap = new HashMap<String,Object>();
		//是否为分页查询
		JSONObject jsonObject = JSONObject.fromObject(parameter);
		if (!(jsonObject.containsKey("pageNO") && null != jsonObject.get("pageNO")
				&& jsonObject.containsKey("records") && null != jsonObject.get("records"))) {
			throw new BusinessException(CodeConstant.PARAMS_ERROR);
		}
		Integer pageNO = (Integer) jsonObject.get("pageNO") ;
		Integer records = (Integer) jsonObject.get("records");
		if(pageNO!=null && pageNO>0 && records!=null && records>0){
			retMap.put("recordsTotal", this.getTotalCount(statement, parameter));
			retMap.put("data",sqlSessionTemplate.selectList(statement, parameter));
			return retMap;
		}
		retMap.put("data",sqlSessionTemplate.selectList(statement, parameter));
		return retMap;
	}
	 /**
     * get total count
     * 
     * @param sqlSession
     * @param statementName
     * @param values
     * @return
     */
    private Integer getTotalCount(String statementName, Object values) {
    	 Map parameterMap = toParameterMap(values);
         Integer count = 0;
         try {
             MappedStatement mst = sqlSessionTemplate.getSqlSessionFactory()
                     .getConfiguration().getMappedStatement(statementName);
             BoundSql boundSql = mst.getBoundSql(parameterMap);
             String sql = " select count(*) total_count from ("
                     + boundSql.getSql() + ") as total";
              
             Connection con = SqlSessionUtils  
            		    .getSqlSession(sqlSessionTemplate.getSqlSessionFactory(), sqlSessionTemplate.getExecutorType(),sqlSessionTemplate.getPersistenceExceptionTranslator())  
            		    .getConnection();  
             PreparedStatement pstmt = con.prepareStatement(sql);
             // BoundSql countBS = new
             // BoundSql(mst.getConfiguration(),sql,boundSql.getParameterMappings(),parameterMap);
             setParameters(pstmt, mst, boundSql, parameterMap);
             ResultSet rs = pstmt.executeQuery();
             if (rs.next()) {
                 count = rs.getInt("total_count");
             }
             rs.close();
             con.close();
             pstmt.close();
         } catch (Exception e) {
             count = 0;
             e.printStackTrace();
             throw new RuntimeException(e);
         }
         return count;
    }
 
    /**
     * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.
     * DefaultParameterHandler
     * 
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps,
            MappedStatement mappedStatement, BoundSql boundSql,
            Object parameterObject) throws SQLException {
        ErrorContext.instance().activity("setting parameters")
                .object(mappedStatement.getParameterMap().getId());
        List<ParameterMapping> parameterMappings = boundSql
                .getParameterMappings();
        if (parameterMappings != null) {
            Configuration configuration = mappedStatement.getConfiguration();
            TypeHandlerRegistry typeHandlerRegistry = configuration
                    .getTypeHandlerRegistry();
            MetaObject metaObject = parameterObject == null ? null
                    : configuration.newMetaObject(parameterObject);
            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                if (parameterMapping.getMode() != ParameterMode.OUT) {
                    Object value;
                    String propertyName = parameterMapping.getProperty();
                    PropertyTokenizer prop = new PropertyTokenizer(propertyName);
                    if (parameterObject == null) {
                        value = null;
                    } else if (typeHandlerRegistry
                            .hasTypeHandler(parameterObject.getClass())) {
                        value = parameterObject;
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        value = boundSql.getAdditionalParameter(propertyName);
                    } else if (propertyName
                            .startsWith(ForEachSqlNode.ITEM_PREFIX)
                            && boundSql.hasAdditionalParameter(prop.getName())) {
                        value = boundSql.getAdditionalParameter(prop.getName());
                        if (value != null) {
                            value = configuration.newMetaObject(value)
                                    .getValue(
                                            propertyName.substring(prop
                                                    .getName().length()));
                        }
                    } else {
                        value = metaObject == null ? null : metaObject
                                .getValue(propertyName);
                    }
                    TypeHandler typeHandler = parameterMapping.getTypeHandler();
                    if (typeHandler == null) {
                        throw new ExecutorException(
                                "There was no TypeHandler found for parameter "
                                        + propertyName + " of statement "
                                        + mappedStatement.getId());
                    }
                    typeHandler.setParameter(ps, i + 1, value,
                            parameterMapping.getJdbcType());
                }
            }
        }
    }
 
    protected Map toParameterMap(Object parameter) {
        if (parameter == null) {
            return new HashMap();
        }
        if (parameter instanceof Map) {
            return (Map<?, ?>) parameter;
        } else {
            try {
                return PropertyUtils.describe(parameter);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }


	

}
