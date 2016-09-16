package com.strings;

import java.util.Arrays;

public class CommonPrefix {

	private String commonPrefix(String[] array){
		
		Arrays.sort(array);
		
		String first = array[0];
		String last = array[array.length - 1];
		
		int len = first.length() < last.length() ? first.length() : last.length();
		int end = 0;
		
		for(int i = 0; i < len; i++){
			if(first.charAt(i) == last.charAt(i)){
				end++;
			}else{
				break;
			}
		}
		return first.substring(0, end);
	}
	
	
	public static void main(String[] args){
		String[] array = {"anagrams of a number", "anamika", "anathemaa"};
		Arrays.sort(array);
		System.out.println(Arrays.asList(array));
		
		System.out.println(new CommonPrefix().commonPrefix(array));
	}
}
