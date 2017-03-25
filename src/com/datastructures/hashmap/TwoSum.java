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
	/*
	array = {5, 1, 2, 4, 3}
		target = 7

		find 2 elements in the array which equals to target


		var 1, var 2 .. 


		Approach 1:
		for(int i = 0; i < n; i++) {
		  for(int j = 0; j < n; j++) {
		    if(array[j] == array[i]) {
		      continue;
		    }
		    if(array[i] + array[j] == target) {
		      System.out.println(var1 + ", " + var2);
		    }
		  }
		}

		Time: O(n^2)
		Space O(1)


		Approach 2:

		3 + 4  = 7
		4 = 7 - 3

		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
		  if(map.containsKey(array[i])) {
		    System.out.println(array[i] + ", " + map.get(array[i])); // 2,5
									      //3,4
		  }else{
		    map.put(target - array[i], array[i]);
		  }
		}


		trace:
		array = {5, 1, 2, 4, 3}
		target = 7
		map = { 
			2:5,
			6:1,        
			3:4        
		      }


		      Map is a <key - value> pair

		Time: O(n) 
		Space: O(n)
	*/

}
