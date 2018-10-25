package com.min.sk.tool.exception;

                           
/**
 * dataframe build error
 * @author min
 * 
 */
public class DataFrameBuildException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataFrameBuildException(){
		
	}
	public DataFrameBuildException(String msg) {
		super(msg);
	}

	public DataFrameBuildException(Throwable e) {
		super(e);
	}
}
