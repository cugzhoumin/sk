package com.min.sk.tool;

/**
 * 
 */

import java.util.Date;

/**
 * @author min
 *
 */
public enum PointType {
	
	DATE(Date.class),
	YEAR(Object.class),  //TODO 
	YEAR_MONTH(YearMonth.class),
	YEAR_WEEK(YearWeek.class);
	
	private Class<?> className;

	private PointType(Class<?> className) {
		this.className = className;
	}

	/**
	 * @return the className
	 */
	public Class<?> getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(Class<?> className) {
		this.className = className;
	} 
	
}
