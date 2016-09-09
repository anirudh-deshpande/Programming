package com.strings;

public class CompareTwoStrings {
	
	public int shiftedInteger(String text){
		
		int check = 0;
		
		for(int i = 0; i < text.length(); i++){
			
			int shift = 1 << (text.charAt(i));
			check |= shift;
			
		}
		
		return check;
		
	}
	
	public boolean compareStrings(String s1, String s2){
		
		if(s1.length() != s2.length())
			return false;
			
		int shiftInt1 = this.shiftedInteger(s1);
		System.out.println(shiftInt1);
		
		int shiftInt2 = this.shiftedInteger(s2);
		System.out.println(shiftInt2);
		
		if(shiftInt1 == shiftInt2){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		System.out.println(new CompareTwoStrings().compareStrings("aacd", "dcba"));
		
	}

}
