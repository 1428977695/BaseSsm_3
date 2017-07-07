package com.hbst.basessm_1.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao {
	
	/**
	 * @Author:Dean
	 * @Description:保存
	 * @param statement
	 *            SQLID
	 * @param parameter
	 *            参数
	 * @return boolean true 成功，false 失败
	 * @Date 2015年12月31日
	 */
	public boolean insert(String statement, Object parameter);
	
	
	
	
	/**
	 * @Author:Dean
	 * @Description:更新
	 * @param statement
	 *            SQLID
	 * @param parameter
	 *            参数
	 * @return boolean true 成功，false 失败
	 * @Date 2015年12月31日
	 */
	public boolean update(String statement, Object parameter);
	
	/**
	 * @Author:Dean
	 * @Description:删除
	 * @param statement
	 *            SQLID
	 * @param parameter
	 *            参数
	 * @return boolean true 成功，false 失败
	 * @Date 2015年12月31日
	 */
	public boolean delete(String statement, Object parameter);
	
	/**
	 * @Author:Dean
	 * @Description:查询单条数据
	 * @param statement
	 *            SQLID
	 * @param parameter
	 *            参数
	 * @return Object
	 * @Date 2015年12月31日
	 */
	public Object findOneByCustom(String statement, Object parameter);
	
	/**
	 * @param <T>
	 * @Author:Dean
	 * @Description: 查询集合列表
	 * @param statement
	 *            SQLID
	 * @param parameter
	 *            参数
	 * @return List<Object>
	 * @Date 2015年12月31日
	 */
	public <T> List<T> findListByCustom(String statement, Object parameter);
	/**
	 * @param <T>
	 * @Author:Dean
	 * @Description: 分页查询
	 * @param statement
	 *            SQLID
	 * @param parameter
	 *            参数
	 * @return List<Object>
	 * @Date 2015年12月31日
	 */
	public Map<String,Object> findPageByCustom(String statement, Object parameter);

}
