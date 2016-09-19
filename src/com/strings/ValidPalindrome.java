package com.strings;

public class ValidPalindrome {

	 public boolean isPalindrome(String s) {
	        
	        s = s.toLowerCase();
	        s =s.replaceAll("[^A-Za-z0-9]", "");
	        
	        int start = 0;
	        int end = s.length() - 1;
	        
	        while(start < end){
	            
	            if(s.charAt(start) != s.charAt(end))
	                return false;
	                
	            start++;
	            end--;
	        }
	        return true;
	    }
	 
	 public static void main(String[] args){
		 String s = "a b.a1";
		 
		 System.out.println(new ValidPalindrome().isPalindrome(s));
	 }
}
