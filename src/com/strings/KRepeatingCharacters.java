package com.strings;

import java.util.HashMap;
import java.util.HashSet;

public class KRepeatingCharacters {
	
	//Leetcode 395. Longest Substring with At Least K Repeating Characters
	public int longestSubstring(String s, int k) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i < s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        
        HashSet<Character> set = new HashSet<>();
        
        for(Character c : map.keySet()){
            if(map.get(c) < k){
                set.add(c);
            }
        }
        
        if(set.size() == 0){
            return s.length();
        }
        
        int i=0;
        int j=0;
        int max = Integer.MIN_VALUE;
        
        while(i < s.length()){
            char c= s.charAt(i);
            
            if(set.contains(c)){
                if(i!=j){
                    max = Math.max(max,longestSubstring(s.substring(j,i),k) );
                }
                j=i+1;
            }
            i++;
        }
        
        if(i!=j){
            max = Math.max(max,longestSubstring(s.substring(j,i),k) );
        }
        
        
        return max == Integer.MIN_VALUE ? 0 : max ;
    }
	
		int longestSubstringAnother(String s, int k) {
        int res = 0, i = 0, n = s.length();
        while (i < n) {
        	
            int[] m = new int[26];
            int mask = 0;
            int max_idx = i;
            
            for (int j = i; j < n; ++j) {
                int t = s.charAt(j) - 'a';
                ++m[t];
                if (m[t] < k) 
                	mask |= (1 << t);
                else 
                	mask &= (~(1 << t));
                
                if (mask == 0) {
                    res = Math.max(res, j - i + 1);
                    max_idx = j;
                }
            }
            i = max_idx + 1;
        }
        return res;
    }

	public static void main(String[] args){
		String s = "aaabb";
		int k = 3;
		System.out.println(new KRepeatingCharacters().longestSubstringAnother(s, k));
	}

}
