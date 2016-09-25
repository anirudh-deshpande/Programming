package com.arrays;

import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        
        int firstNonVal = 0;
        int n = nums.length;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(nums[i] != val){
                nums[firstNonVal++] = nums[i];
                count++;
            }
            
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }
    
    public static void main(String[] args){
    	int[] nums = {3, 2, 1, 3};
    	int val = 3;
    	System.out.println(new RemoveElement().removeElement(nums, val));
    }
	
}
