package com.hbst.basessm_1.util.baseUtil;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Title: 处理日期工具类
 * </p>
 * <p>
 * Description: 处理日期工具类
 * </p>
 * 
 * @version 1.00
 */
public class DateUtil {

	/**
	 * 检查字符串是否为yyyyMMdd格式的日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static boolean isNotShortDate(String dateStr) {
		if (null == dateStr || dateStr.equals("")) {
			return true;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			sdf.parse(dateStr);
			return false;
		} catch (java.text.ParseException e) {
			return true;
		}
	}

	/**
	 * 检查日期格式字符串是否为有效的yyyyMMddHHmmss格式
	 * 
	 * @param dateTime
	 * @return
	 */
	public static boolean isNotFullDateTime(String dateTime) {
		if (null == dateTime || dateTime.equals("")) {
			return true;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			sdf.parse(dateTime);
			return false;
		} catch (java.text.ParseException e) {
			return true;
		}
	}

	private DateUtil() {
	}

	public static DateFormat getDefaultDateFormat() {
		return new SimpleDateFormat("yyyy-MM-dd");
	}

	public static DateFormat getDefaultTimeFormat() {
		return new SimpleDateFormat("HH:mm:ss");
	}

	public static DateFormat getDefaultDateTimeFormat() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	}

	/**
	 * @param date
	 *            日期类型
	 * @param dateFormat
	 *            日期格式
	 * @return 格式化字符串
	 */
	public synchronized static String date2String(Date date, DateFormat dateFormat) {
		if (date == null)
			return null;
		return dateFormat.format(date);
	}

	/**
	 * @param date
	 *            日期类型
	 * @param dateFormat
	 *            日期格式
	 * @return 格式化字符串
	 */
	public static String date2String(Date date, String dateFormat) {
		if (date == null)
			return null;
		return date2String(date, new SimpleDateFormat(dateFormat));
	}

	/**
	 * @param date
	 *            日期类型
	 * @return 格式化字符串
	 */
	public static String date2String(Date date) {
		if (date == null)
			return null;
		return date2String(date, getDefaultDateFormat());
	}

	/**
	 * @param time
	 *            时间类型
	 * @param dateFormat
	 *            时间格式
	 * @return 格式化的字符串
	 */
	public synchronized static String time2String(Date time, DateFormat dateFormat) {
		if (time == null)
			return null;
		return dateFormat.format(time);
	}

	/**
	 * @param time
	 *            时间类型
	 * @param dateFormat
	 *            时间格式
	 * @return 格式化的字符串
	 */
	public static String time2String(Date time, String dateFormat) {
		if (time == null)
			return null;
		return date2String(time, new SimpleDateFormat(dateFormat));
	}

	/**
	 * @param time
	 *            时间类型
	 * @return 格式化的字符串
	 */
	public static String time2String(Date time) {
		if (time == null)
			return null;
		return date2String(time, getDefaultTimeFormat());
	}

	/**
	 * @param dateTime
	 *            日期时间
	 * @param dateFormat
	 *            格式
	 * @return 格式化字符串
	 */
	public synchronized static String dateTime2String(Date dateTime, DateFormat dateFormat) {
		if (dateTime == null)
			return null;
		return dateFormat.format(dateTime);
	}

	/**
	 * @param dateTime
	 *            日期时间
	 * @param dateFormat
	 *            格式
	 * @return 格式化字符串
	 */
	public static String dateTime2String(Date dateTime, String dateFormat) {
		if (dateTime == null)
			return null;
		return dateTime2String(dateTime);
	}

	/**
	 * @param dateTime
	 *            日期时间
	 * @return 格式化字符串
	 */
	public static String dateTime2String(Date dateTime) {
		if (dateTime == null)
			return null;
		return date2String(dateTime, getDefaultDateTimeFormat());
	}

	public synchronized static Date string2Date(String date, DateFormat dateFormat) {
		if (date == null)
			return null;
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static Date string2Date(String date, String dateFormat) {
		return string2Date(date, new SimpleDateFormat(dateFormat));
	}

	public static Date string2Date(String date) {
		return string2Date(date, getDefaultDateFormat());
	}

	public static Time string2Time(String time, DateFormat timeFormat) {
		if (time == null)
			return null;
		return new Time(string2Date(time, timeFormat).getTime());
	}

	public static Time string2Time(String time, String timeFormat) {
		if (time == null)
			return null;
		return new Time(string2Date(time, timeFormat).getTime());
	}

	public static Time string2Time(String time) {
		return string2Time(time, getDefaultTimeFormat());
	}

	public static Timestamp string2DateTime(String time, DateFormat timeFormat) {
		if (time == null)
			return null;
		return new Timestamp(string2Date(time, timeFormat).getTime());
	}

	public static Timestamp string2DateTime(String time, String timeFormat) {
		if (time == null)
			return null;
		return new Timestamp(string2Date(time, timeFormat).getTime());
	}

	public static Timestamp string2DateTime(String time) {
		return string2DateTime(time, getDefaultDateTimeFormat());
	}

	/**
	 * 取得当前日期。日期格式为：yyyy-MM-dd
	 * 
	 * @return 当前日期字符串。
	 */
	public synchronized static String getCurrentDateAsString() {
		return getDefaultDateFormat().format(Calendar.getInstance().getTime());
	}

	/**
	 * 取得当前日期时间。日期格式为：yyyy-MM-dd hh:mm:ss *
	 * 
	 * @return 当前日期字符串。
	 */
	public synchronized static String getCurrentDateTimeAsString() {
		return getDefaultDateTimeFormat().format(Calendar.getInstance().getTime());
	}

	/**
	 * 取得当前日期时间。日期格式为由dateFormat定义
	 * 
	 * @param dateFormat
	 *            格式串
	 * @return 当前日期字符串。
	 */
	public static String getCurrentDateAsString(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(Calendar.getInstance().getTime());
	}

	/**
	 * 根据dateFormat定义日期格式取得指定的日期
	 * 
	 * @param date
	 *            指定的日期
	 * @param dateFormat
	 *            格式串
	 * @return 日期字符串。
	 */
	public static String getDateString(Date date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}

	public static Date parseDate(String date, DateFormat df) {
		try {
			return df.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * 根据dateFormat定义日期格式取得指定的日期
	 * 
	 * @param date
	 *            指定的日期字符串
	 * @param dateFormat
	 *            格式串
	 * @return 日期
	 */
	public static Date parseDate(String date, String dateFormat) {
		SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
		return parseDate(date, fmt);
	}

	public synchronized static Date parseDate(String date) {
		return parseDate(date, getDefaultDateTimeFormat());
	}

	/**
	 * 取得当前的时间戳
	 * 
	 * @return 时间戳
	 */
	public static Timestamp nowTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 将指定的日期转换时间戳 *
	 * 
	 * @param date
	 *            日期
	 * @return 时间戳
	 */
	public static Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public static String toString(Date time) {
		return getDateString(time, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date fromUnixTime(Long ms) {
		return new Date(ms.longValue() * 1000);
	}

	public static Long unixTimestamp(String date) {
		return Long.valueOf((parseDate(date).getTime() / 1000));
	}

	/**
	 * 根据给定格式生成数字型的日期
	 * 
	 * @param date
	 * @param dateFormat
	 * @return 数字日期
	 */
	public static Long unixTimestamp(String date, String dateFormat) {
		return Long.valueOf((parseDate(date, dateFormat).getTime() / 1000));
	}

	public static Long currentUnixTimestamp() {
		return Long.valueOf((System.currentTimeMillis() / 1000));
	}

	public static Long unixTimestamp(Date date) {
		return Long.valueOf((date.getTime() / 1000));
	}

	/**
	 * 根据指定的filed做日期的修改
	 * 
	 * @param date
	 * @param amount
	 * @param field
	 * @return
	 */
	public static Date addDate(Date date, int amount, int field) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	public static Date getToday() {
		return new Date(System.currentTimeMillis());
	}

	public static java.sql.Date getCurrentSqlDate() {
		return new java.sql.Date(System.currentTimeMillis());
	}

	/**
	 * 
	 * @param date
	 *            格式：yyyy-MM-dd
	 * @return
	 */
	public static java.sql.Date StringToSqlDate(String date) {
		return java.sql.Date.valueOf(date);
	}

	/**
	 * 根据指定field值进行相加减
	 * 
	 * @param date
	 * @param dateFormat
	 *            返回格式
	 * @param amount
	 *            对应的数量
	 * @param field
	 *            对应的那个列
	 * @return
	 */
	public static String getDate(Date date, String dateFormat, int amount, int field) {
		return getDateString(addDate(date, amount, field), dateFormat);
	}

	/**
	 * @param date
	 * @param dateFormat
	 * @param amount
	 * @param field
	 * @return
	 */
	public static String getDate(String date, String dateFormat, int amount, int field) {
		return getDate(string2Date(date, dateFormat), dateFormat, amount, field);
	}

	/**
	 * 获取 开始时间和截止时间之间的日期字符串表示(格式由format指定)
	 * 
	 * @param from
	 *            开始时间,包括;如果为null则由to向前倒退一个月
	 * @param to
	 *            截止时间,包括;如果为null则取当前时间
	 * @param format
	 *            返回的字符串格式
	 * @return 字符串列表
	 */
	public static List<String> getDateStringList(Date from, Date to, String format) {
		/*
		 * if(from==null){ throw new IllegalArgumentException("开始时间不能为null"); }
		 */
		if (to == null) {
			// 截止时间为空,使用当前时间
			to = new Date(System.currentTimeMillis());
		}
		if (from == null) {
			from = addDate(to, -1, Calendar.MONTH);// 默认向前一个月
		}
		if (from.after(to)) {
			throw new IllegalArgumentException(
					"开始时间不能大于截止时间  from:" + DateUtil.date2String(from) + ",to:" + DateUtil.date2String(to));
		}

		ArrayList<String> ret = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(from);
		// 清除 小时,分钟,秒
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date fromDate = cal.getTime();
		// 不能用before,可能to刚好也是00:00:00
		SimpleDateFormat df = new SimpleDateFormat(format);
		while (!fromDate.after(to)) {
			ret.add(df.format(fromDate));
			cal.add(Calendar.DAY_OF_YEAR, 1);
			fromDate = cal.getTime();
		}
		return ret;
	}

	public static List<String> getMonthStringList(Date to, int count, String format) {
		if (to == null) {
			// 截止时间为空,使用当前时间
			to = new Date(System.currentTimeMillis());
		}
		ArrayList<String> ret = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(to);
		Date date = cal.getTime();

		SimpleDateFormat df = new SimpleDateFormat(format);
		for (int i = 0; i < count; i++) {
			ret.add(df.format(date));
			cal.add(Calendar.MONTH, -1);
			date = cal.getTime();
		}
		return ret;
	}

	public static List<Date> getMonthList(Date to, int count, String format) {
		if (to == null) {
			// 截止时间为空,使用当前时间
			to = new Date(System.currentTimeMillis());
		}
		ArrayList<Date> ret = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(to);
		Date date = cal.getTime();

		for (int i = 0; i < count; i++) {
			ret.add(date);
			cal.add(Calendar.MONTH, -1);
			date = cal.getTime();
		}
		return ret;
	}

	public static List<String> getLastDays(int days, String format) {
		ArrayList<String> ret = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat df = new SimpleDateFormat(format);
		for (int i = 0; i < days; i++) {
			ret.add(df.format(date));
			cal.add(Calendar.DAY_OF_YEAR, -1);
			date = cal.getTime();
		}
		return ret;
	}

	public static List<String> getIntervalDays(String format, Date startTime, Date endTime) {
		List<String> ret = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(format);
		cal.setTime(startTime);
		while (cal.getTime().before(endTime)) {
			ret.add(df.format(cal.getTime()));
			cal.add(Calendar.DAY_OF_YEAR, 1);
		}
		ret.add(df.format(endTime));
		return ret;
	}

	public static List<Date> getDateList(Date from, Date to, Date time) {
		if (from == null) {
			throw new IllegalArgumentException("开始时间不能为null");
		}
		if (to == null) {
			// 截止时间为空,使用当前时间
			to = new Date(System.currentTimeMillis());
		}
		if (from.after(to)) {
			throw new IllegalArgumentException("开始时间不能大于截止时间");
		}

		ArrayList<Date> ret = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.setTime(from);
		cal2.setTime(time);
		// 清除 小时,分钟,秒
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date fromDate = cal.getTime();
		// 不能用before,可能to刚好也是00:00:00

		while (!fromDate.after(to)) {
			cal2.set(Calendar.YEAR, cal.get(Calendar.YEAR));
			cal2.set(Calendar.MONTH, cal.get(Calendar.MONTH));
			cal2.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
			ret.add(cal2.getTime());

			cal.add(Calendar.DAY_OF_YEAR, 1);
			fromDate = cal.getTime();
		}
		return ret;
	}

	public static List<Date> getDateList(Date from, Date to) {
		if (from == null) {
			throw new IllegalArgumentException("开始时间不能为null");
		}
		if (to == null) {
			// 截止时间为空,使用当前时间
			to = new Date(System.currentTimeMillis());
		}
		if (from.after(to)) {
			throw new IllegalArgumentException("开始时间不能大于截止时间");
		}

		ArrayList<Date> ret = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(from);

		// 清除 小时,分钟,秒
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date fromDate = cal.getTime();
		// 不能用before,可能to刚好也是00:00:00

		while (!fromDate.after(to)) {
			ret.add(cal.getTime());
			cal.add(Calendar.DAY_OF_YEAR, 1);
			fromDate = cal.getTime();
		}
		return ret;
	}

	/**
	 * 根据时间范围获取 范围月份列表
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public static List<Date> getMonthList(Date from, Date to) {
		if (from == null) {
			throw new IllegalArgumentException("开始时间不能为null");
		}
		if (to == null) {
			// 截止时间为空,使用当前时间
			to = new Date(System.currentTimeMillis());
		}
		if (from.after(to)) {
			throw new IllegalArgumentException("开始时间不能大于截止时间");
		}

		ArrayList<Date> ret = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(from);

		// 清除 小时,分钟,秒
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		Date fromDate = cal.getTime();
		// 不能用before,可能to刚好也是00:00:00

		while (!fromDate.after(to)) {
			ret.add(cal.getTime());
			cal.add(Calendar.MONTH, 1);
			fromDate = cal.getTime();
		}
		return ret;
	}

	/**
	 * 
	 * @param month
	 * @return 时分秒 都为 0
	 */
	public static Date getFirstDayOfMonth(Date month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 
	 * @param month
	 * @return 时分秒为 23:59:59
	 */
	public static Date getLastDayOfMonth(Date month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(month);
		// 月份增加1,下个月1号前一天
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	public static boolean beforeToday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return date.before(cal.getTime());
	}

	/**
	 * 获取指定日期的初始时间，即时分秒为 00:00:00
	 * 
	 * @param date
	 * @return 时分秒为 00:00:00
	 */
	public static Date getFirstDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取指定日期的末尾时间，即时分秒为 23:59:59
	 * 
	 * @param date
	 * @return 时分秒为 23:59:59
	 */
	public static Date getLastDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	/**
	 * description:取得昨天零晨
	 *
	 * @return
	 */
	public static Date getLastDate() {
		Date today = DateUtil.getToday();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DATE, -1);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();

	}

	/**
	 * 指定的日志是否在今天之后
	 * 
	 * @param date
	 * @return
	 */
	public static boolean afterToday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return date.compareTo(cal.getTime()) >= 0;
	}

	public static boolean isValidity(String dateStr, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		boolean flag = true;
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(dateStr);
		} catch (ParseException e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * description:计算两个时间差
	 *
	 * @param d1
	 * @param d2
	 * @return 返回以分为单位
	 */
	public static long decrease(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		long l1 = c1.getTimeInMillis() / 60000;
		c1.setTime(d2);
		long l2 = c1.getTimeInMillis() / 60000;
		return l2 - l1;
	}
	
	private static void setToFirstDay(Calendar calendar) {
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, -1);
        }
    }
	
	/**
	 * @return 获取当前日期的周四日期
	 */
	public static String getCurrentThursday(){
		Date date = new Date();
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(date);
    	setToFirstDay(calendar);
        calendar.add(Calendar.DATE, 3);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(calendar.getTime());
	}
	
	/**
	 * @return 获取当前日期的周五日期
	 */
	public static String getCurrentFriday(){
		Date date = new Date();
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(date);
    	setToFirstDay(calendar);
        calendar.add(Calendar.DATE, 4);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(calendar.getTime());
	}
	
	/**
	 * @return 获取某月某天
	 */
	public static String getCurrentMonth(Integer month,Integer day){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		 Calendar c = Calendar.getInstance();    
		c.add(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH,day);//设置为几号,既为本月第几天 
		return format.format(c.getTime());
	}
	
	
	
	public static void main(String[] args) {
//        System.out.println(getCurrentThursday());
//        System.out.println(getCurrentFriday());
		System.out.println(getCurrentMonth(1,2));
    }

    
}