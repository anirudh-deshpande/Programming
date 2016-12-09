package com.dp;

import java.util.Arrays;

public class CuttingRod {
	
	public int cuttingRod(int size, int[] value){
		
		int[][] M = new int[value.length][size + 1];
		for(int i = 1; i < value.length; i++){
			
			for(int j = 0; j <= size; j++){
				if(j >= i){
					M[i][j] = Math.max(M[i - 1][j], M[i][j - i] + value[i]);
				}else{
					M[i][j] = M[i - 1][j];
				}
			}
		}
		if(value[0] > M[value.length - 1][size]){
			return value[0]; 
		}
		
		for(int i = 0; i < M.length; i++){
			System.out.println(Arrays.toString(M[i]));
		}
		
		
		//cuts
		int i = value.length - 1;
		int j = size;
		while(j > 0){
			if(M[i][j] != M[i - 1][j]){
				System.out.println( j-i +" --> "+ j);
				j -= i;
				continue;
			}
			i--;
		}
		
		
		
		return M[value.length - 1][size];
	}
	
	public static void main(String[] args){
		int size = 5;
		int[] value = {0, 5, 12, 10, 7};
		
		int max = new CuttingRod().cuttingRod(size, value);	
		System.out.println(max);
	}
	

}
