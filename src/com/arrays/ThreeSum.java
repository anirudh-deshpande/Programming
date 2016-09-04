package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] numbers){
		Arrays.sort(numbers);
		List<List<Integer>> returnList = new ArrayList<List<Integer>>();
		
		
		if(numbers.length <= 3){
			return returnList;
		}
		
		
		Set<List<Integer>> storeSet = new HashSet<>();
			
		for(int i=0; i < numbers.length - 2; i++){
				
			int start = i+1;
			int end = numbers.length - 1;
			
			while(start < end){
				if(numbers[i] + numbers[start] + numbers[end] == 2){
						
					List<Integer> list = new ArrayList<>();
					list.add(numbers[i]);
					list.add(numbers[start]);
					list.add(numbers[end]);
					storeSet.add(list);
					start++;
					end--;
					
				}else{
					if(numbers[i] + numbers[start] + numbers[end] < 2){
						start++;
					}else{
						end--;
					}
				}
			}
			
		}
		
		returnList.addAll(storeSet);
		
		return returnList;
		
	}
	
	public static void main(String[] args){
		int[] numbers = {1,0,-1,2,-2,3};
		
		List<List<Integer>> returnList = new ThreeSum().threeSum(numbers);
		System.out.println(returnList);
	}
}
