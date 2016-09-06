package com.arrays;

import java.util.Arrays;

public class RmDupsSortedArray {

	private int[] removeDups(int[] array){
		
		int index = 1;
		for(int i = 1; i < array.length; i++){
			if(array[i] != array[i-1]){
				array[index++] = array[i];
			}
		}
		
		return Arrays.copyOfRange(array, 0, index);
	}
	
	public static void main(String[] args){
		int[] array = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5};
		int[] result = new RmDupsSortedArray().removeDups(array);
		
		for(int i=0; i < result.length; i++){
			System.out.println(result[i]);
		}
		
		//System.out.println(Arrays.asList(result));
	}
	
}
