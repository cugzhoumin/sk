package com.min.sk.tool;

/**
 * 
 */

/**
 * year - weeek (1-52)
 * @author min
 *
 */
public class YearWeek implements Comparable<YearWeek>{

	private int year;
	
	private int week;

	/**
	 * this 是否小于yw
	 * @param yw
	 * @return
	 */
    public boolean before(YearWeek yw) {
        if (this.year != yw.getYear()) {
			return this.year < yw.getWeek();
		}
        if (this.week != yw.getWeek()) {
			return this.week < yw.getWeek();
		}
		return false;
    }
    
    /**
     * 判断两个ym 是否相等
     * @param yw
     * @return
     */
    public boolean equals(YearWeek yw){
    	if (this.getYear() == yw.getYear() && this.getWeek() == yw.getWeek()) {
			return true;
		}
    	return false;
    }
    
    public int getNum(){
    	return this.getYear()*52 + this.getWeek();
    }
    
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the week
	 */
	public int getWeek() {
		return week;
	}

	/**
	 * @param week the week to set
	 */
	public void setWeek(int week) {
		this.week = week;
	}

	@Override
	public int compareTo(YearWeek o) {
		if (this.getYear() != o.getYear()) {
			return this.getYear() < o.getYear() ? -1 : 1;
		}
		if (this.getWeek() != o.getWeek()) {
			return this.getWeek() < o.getWeek() ? -1 : 1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		int n = year*52+week;
		return n;
	}
}
