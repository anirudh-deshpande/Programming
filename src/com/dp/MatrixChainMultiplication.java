package com.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {
	
	public int findCost(int[] nums){
		
		int[][] opt = new int[nums.length][nums.length];
		int n = nums.length; 
		
		for(int d = 2; d <= n; d++){
			
			for(int i = 0; i < n - d + 1; i++){
				
				int j = i + d - 1;
				System.out.println("(" +(i+1) +","+(j+1)+ ")");
				
				if(i + 1 == j){
					opt[i][j] = 0;
					continue;
				}
				
				opt[i][j] = Integer.MAX_VALUE - 1;
				int cost = 0;
				
				for(int k = i + 1; k < j; k++){
					System.out.println( " = " + "(" +(i+1)+","+(k + 1)+ ")" +" * "+"(" +(k + 1) +","+(j + 1)+ ")");	
										
					cost = opt[i][k] + opt[k][j] + nums[i] * nums[j] * nums[k]; 
					if(cost < opt[i][j]){
						opt[i][j] = cost;
					}
					
				}
				
			}
			
		}
		
		for(int i = 0; i < n; i++){
			System.out.println(Arrays.toString(opt[i]));
		}
		
		
		return opt[0][n - 1];
	}
	
	public int findCostCopy(int arr[]){
        int temp[][] = new int[arr.length][arr.length];
        int q = 0;
        for(int l=2; l < arr.length; l++){
            for(int i=0; i < arr.length - l; i++){
                int j = i + l;
                temp[i][j] = 1000000;
                for(int k=i+1; k < j; k++){
                    q = temp[i][k] + temp[k + 1][j] + arr[i]*arr[k]*arr[j];
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
            }
        }
        return temp[0][arr.length-1];
    }
	
	public static void main(String args[]){
		MatrixChainMultiplication mmc = new MatrixChainMultiplication();
        int arr[] = {2, 3 , 6, 4, 5, 7, 9};
		
		//int[] arr = {40, 20, 30, 10, 30};
        int cost = mmc.findCost(arr);
        System.out.print(cost);
    }

}
