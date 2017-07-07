package com.hbst.basessm_1.util.baseUtil;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.time.DateUtils;
public class DateConverterExt implements Converter {
	
	public DateConverterExt() {
	}
	
	@SuppressWarnings("rawtypes")
	public Object convert(Class type, Object value) {
		
		if (value == null) {
			return new Date();
		}
		
		if (value instanceof Date) {
			return value;
		}
		
		if (value instanceof Long) {
			Long longValue = (Long) value;
			return new Date(longValue.longValue());
		}
		
		try {
			return DateUtils.parseDate(value.toString(), new String[] { "yyyy-MM-dd HH:mm:ss.s","yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd","MM/dd/yyyy" });
		} catch (Exception e) {
			throw new ConversionException(e);
		}
	}
	
}
