package com.arrays;

import java.util.Arrays;

public class PlusOne {
	
	 public int[] plusOne(int[] digits) {
	        
	        for(int i = digits.length - 1; i >= 0; i--){
	            if(digits[i] < 9){
	                digits[i]++;
	                return digits;
	            }
	            digits[i] = 0;
	        }
	        
	        int[] newNumber = new int[digits.length + 1];
	        newNumber[0] = 1;
	        
	        return newNumber;
	        
	    }

	public static void main(String[] args){
		PlusOne obj = new PlusOne();
		int[] digits = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
		System.out.println(Arrays.toString(obj.plusOne(digits)));
		
	}

}
