package com.hbst.basessm_1.dao.plugin;


import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import net.sf.json.JSONObject;  

/**
 * @author tangguilin
 * 分页拦截器
 */
@Intercepts({
	 @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}),  
	 @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})  
public class PageInterceptor implements Interceptor {  

	public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof StatementHandler) {  
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();  
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
            //获取参数对象
            DefaultParameterHandler parameterHander=(DefaultParameterHandler) metaStatementHandler.getValue("delegate.parameterHandler");
            Object parameterObject = parameterHander.getParameterObject();
            JSONObject jsonParameter = JSONObject.fromObject(parameterObject);
            //是否分页
            if(jsonParameter!=null && jsonParameter.has("pageNO")){
            	Integer pageNO = jsonParameter.getInt("pageNO");
                Integer records = jsonParameter.getInt("records");
            	BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            	String sql = boundSql.getSql();
            	StringBuffer sb=new StringBuffer();
        		sb.append(sql);
        		sb.append(" limit ").append((pageNO-1)*records).append(" , ").append(records);
        		metaStatementHandler.setValue("delegate.boundSql.sql", sb.toString()); 
            }
        }
		return invocation.proceed();
	}
	
	/**
     * 拦截类型StatementHandler 
     */
	public Object plugin(Object target) {
		if (target instanceof StatementHandler) {  
            return Plugin.wrap(target, this);  
        } else {  
            return target;  
        }  
	}
	
	public void setProperties(Properties properties) {
		
	}  
}  