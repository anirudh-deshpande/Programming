package com.sorting;

import java.util.Arrays;

public class ShellSort {
	
	public int[] shellSort(int[] nums){
		int n = nums.length;
		
		int h = 1;
		
		while(h < n/3) 
			h = 3*h + 1;
		
		while(h >= 1){
			for(int i = h; i < n; i++){
				for(int j = i; j >= h; j -= h){
					if(nums[j] < nums[j - h]){
						int temp = nums[j];
						nums[j] = nums[j - h];
						nums[j - h] = temp;
					}
				}
			}
			h = h / 3;
		}
		return nums;
	}
	
	public static void main(String[] args){
		int[] nums = {3, 4, 3, 1, 2, 5, 6, 7, 2, 3, 4, 1};
		nums = new ShellSort().shellSort(nums);
		System.out.println(Arrays.toString(nums));
		
	}

}
