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
			
			System.out.println(numbers[ n-i-1]);
			System.out.println();
		}
		
	}
	
	public static void main(String[] args){
		int[] numbers = {3, 4, 3, 1, 2, 5, 6, 7, 2, 3, 4, 1};
		new BubbleSort().bubbleSort(numbers);
		System.out.println(Arrays.toString(numbers));
		
	}

}
