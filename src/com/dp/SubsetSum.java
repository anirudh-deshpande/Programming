package com.dp;

public class SubsetSum {
	
	public boolean subsetSum(int[] Items, int S){
		
		int N = Items.length;
		boolean opt[][] = new boolean[N + 1][S + 1];
		
		for(int item = 0; item <= N; item++){
			opt[item][0] = true;
		}
		
		for(int item = 1; item <= N; item++){
			
			for(int sum = 0; sum <= S; sum++){
				
				if(sum < Items[item - 1]){
					opt[item][sum] = opt[item - 1][sum];
				}else{
					opt[item][sum] = opt[item - 1][sum] || opt[item - 1][sum - Items[item - 1]];
				}
				
			}
			
		}
		return opt[N][S];
	}
	
	public boolean partition(int[] Items){
		
		int addition = 0;
		
		
		for(int i = 0; i < Items.length; i++){
			addition += Items[i];
		}
		
		if((addition % 2) != 0){
			return false;
		}
		
		int S = addition / 2;
		
		int N = Items.length;
		boolean opt[][] = new boolean[N + 1][S + 1];
		
		for(int item = 0; item <= N; item++){
			opt[item][0] = true;
		}
		
		for(int item = 1; item <= N; item++){
			
			for(int sum = 0; sum <= S; sum++){
				
				if(sum < Items[item - 1]){
					opt[item][sum] = opt[item - 1][sum];
				}else{
					opt[item][sum] = opt[item - 1][sum] || opt[item - 1][sum - Items[item - 1]];
				}
				
			}
			
		}
		return opt[N][S];
	}

	
	public static void main(String[] args){
		SubsetSum ss = new SubsetSum();
		int[] items = {2 , 4, 5, 6};
		System.out.println(ss.subsetSum(items, 1));
		
		System.out.println(ss.partition(items));
	}
}
