package com.arrays;

import java.util.HashMap;

public class ContainsDuplicateII {
	
	public boolean containsDuplicateII(int[] nums, int k){
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++){
			
			if(map.containsKey(nums[i])){
				int index = map.get(nums[i]);
				if(i - index <= k){
					return true;
				}
			}
			map.put(nums[i], i);
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 4, 5, 6, 1};
		int k = 6;
		
		System.out.println(new ContainsDuplicateII().containsDuplicateII(nums, k));
	}

}
