package com.strings;

import java.util.HashSet;

public class ValidAnagram {
	
public boolean isAnagram(String s, String t) {
        
        int[] m = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            m[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < t.length(); i++){
            m[t.charAt(i) - 'a']--;
        }
        
        for(int i = 0; i < 26; i++){
            if(m[i] != 0)
                return false;
        }
        
        return true;
    }
    
    public static void main(String[] args){
    	String s = "aacc";
    	String t = "ccac";
    	
    	System.out.println(new ValidAnagram().isAnagram(s, t));
    	
    	//SUITABLE ONE IS MANY POINTER METHOD IN ARRAYS M[26]
    }

}
