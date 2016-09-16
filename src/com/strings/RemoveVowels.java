package com.strings;

public class RemoveVowels {
public String reverseVowels(String s) {
        
        //leetcode -> loetcede
        
        String vowels = "aeiouAEIOU";
        char[] sArray = s.toCharArray();
        char[] vArray = vowels.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        
        
        while(start < end){
            
            while(start < end && (vowels.indexOf(sArray[start]) == -1))
                start++;
                
            while(start < end && (vowels.indexOf(sArray[end]) == -1))
                end --;
                
            char temp = sArray[start];
            sArray[start] = sArray[end];
            sArray[end] = temp;
            
            start++;
            end--;
        }
        
        return String.valueOf(sArray);
    }
}
