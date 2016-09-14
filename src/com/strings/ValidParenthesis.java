package com.strings;

import java.util.Stack;

public class ValidParenthesis {
	
public boolean isValid(String s) {
        
        // ({[]})    ({ ]
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            switch(c){
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                    
                case ']':
                    if(stack.isEmpty() || !(stack.peek() == '[')){
                        return false;
                    }else{
                        stack.pop();
                        continue;
                    }
                
                case '}':
                    if(stack.isEmpty() || !(stack.peek() == '{')){
                        return false;
                    }else{
                        stack.pop();
                        continue;
                    }
                    
                case ')':
                    if(stack.isEmpty() || !(stack.peek() == '(')){
                        return false;
                    }else{
                        stack.pop();
                        continue;
                    }
            }
            
        }
        return stack.isEmpty();
        
    }

	public static void main(String args[]){
		String s = "({[]})";
		System.out.println(new ValidParenthesis().isValid(s));
	}

}
