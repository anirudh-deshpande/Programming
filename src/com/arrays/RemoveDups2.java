package com.arrays;

public class RemoveDups2 {
	
	public int removeDuplicates(int[] nums) {
        
        if(nums.length <= 2)
            return 2;

        int k = 2;
        int end = 1;
        int count = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] != nums[i]){
                count = 1;
                nums[end++] = nums[i];
            }else if(count < k){
                nums[end++] = nums[i];
                count++;
            }
        }
        return end;
    }
	
	public static void main(String[] args){
		int[] nums = {1, 1, 1, 2, 2, 3, 3};
		
		System.out.println(new RemoveDups2().removeDuplicates(nums));
	}

}
