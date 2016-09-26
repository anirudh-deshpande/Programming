package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	
public List<Integer> majorityElement(int[] nums) {
        
        if(nums.length == 0){
            return new ArrayList<>();
        }
        
        int candidate1 = nums[0];
        int count1 = 0;
        
        int candidate2 = nums[0];
        int count2 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }else if(count1 == 0){
                candidate1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                candidate2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }
        }
        
        List<Integer> ret = new ArrayList<>();
        
        if(count1 > nums.length / 3.0){
            ret.add(candidate1);
        }
        
        if(count2 > nums.length / 3.0){
            ret.add(candidate2);
        }
        
        return ret;
        
        
    }

	public static void main(String[] args){
		int[] nums = {2,2,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9};
		
		System.out.println(new MajorityElementII().majorityElement(nums));
	}

}
