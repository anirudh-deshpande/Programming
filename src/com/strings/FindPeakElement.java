package com.strings;

public class FindPeakElement {
	
	int findPeakElement(int[] num) {
	    return Helper(num, 0, num.length-1);
	}
	int Helper(int[] num, int low, int high)
	{
	    if(low == high)
	        return low;
	    else
	    {
	        int mid1 = (low+high)/2;
	        int mid2 = mid1+1;
	        if(num[mid1] > num[mid2])
	            return Helper(num, low, mid1);
	        else
	            return Helper(num, mid2, high);
	    }
	}

}
