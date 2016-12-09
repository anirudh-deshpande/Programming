package com.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
	
	public char[] lcs(char[] s1, char[] s2){
		
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
			System.out.println(Arrays.toString(opt[i]));
		}
		
		String result = "";
		int i = M;
		int j = N;
		
		while(i > 0 && j > 0){
			
			if(opt[i][j] == opt[i - 1][j]){
				i = i - 1;
			}else if(opt[i][j] == opt[i][j - 1]){
				j = j - 1;
			}else{
				result = s1[i - 1] + result; 
				i = i - 1;
				j = j - 1;
			}
			
			
			
		}
		
		return result.toCharArray();
	}
	
	public static void main(String[] args){
		
		String s1 = "abcdef";
		String s2 = "acbcf";
		
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		
		System.out.println(lcs.lcs(s1.toCharArray(), s2.toCharArray()));
		
	}

}
