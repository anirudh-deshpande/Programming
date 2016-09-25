package com.arrays;

public class BoyerMooreMajorityElement {
	
	public int majorityElement(int[] nums){
		
		int count = 0;
		int candidate = nums[0];
		
		for(int i = 0; i < nums.length; i++){
			if(count == 0){
				candidate = nums[i];
			}else if(nums[i] == candidate){
				count += 1;
			}else{
				count -= 1;
			}
		}
		
		return candidate;
	}
	
	public static void main(String[] args){
		int[] nums = {3,2,3};
		System.out.println(new BoyerMooreMajorityElement().majorityElement(nums)); 
	}

}
