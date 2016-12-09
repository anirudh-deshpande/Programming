package com.arrays;

import java.util.HashMap;

public class SentenceScreenFitting {
	
public int wordsTyping(String[] sentence, int rows, int cols) {
        
        HashMap<Integer, String> map = new HashMap<>();
        
        for(int i = 0; i < rows; i++){
            map.put(i, "");
        }
        
        int pass = 0;
        int words_added = 0;
        
        for(int i = 0; i < rows; i++){
            
            int remaining = cols;
            
            int j = words_added;
            while(j < sentence.length){
                
                String word = sentence[j];
                
                if(word.length() > remaining){
                    break;
                }
                
                map.put(i, map.get(i) + word + "-");
                words_added++;
                remaining -= word.length() + 1;
                //System.out.println(remaining);
                
            
                if(words_added == sentence.length){
                    pass++;  
                    words_added = 0;
                    j = words_added;
                    
                    if(i == 0){
                    	int length_of_sentence = map.get(i).length();
                    	int no_fit = cols / length_of_sentence;
                    	j = no_fit * length_of_sentence; //return no_fit * rows;
                    }
                    
                }else{
                	j++;
                }
            
            }
            
        }
        
        //System.out.println(map);
        return pass;
        
    }


public int wordsTyping3(String[] sentence, int rows, int cols) {
    String s = String.join(" ", sentence) + " ";
    int start = 0, l = s.length();
    for (int i = 0; i < rows; i++) {
        start += cols;
        if (s.charAt(start % l) == ' ') {
            start++;
        } else {
            while (start > 0 && s.charAt((start-1) % l) != ' ') {
                start--;
            }
        }
    }

    return start / s.length();
}

public int wordsTypingLeetcode2(String[] sentence, int rows, int cols) {
    String s = String.join(" ", sentence) + " ";
    int start = 0, l = s.length();
    for (int i = 0; i < rows; i++) {
        start += cols;
        if (s.charAt(start % l) == ' ') {
            start++;
        } else {
            while (start > 0 && s.charAt((start-1) % l) != ' ') {
                start--;
            }
        }
    }
    
    return start / s.length();
}


	public int wordsTypingLeetcode(String[] sentence, int rows, int cols) {
	    String s = String.join(" ", sentence) + " ";
	    int len = s.length(), count = 0;
	    int[] map = new int[len];
	    for (int i = 1; i < len; ++i) {
	        map[i] = s.charAt(i) == ' ' ? 1 : map[i-1] - 1;
	    }
	    for (int i = 0; i < rows; ++i) {
	        count += cols;
	        count += map[count % len];
	    }
	    return count / len;
	}

	public static void main(String[] args){
		String[] sentence = {"try", "to", "be", "better"};
		int rows = 10000;
		int cols = 9001;
		
		SentenceScreenFitting obj = new SentenceScreenFitting();
		
		System.out.println(obj.wordsTyping3(sentence, rows, cols));
		
		System.out.println(obj.wordsTypingLeetcode2(sentence, rows, cols));
		
		System.out.println(obj.wordsTypingLeetcode(sentence, rows, cols));
		
		System.out.println(obj.wordsTyping(sentence, rows, cols));
	}
	

}
