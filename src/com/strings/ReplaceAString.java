package com.strings;

public class ReplaceAString {
	
	private String replaceAStringUsingSB(String text, String replacement){
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < text.length(); i++){
			if(text.charAt(i) == ' '){
				sb = sb.append(replacement);
			}else{
				sb = sb.append(text.charAt(i));
			}
		}
		
		return sb.toString();
		
	}
	
	private String replaceAString(String text, String replacement){
		
		int numberOfSpaces = 0;
		
		for(int i = 0; i < text.length(); i++){
			if(text.charAt(i) == ' '){
				numberOfSpaces++;
			}
		}
		
		int newLength = text.length() + numberOfSpaces * 2;
		int j = 0;
		
		char[] replaced = new char[newLength];
		
		for(int i = text.length() - 1; i >= 0 ; i--){
			if(text.charAt(i) == ' '){
				replaced[newLength - 1] = '0';
				replaced[newLength - 2] = '2';
				replaced[newLength - 3] = '%';
				
				newLength -= 3;
			}else{
				replaced[newLength - 1] = text.charAt(i);
				newLength -= 1;
			}
		}
		
		return String.valueOf(replaced);
	}
	
	public static void main(String[] args){
		ReplaceAString replace = new ReplaceAString();
		
		String replaced1 = replace.replaceAStringUsingSB("Anirudh is good!", "%20");
		System.out.println(replaced1);
		
		String replaced2 = replace.replaceAString("Anirudh is good!", "%20");
		System.out.println(replaced2);
		
	}

}
