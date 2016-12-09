package com.dp;

import java.util.Arrays;

public class MinimumCoinChange {
	
	public int minimumCoinChange(int[] coins, int S){
		
		int N = coins.length;
		int[][] opt = new int[N + 1][S + 1];
		
		for(int j = 0;j <= S; j++){
			opt[0][j] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i <= N; i++){
			for(int j = 1; j <=S; j++){
				if(j >= coins[i - 1]){
					opt[i][j] = Integer.min(opt[i - 1][j], opt[i][j - coins[i - 1]] + 1);
				}else{
					opt[i][j] = opt[i - 1][j];
				}
			}
			
			System.out.println(Arrays.toString(opt[i]));
		}
		
		
		int i = N;
		int j = S;
		
		while(j > 0 && i > 0){
			if(opt[i][j] == opt[i - 1][j]){
				i = i - 1;
				continue;
			}
			System.out.println(coins[i - 1]);
			j = j - coins[i - 1];
		}
		
		
		return opt[N][S];
		
	}
	
	
	public static void main(String[] args){
		
		int[] coins = {5, 6};
		int total = 13;
		
		int min = new MinimumCoinChange().minimumCoinChange(coins, total);
		
		//System.out.println(min);
	}

}
