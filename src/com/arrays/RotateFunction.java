package com.arrays;

public class RotateFunction {
	
	public int rotateFunction(int[] nums){
		
		if(nums.length == 0){
			return 0;
		}
		
		int index = 0;
		int max = 0;
		int iter = 0;
		
		while(iter < nums.length){
			int value = 0;
			for(int i = 0; i < nums.length; i++){
				value += nums[i] * index++;
				if(index >= nums.length){
					index = 0;
				}
			}
			
			if(value > max){
				max = value;
			}
			
			iter++;
			index = iter;
		}
		
		return max;
		
	}
	
	public static void main(String[] args){
		int[] nums = {4, 3, 2, 6};
		
		System.out.println(new RotateFunction().rotateFunction(nums));
	}

}
