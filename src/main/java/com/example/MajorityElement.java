package com.example;

public class MajorityElement {
	
	public int majorityElement(int[] nums) {
	    int result = 0, count = 0;
	 
	    for(int i = 0; i < nums.length; i++){
	    	if(count == 0){
	    		result = nums[i];
	    		count = 1;
	    	}else if(result == nums[i]){
	    		count++;
	    	}else{
	    		count--;
	    	}
	    }
	 
	    return result;
	}
	
	public static void main(String[] args){
		int[] array = {1,2,1,4,1,6,1,8,1};
		System.out.println(new MajorityElement().majorityElement(array));
	}

}
