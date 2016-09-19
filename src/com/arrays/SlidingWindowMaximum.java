package com.arrays;

import java.util.Arrays;

public class SlidingWindowMaximum {
	//239. Sliding Window Maximum
	
	
	public int maximum(int[] nums, int start, int end){
        int max = 0;
        for(int i = start; i <= end; i++){
            if(nums[i] > max)
                max = nums[i];
        }
        return max;
    }
    
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums.length == 0 || nums.length == 1 || k == 1){
            return nums;
        }
        
        //Create the sliding window
        if(nums.length == 0 || nums.length == 1 || k == 1){
            return nums;
        }
        
        //Create the sliding window
        int i = 0, j = 0;
        int[] list = new int[nums.length - (k - 1)];
        int l = 0;
        
        while(j < (k - 1))
            j++;
            
        while(j < nums.length){
            int max = maximum(nums, i, j);
            list[l++] = max;
            i++;
            j++;
        }
        return list;
    }
    
    public static void main(String[] args){
    	int[] nums = {9, 11};
    	int k = 2;
    	int[] max = new SlidingWindowMaximum().maxSlidingWindow(nums, k);
    	System.out.println(Arrays.toString(max));
    }

}
