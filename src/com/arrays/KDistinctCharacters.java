package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class KDistinctCharacters {
	
	 public int lengthOfLongestSubstringKDistinct(String s, int k) {
	        
	        HashMap<Character, Integer> map = new HashMap<>();
	        
	        int max = 0;
	        int count = 0;
	        
	        for(int i = 0; i < s.length(); i++){
	            
	            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
	            
	            if(map.size() > k){
	                
	                int right_index = s.indexOf(s.charAt(i));
	                System.out.println("Rightmost: "+s.charAt(i));
	                
	                int length = 0;
	                
	                for(Character c : map.keySet()){
	                    
	                    int index = s.indexOf(c);
	                    
	                    if(index != s.indexOf(s.charAt(i)))
	                        length += map.get(c);
	                        
	                    if(index < right_index){
	                        right_index = index;
	                    }
	                    
	                }
	                
	                map.remove(s.charAt(right_index));
	                count = length;
	            }
	            
	            if(count > max){
	                max = count;
	                System.out.println("Inside: "+max);
	            }
	            
	        }
	        
//	        int length = 0;
//	        for(Character c : map.keySet()){
//	            length += map.get(c);
//	        }
//	        
//	        if(length > max){
//	            max = length;
//	            System.out.println("Outside: "+max);
//	        }
	        
	        if(map.size() == s.length()){
	            return s.length();
	        }
	        
	        // if(map.size() == k){
	        //     int length = 0;
	        //     for(Character c : map.keySet()){
	        //         length += map.get(c);
	        //     }
	        //     return length;
	        // }
	        
	        return max;
	    }
	 
	 
	 public int lengthOfLongestSubstringKDistinctLeetcode(String s, int k) {
		    Map<Character, Integer> map = new HashMap<>();
		    int left = 0;
		    int best = 0;
		    for(int i = 0; i < s.length(); i++) {
		        char c = s.charAt(i);
		        map.put(c, map.getOrDefault(c, 0) + 1);
		        while (map.size() > k) {
		            char leftChar = s.charAt(left);
		            
		                map.put(leftChar, map.get(leftChar) - 1);                     
		                if (map.get(leftChar) == 0) { 
		                    map.remove(leftChar);
		                }
		            
		            left++;
		        }
		        best = Math.max(best, i - left + 1);
		    }
		    return best;
		} 
	 
	 public static void main(String[] args){
		 KDistinctCharacters obj = new KDistinctCharacters();
		 String s = "ECEBA";
		 int k = 2;
		 
		 int max = obj.lengthOfLongestSubstringKDistinctLeetcode(s, k);
		 
		 System.out.println(max);
	 }

}
