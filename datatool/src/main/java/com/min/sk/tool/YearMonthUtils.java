package com.min.sk.tool;

/**
 * 
 */

import java.text.ParseException;

import org.apache.commons.lang.StringUtils;

/**
 * @author min
 *
 */
public class YearMonthUtils {
	
	/**
	 * 解析字符串到yearmonth 不高大，只支持指定解析
	 * @param str
	 * @return
	 */
	public static YearMonth parseYm(String str) throws ParseException{
		if (StringUtils.isEmpty(str)) {
			throw new IllegalArgumentException("year month must not be null");
		}
		YearMonth yearMonth = new YearMonth();
		String[] items = str.split("-");
		if (items.length != 2) {
			throw new ParseException("Unable to parse the year month: " + str, -1);
		}
		yearMonth.setYear(Integer.valueOf(items[0]));
		MonthEnum month = MonthEnum.valueOfI(Integer.valueOf(items[1]));
		yearMonth.setMonth(month.getI());
		return yearMonth;
	}

	/**
	 * 只提供标准化的格式化
	 * @return
	 */
	public static String formatYm(YearMonth ym){
		StringBuffer sb = new StringBuffer();
		sb.append(ym.getYear()).append("-").append(ym.getMonth());
		return sb.toString();
	}
	
	/**
	 * 计算量个ym之间的月份间隔数目
	 * @param ym1
	 * @param ym2
	 * @return
	 */
	public static int diffBetweenYm(YearMonth ym1 , YearMonth ym2){
		int diff = Math.abs((ym1.getYear() - ym2.getYear())*12);
		diff += Math.abs(ym1.getMonth() - ym2.getMonth());
		return diff+1;
	}
	
	/**
	 * 
	 * @param ym1
	 * @param ym2
	 * @return
	 */
	public static int minusYm(YearMonth ym1, YearMonth ym2){
		return ym1.getNum() - ym2.getNum();
	}
	
	/**
	 * year month 按照月增加
	 * @param ym
	 * @param m
	 * @return
	 */
	public static YearMonth addYmMonths(YearMonth ym, int m){
		int n = ym.getNum();
		n += m;
		YearMonth resYm = new YearMonth();
		resYm.setYear(n/12);
		resYm.setMonth(n % 12);
		return resYm;
	}
}
