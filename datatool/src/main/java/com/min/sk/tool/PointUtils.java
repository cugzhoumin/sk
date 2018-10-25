package com.min.sk.tool;

import com.min.sk.common.DateMwcUtils;

/**
 * 
 */


/**
 * @author min
 *
 */
public class PointUtils {
	/**
	 * 计算量个ym之间的月份间隔数目
	 * @param ym1
	 * @param ym2
	 * @return
	 */
	public static int diffBetweenPoint(Point p1 , Point p2){
		switch (p1.getPointType()) {
		case DATE:
			return DateMwcUtils.daysOfTwoDateInt(p1.getDate(), p2.getDate());
		case YEAR_MONTH:
			return YearMonthUtils.diffBetweenYm(p1.getYearMonth(), p2.getYearMonth());
		default:
			return DateMwcUtils.daysOfTwoDateInt(p1.getDate(), p2.getDate());
		}
	}
	
	/**
	 * 格式化成最表准的格式
	 * @param p
	 * @return
	 */
	public static String format(Point p){
		switch (p.getPointType()) {
		case DATE:
			return DateMwcUtils.toDfString(p.getDate());
		case YEAR_MONTH:
			return YearMonthUtils.formatYm(p.getYearMonth());
			
		default:
			return DateMwcUtils.toDfString(p.getDate());
		}
	}
	
	/**
	 * 点位置的移动
	 * @param p
	 * @param i
	 * @return
	 */
	public static Point add(Point p,int i) {
		Point point = new Point(p);
		return point.add(i);
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public static Point copy(Point p){
		return new Point(p);
	}
}
