package com.sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public int[] selectionSort(int[] nums){
		
		int n = nums.length; int x = 0; int y = 0;
		
		for(x = 0; x < n; x++){
			
			int index_min = x;
			
			int min = Integer.MAX_VALUE;
			
			for(y = x; y < n; y++){
				if(nums[y] < min){
					min = nums[y];
					index_min = y;
				}
			}
			
			int temp = nums[x];
			nums[x] = nums[index_min];
			nums[index_min] = temp;
		}
		
		return nums;
		
	}
	
	public static void main(String[] args){
		int[] nums = {3, 4, 3, 1, 2, 5, 6, 7, 2, 3, 4, 1};
		int[] sorted = new SelectionSort().selectionSort(nums);
		
		System.out.println(Arrays.toString(sorted));
	}

}
