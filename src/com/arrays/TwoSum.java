package com.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
	
	public List<List<Integer>> twoSum(int[] numbers, int target){
		
		List<List<Integer>> returnList = new ArrayList<>();
		
		if(numbers.length >= 2){
			HashMap<Integer, Integer> map = new HashMap<>();
			
			for(int i=0;i<numbers.length;i++){
				if(!map.isEmpty() && map.containsKey(target-numbers[i])){
					
					List<Integer> k = new ArrayList<>();
					k.add(map.get(target-numbers[i])+1);
					k.add(i+1);
					returnList.add(k);
					
				}
				
				map.put(numbers[i], i);
			}
			
		}
		
		return returnList;
		
	}
	
	public static void main(String[] args){
		
		int[] numbers = {2, 7, 11, 15, 4, 5, -2};
		int target = 9;
		
		System.out.println(new TwoSum().twoSum(numbers, target));
	}

}
