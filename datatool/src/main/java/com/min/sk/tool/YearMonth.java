package com.min.sk.tool;

/**
 * 
 */

/**
 * @author min
 * 
 *
 */
public class YearMonth implements Comparable<YearMonth>{

	private int year;
	
	private int month;

	/**
	 * this 是否小于ym
	 * @param ym
	 * @return
	 */
    public boolean before(YearMonth ym) {
        if (this.year != ym.getYear()) {
			return this.year < ym.getMonth();
		}
        if (this.month != ym.getMonth()) {
			return this.month < ym.getMonth();
		}
		return false;
    }
    
    /**
     * 判断两个ym 是否相等
     * @param ym
     * @return
     */
    public boolean equals(YearMonth ym){
    	if (this.getYear() == ym.getYear() && this.getMonth() == ym.getMonth()) {
			return true;
		}
    	return false;
    }
    
    public int getNum(){
    	return this.getYear()*12 + this.getMonth();
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
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public int compareTo(YearMonth o) {
		if (this.getYear() != o.getYear()) {
			return this.getYear() < o.getYear() ? -1 : 1;
		}
		if (this.getMonth() != o.getMonth()) {
			return this.getMonth() < o.getMonth() ? -1 : 1;
		}
		return 0;
	}


	@Override
	public int hashCode() {
		Integer n = year*12+month;
		return n.hashCode();
	}
	
	
}
