package com.example;

import java.util.Arrays;

public class MaximumFrequentElement {
	
	public void findMaxFrequency(int[] arr){
		// Traverse all array elements
	    int i = 0;
	    int n = arr.length;
	    
	    while (i<n)
	    {
	        // If this element is already processed,
	        // then nothing to do
	        if (arr[i] <= 0)
	        {
	            i++;
	            continue;
	        }
	 
	        // Find index corresponding to this element
	        // For example, index for 5 is 4
	        int elementIndex = arr[i]-1;
	 
	        // If the elementIndex has an element that is not
	        // processed yet, then first store that element
	        // to arr[i] so that we don't loose anything.
	        if (arr[elementIndex] > 0)
	        {
	            arr[i] = arr[elementIndex];
	 
	            // After storing arr[elementIndex], change it
	            // to store initial count of 'arr[i]'
	            arr[elementIndex] = -1;
	        }
	        else
	        {
	            // If this is NOT first occurrence of arr[i],
	            // then increment its count.
	            arr[elementIndex]--;
	 
	            // And initialize arr[i] as 0 means the element
	            // 'i+1' is not seen so far
	            arr[i] = 0;
	            i++;
	        }
	    }
	}

	public static void main(String[] args){
		int[] array = {0,0,0};
		
		System.out.println(Arrays.toString(array));
		new MaximumFrequentElement().findMaxFrequency(array);
		System.out.println(Arrays.toString(array));
		
		
	}
}
