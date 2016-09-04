package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumClosest {

	public List<List<Integer>> threeSumClosest(int[] numbers, int target){
		Arrays.sort(numbers);
		
		List<List<Integer>> returnList = new ArrayList<List<Integer>>();
		if(numbers.length < 3){
			return returnList;
		}
		
		Set<List<Integer>> hashSet = new HashSet<>();
		
		int sum = numbers[0] + numbers[1] + numbers[2];
		int closest = Math.abs(target - sum);
		
		for(int i=0; i<numbers.length - 2; i++){
			
			int start = i + 1;
			int end = numbers.length - 1;
			
			while(start < end){
				sum = numbers[i] + numbers[start] + numbers[end];
				int diff = Math.abs(target - sum);
				if(diff < closest){
					hashSet.clear();
					List<Integer> list = new ArrayList<>();
					list.add(numbers[i]);
					list.add(numbers[start]);
					list.add(numbers[end]);
					hashSet.add(list);
					closest = diff;
					start++;
					end--;
				}
				
				else if(sum < target){
					start++;
				}else{
					end--;
				}
				
				
			}
		}
		
		returnList.addAll(hashSet);
		return returnList;
	}
	
	public static void main(String[] args){
		int[] numbers = {3,2,1,-3,0};
		int target = 7;
		
		System.out.println(new ThreeSumClosest().threeSumClosest(numbers, target));
	}
}
