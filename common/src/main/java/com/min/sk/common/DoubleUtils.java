package com.min.sk.common;

/**
 * 
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author min
 *
 */
public class DoubleUtils {

	public static final int DEFAULT_SCALE = 3;
	
	private DoubleUtils() {
	}
	
	public static final Double APPROACH_ZERO = 0.000001;
	
	/**
	 * 是否靠近0
	 * @param value
	 * @return
	 */
	public static boolean isApproachZero(double value){
		return isApproachZero(value, APPROACH_ZERO);
	}
	/**
	 * 是否靠近0
	 * @param value
	 * @param th
	 * @return
	 */
	public static boolean isApproachZero(double value , double th){
		if (Math.abs(value) < th) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean equal(Double v1 , Double v2){
		if (v1 == null || v2 ==null) {
			if (v1==null && v2 == null) {
				return true;
			}else{
				return false;
			}
		}
		if (isApproachZero(v1-v2)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 默认保留格式
	 * @param d
	 * @return
	 */
	public static double ceilDouble(double d) {
		return ceilDouble(d, DEFAULT_SCALE);
	}
	/**
	 * 格式化
	 * @param d
	 * @param scale
	 * @return
	 */
	public static double ceilDouble(double d, int scale) {
		if (Double.isNaN(d) || Double.isInfinite(d)) {
			return d;
		} else {
			return BigDecimal.valueOf(d).setScale(scale, RoundingMode.HALF_UP)
					.doubleValue();
		}
	}
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isLegal(Double value){
		if (value != null && !Double.isNaN(value) && !Double.isInfinite(value)) {
			return true;
		}
		return false;
	}
	
    public static double format(Double value) {
		DecimalFormat df = new DecimalFormat("#.00");
        if (Double.isNaN(value) || value == null || value.isNaN()) {
            return 0;
        }
		return Double.valueOf(df.format(value));
	}
    public static double format2(Double value) {
        if (value == null || new Double(value).isNaN()) {
            return 0;
        } else {
            DecimalFormat df = new DecimalFormat("#.00");
            return Double.valueOf(df.format(value));

        }
    }
}
