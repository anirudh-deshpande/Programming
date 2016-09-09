package com.strings;

public class UniqueCharacters {
	
	public boolean isUniqueCharacters(String str){
		
		if(str.length() < 2)
			return true;
		
		int checker = 0;
		str = str.toLowerCase();
		
		for(int i = 0; i < str.length(); i++){
			
			int val = 1 << (str.charAt(i) - 97);
			
			if((val & checker) != 0){
				return false;
			}
			
			checker = checker | val;
		}
		
		return true;
		
	}
	
	public static void main(String[] args){
		String s = "abcdefghi";
		
		System.out.println(new UniqueCharacters().isUniqueCharacters(s));
	}

}
