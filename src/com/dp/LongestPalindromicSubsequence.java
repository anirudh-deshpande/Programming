package com.dp;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
	
	
	public void print(int[][] opt, char[] str, int i, int j){
		
		if(j < i)
			return;
		
		if(opt[i][j] == opt[i][j - 1]){
			j = j - 1;
			print(opt, str, i, j);
		}else if(opt[i][j] == opt[i + 1][j]){
			i = i + 1;
			print(opt, str, i, j);
		}else{
			System.out.println(str[i]);
			print(opt, str, i + 1, j - 1);
			System.out.println(str[j]);
		}
	}
	
	public void longestSubseq(char[] str){
		
		//a, d, b, c, b, a
		
		int N = str.length; 
		int[][] opt = new int[N][N];
		
		for(int i = 0; i<N; i++){
			opt[i][i] = 1;
		}
		
		for(int d = 2 ; d <= N; d++){
			
			System.out.println();
			for(int i = 0; i < N - d + 1; i++){
				
				int j = i + d - 1;
					
				if(d == 2 && str[i] == str[j]){
					opt[i][j] = 2;
				}else if(str[i] == str[j]){
					opt[i][j] = 2 + opt[i + 1][j - 1]; 
				}else{
					opt[i][j] = Integer.max(opt[i + 1][j], opt[i][j - 1]);
				}
			}
			
			
			
		}
		print(opt, str, 0, N - 1);
		System.out.println(opt[0][N - 1]);
	}
	
	public static void main(String[] args){
		String str = "adbcba";
		//String palindrome = new LongestPalindromicSubsequence().longestSubseq(str.toCharArray()).toString();
		new LongestPalindromicSubsequence().longestSubseq(str.toCharArray());
	}

}
