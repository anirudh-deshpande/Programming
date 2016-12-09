package com.dp;

// Leetcode 70
public class ClimbingStairs {
	
	public long climbStairs(int n) {
        
        long[] opt_till_this_step = new long[n+1];
        
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        opt_till_this_step[0] = 0;
        opt_till_this_step[1] = 1;
        opt_till_this_step[2] = 2;
        
        for(int i = 3; i <=n; i++){
            opt_till_this_step[i] = opt_till_this_step[i-1] + opt_till_this_step[i-2];
        }
        
        return opt_till_this_step[n];
    }
	
	public static void main(String[] args){
		System.out.println(new ClimbingStairs().climbStairs(5000));
	}


}
