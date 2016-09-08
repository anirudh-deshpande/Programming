package com.strings;

public class StringToNumber {
	
	public int convertToNumber(String num){
		
		int returnVal = Integer.MIN_VALUE;
		
		if(num.length() == 0){
			return returnVal;
		}
		
		for(int i = 0; i < num.length(); i++){
			if(num.charAt(i) < '0' || num.charAt(i) > '9'){
				return returnVal;
			}
		}
		
		int n = num.length();
		int power = 0;
		
		returnVal = 0;
		for(int i = n-1; i >= 0; i--){
			returnVal += (num.charAt(i) - 48) * (int)Math.pow(10, power++);
		}
		
		return returnVal;
		
	}
	
	public static void main(String[] args){
		String num = "123456";
		int convertedNumber = new StringToNumber().convertToNumber(num);
		System.out.println(convertedNumber);
	}

}
