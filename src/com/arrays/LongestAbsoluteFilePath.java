package com.arrays;

import java.util.HashMap;

public class LongestAbsoluteFilePath {
	
	public int lenOfLongestFilePath(String input){
		
		String[] paths = input.split("\n");
		int[] cache = new int[paths.length + 1];
		int maxlen = 0;
		
		for(String s:paths){
			int level = s.lastIndexOf('\t') + 1;
			int curlen = cache[level] + s.length() - level + 1; 
			cache[level + 1] = curlen;
			
			if(s.contains(".")){
				maxlen = Math.max(maxlen, curlen - 1);
			}
		}
		
		return maxlen;
		
	}
	
	
	public int lenOfLongestFilePathHashMap(String input){
		
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		String[] subs = input.split("\n");

		for(int i = 0; i < subs.length; i++){
			
			String current = subs[i];
			
			int level = current.length() - current.replaceAll("\t", "").length();
			
			int length = 0;
			
			if(level == 0){
				length = current.length() + 1;
			}else{
				length = map.get(level - 1) + current.replaceAll("\t", "").length() + 1; 
			}
			
			if(current.indexOf('.') >= 0){
				max = Math.max(max, length - 1);
			}else{
				map.put(level, length);
			}
			
		}
		
		return max;
	}
	
	public static void main(String[] args){
		LongestAbsoluteFilePath obj = new LongestAbsoluteFilePath();
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		//System.out.println(input);
		int maxlen = obj.lenOfLongestFilePath(input);
		int maxlenHM = obj.lenOfLongestFilePathHashMap(input);
		System.out.println(maxlen);
		System.out.println(maxlenHM);
	}

}
