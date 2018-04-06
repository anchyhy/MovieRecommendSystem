package com.lzs.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import ognl.DefaultTypeConverter;

/**
 * 
 * @author Yahui Lu
 *
 *         This class is used to convert a string to an object of
 *         java.util.Date.
 */
public class DateConverter extends DefaultTypeConverter {
	@Override
	public Object convertValue(Map context, Object value, Class toType) {
		if (toType == Date.class) {
			String dateStr = ((String[]) value)[0];
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			try{
				return dateFormat.parse(dateStr);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return super.convertValue(context, value, toType);
	}
}
