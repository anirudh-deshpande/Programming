package com.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CunstructArithmeticProgression {

	public void constructAP(int[] nums){
		
		//1, 2, 3, 4, 5
		
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++){
			
			for(int j = 0; j < i; j++){
				int diff = nums[i] - nums[j];
				if(map.containsKey(diff)){
					map.get(diff).add(nums[i]);
				}else{
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					map.put(diff, list);
				}
			}
			
		}
		
		System.out.println(map);
	}
	
	
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 4, 5};
		CunstructArithmeticProgression cap = new CunstructArithmeticProgression();
		cap.constructAP(nums);
	}
	
	
}
