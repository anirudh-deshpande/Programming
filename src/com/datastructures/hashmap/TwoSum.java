package com.datastructures.hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

	public void isSumTarget(int[] nums, int target){

		HashMap<Integer, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();

		
		
		for(int i = 0; i < nums.length; i++){
			
			if(!set.contains(nums[i])){
				
				set.add(nums[i]);
				
				if(map.containsKey(nums[i])){
					System.out.println("The numbers are: " + nums[i] +" and "+map.get(nums[i]));
					map.remove(nums[i]);	
				}else{
					int key = target - nums[i]; 		
					map.put(key, nums[i]);
				}
			}
			
		}

	}
	
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 3, 4, 5};
		int target = 6;
		
		TwoSum ts = new TwoSum();
		
		ts.isSumTarget(nums, target);
		
	}

}
