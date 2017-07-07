package com.hbst.basessm_1.util.entity;

import java.io.Serializable;

/**
 * 返回消息实体对象定义
 * 
 * @author Dean 20160912
 */
public class ResultMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	// 成功或失败的错误码，成功时返回000000
	private String code;

	// 失败时返回的错误消息
	private String codeDesc;

	// 当需要返回值时返回值对象，如果是查询列表，则返回queryList对象
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ResultMessage [code=" + code + ", codeDes=" + codeDesc + ", data=" + data + "]";
	}

}
