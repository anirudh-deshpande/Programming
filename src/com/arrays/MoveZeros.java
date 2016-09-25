package com.arrays;

import java.util.Arrays;

public class MoveZeros {
	//283. Move Zeroes
	
	private void moveZeros(int[] nums){
		int firstNonZeroIndex = 0;
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != 0){
				nums[firstNonZeroIndex] = nums[i];
				firstNonZeroIndex++;
			}
		}
		
		for(int i = firstNonZeroIndex; i < nums.length; i++){
			nums[i] = 0;
		}
	}
	
	public static void main(String[] args){
		int[] nums = {0, 0, 2, 3, 0, 1, 0, 0, 4, 5, 7};
		new MoveZeros().moveZeros(nums);
		System.out.println(Arrays.toString(nums));
	}
}
