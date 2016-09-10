package com.strings;

public class StringCompression {
	
	private boolean check(String text){
		
		char pivot = text.charAt(0);
		int count = 1;
		int compressedStringCount = 0;
		
		for(int i = 1; i < text.length(); i++){
			if(text.charAt(i) != pivot){
				compressedStringCount += 1 + String.valueOf(count).length();
				count = 1;
				pivot = text.charAt(i);
			}else{
				count++;
			}
		}
		
		compressedStringCount += 1 + String.valueOf(count).length();
		return text.length() > compressedStringCount;
	}
	
	private String compressedString(String text){
		
		if(text == null || text.length() == 0)
			return "";
		
		if(!this.check(text)){
			return text;
		}
			
		StringBuilder sb = new StringBuilder();
		char pivot = text.charAt(0);
		int count = 1;
		
		for(int i = 1; i < text.length(); i++){
			
			if(text.charAt(i) != pivot){
				sb.append(pivot).append(String.valueOf(count));
				pivot = text.charAt(i);
				count = 1;
			}else{
				count++;
			}
		}
		
		sb.append(pivot).append(String.valueOf(count));
		return sb.toString();
		
	}
	
	public static void main(String[] args){
		String s = "aaabbbbcccddddddd3333333333333333333333333333333333333333333";
		System.out.println(new StringCompression().compressedString(s));
	}

}
