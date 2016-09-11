package com.strings;

public class FindMinimumRmvKDigits {
	
	public static String removeIndex(String lower, int index){
		
		StringBuilder result = new StringBuilder();
		
		if(index > 0){
			result.append(lower.substring(0, index));			
		}
		
		if(index < lower.length() - 1){
			result.append(lower.substring(index + 1));
		}
		
		return result.toString();
	}
	
	public static String rmvKAnomalies(String str, int remove){
		
		String lower = str;
		
		while(remove > 0){
			
			//Remove the first anomaly
			/*
			 * Logic: 1st index i greater than (i + 1) is an anomaly
			 */
			int index = -1;
			
			for(int i = 0; i < lower.length() - 1; i++){
				if(lower.charAt(i) > lower.charAt(i + 1)){
					index = i;
					break;
				}
			}
			
			if(index >= 0){
				lower = removeIndex(lower, index);
			}else{
				lower = removeIndex(lower, lower.length() - 1);
			}
			
			remove--;
		}
		
		return lower;
		
	}
	
	public static void main(String[] args){
		String str = "765028321";
		int remove = 5;
		
		String lower = FindMinimumRmvKDigits.rmvKAnomalies(str, remove);
		
		System.out.println(lower);
	}

}
