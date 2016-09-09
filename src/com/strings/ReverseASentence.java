package com.strings;

public class ReverseASentence {
	
	private String reverseAString(String text){
		String reverse = "";
		
		for(int i = text.length() - 1; i >=0; i--){
			reverse += text.charAt(i);
		}
		
		return reverse;
	}
	
	private String reverseASencence(String sentence){
		
		String reversedString = this.reverseAString(sentence);
		String reversedSentence = "";
		
		String[] split = reversedString.split(" ");
		
		for(int i = 0; i < split.length; i++){
			reversedSentence += this.reverseAString(split[i]) + " ";
		}
		
		return reversedSentence;
	}
	
	public static void main(String[] args){
		String sentence = "Build number is required for testing";
		String reversed = new ReverseASentence().reverseASencence(sentence);
		System.out.println(reversed);
	}

}
