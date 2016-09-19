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

}
