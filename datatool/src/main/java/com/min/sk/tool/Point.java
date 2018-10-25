package com.min.sk.tool;


import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * @author min
 *
 */
public class Point implements Comparable<Point>{

	private Date date;
	
	private YearMonth yearMonth;

	
	private PointType pointType;
	
	private YearWeek yearWeek;
	
	
	public Point(Point p){
		if (p.getDate() != null) {	
			this.date = new Date();
			this.date.setTime(p.getDate().getTime());
		}
		if (p.getYearMonth() != null) {	
			this.yearMonth = new YearMonth();
			this.yearMonth.setYear(p.getYearMonth().getYear());
			this.yearMonth.setMonth(p.getYearMonth().getMonth());
		}
		if (p.getYearWeek() != null) {
			this.yearWeek = new YearWeek();
			this.yearWeek.setYear(p.getYearWeek().getYear());
			this.yearWeek.setWeek(p.getYearWeek().getWeek());
		}
		if (p.getPointType() != null) {			
			this.pointType = p.getPointType();
		}
	}
	
	public Point(Date date, YearMonth yearMonth, YearWeek yearWeek,PointType pointType) {
		if (date != null) {	
			this.date = new Date();
			this.date.setTime(date.getTime());
		}
		if (yearMonth != null) {	
			this.yearMonth = new YearMonth();
			this.yearMonth.setYear(yearMonth.getYear());
			this.yearMonth.setMonth(yearMonth.getMonth());
		}
		if (yearWeek != null) {
			this.yearWeek = new YearWeek();
			this.yearWeek.setYear(yearWeek.getYear());
			this.yearWeek.setWeek(yearWeek.getWeek());
		}
		if (pointType != null) {			
			this.pointType = pointType;
		}
	}

	public Point(Date date){
		this.date = new Date();
		this.date.setTime(date.getTime());
		
		this.pointType = PointType.DATE;
	}

	public Point(YearMonth yearMonth){
		this.yearMonth = new YearMonth();
		this.yearMonth.setYear(yearMonth.getYear());
		this.yearMonth.setMonth(yearMonth.getMonth());
		
		this.pointType = PointType.YEAR_MONTH;
	}
	
	public Point(YearWeek yearWeek){
		this.yearWeek = new YearWeek();
		this.yearWeek.setYear(yearWeek.getYear());
		this.yearWeek.setWeek(yearWeek.getWeek());
		
		this.pointType = PointType.YEAR_WEEK;
	}
	
	
	public Point add(int i) {
		return add(this, i);
	}
	
	
	/**
	 * point +
	 * @param p
	 * @param i
	 * @return
	 */
	public Point add(Point p,int i){
		
		switch (p.pointType) {
		case DATE:
			p.setDate(DateUtils.addDays(p.getDate(), i));
			return p;
		case YEAR_MONTH:
			p.setYearMonth(YearMonthUtils.addYmMonths(p.getYearMonth(), i));
			return p;
		case YEAR_WEEK:
			p.setYearWeek(YearWeekUtils.addYwWeeks(p.getYearWeek(), i));
			return p;
		default:
			break;
		}
		return p;
	}
	
	/**
	 * this 是否小于ym
	 * @param ym
	 * @return
	 */
    public boolean before(Point point) {
    	switch (this.pointType) {
		case DATE:
			return this.getDate().before(point.getDate());
		case YEAR_MONTH:
			return this.getYearMonth().before(point.getYearMonth());
		case YEAR_WEEK:
			return this.yearWeek.before(point.getYearWeek());
		default:
			break;
		}
    	return this.getDate().before(point.getDate());
    }
    
    /**
     * 判断两个ym 是否相等
     * @param ym
     * @return
     */
    public boolean equals(Point point){
    	switch (this.pointType) {
		case DATE:
			return this.getDate().equals(point.getDate());
		case YEAR_MONTH:
			return this.getYearMonth().equals(point.getYearMonth());
		case YEAR_WEEK:
			return this.getYearWeek().equals(point.getYearWeek());
		default:
			break;
		}
    	return this.getDate().before(point.getDate());
    }
    
	/**
	 * @return the pointType
	 */
	public PointType getPointType() {
		return pointType;
	}

	/**
	 * @param pointType the pointType to set
	 */
	public void setPointType(PointType pointType) {
		this.pointType = pointType;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the yearMonth
	 */
	public YearMonth getYearMonth() {
		return yearMonth;
	}

	/**
	 * @param yearMonth the yearMonth to set
	 */
	public void setYearMonth(YearMonth yearMonth) {
		this.yearMonth = yearMonth;
	}

	
	/**
	 * @return the yearWeek
	 */
	public YearWeek getYearWeek() {
		return yearWeek;
	}

	/**
	 * @param yearWeek the yearWeek to set
	 */
	public void setYearWeek(YearWeek yearWeek) {
		this.yearWeek = yearWeek;
	}

	@Override
	public int compareTo(Point o) {
		switch (this.getPointType()) {
		case DATE:
			return this.getDate().compareTo(o.getDate());
		case YEAR_MONTH:
			return this.getYearMonth().compareTo(o.getYearMonth());
		case YEAR_WEEK:
			return this.getYearWeek().compareTo(o.getYearWeek());
		default:
			return this.getDate().compareTo(o.getDate());
		}
	}

	@Override
	public int hashCode() {
		switch(this.getPointType()){
		case DATE:
			return this.getDate().hashCode();
		case YEAR_MONTH:
			return this.getYearMonth().hashCode();
		case YEAR_WEEK:
			return this.getYearWeek().hashCode();
		default:
			return this.getDate().hashCode();
		}
	}


	@Override
	public boolean equals(Object obj) {
		switch(this.getPointType()){
		case DATE:
			return this.getDate().equals(((Point)obj).getDate());
		case YEAR_MONTH:
			return this.getYearMonth().equals(((Point)obj).getYearMonth());
		case YEAR_WEEK:
			return this.getYearWeek().equals(((Point)obj).getYearWeek());
		default:
			return this.getDate().equals(((Point)obj).getDate());
		}
	}

	
	
	
}
