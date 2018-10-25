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
public class YearWeekUtils {
	
	/**
	 * 解析字符串到year week 不高大，只支持指定解析
	 * @param str
	 * @return
	 */
	public static YearWeek parseYw(String str) throws ParseException{
		if (StringUtils.isEmpty(str)) {
			throw new IllegalArgumentException("year month must not be null");
		}
		YearWeek yearWeek = new YearWeek();
		String[] items = str.split("-");
		if (items.length != 2) {
			throw new ParseException("Unable to parse the year month: " + str, -1);
		}
		yearWeek.setYear(Integer.valueOf(items[0]));
		MonthEnum month = MonthEnum.valueOfI(Integer.valueOf(items[1]));
		yearWeek.setWeek(month.getI());
		return yearWeek;
	}

	/**
	 * 只提供标准化的格式化
	 * @return
	 */
	public static String formatYw(YearWeek yw){
		StringBuffer sb = new StringBuffer();
		sb.append(yw.getYear()).append("-").append(yw.getWeek());
		return sb.toString();
	}
	
	/**
	 * 计算量个yw之间的周数间隔数目
	 * @param yw1
	 * @param yw2
	 * @return
	 */
	public static int diffBetweenYw(YearWeek yw1 , YearWeek yw2){
		int diff = Math.abs((yw1.getYear() - yw2.getYear())*52);
		diff += Math.abs(yw1.getWeek() - yw2.getWeek());
		return diff+1;
	}
	
	/**
	 * 
	 * @param yw1
	 * @param yw2
	 * @return
	 */
	public static int minusYw(YearWeek yw1, YearWeek yw2){
		return yw1.getNum() - yw2.getNum();
	}
	
	/**
	 * year week 按照周增加
	 * @param yw
	 * @param w
	 * @return
	 */
	public static YearWeek addYwWeeks(YearWeek yw, int w){
		int n = yw.getNum();
		n += w;
		YearWeek resYw = new YearWeek();
		resYw.setYear(n/52);
		resYw.setWeek(n % 52);
		return resYw;
	}
}
