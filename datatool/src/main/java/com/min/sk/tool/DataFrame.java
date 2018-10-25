/**
 * 
 */
package com.min.sk.tool;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.management.openmbean.KeyAlreadyExistsException;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import com.min.sk.tool.exception.NoSuchDataException;


/**
 * a data frame 
 * @author min
 *
 */
public class DataFrame {
	private Map<String, Object> map = new HashMap<String, Object>();

	public DataFrame(){
		map = new HashMap<String, Object>();
	}
	/**
	 * @return the map
	 */
	public Map<String, Object> getMap() {
		return map;
	}

	public boolean isEmpty(){
		return MapUtils.isEmpty(map);
	}
	
	/**
	 * remove key
	 * @param key
	 */
	public void removeByKey(String key) {
		if (map.containsKey(key)) {
			map.remove(key);
		}
	}
	/**
	 * 从数据框中找到某个关键字对应的数据
	 * 
	 * @param key
	 * @param cls
	 * @throws NoSuchFieldError
	 * @return
	 * @throws NoSuchFieldException
	 */
	@SuppressWarnings("unchecked")
	public <T> T getDataByKey(String key, Class<T> cls) throws NoSuchDataException {
		try {
			if (map.containsKey(key)) {
				T t = (T) map.get(key);
				if (t != null) {
					return t;
				}
			}
		} catch (Exception e) {
			throw new NoSuchDataException(e);
		}

		throw new NoSuchDataException("does not find data named " + key + " in dataframe ");
	}

	/**
	 * @param key
	 * @return
	 */
	public boolean existKey(String key) {
		if (map.containsKey(key)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 向数据框中添加某个关键字对应的数据
	 * 
	 * @param key
	 * @param data
	 * @param override
	 * @throws KeyAlreadyExistsException
	 */
	public void add(String key, Object data, boolean override) {
		if (map.containsKey(key) && !override) {
			throw new KeyAlreadyExistsException(key);
		}
		map.put(key, data);
	}
	
	/**
	 * 清空数据
	 */
	public void clear() {
		this.map.clear();
	}	
	
	@Override
	public String toString() {
//		return map.toString();
		StringBuilder sb = new StringBuilder();
		sb.append("\n{\n");
		for(Entry<String,Object> e : map.entrySet()) {
			sb.append(e.getKey()).append("=").append(e.getValue()).append(",\n");
		}
		sb.append("}");
		
		return sb.toString();
	}	
	public String toExcString(Date bd,Date ed){
		List<TS> tsList = new ArrayList<TS>();
		List<String> nameList = new ArrayList<String>();
		for(Entry<String,Object> e : map.entrySet()) {
			if(e.getValue() instanceof TS){
				tsList.add((TS)e.getValue());
				nameList.add(e.getKey());
			}
		}

		Date curDate = bd;
		StringBuffer sb = new StringBuffer();
		sb.append("date").append("\t");
		for(String string : nameList){
			sb.append(string).append("\t");
		}
		sb.append("\n");
		while(curDate.before(ed) || curDate.equals(ed)){
			sb.append(DateFormatUtils.format(curDate, "yyyy-MM-dd")+"\t");
			for(TS ts : tsList){
				Double value = ts.getData(curDate);
				if (value != null) {					
					sb.append(ts.getData(curDate)+"\t");
				}else {
					sb.append(""+"\t");
				}
			}
			sb.append("\n");
			curDate = DateUtils.addDays(curDate, 1);
		}
		return sb.toString();
	}
}
