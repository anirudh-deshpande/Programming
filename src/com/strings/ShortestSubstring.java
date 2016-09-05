package com.strings;

public class ShortestSubstring {
	
	private String shortestSubString(String text, String...sub){
		
		String shortMatch = "";
		int shortMatchLength = Integer.MAX_VALUE;
		
		for(int i = text.length()-1; i >= 0; i--){
			
			String subText = text.substring(i);
			
			int index = -1;
			int start = Integer.MAX_VALUE;
			int end = -1;
			
			for(int j = 0; j < sub.length; j++){
				index = subText.indexOf(sub[j]);
				start = Math.min(start, index);
				end = Math.max(end, index == -1 ? -1 : index + sub[j].length());
			}
			
			if(start == -1)
				continue;
			
			String matchedString = subText.substring(start, end);
			System.out.println(matchedString);
			
			if(matchedString.length() < shortMatchLength){
				shortMatchLength = matchedString.length(); 
				shortMatch = matchedString;
			}
		}
		return shortMatch;
	}
	
	public static void main(String[] args){
		System.out.println(new ShortestSubstring().shortestSubString("anirudhabcdruebc", "ru", "bc"));
	}

}
