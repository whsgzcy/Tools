package com.migu.sf.util;

public class StringUtil {
	
	/**
	 * str is null or empty
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str){
		
		if(str == null || str.isEmpty()) return true;
		
		return false;
	}

}