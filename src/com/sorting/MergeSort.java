package com.sorting;

import java.util.Arrays;

public class MergeSort {
	
	public void mergeSort(int[] nums, int low, int high){
		
		
		if(low < high){
		
			int mid = (low + high) / 2;
			mergeSort(nums, low, mid);
			mergeSort(nums, mid + 1, high);
			merge(nums, low, mid, high);
		}
		
	}
	
	public void merge(int[] nums, int low, int mid, int high){
		
		int[] aux = new int[(high - low) + 1];
		
		int i = low;
		int j = mid + 1;
		int k = 0;
		
		while(i <= mid && j <= high){
			if(nums[i] < nums[j]){
				aux[k] = nums[i];
				i++;
			}else{
				aux[k] = nums[j];
				j++;
			}
			k++;  
		}
		
		if(j <= high){
			while(j <= high){
				aux[k] = nums[j];
				k++;j++;
			}
		}
		
		 if(i <= mid){
			while(i <= mid){
				aux[k] = nums[i];
				k++;i++;
			}
		}
		
		for(k = 0; k < aux.length; k++){
			nums[low + k] = aux[k];
		}
	}
	
	public static void main(String[] args){
		int[] nums = {3, 4, 3, 1, 2, 5, 6, 7, 2, 3, 4, 1};
		new MergeSort().mergeSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

}
