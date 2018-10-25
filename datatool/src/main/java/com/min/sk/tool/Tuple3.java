package com.min.sk.tool;

/**
 * 
 */

/**
 * a and b and c
 * @author min
 *
 */
public class Tuple3<A,B,C> extends Tuple2<A, B> {
	public C thrid;
    public Tuple3(A a, B b, C c) {
        super(a, b);
        this.thrid = c;
    }
}
