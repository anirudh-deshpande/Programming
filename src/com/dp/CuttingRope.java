package com.dp;

import java.util.Arrays;

public class CuttingRope {
	
	public class Solution{
		int i;
		int j;
		
		public Solution(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	public int maxProduct(int num){
        int T[] = new int[num+1];
        Solution[] solution = new Solution[num+1];
        
        T[0] = 1;
        for(int i=1; i <= num; i++){
            T[i] = i;
            solution[i] = new Solution(i, i);
        }
        for(int i=2; i <= num; i++){
        	for(int j=1; j <= i; j++){	
            	if(T[j]*T[i-j] > T[i]){
            		
            		T[i] = T[j]*T[i-j];
            		solution[i].i = j;
            		solution[i].j = i - j;
            		
            	}
            }
        	System.out.println("i: "+i+" " + solution[i].i +" "+ solution[i].j);
        	System.out.println(Arrays.toString(T));
        }
        
        //Finding the solution
        
        
        
        return T[num];
    }

	public int cutRope(int n){
		if(n == 0 || n == 1){
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i < n; i++){
			max = Math.max(max ,Math.max(i * (n - i), i * cutRope(n - i)));
		}
	
		return max;
	}
	
	public int cutRopeDP(int n){
		
		int[] opt = new int[n + 1];
		int[] tracker = new int[n + 1];
		
		for(int j = 1; j < n+1; j++){
			
			int max = Integer.MIN_VALUE;
			boolean max_changed = false;
			
			for(int i = 0; i < j; i++){
				if(i * opt[(j - i)] > i * (j - i)){
					if(i * opt[(j - i)] > max){
						max = i * opt[(j - i)];
						
						tracker[j] = i;
						
					}
				}else{
					if(i * (j - i) > max){
						max = i * (j - i);
						max_changed = true;
						
						tracker[j] = i;
					}
				}
				
			}
			
			opt[j] = max;
			
		}
		System.out.println(Arrays.toString(opt));
		System.out.println(Arrays.toString(tracker));
		return opt[n];
	}
	
	public static void main(String[] args){
		int n  = 10;
		System.out.println(new CuttingRope().maxProduct(n));
	}
	
	
	
}
