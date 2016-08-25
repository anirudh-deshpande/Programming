package com.example;

public class PeakElement {
	
	private int getPeakElement(int[] array){
		
		int prev=0, next=0 ,max=0, index=0;
		
		for(int cur = 1;cur < array.length-2; cur++){
			prev = array[cur-1];
			next = array[cur+1];
			
			if(array[cur] >= prev && array[cur] >= next){
				if(array[cur] > max){
					index = cur;
					max = array[cur];
				}
			}
		}
		
		if(array[array.length-1] > max){
			return array.length-1;
		}
		return index;
	}
	
	public static void main(String[] args){
		int[] array = {1,2,-1,3,2,100,5};
		System.out.println(new PeakElement().getPeakElement(array));
	}

}
