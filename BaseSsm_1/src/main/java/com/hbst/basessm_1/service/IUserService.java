package com.hbst.basessm_1.service;

import com.hbst.basessm_1.util.entity.ResultMessage;



/**
 * 
 */
public interface IUserService {

	/**
	 * 查询通用代码主表列表
	 * @return
	 */
	public abstract ResultMessage queryUser(Object jsonParameter) throws Exception; 

	
}
