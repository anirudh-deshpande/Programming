package com.strings;

public class Split {

	public int lastWordLength(String s){
		String[] split = s.split(" ");
		return split.length;
	}
	public static void main(String[] args){
		String s = " ";
		int len = new Split().lastWordLength(s);
	}
}
