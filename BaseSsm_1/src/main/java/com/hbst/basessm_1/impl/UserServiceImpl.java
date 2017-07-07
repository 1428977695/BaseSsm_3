package com.hbst.basessm_1.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hbst.basessm_1.dao.IBaseDao;
import com.hbst.basessm_1.pojo.User;
import com.hbst.basessm_1.service.IUserService;
import com.hbst.basessm_1.util.baseUtil.StringUtil;
import com.hbst.basessm_1.util.constant.CodeConstant;
import com.hbst.basessm_1.util.constant.CommonConstant;
import com.hbst.basessm_1.util.entity.ResultMessage;
import com.hbst.basessm_1.util.exception.BusinessException;
import com.hbst.basessm_1.util.log.ISCLog;
import com.hbst.basessm_1.util.log.impl.SCLogger;

import net.sf.json.JSONObject;

/**
 * 物料类型接口
 * 
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService{

	private static final ISCLog logger = new SCLogger(UserServiceImpl.class);

	@Autowired
	private IBaseDao baseDao;

	/**
	 * 
	 * 
	 * @return
	 */
	@Override
	public ResultMessage queryUser(Object jsonParameter) throws Exception {
		logger.begin();
		if (StringUtil.isEmpty(jsonParameter)) {
			throw new BusinessException(CodeConstant.PARAMS_ERROR);
		}
		logger.debug("Parameter is:", jsonParameter);
		//检查参数是否为空
		// 检查参数是否存在且符合不允许为空的规则
		JSONObject jsonObject = JSONObject.fromObject(jsonParameter);
		// 获取参数，确保参数的正确性
		User user = (User) baseDao.findOneByCustom("selectUser", jsonObject);
		
		ResultMessage message=new ResultMessage();
		
		JSONObject resultJsonObject = new JSONObject();
		resultJsonObject.put(CommonConstant.QUERY_LIST_NAME, user);
		
		logger.debug("Object Conversion Json Result:", resultJsonObject.toString());
		message.setCode(CodeConstant.SUCCESS);
		message.setData(resultJsonObject);
		logger.end();
		return message;
	}
	

	

}
