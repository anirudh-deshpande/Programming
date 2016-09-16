package com.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ValidParenthesisFormation {

public boolean isValid(String s){
        
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                count++;
            else if(s.charAt(i) == ')'){
                if(count == 0)
                    return false;
                count--;
            }
        }
        
        return (count == 0);
        
    }
    public List<String> removeInvalidParentheses(String s) {
        
        // ((())
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        List<String> answer = new ArrayList<>();
        
        queue.add(s);
        visited.add(s);
        
        boolean found = false;
        
        while(!queue.isEmpty()){
            s = queue.poll();
            
            if(this.isValid(s)){
                answer.add(s);
                found = true;
            }
            
            if(found){
            	continue;
            }
            
            for(int i=0; i < s.length(); i++){
                
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                String t = s.substring(0, i) + s.substring(i + 1);
                
                if(!visited.contains(t)){
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return answer;
    }
    
    public static void main(String[] args){
    	ValidParenthesisFormation vp = new ValidParenthesisFormation();
    	String s = "()())()";
    	System.out.println(vp.removeInvalidParentheses(s));
    }
	
}
