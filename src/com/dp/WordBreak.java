package com.dp;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	public boolean wordBreakRecursive(String s, Set<String> set){
		
		if(set.contains(s)){
			return true;
		}
		
		for(int i = 0; i < s.length(); i++){
			if(set.contains(s.substring(0, i)) && wordBreakRecursive(s.substring(i), set)){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean wordBreakDP(String s, Set<String> set){
		
		boolean[] opt = new boolean[s.length() + 1];
		
		opt[0] = true;
		
		for(int i = 0; i <= s.length(); i++){
			
			for(int j = 0; j < i; j++){
				
				if(opt[j] == true && set.contains(s.substring(j, i))){
					opt[i] = true;
				}
				
			}
			
		}
		
		return opt[s.length()];
		
	}
	
	
	public static void main(String[] args){
		String s = "ilovemyindia";
		Set<String> set = new HashSet<>();
		
		set.add("i");
		set.add("love");
		set.add("my");
		set.add("people");
		set.add("india");
		
		WordBreak wb = new WordBreak();
		
		System.out.println(wb.wordBreakRecursive(s, set));
		System.out.println(wb.wordBreakDP(s, set));
		
	}
}
