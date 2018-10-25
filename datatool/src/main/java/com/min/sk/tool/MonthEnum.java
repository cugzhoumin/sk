package com.min.sk.tool;

/**
 * 
 */

/**
 * @author min
 *
 */
public enum MonthEnum {

	Jan(1,"Jan",1),
	Feb(2,"Feb",2),
	Mar(3,"Mar",3),
	Apr(4,"Apr",4),
	May(5,"May",5),
	Jun(6,"Jun",6),
	Jul(7,"Jul",7),
	Aug(8,"Aug",8),
	Sep(9,"Sep",9),
	Oct(10,"Oct",10),
	Nov(11,"Nov",11),
	Dec(12,"Dec",12);
	
	private int i;
	private String name;
	private int month;
	
	private MonthEnum(int i, String name, int month) {
		this.i = i;
		this.name = name;
		this.month = month;
	}
	
	public static MonthEnum valueOfI(int i){
		for(MonthEnum e : MonthEnum.values()){
			if (e.getI() == i) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * @return the i
	 */
	public int getI() {
		return i;
	}
	/**
	 * @param i the i to set
	 */
	public void setI(int i) {
		this.i = i;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	
	
}
