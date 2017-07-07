package com.hbst.basessm_1.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbst.basessm_1.service.IUserService;
import com.hbst.basessm_1.util.baseUtil.ResourceUtils;
import com.hbst.basessm_1.util.constant.CodeConstant;
import com.hbst.basessm_1.util.constant.CommonConstant;
import com.hbst.basessm_1.util.entity.ResultMessage;
import com.hbst.basessm_1.util.exception.BusinessException;
import com.hbst.basessm_1.util.log.ISCLog;
import com.hbst.basessm_1.util.log.impl.SCLogger;

import net.sf.json.JSONObject;

/**
 * @author Dean 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private static final ISCLog logger = new SCLogger(UserController.class);
	@Resource
	private IUserService userService;
	
	/**
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryUser.do", method = RequestMethod.POST)
	public Object queryUser(HttpServletRequest request, HttpServletResponse response) {
		logger.begin();
		ResultMessage message = new ResultMessage();
		try {
			JSONObject json = new JSONObject();
			json.put("user", "lishun");
			// 获取Session对象
				message = userService.queryUser(json);
		} catch (BusinessException e) {
			message.setCode(e.getErrorCode());
			message.setCodeDesc(e.getErrorDes());
			logger.error(e);
		} catch (Exception e) {
			message.setCode(CodeConstant.SYSTEM_ERROR);
			message.setCodeDesc(ResourceUtils.getResultCodeDesc(CodeConstant.SYSTEM_ERROR));
			logger.error(e);
		}
		logger.end();
		return message;
	}
	
}
