package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
	
public ArrayList<Integer> lcs(int[] s1, int[] s2){
		
		int M = s1.length;
		int N = s2.length;
		
		int[][] opt = new int[M + 1][N + 1];
		
		for(int i = 1; i <= M; i++){
			for(int j = 1; j <= N; j++){
				if(s1[i - 1] == s2[j - 1]){
					opt[i][j] = 1 + opt[i - 1][j - 1];
				}else{
					opt[i][j] = Integer.max(opt[i][j - 1], opt[i - 1][j]); 
				}
			}
			
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		int i = M;
		int j = N;
		
		while(i > 0 && j > 0){
			
			if(opt[i][j] == opt[i - 1][j]){
				i = i - 1;
			}else if(opt[i][j] == opt[i][j - 1]){
				j = j - 1;
			}else{
				result.add(s1[i - 1]); 
				i = i - 1;
				j = j - 1;
			}
			
			
			
		}
		
		Collections.reverse(result);
		
		return result;
	}
	
	public int lisLength(int[] nums){
		
		int N = nums.length;
		int[] opt = new int[N];
		
		for(int i = 0; i < N; i++){
			opt[i] = 1;
		}
		
		for(int i = 1; i < N; i++){
			for(int j = 0; j < i; j++){
				
				if(nums[j] < nums[i]){
					opt[i] = Integer.max(opt[i], opt[j] + 1);
				}
				
			}
		}
		
		System.out.println(Arrays.toString(opt));
		return opt[N - 1];
		
	}
	
	public static void main(String[] args){
		
		int[] nums = {3, 4, -1, 0, 6, 2, 3};
	
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.lisLength(nums));
		
		int[] temp = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++){
			temp[i] = nums[i];
		}
		
		Arrays.sort(nums);

		ArrayList<Integer> result = lis.lcs(nums, temp);
		System.out.println(result);
		
	}

}
