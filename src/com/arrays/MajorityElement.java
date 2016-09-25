package com.arrays;
import java.util.HashMap;

public class MajorityElement {
	
public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num:nums){
            map.put(num, map.getOrDefault(num , 0) + 1);
        }
        
        for(int key: map.keySet()){
            if(map.get(key) >= Math.ceil(nums.length/2.0)){
                return key;
            }
        }
        
        return 0;
    }

	public static void main(String[] args){
		int[] nums = {3,2,3};
		System.out.println(new MajorityElement().majorityElement(nums));
	}

}
