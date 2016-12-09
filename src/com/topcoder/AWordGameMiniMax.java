package com.topcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AWordGameMiniMax{
	List<String> words = new ArrayList<String>();
    
    //Returns the word uttered by loosing candidate
    public String minimax(String soFar){    	
        String result = null;
        boolean[] seen = new boolean[256];
        
        for(int i = 0; i < words.size(); i++){
        	String word = words.get(i);
            if(word.equals(soFar)){
            	return "";
            }else if(word.startsWith(soFar)){
            	char ch = word.charAt(soFar.length());
                if(seen[ch]){
                	continue;
                }
                seen[ch] = true;
                String newResult = ch + minimax(word.substring(0, soFar.length() + 1));
                if(newResult.length() % 2 == 0){
                    //Choose the minimum
                    if(result == null || result.length() % 2 == 1 || newResult.length() < result.length()){
                    	result = newResult;
                    }
                }else{
                    //Choose the maximum
                	if(result == null || result.length() % 2 == 1 || newResult.length() > result.length()){
                    	result = newResult;
                    }
                }
            }
        }
    	return result;
    }
    
    public String outcome(String[] sentences){    	
        for(int i = 0; i < sentences.length; i++){
        	String[] all_words = sentences[i].split(" ");            
            for(int j = 0; j < all_words.length; j++){
            	words.add(all_words[j]);
            }            
        }
        return minimax("");
    }
    
    public static void main(String[] args){
    	String[] words = {"pascal program programmer task tree", "treacherous treachery tread trace"};
    	AWordGameMiniMax obj = new AWordGameMiniMax();
    	System.out.println(obj.outcome(words));
    }
}

class AWordGame {
	 ArrayList words = new ArrayList();
	    String minimax(String soFar){
	        String ret = null;
	        boolean branched[] = new boolean[256];
	        for(int i = 0; i<words.size(); i++){
	            String w = words.get(i).toString();
	            if(w.equals(soFar)){
	                return "";
	            }else if(w.startsWith(soFar)){
	                char ch = w.charAt(soFar.length());
	                if(branched[ch])continue;
	                branched[ch] = true;
	                String s = ch + minimax(w.substring(0,soFar.length()+1));
	                if(s.length()%2==0){
	                    if(ret==null || ret.length()%2 == 1 || s.length() < ret.length()){
	                        ret = s;
	                    }
	                }else if(ret == null || ret.length()%2 == 1 && s.length() > ret.length()){
	                	//if(s.length() > ret.length()){
	                	ret = s;
	                }
	            }
	        }
	        return ret;
	    }
	    
	    public String outcome(String[] wordList){
	        for(int i = 0; i<wordList.length; i++){
	            String[] sp = wordList[i].split(" ");
	            for(int j = 0; j<sp.length; j++){
	                words.add(sp[j]);
	            }
	        }
	        Collections.sort(words);
	        return minimax("");
	    }
	    
	    public static void main(String[] args){
	    	String[] words = {"task tasp"};
	    	AWordGameMiniMax obj = new AWordGameMiniMax();
	    	System.out.println(obj.outcome(words));
	    }
	
}
