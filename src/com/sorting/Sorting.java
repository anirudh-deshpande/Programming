package com.sorting;

import java.util.Arrays;

public class Sorting {

	public static void bubbleSort(int[] a){
		int temp=0;
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		
	}
	
	public static void selectionSort(int[] a){

	    int temp=0;
	    int lowIndex=0;
	    int lowValue;
	    
	    for(int i=0;i<a.length;i++){
	        lowValue=a[i];
	        lowIndex=i;
	        
	        for(int j=i;j<a.length;j++){
	            if(a[j]<lowValue){
	                lowValue=a[j];
	                lowIndex=j;
	            }
	        }
	        
	        temp=a[i];
	        a[i]=a[lowIndex];
	        a[lowIndex]=temp;
	    }
	}

	public static void insertionSort(int[] a){

	    int temp;
	    int key;
	    
	    for(int i=1;i<a.length;i++){
	    
	        key=a[i];
	        int j=i-1;
	        
	        while(j>=0 && a[j]>key){
	        
	            temp=a[j];
	            a[j]=a[j+1];
	            a[j+1]=temp;
	            
	            j--;
	        }
	    
	    }    
	}
	
	public static void quickSort(int[] a,int low,int high){
	    int partition;
	    if(low<high){
	        partition = partition(a,low,high);
	        quickSort(a,low,partition-1);
	        quickSort(a,partition+1,high);
	    }
	}

	private static int partition(int[] a,int low,int high){
	    int pivot = a[low];
	    int temp;
	    int lowWall=low;
	    
	    for(int i=low+1;i<=high;i++){
	        if(a[i]<pivot){
	            lowWall=lowWall+1;
	            
	            temp=a[lowWall];
	            a[lowWall]=a[i];
	            a[i]=temp;
	        }
	    }
	    
	    temp=a[lowWall];
	    a[lowWall]=a[low];
	    a[low]=temp;
	    
	    return lowWall;
	    
	}
	
	public static void mergeSort(int[] a,int low,int high){
	    
	    int mid=0;
	    if(low<high){
	        mid=(low+high)/2;
	        
	        mergeSort(a,low,mid);
	        mergeSort(a,mid+1,high);
	        merge(a,low,mid,high);
	    }
	}

	public static void merge(int[] a,int low,int mid,int high){
	    
	    int left=low;
	    int right=mid+1;
	    int[] out = new int[high-low+1];
	    int k=0;
	    
	    while(left<=mid && right<=high){
	        if(a[left]<a[right]){
	            out[k]=a[left];
	            left++;
	        }else{
	            out[k]=a[right];
	            right++;
	        }
	        k++;
	    }
	    
	    if(left<=mid){
	        while(left<=mid){
	            out[k]=a[left];
	            left++;
	            k++;        
	        }
	    }
	    
	    if(right<=high){
	        while(right<=high){
	            out[k]=a[right];
	            right++;
	            k++;        
	        }
	    }
	    
	    for(int m=0;m<out.length;m++){
	        a[low+m]=out[m];
	    }

	}
	
	private static final int RANGE=26;

	public static String countingSort(String s){

		char[] c=s.toCharArray();
		
	    int[] count = new int[RANGE];
	    char[] out = new char[s.length()];
	    
	    for(int i=0;i<s.length();i++){
	        count[(int)s.charAt(i)-97]++;
	    }
	    
	    for(int i=1;i<RANGE;i++){
	        count[i]+=count[i-1];
	    }
	    
	    for(int i=0;i<s.length();i++){
	        out[count[((int)s.charAt(i)-97)]-1]=s.charAt(i);
	        count[(int)s.charAt(i)-97]--;
	    }
	    
	    return String.valueOf(out);

	}
	
	public static final int DIGITS = 100;
	
	private static int max(int[] a){
		int max=a[0];
		
		for(int i=1;i<a.length;i++){
			if(a[i]>max)
				max=a[i];
		}
		return max;
	}

	public static int[] radixSort(int[] a){

	    int m = max(a);
	    
	    for(int exp=1;(m/exp)>0;exp*=10){
	        countingSortForRadix(a,exp);
	    }
	    return a;
	}

	public static void countingSortForRadix(int[] a,int exp){
	    
	    int[] out = new int[a.length];
	    int[] count = new int[DIGITS];
	    Arrays.fill(count, 0);
	    
	    for(int i=0;i<a.length;i++){
	        count[(a[i]/exp)%DIGITS]++;
	    }
	    
	    for(int i=1;i<DIGITS;i++){
	        count[i]+=count[i-1];
	    }
	    
	    for(int i=a.length-1;i>=0;i--){
	        out[count[(a[i]/exp)%DIGITS]-1]=a[i];
	        count[(a[i]/exp)%DIGITS]--;
	    }
	    
	    for(int i=0;i<a.length;i++){
	        a[i]=out[i];
	    }
		
		/*int[] output = new int[a.length];
        int[] count = new int[DIGITS];
        Arrays.fill(count, 0);
        
        
        for(int i=0;i<a.length;i++){
            count[(a[i]/exp)%DIGITS]++;
        }
        
        for(int i=1;i<DIGITS;i++){
            count[i]+=count[i-1];
        }
        
        for(int i=a.length-1;i>=0;i--){
        
            output[count[(a[i]/exp)%DIGITS]-1] = a[i];
            count[(a[i]/exp)%DIGITS]--;
            
        }
        
        for(int i=0;i<a.length;i++){
            a[i]=output[i];
        }*/
	    
	}
	
	public static void main(String[] args){
		int[] a = {2,1,4,3,6,5};
		
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
		
		int[] b = {2,1,4,3,6,5};
		
		selectionSort(b);
		System.out.println(Arrays.toString(b));
		
		int[] c = {2,1,4,3,6,5};
		
		insertionSort(c);
		System.out.println(Arrays.toString(c));
		
		
		int[] d = {2,1,4,3,6,5};
		
		quickSort(d,0,d.length-1);
		System.out.println(Arrays.toString(d));
		
		int[] e = {2,1,4,3,6,5};
		
		mergeSort(e,0,e.length-1);
		System.out.println(Arrays.toString(e));
		
		int[] f = {2,1,4,3,6,5};
		
		mergeSort(f,0,f.length-1);
		System.out.println(Arrays.toString(e));
		
		int[] g = {2,1,4,3,6,5};
		String s = "anirudhdeshpande";
		
		System.out.println(countingSort(s));
		
		int[] h = {20000,12121,4,3654,6000,1235};
				
		System.out.println(Arrays.toString(radixSort(h)));

		
	}
	
}
