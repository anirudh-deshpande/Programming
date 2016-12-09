package com.dp;

public class NumArithmeticSlicesSubArray {
	
	public int numSlices(int[] nums){
		
		int n = nums.length;
		
		if(n <= 2){
			return 0;
		}
		
		int sum = 0;
		int count = 0;
		
		for(int i = 2; i < n; i++){
			if((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])){
				count++;
				sum += count;
			}else{
				count = 0;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args){
	
		NumArithmeticSlicesSubArray obj = new NumArithmeticSlicesSubArray();
		int[] nums = {1, 2, 3, 10, 5};	
		System.out.println(obj.numSlices(nums));
		
	}
	

}
