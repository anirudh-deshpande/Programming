package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs){
		
		Map< List<Integer>, List<String> > map = new HashMap<>();
		
		for(int i = 0; i < strs.length; i++){
		
			Integer[] charArray = new Integer[26];
			Arrays.fill(charArray, 0);
			
			for(int j = 0; j < strs[i].length(); j++){
				charArray[strs[i].charAt(j) - 97]++;
			}
			
			List<Integer> list = Arrays.asList(charArray);
			
			if(!map.containsKey(list)){
				map.put(list, new ArrayList<String>());
			}
			
			map.get(list).add(strs[i]);

		}
		
		List<List<String>> answer = new ArrayList<>();
		answer.addAll(map.values());
		return answer;
		
	}
	
	public List<List<String>> groupAnagrams2(String[] strs){
		
		Map<Integer, List<String>> map = new HashMap<>();
		
		for(int i = 0; i < strs.length; i++){
			
			String str = strs[i];
			
			int check = 0;
			
			for(int j = 0; j < str.length(); j++){
				
				int shift = 1 << (str.charAt(j) - 97);
				check += shift;
				
			}
			
			if(!map.containsKey(check))
				map.put(check, new ArrayList<String>());
			
			map.get(check).add(str);
			
		}
		
		//Because the compiler does not know it is a list of Strings
		List<List<String>> ans = new ArrayList<>();
		ans.addAll(map.values());
		
		return ans;
		
	}
	
	public static void main(String[] args){
		
		String[] strs = {"abc", "bca", "aabc"};
		System.out.println(new GroupAnagrams().groupAnagrams(strs));
		System.out.println(new GroupAnagrams().groupAnagrams2(strs));
	}

}
