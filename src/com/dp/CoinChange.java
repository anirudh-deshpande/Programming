package com.dp;

import java.util.Arrays;

public class CoinChange {
	
public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        int[][] opt = new int[n + 1][amount + 1];
        
        opt[0][0] = 0;
        
        for(int i = 0; i <= amount; i++){
        	opt[0][i] = Integer.MAX_VALUE - 1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                
                if(j >= coins[i - 1]){
                    opt[i][j] = Integer.min(
                        opt[i - 1][j], 
                        opt[i][j - coins[i - 1]] + 1);
                }else{
                    opt[i][j] = opt[i - 1][j];
                }
                	
            }
        }
        
        for(int i = 0; i <= n; i++){
        	System.out.println(Arrays.toString(opt[i]));
        }
        
        if(opt[n][amount] == Integer.MAX_VALUE - 1)
        	return -1;
        
        return opt[n][amount];
        
    }

	public static void main(String[] args){
		
		int[] coins = {2};
		int amount = 3;
		
		System.out.println(new CoinChange().coinChange(coins, amount));
		
		
	}

}
