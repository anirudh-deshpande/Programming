package com.strings;

import java.util.HashSet;

public class SubstrWithoutRepeatingChars {
	
public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> set = new HashSet<>();
        
        int ans = 0; 
        int j = 0;
        int i = 0;
        
        while(i < s.length() && j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        
        return ans;
        
    }

}
