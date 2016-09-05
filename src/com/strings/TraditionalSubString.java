package com.strings;

public class TraditionalSubString {
	
	private boolean hasSubString(String text, String pattern){
		
		int i=0; int j=0; int k=0;
		
		while(i < text.length() && j < pattern.length()){
			if(text.charAt(i) == pattern.charAt(j)){
				i++;
				j++;
			}else{
				k++;
				i=k;
				j=0;
			}
		}
		
		return j == pattern.length();
	}
	
	
	public static void main(String[] args){
		
		String text = "abcxabcdabcdabcy";
		String pattern = "abcdabcy";
		
		System.out.println(new TraditionalSubString().hasSubString(text, pattern));
		
		
	}

}
