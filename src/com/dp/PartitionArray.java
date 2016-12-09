package com.dp;

import java.util.Arrays;

public class PartitionArray {
	
	public void partition(int[] nums, int K){
		
		int n = nums.length;
		int[][] opt = new int[n + 1][K + 1];
		int[][] deviders = new int[n + 1][K + 1];
		int[] prefix_sums = new int[n + 1];
		
		for(int i = 1; i <= n; i++){
			prefix_sums[i] = prefix_sums[i - 1] + nums[i - 1];
		}
		
//		System.out.println(Arrays.toString(prefix_sums));
		
		for(int i = 1; i <= n; i++){
			opt[i][1] = prefix_sums[i];
		}
		
		for(int k = 1; k <= K; k++){
			opt[1][k] = nums[0];
		}
		
		
//		for(int d = 0; d <= n; d++)
//			System.out.println(Arrays.toString(opt[d]));
		
		
		for(int i = 2; i <= n; i++){
			for(int k = 2; k <= K; k++){
				opt[i][k] = Integer.MAX_VALUE;
				
				for(int j = 1; j < i; j++){
					int cost = Integer.max(opt[j][k - 1], prefix_sums[i] - prefix_sums[j]);
					
					if(cost < opt[i][k]){
						opt[i][k] = cost;
						deviders[i][k] = j;
					}
				}
				
			}
		}
		
		
		for(int d = 0; d <= n; d++)
			System.out.println(Arrays.toString(deviders[d]));
			
		reconstruct_path(nums, deviders, n, K);
	}
	
	public void reconstruct_path(int[] nums, int[][] deviders, int n, int K){
		
		if(K == 1){
			print_books(nums, 1, n);
		}else{
			reconstruct_path(nums, deviders, deviders[n][K], K - 1);
			print_books(nums, deviders[n][K] + 1, n);
		}
		
	}
	
	public void print_books(int[] nums, int start, int end){
		for(int i = start; i <= end; i++){
			System.out.print(nums[i - 1]+" ");
		}
		System.out.println();
	}
	
	
	
	
	public static void main(String[] args){
		
		PartitionArray obj = new PartitionArray();
		//int[] nums = {100, 800, 200, 300, 400, 500, 600, 700, 900};
		//int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		
		int[] nums = {10, 100000, 1111, 110000};
		int k = 2;
		
		obj.partition(nums, k);
		
		
	}

}
