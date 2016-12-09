package com.sorting;
import java.util.Arrays;
import java.util.Random;

public class RandomShuffle {

	public static void main(String[] args){
		
		Random random = new Random();
		
		int[] nums = {1, 2, 3}; 
		
		for(int i = 0; i < nums.length; i++){
			int r = random.nextInt(i+1);
			
			System.out.println("Random: "+r);
			
			int temp = nums[i];
			nums[i] = nums[r];
			nums[r] = temp;
		}
		
		System.out.println(Arrays.toString(nums));
	}
	
	
}
