package com.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
	
	//215. Kth Largest Element in an Array
	
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        
        for(int num:nums){
            queue.add(num);
        }
        
        int retVal = 0;
        while(k > 0){
            retVal = queue.poll();
            k--;
        }
        return retVal;
    }
	
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 4 ,5 , 6};
		int k = 3;
		
		System.out.println(new KthLargestElement().findKthLargest(nums, k));
	}

}
