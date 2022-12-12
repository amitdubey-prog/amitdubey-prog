package com.amit.demo;

public class StringUtil {

	public String  reverse(String str) {
		
		if (str==null || str== "")
			throw new IllegalArgumentException("Please pass valid argument");
		StringBuilder sb = new StringBuilder(str);
		StringBuilder reverse = sb.reverse();
		return reverse.toString();
	}

}
