/**
 * 
 */
package com.min.sk.common;

import java.nio.charset.Charset;

/**
 * @author min
 * @date 2018年10月23日
 *
 */
public class CommonConstants {

	/**
	 * 
	 * default char set
	 * 
	 */
	public static final Charset ENCODE = Charset.forName("utf-8");
	
	/**
	 * default date format : yyyy-MM-dd
	 * 
	 */
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	
	/**
	 * default date pattern2 : yyyy/MM/dd
	 */
	public static final String DATE_PATTERN_SLASH = "yyyy/MM/dd";
	
	public static final String DATE_PARTERN_POINT = "yyyy.MM.dd";
	
	public static final String DATE_PARTERN_POINT_YM = "yyyy.MM";
	
	/**
	 * defualt date format whith time : yyyy-MM-dd HH:mm:ss
	 * 
	 */
	public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * defualt date formats to parse date string :(yyyy-MM-dd	,	yyyy-MM-dd HH:mm:ss	,	yyyy/MM/dd)
	 * 
	 */
	public static final String[] DATE_PATTERNS = new String[] { DATE_PATTERN, DATETIME_PATTERN, DATE_PATTERN_SLASH,DATE_PARTERN_POINT,DATE_PARTERN_POINT_YM};
	
	/**
	 * default sperator
	 */
	public static final String DEFAULT_SEPERATOR = String.valueOf('\t');
	
	/**
	 * comma seperator
	 */
	public static final String COMMA_SEPERATOR = String.valueOf(',');
	
	/**
	 * month days , we defined as : 28 , four week
	 */
	public static final int MONTH_DAYS = 28;
	
	public static final int YEAR_DAYS = 365;
	
	public static final int WEEK_DAYS = 7;
}
