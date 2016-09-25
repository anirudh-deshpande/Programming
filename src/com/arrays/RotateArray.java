package com.arrays;

import java.util.Arrays;

public class RotateArray {
	
	public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        
        k %= nums.length;
        
        this.reverse(nums, 0, nums.length - 1); 
        this.reverse(nums, 0, k - 1);
        this.reverse(nums, k, nums.length - 1);
    }

    public static void main(String[] args){
    	int[] nums = {1, 2, 3};
    	int k = 4;
    	new RotateArray().rotate(nums, k);
    	
    	System.out.println(Arrays.toString(nums));
    }



}
