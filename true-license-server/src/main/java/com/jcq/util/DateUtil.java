package com.jcq.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期
	 * @param format
	 *            String 格式
	 * @return Date 日期
	 */
	public static Date parseDate(String dateStr, String format) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			String dt = dateStr.replaceAll("/", "-");
			if ((!dt.equals("")) && (dt.length() < format.length())) {
				dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]",
						"0");
			}
			date = (Date) dateFormat.parse(dt);
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期：YYYY-MM-DD 格式
	 * @return Date
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd");
	}

	public static Date parseDateExp(String dateStr) {
//		return parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = (Date) dateFormat.parse(dateStr);
		} catch (ParseException e) {

		}
		return date;
	}

	/**
	 * 功能描述：格式化输出日期
	 * 
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return 返回字符型日期
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				DateFormat dateFormat = new SimpleDateFormat(format);
				result = dateFormat.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 功能描述：
	 * 
	 * @param date
	 *            Date 日期
	 * @return
	 */
	public static String format(Date date) {
		return format(date, "yyyy-MM-dd");
	}
	public static String format2(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 功能描述：返回年份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回年份
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 功能描述：返回月份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 功能描述：返回日份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能描述：返回小时
	 * 
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	
	public static int getHourMIn5(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(12,-5);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * @author yujiansong
	 * 向后推迟n分钟
	 */
	public static int getHourMinN(int mins){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(12,mins);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	/**
	 * 功能描述：返回分钟
	 * 
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 功能描述：返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	/**
	 * 功能描述：返回字符型日期
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符型日期 yyyy-MM-dd 格式
	 */
	public static String getDate(Date date) {
		return format(date, "yyyy-MM-dd");
	}

	public static String getDate8(Date date) {
		return format(date, "yyyyMMdd");
	}

	/**
	 * 功能描述：返回字符型时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型时间 HH:mm:ss 格式
	 */
	public static String getTime(Date date) {
		return format(date, "HH:mm:ss");
	}

	public static String getTime(Date date, String format) {
		return format(date, format);
	}

	/**
	 * 功能描述：返回字符型日期时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型日期时间 yyyy-MM-dd HH:mm:ss 格式
	 */
	public static String getDateTime(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 功能描述：日期相加
	 * 
	 * @param date
	 *            Date 日期
	 * @param day
	 *            int 天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		long millis = getMillis(date) + ((long) day) * 24 * 3600 * 1000;
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	public static Date addMin(Date date, int min) {
		Calendar calendar = Calendar.getInstance();
		long millis = getMillis(date) + ((long) min) * 60 * 1000;
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	/**
	 * 功能描述：日期相减
	 * 
	 * @param date
	 *            Date 日期
	 * @param date1
	 *            Date 日期
	 * @return 返回相减后的日期
	 */
	public static int diffDate(Date date, Date date1) {
//		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));//天
//		return (int) ((getMillis(date) - getMillis(date1)) / ( 3600 * 1000));//小时
		return (int) ((getMillis(date) - getMillis(date1)) / ( 60 * 1000));//分钟
	}

	/**
	 * 功能描述：取得指定月份的第一天
	 * 
	 * @param strdate
	 *            String 字符型日期
	 * @return String yyyy-MM-dd 格式
	 */
	public static String getMonthBegin(String strdate) {
		Date date = parseDate(strdate);
		return format(date, "yyyy-MM") + "-01";
	}

	/**
	 * 功能描述：取得指定月份的最后一天
	 * 
	 * @param strdate
	 *            String 字符型日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String getMonthEnd(String strdate) {
		Date date = parseDate(getMonthBegin(strdate));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return formatDate(calendar.getTime());
	}

	/**
	 * 功能描述：常用的格式化日期
	 * 
	 * @param date
	 *            Date 日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String formatDate(Date date) {
		return formatDateByFormat(date, "yyyy-MM-dd");
	}

	/**
	 * 功能描述：以指定的格式来格式化日期
	 * 
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return String 日期字符串
	 */
	public static String formatDateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @Title: dateCompare
	 * @Description: date1<date2 返回-1 ，相等0，否则返回1
	 * @param @param date1
	 * @param @param date2
	 * @param @return
	 * @return int
	 * @throws
	 */
	public static int dateCompare(String date1, String date2) {
		int num = -1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			num = sdf.parse(date1).compareTo(sdf.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return num;
	}

	public static int getDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/** 
     * 得到几天前的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateBefore(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);  
        return now.getTime();  
    }  
  
    /** 
     * 得到几天后的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    } 
    
	/**
	 * 获取日期相差天数
	 * 
	 * @param
	 * @return 日期类型时间
	 * @throws ParseException
	 */
	public static Long getDiffDay(String beginDate, String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Long checkday = 0l; // 开始结束相差天数
		try {
			checkday = (formatter.parse(endDate).getTime() - formatter.parse(
					beginDate).getTime())
					/ (1000 * 24 * 60 * 60);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			checkday = null;
		}
		return checkday;
	}

	public static Long getDiffDay(Date beginDate, Date endDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strBeginDate = format.format(beginDate);
		String strEndDate = format.format(endDate);
		return getDiffDay(strBeginDate, strEndDate);
	}

	public static Date getYesterday(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, -1);
		
		String yesterday = new SimpleDateFormat("yyyy-MM-dd ").format(cal
				.getTime());
		return parseDate(yesterday);
	}

	public static boolean isValidDate(String str,String pattern) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			Date date = format.parse(str);
			System.out.println(date);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

	public static String getPreMonth(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		try {
			Calendar ct = Calendar.getInstance();
			ct.setTime(date);
			ct.add(Calendar.MONTH, -1);
			return df.format(ct.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 月份加一
	 * @param date
	 * @return
	 */
	public static String monthAddFrist(String date) {

		DateFormat df = new SimpleDateFormat("yyyy-MM");
		try {
			Calendar ct = Calendar.getInstance();
			ct.setTime(df.parse(date));
			ct.add(Calendar.MONTH, +1);
			return df.format(ct.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 传入两个时间范围，返回这两个时间范围内的所有日期，并保存在一个集合中
	 *
	 * @param beginDate 起始日期
	 * @param endDate   结束日期
	 * @return
	 * @throws Exception
	 */
	public static List<Date> findEveryDay(Date beginDate, Date endDate){
		//创建一个放所有日期的集合
		List<Date> dates = new ArrayList();
		//将格式化后的第一天添加进集合
		dates.add(beginDate);
		//使用本地的时区和区域获取日历
		Calendar calBegin = Calendar.getInstance();
		//传入起始时间将此日历设置为起始日历
		calBegin.setTime(beginDate);
		//判断结束日期前一天是否在起始日历的日期之后
		while (endDate.after(calBegin.getTime())) {
			//根据日历的规则:月份中的每一天，为起始日历加一天
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			//得到的每一天就添加进集合
			dates.add(calBegin.getTime());
			//如果当前的起始日历超过结束日期后,就结束循环
		}
		return dates;
	}

	/**
	 *
	 *@Description 获取指定日期当月的第一天
	 */
	public static Date getMonthBegin(Date date) {
		String firstDateStr = format(date, "yyyy-MM") + "-01";
		return parseDate(firstDateStr);
	}
}
