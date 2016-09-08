package com.sorting;

import java.util.Arrays;

public class BubbleSort {
	
	private void bubbleSort(int[] numbers){
		
		int n = numbers.length;
		
		for(int i=0; i < n; i++){
			for(int j = 0; j < n-i-1; j++){
				if(numbers[j] > numbers[j+1]){
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		int[] numbers = {101, 91, 81, 79, 181, 234, 321, 2, 1};
		new BubbleSort().bubbleSort(numbers);
		System.out.println(Arrays.toString(numbers));
		
	}

}
