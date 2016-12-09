package com.arrays;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
	
	//Leetcode #384
	
	int[] nums;
	int[] original;
	
	public ShuffleAnArray(int[] nums){
		
		this.nums = new int[nums.length];
		this.original = new int[nums.length];
		int n = nums.length;
		
		for(int i = 0; i < n; i++){
			this.nums[i] = nums[i];
			this.original[i] = nums[i];
		}
		
	}
	
	
	public int[] shuffle(){
		
		Random rn = new Random();
		int n = this.nums.length;
		
		for(int i = 0; i < n; i++){
			
			int random_index = rn.nextInt(i + 1);
			
			int temp = this.nums[random_index];
			this.nums[random_index] = this.nums[i];
			this.nums[i] = temp;
			
		}
		return this.nums;	
	}
	
	public int[] reset(){
		
		int n = this.nums.length;
		
		for(int i = 0; i < n; i++){
			this.nums[i] = this.original[i];
		}
		
		return this.nums;
		
	}
	
	public static void main(String[] args){
		
		int[] nums = {1, 2, 3, 4, 5, 6};
		ShuffleAnArray obj = new ShuffleAnArray(nums);
		
		System.out.println(Arrays.toString(obj.shuffle()));
		
		System.out.println(Arrays.toString(obj.shuffle()));
		
		System.out.println(Arrays.toString(obj.reset()));
		
	
	}
	

}
