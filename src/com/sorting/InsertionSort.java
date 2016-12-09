package com.sorting;

import java.util.Arrays;

public class InsertionSort {
	
	public int[] insertionSort(int[] nums){
		
		int n = nums.length;
		for(int i = 0; i < n; i++){
			
			for(int j = i; j > 0; j--){
				if(nums[j] < nums[j - 1]){
					int temp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = temp;
				}else{
					break;
				}
			}
			
		}
		return nums;
		
	}
	
	public static void main(String[] args){
		int[] numbers = {3, 4, 3, 1, 2, 5, 6, 7, 2, 3, 4, 1};
		new InsertionSort().insertionSort(numbers);
		System.out.println(Arrays.toString(numbers));
		
	}

}
