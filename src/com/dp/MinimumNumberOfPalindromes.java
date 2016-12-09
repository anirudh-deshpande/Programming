package com.dp;

import java.util.Arrays;

public class MinimumNumberOfPalindromes {
	
	public boolean isPalindrome(String str,int i,int j){
		
		char[] strArray = str.toCharArray();
		while(i < j){
			if(strArray[i++] != strArray[j--]){
				return false;
			}
		}
		
		return true;
	}
	
	public int minPalindromes(String str){
		
		int n = str.length();
		int[][] opt = new int[n][n];
		
		for(int i = 0; i < n; i++){
			opt[i][i] = 1;
		}
		
		
		for(int d = 2; d <= n; d++){
			
			for(int i = 0; i < n - d + 1; i++){
				int j = i + d - 1;
				
				if(isPalindrome(str, i, j)){
					opt[i][j] = 1;
					
				}else{
				
					opt[i][j] = d;
					
					for(int k = i; k < j; k++){
						if(opt[i][k] + opt[k + 1][j] < opt[i][j])
							opt[i][j] = opt[i][k] + opt[k + 1][j];
					}
				}
				
			}
		}
		
		
		for(int i = 0; i < n; i++){
			System.out.println( i+": "+ Arrays.toString(opt[i]));
		}
		return opt[0][n - 1];
	}
	
	
	public static void main(String[] args){
		String str = "civicacaramanamaracacammacdeified";
		System.out.println(new MinimumNumberOfPalindromes().minPalindromes(str));
	}

}
