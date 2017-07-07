
package com.hbst.basessm_1.util.baseUtil;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;

public class BeanUtil extends BeanUtils {
	
	static
	
	{
		ConvertUtils.register(new DateConverterExt(), java.util.Date.class);
		ConvertUtils.register(new  DateConverter(), java.sql.Date.class);
		ConvertUtils.register(new BigDecimalConverter(), BigDecimal.class);
	}
	
	public static <T> Object copyProperties(Class<T> cla, Object obj) {
		
		try {
			T t = cla.newInstance();
			BeanUtils.copyProperties(t, obj);
			return t;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
