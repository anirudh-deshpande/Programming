package com.dp;

public class SplitArrayLargestSum {
	
	public int splitArray(int[] nums, int m) {
		
        int n = nums.length;
        
        int[] dp = new int[n+1];
        
        for (int i = n-1; i >= m-1; --i) {
        	
            dp[i] = dp[i+1] + nums[i];
            
        }
        
        for (int k = 2; k <= m; ++k) {
        	
            for (int i = m-k; i <= n-k; ++i) {
            	
                dp[i] = Integer.MAX_VALUE;
                
                for (int j = i, sum = 0; j <= n-k; ++j) {
                	
                    sum += nums[j];
                    
                    if (sum >= dp[i]) 
                    	break;
                    
                    dp[i] = Math.max(sum, dp[j+1]);
                    
                }
                
                if (k == m) break;
            }
        }
        
        return dp[0];
    }
	
	public static void main(String[] args){
		
		SplitArrayLargestSum split = new SplitArrayLargestSum();
		int[] nums = {7, 2, 5, 10, 8};
		int sum = split.splitArray(nums, 3);
		System.out.println(sum);
		
	}

}
