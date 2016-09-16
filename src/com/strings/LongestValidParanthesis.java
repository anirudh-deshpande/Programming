package com.strings;

import java.util.Stack;

public class LongestValidParanthesis {
	

	private int longestValidParens(String s){
		Stack<Integer> stack = new Stack<>();
		int left = -1;
		int max = 0;
		
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == '('){
				stack.push(i);
			}
			else{
				if(stack.isEmpty()){
					left = i;
				}else{
					stack.pop();
					
					if(stack.isEmpty())
						max = Math.max(max, i - left);
					else
						max = Math.max(max, i - stack.peek());
				}
			}
		}
		
		return max;
	}
	
	private int longestValidParens2(String s){
		Stack<Integer> stack = new Stack<Integer>();
	    int max=0;
	    int left = -1;
	    for(int j=0;j<s.length();j++){
	        if(s.charAt(j)=='(') 
	        	stack.push(j);            
	        else {
	            if (stack.isEmpty()) 
	            	left=j;
	            else{
	                stack.pop();
	                if(stack.isEmpty()) 
	                	max=Math.max(max,j-left);
	                else 
	                	max=Math.max(max,j-stack.peek());
	               }
	            }
	        }
	    return max;
	}
	
	public static void main(String[] args){
		String s = "()";
		System.out.println(new LongestValidParanthesis().longestValidParens(s));
	}
}
