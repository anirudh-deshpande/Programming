package com.strings;

public class CheckAnagramPalindrome {

	private boolean IsAnagramPalindrome(String text){
		
		int checker = 0;
		int mask = 1;
		
		for(int i=0; i < text.length();i++){
			mask = 1 << text.charAt(i);
			checker = checker ^ mask;
		}
		
		if(checker == 0 || (checker & (checker-1)) == 0)
			return true;
		
		return false;
		
	}
	
	public static void main(String[] args){
		String str1 = "axyxbcbxyxa";
		String str2 = "cbxyxazaxyxb";
		
		System.out.println(new CheckAnagramPalindrome().IsAnagramPalindrome(str1));
		System.out.println(new CheckAnagramPalindrome().IsAnagramPalindrome(str2));
	}
	
}
