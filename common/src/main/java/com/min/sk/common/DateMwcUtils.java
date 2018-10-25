package com.min.sk.common;

/**
 * 
 */

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;


/**
 * @author min
 *
 */
public class DateMwcUtils extends DateUtils{

	private DateMwcUtils(){
	}
	
	/**
	 * 计算日期diff
	 * @param fDate
	 * @param oDate
	 * @return
	 */
    public static int daysOfTwoDateInt(Date fDate, Date oDate) {
        long days = (fDate.getTime() - oDate.getTime()) / MILLIS_PER_DAY;
        return (int)Math.abs(days);
    }
    
    /**
     * 日期差值，可正负 bd-ed
     * @param bd
     * @param ed
     * @return
     */
    public static int subtractionDateInt(Date bd,Date ed){
    	long days = (bd.getTime() - ed.getTime()) / MILLIS_PER_DAY;;
    	return (int)days;
    }
    
    /**
     * 计算日期diff
     * @param bd
     * @param ed
     * @return
     */
    public static double daysOfTwoDateFloat(Date bd,Date ed){
        double days = (bd.getTime() - ed.getTime()) / MILLIS_PER_DAY;
        return Math.abs(days);
    }
    
    /**
     * 日期差值，可正负 bd-ed
     * @param bd
     * @param ed
     * @return
     */
    public static double subtractionDateFloat(Date bd,Date ed){
    	double days = (bd.getTime() - ed.getTime()) / MILLIS_PER_DAY;;
    	return days;
    }
    
    /**
     * 默认的tostring
     * @param date
     * @return
     */
    public static final String toDfString(Date date){
    	return DateFormatUtils.format(date, CommonConstants.DATE_PATTERN);
    }
}
