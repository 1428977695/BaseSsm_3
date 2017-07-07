package com.hbst.basessm_1.util.exception;

import com.hbst.basessm_1.util.baseUtil.ResourceUtils;
import com.hbst.basessm_1.util.constant.CodeConstant;

/**
 * 系统自定义异常类。
 * 
 * 
 * 
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * 错误码。
	 */
	private String errorCode;

	/**
	 * 问题
	 */
	private String errorDes;

	/**
	 * 指定错误码与错误描述的异常。
	 * 
	 * @param errorCode
	 *            错误码
	 * @param msg
	 *            异常信息
	 */
	public BusinessException(String errorCode, String msg) {
		super(msg);
		this.errorCode = errorCode;
		this.errorDes = msg;
	}
	
	/**
	 * 指定错误码与错误描述的异常。
	 * 
	 * @param errorCode
	 *            错误码
	 * @param msg
	 *            异常信息
	 */
	public BusinessException(String errorCode) {
		super(ResourceUtils.getResultCodeDesc(errorCode));
		this.errorCode = errorCode;
		this.errorDes = (ResourceUtils.getResultCodeDesc(errorCode));
	}

	/**
	 * 未定义异常。
	 */
	public BusinessException() {

		super(ResourceUtils.getResultCodeDesc(CodeConstant.SYSTEM_ERROR));
		this.errorCode = CodeConstant.SYSTEM_ERROR;
	}


	public String getErrorDes() {
		return errorDes;
	}

	public void setErrorDes(String errorDes) {
		this.errorDes = errorDes;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
