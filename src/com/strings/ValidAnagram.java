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
	
	/*
	Anagram: 

		s1= aabdbcc
		s2= abceabc

		s1, s2 are called anagrams

		a = 2
		b = 2
		c = 2



		int[] buffer = new int[27];
		buffer[0] =>  # of a's in the String = 2
		buffer[1] =>  # of b's in the String = 2
		buffer[2] =>  # of b's in the String = 2
		buffer[3] =>  # of b's in the String = 1
		. 
		.
		.
		.
		.
		buffer[26] =>  # of z's in the String = 0


		for(int i = 0; i < s1.length(); i++) {
		  int ch = s1.charAt(i); // 'b' -> 97
		  int index = ch - 'a'; // index = 1
		  buffer[index] = buffer[index] + 1;
		}

		buffer: [2, 2, 2, 1, 0, ...... 0]

		for(int i = 0; i < s2.length(); i++) {
		  int ch = s2.charAt(i);
		  int index = ch - 'a';
		  buffer[index] = buffer[index] - 1;
		}

		buffer = [0, 0, 0, 1, -1, 0]

		for(int i = 0; i <= 26; i++) {
		  if(buffer[i] != 0) {
		    return false;
		  }  
		}

		return true;

		//abceabc
		buffer = [0, 0, 0, 1, -1, 0]

	*/

}
