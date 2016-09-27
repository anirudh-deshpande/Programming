package com.strings;

public class KMPSubstringSearch {
	
	private int[] getPrefixArray(String pattern){
		
		int[] lps = new int[pattern.length()];
		int index = 0;
		
		for(int i = 1; i < pattern.length(); ){
			if(pattern.charAt(index) == pattern.charAt(i)){
				lps[i] = index + 1;
				index++;
				i++;
			}else{
				if(index != 0){
					index = lps[index-1];
				}else{
					lps[i] = 0;
					i++;
				}
			}
		}
		
		return lps;
		
	}
	
	private boolean KMPhasSubString(String text, String pattern){
		int i=0; int j=0;
		int[] lps = this.getPrefixArray(pattern);
		
		while(i < text.length() && j < pattern.length()){
			if(text.charAt(i) == pattern.charAt(j)){
				i++;j++;
			}else{
				if(j != 0)
					j = lps[j-1];
				else{
					i++;
					j = 0;
				}
					
			}
		}
		
		return j==pattern.length();
	}
	
	public static void main(String[] args){
		
		String text = "abcxabcdabcdabcy";
		String pattern = "abcdabcy";
		
		System.out.println(new KMPSubstringSearch().KMPhasSubString(text, pattern));
		
	}

}
