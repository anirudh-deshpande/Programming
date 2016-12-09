package com.dp;

public class Kadane1D {
	
	public int kadane1D(int[] nums){
		
		int N = nums.length;
		int global_optimum = nums[0];
		int local_optimum = nums[0];
		int start = 0;
		int end = 0;
		boolean start_changed = false;
		
		for(int i = 1; i < N; i++){
			if((local_optimum + nums[i]) < nums[i]){
				local_optimum = nums[i];
				start_changed = true;
			}else{
				local_optimum = local_optimum + nums[i];
			}
			
			if(local_optimum > global_optimum){
				global_optimum = local_optimum;
				if(start_changed){
					start = i;
					start_changed = false;
				}
				end = i;
			}
		}
		
		for(int i = start; i <=end; i++){
			System.out.print(nums[i] + " ");
		}
		
		return global_optimum;
	}
	
	public static void main(String[] args){
		int[] nums = {1, -3, 2, 1, -1};
		Kadane1D kd = new Kadane1D();
		
		int global_optimum = kd.kadane1D(nums);
		System.out.println("\nGlobal optimum: "+global_optimum);
		
	}

}
