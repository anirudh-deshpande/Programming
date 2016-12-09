package com.dp;

import java.util.Arrays;

public class Knapsack01 {
	
	public int bottomUpDP(int[] Weights,int[] Values, int W){
		
		int N = Values.length;
		int[][] opt = new int[N + 1][W + 1];
		
		for(int item = 0; item <= N; item++){
			for(int weight = 0; weight <= W; weight++){
				
				if(item == 0 || weight == 0){
					opt[item][weight] = 0;
					continue;
				}
				
				if(weight - Weights[item - 1] < 0){
					opt[item][weight] = opt[item - 1][weight];  
				}else{
					opt[item][weight] = Integer.max(opt[item - 1][weight], Values[item - 1] + opt[item - 1][weight - Weights[item - 1]]);
				}
			}
			System.out.println(Arrays.toString(opt[item]));
		}
		
		
		int item = N;
		int weight = W;
		while(item > 0){
			if(opt[item][weight] == opt[item-1][weight]){
				item--;
				continue;
			}
			System.out.println(item);
			weight -= Weights[item - 1];
			item--;
			
		}
		
		return opt[N][W];
	}
	
	
	
	
	
	
	public static void main(String[] args){
        Knapsack01 k = new Knapsack01();
        int Weights[] = {1 ,3 , 4, 5};
        int Values[] = {1, 4, 5, 7};
        
        int r = k.bottomUpDP(Weights, Values, 7);
        
        System.out.println(r);
	}

}
