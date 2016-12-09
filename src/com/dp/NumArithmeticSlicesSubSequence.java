package com.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumArithmeticSlicesSubSequence {
	
	public int numberOfArithmeticSlices(int[] A) {
        int re = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[A.length];
        HashMap<Integer, List<Integer>> answers = new HashMap<>();
        
        for(int i=0; i<A.length; i++) {
            maps[i] = new HashMap<>();
            
            int num = A[i];
            
            
            for(int j=0; j<i; j++) {
                if((long)num-A[j]>Integer.MAX_VALUE) continue;
                if((long)num-A[j]<Integer.MIN_VALUE) continue;
                
                int diff = num - A[j];
                int count = maps[j].getOrDefault(diff, 0);
                maps[i].put(diff, maps[i].getOrDefault(diff,0)+count+1);
                
                if(answers.containsKey(diff)){
                	answers.get(diff).add(num);
                }
                else{
                	List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(A[j]);
                	answers.put(diff, list);
                }
                re += count;
            }
            
            System.out.println(maps[i]);
        }
        System.out.println(answers);
        return re;
    }
	
	
	public int lenghtOfLongestAP(int set[], int n)
	{
		
	    if (n <= 2)  
	    	return n;
	 
	    // Create a table and initialize all values as 2. The value of
	    // L[i][j] stores LLAP with set[i] and set[j] as first two
	    // elements of AP. Only valid entries are the entries where j>i
	    int[][] L = new int[n][n];
	    int llap = 2;  // Initialize the result
	 
	    // Fill entries in last column as 2. There will always be
	    // two elements in AP with last number of set as second
	    // element in AP
	    for (int i = 0; i < n; i++)
	        L[i][n-1] = 2;
	 
	    // Consider every element as second element of AP
	    for (int j=n-2; j>=1; j--)
	    {
	        // Search for i and k for j
	        int i = j-1, k = j+1;
	        while (i >= 0 && k <= n-1)
	        {
	           if (set[i] + set[k] < 2*set[j])
	               k++;
	 
	           // Before changing i, set L[i][j] as 2
	           else if (set[i] + set[k] > 2*set[j])
	           {   
	        	   L[i][j] = 2; i--;
	           }
	 
	           else
	           {
	               // Found i and k for j, LLAP with i and j as first two
	               // elements is equal to LLAP with j and k as first two
	               // elements plus 1. L[j][k] must have been filled
	               // before as we run the loop from right side
	               L[i][j] = L[j][k] + 1;
	 
	               // Update overall LLAP, if needed
	               llap = Math.max(llap, L[i][j]);
	 
	               // Change i and k to fill more L[i][j] values for
	               // current j
	               i--; k++;
	            
	           }
	        }
	 
	        // If the loop was stopped due to k becoming more than
	        // n-1, set the remaining entties in column j as 2
	        while (i >= 0)
	        {
	            L[i][j] = 2;
	            i--;
	        }
	    }
	    return llap;
	}
	
	
	public int lengthOfLongestAP(int[] nums){
		
		int n = nums.length;
		int max = 0;
		
		if(n <= 2){
			return n;
		}
		
		int[][] opt = new int[n][n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				opt[i][j] = 2;
			}
		}
		
		
		
		for(int j = n - 2; j >= 1; j--){
			
			int i = j - 1;
			int k = i + 1;
			
			while(i >= 0 && k <= (n - 1)){
				
				if(nums[i] + nums[k] < 2 * nums[j]){
					k++;
				}else if(nums[i] + nums[k] > 2 * nums[j]){
					i--;
				}else{
					opt[i][j] = opt[j][k] + 1; 
					
					max = Math.max(max, opt[i][j]);
					
					k++;
					i--;
				}
				
			}
			
		}
		
		return max;
	}
	
	
	public static void main(String[] args){
		
		NumArithmeticSlicesSubSequence obj = new NumArithmeticSlicesSubSequence();
		int[] nums = {1, 2, 3 ,4, -1, -2, 5, 4, 3, 2};
		System.out.println(obj.numberOfArithmeticSlices(nums));
		System.out.println(obj.lenghtOfLongestAP(nums, nums.length));
		
		System.out.println(obj.lengthOfLongestAP(nums));
		
		
		
	}

}
