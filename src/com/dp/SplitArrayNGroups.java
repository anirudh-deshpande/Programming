package com.dp;

public class SplitArrayNGroups {
	
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 4, 5};		
		for(int i = 0; i < nums.length; i++){
			System.out.println("Group: " + Math.floor(i / (nums.length/3)) + 1);
		}
	}

}
