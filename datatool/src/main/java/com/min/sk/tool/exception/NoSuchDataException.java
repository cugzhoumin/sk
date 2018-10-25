package com.min.sk.tool.exception;


/**
 * 当dataFrame中不存在指定key的数据，则抛出该异常
 * <ul>
 * 可能的异常类型
 * <li>key不存在
 * <li>key存在，但value为null
 * <li>key存在，但value转换异常
 * 
 * 
 */
public class NoSuchDataException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoSuchDataException(String string) {
		super(string);
	}

	public NoSuchDataException(Exception e) {
		super(e);
	}

}
