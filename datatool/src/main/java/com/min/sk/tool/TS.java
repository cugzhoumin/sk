package com.min.sk.tool;


import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import com.min.sk.common.DoubleUtils;




public class TS {

	private Point startPoint;
	private long interval = Interval.DEFAULT;
	private int len;
	private Integer frequency;
	private double[] y;
	
	/**
	 * @return the len
	 */
	public int getLen() {
		return len;
	}

	/**
	 * @param len the len to set
	 */
	public void setLen(int len) {
		this.len = len;
	}

	/**
	 * @return the y
	 */
	public double[] getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double[] y) {
		this.y = y;
	}

	
	/**
	 * 构建基于point的ts
	 * @param start
	 * @param y
	 */
	public TS(Point startPoint, double[] y) {
		this.startPoint = new Point(startPoint);
		this.len = y.length;
		this.y = y.clone();
	}
	
	/**
	 * constructor method
	 * 
	 * @param start
	 * @param interval
	 * @param y
	 */
	public TS(double[] y) {
		this.y = y.clone();
		this.len = y.length;
	}

	/**
	 * copy to a new one
	 * @author min
	 * @param toCopy
	 */
	public TS(TS toCopy){
		double[] data = new double[toCopy.getLen()];
		for (int i = 0; i < data.length; i++) {
			data[i] = toCopy.getY()[i];
		}
		this.startPoint = PointUtils.copy(toCopy.getStartPoint());
		this.interval = toCopy.interval;
		this.len = data.length;
		this.frequency = toCopy.frequency;
		this.y = data;
	}
	
	public TS(TS toCopy,double[] data){
		this.startPoint = PointUtils.copy(toCopy.getStartPoint());
		this.interval = toCopy.interval;
		this.len = data.length;
		this.frequency = toCopy.frequency;
		this.y = data.clone();
	}
	
	public TS() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * get point data
	 * @param p
	 * @return
	 */
	public Double getData(Point p){
		switch (p.getPointType()) {
		case DATE:
			return getData(p.getDate());
		case YEAR_MONTH:
			return getData(p.getYearMonth());
		case YEAR_WEEK:
			return getData(p.getYearWeek());
		default:
			return getData(p.getDate());
		}
	}
	
	public Double getData(YearWeek yearWeek){
		Long index = (long)YearWeekUtils.minusYw(yearWeek,startPoint.getYearWeek()) ;
		if (index >= 0 && index < len) {
			return y[index.intValue()];
		}
		return null;
	}
	
	/**
	 * 根据year month获取数据
	 * @param yearMonth
	 * @return
	 */
	public Double getData(YearMonth yearMonth){
		Long index = (long)YearMonthUtils.minusYm(yearMonth,startPoint.getYearMonth()) ;
		if (index >= 0 && index < len) {
			return y[index.intValue()];
		}
		return null;
	}
	
	/**
	 * 根据日期来获取数据item
	 * @param date
	 * @return
	 * @author min
	 */
	public Double getData(Date date){
		Long index = (date.getTime()-startPoint.getDate().getTime()) / Interval.DAY;
        if (index >=0 && index < len) {			
        	return y[index.intValue()];
		}
        return null;
	}
	/**
	 * 根据日期设置ts中某一个时刻的数
	 * @param dateTime
	 * @param d
	 * @author min
	 */
	public void setData(long dateTime,double d){
		Long index = (dateTime-startPoint.getDate().getTime()) / Interval.DAY;
		y[index.intValue()] = d;
	}
	
	/**
	 * 
	 */
	public void setData(YearWeek yw,double d){
		Long index = (long)YearWeekUtils.minusYw(yw,startPoint.getYearWeek());
		y[index.intValue()] = d;
	}
	
	/**
	 * 
	 * @param p
	 * @param d
	 */
	public void setData(Point p , double d){
		switch (p.getPointType()) {
		case DATE:
			setData(p.getDate(), d);
			break;
		case YEAR_MONTH:
			setData(p.getYearMonth(), d);
			break;
		case YEAR_WEEK:
			setData(p.getYearWeek(), d);
			break;
		default:
			setData(p.getDate(), d);
			break;
		}
	}
	/**
	 * 根据日期来设置时序ts中某一个时刻的值
	 * @param date
	 * @param d
	 * @author min
	 */
	public void setData(Date date,double d){
		Long index = (date.getTime()-startPoint.getDate().getTime()) / Interval.DAY;
		y[index.intValue()] = d;
	}
	/**
	 * 针对ym设置data
	 * @param ym
	 * @param d
	 */
	public void setData(YearMonth ym , double d){
		Long index = (long)YearMonthUtils.minusYm(ym,startPoint.getYearMonth());
		y[index.intValue()] = d;
	}
	
	/**
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public double getSumOfPeriod(Date fromDate,Date toDate) {
		double result = 0D;
		Date iterDate = fromDate;
		while(iterDate.before(toDate)){
			Double curValue = getData(iterDate);
			if (DoubleUtils.isLegal(curValue)) {
				result += curValue;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param fromYm
	 * @param toYearMonth
	 * @return
	 */
	public double getSumOfPeriod(YearMonth fromYm, YearMonth toYearMonth){
		double result = 0;
		YearMonth iterYm = fromYm;
		while(iterYm.before(toYearMonth)){
			Double curValue = getData(iterYm);
			if (DoubleUtils.isLegal(curValue)) {
				result += curValue;
			}
		}
		return result;
	}
	
	/**
	 * @return the interval
	 */
	public long getInterval() {
		return interval;
	}

	/**
	 * @param interval the interval to set
	 */
	public void setInterval(long interval) {
		this.interval = interval;
	}


	/**
	 * @return the frequency
	 */
	public Integer getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(Integer frequency) { 
		this.frequency = frequency;
	}

	/**
	 * @return the startPoint
	 */
	public Point getStartPoint() {
		return startPoint;
	}

	/**
	 * @param startPoint the startPoint to set
	 */
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n\tstart:" + this.startPoint);
		
		if(this.interval >= Interval.SECOND) {
			sb.append("(" + DateFormatUtils.format(this.startPoint.getDate(), "yyyy-MM-dd HH:mm:ss") ).append(")");
		}
		
		sb.append(", interval:" + this.interval).append(", len:" + this.len).append(", frequency:" + this.frequency);
		sb.append("\n");
//		sb.append("\ty:" + Arrays.toString(y));
		sb.append("\ty: [");
		if(y.length > 0) {
			for(int i = 0; i < y.length - 1; i++) {
				sb.append(String.format("%.2f", y[i])).append(", ");
			}
			sb.append(String.format("%.2f",y[y.length - 1])).append("]");
		}
//		sb.append("\n");

		return sb.toString();
	}
	public static final class Interval {
		public static final long DEFAULT = 1L;
		public static final long SECOND = 1000;
		public static final long MINUTE = 60000;
		public static final long HOUR = 3600000;
		public static final long DAY = DateUtils.MILLIS_PER_DAY;
		public static final long WEEK = DateUtils.MILLIS_PER_DAY * 7;
		public static final long MONTH = DateUtils.MILLIS_PER_DAY * 28;
	}
}
