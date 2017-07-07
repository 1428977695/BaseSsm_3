package com.hbst.basessm_1.util.baseUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public final class ResourceUtils {
	private static final String POSTFIX_DESC = ".desc";
	private static Properties props;

	static {

		try {
			props = PropertiesLoaderUtils.loadAllProperties("msg_exception.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getResultCodeDesc(String resultCode) {
		if (props != null) {
			String errorkey = resultCode;
			String errorDesc = null;
			try {
				errorDesc = new String(props.getProperty(errorkey).getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			return errorDesc;
		} else {
			return "system error";
		}
	}

}
