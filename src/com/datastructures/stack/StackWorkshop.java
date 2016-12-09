package com.datastructures.stack;

import java.util.Stack;

public class StackWorkshop {
	
	public static void main(String[] args){
		
		Stack<Integer> stack = new Stack<>();
		
		stack.add(1);
		stack.add(2);
		stack.add(3);
		
		System.out.println(stack.indexOf(stack.peek()));
		
	}

}
