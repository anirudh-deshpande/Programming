package com.dp;

public class UniquePaths {
	
	public long uniquePaths(int m, int n){
		
		long[][] opt = new long[m][n];
		
		for(int i = 0; i < m; i++){			
			opt[i][0] = 1;
		}
		
		for(int j = 0; j < n; j++){			
			opt[0][j] = 1;
		}
		
		for(int i = 1; i < m; i++){
			for(int j = 0; j < n; j++){
				opt[i][j] = opt[i -1][j] + opt[i][j - 1];
			}
		}
		
		return opt[m - 1][n - 1];
		
	}
	

}
