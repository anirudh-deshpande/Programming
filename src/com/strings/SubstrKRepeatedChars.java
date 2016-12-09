package com.strings;

import java.util.HashMap;
import java.util.Map;

public class SubstrKRepeatedChars {
	
	int longestSubstring(String s, int k) {
		
        int res = 0, i = 0, n = s.length();
        
        while (i + k <= n) { 
            	Map<Character, Integer> map = new HashMap<>();
        		int mask = 0; 
            	int max_idx = i;
            	
            	int j;
            for (j = i; j < n; ++j) {
                int t = s.charAt(j) - 'a';
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                
                if (map.get(s.charAt(j)) < k) 
                		mask |= (1 << t);
                else 
                		mask &= (~(1 << t));
                
                if (mask == 0) {
                		map.remove(s.charAt(j));
                    res = Math.max(res, j - i + 1);
                    max_idx = j;
                }
            }
            i = max_idx + 1;
        }
        return res;
    }
	
	private int longestSubStringMine(String s, int k){
		
		HashMap<Character, Integer> map = new HashMap<>();
		int checker = 0;
		int start = 0;
		int res = 0;
		
		for(int i = 0; i < s.length(); i++){
			
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			
			int count = map.get(c); 
			
			if(count < k){
				checker |= 1 << (c - 'a');
			}else{
				checker &= ~(1 << (c - 'a'));
			}
			
			if(checker == 0){
				map.remove(c);
				res = Math.max(res, i - start);
				start = i + 1;
			}
			
		}
		
		return res;
		
	}
	
	public int longestSubStringAnotner(String s, int k){
		int res = 0, i = 0, n = s.length();
        
        while (i + k < n) {
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
		String s = "abavbdbc";
		int num = new SubstrKRepeatedChars().longestSubStringAnotner(s, 2);
		System.out.println(num);
		
	}

}
