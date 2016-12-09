package com.design;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class InsertRemoveGetRandom {
	
	HashSet<Integer> set = new HashSet<>();
	
	public void insert(int element){
		
		set.add(element);
		
	}
	
	public void remove(int element){
		
		set.remove(element);
		
	}
	
	public int shuffleAndGet(){
		
		int start = 0;
		int count = 0;
		Random random = new Random();
		
		Integer[] arr = set.toArray(new Integer[set.size()]);
		
		for(int i = 0; i < arr.length; i++){
			
			int index = random.nextInt((count - start) + 1) + start;
			
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;			
			
		}
		
		int index = random.nextInt(arr.length);
		return arr[index];
		
	}
	
	public int getRandom(){
		return shuffleAndGet();
	}
	
	public static void main(String[] args){
		
		InsertRemoveGetRandom obj = new InsertRemoveGetRandom();
		
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(5);
		obj.insert(6);
		
		System.out.println(obj.getRandom()); 
		
	}

}
