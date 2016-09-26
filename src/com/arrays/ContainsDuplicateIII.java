package com.arrays;

import java.util.TreeSet;

public class ContainsDuplicateIII {
	
	public boolean containsDuplicate(int[] nums, int t, int k){
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i = 0; i < nums.length; i++){
			
			Integer floor = set.floor(nums[i] + t);
			Integer ceiling = set.ceiling(nums[i] - t);
			
			if(floor != null && floor >= nums[i] || ceiling != null && ceiling <= nums[i]){
				return true;
			}
			
			set.add(nums[i]);
			if(set.size() > k){
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] nums = {1, 2, 1, 4, 5, 6, 2};
		int t = 1;
		int k = 3;
		
		System.out.println(new ContainsDuplicateIII().containsDuplicate(nums, t, k));
	}

}
