package com.linkedlist;

import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;;

public class PhoneDirectory {
	
	/*
	 *  get: Provide a number which is not assigned to anyone.
		check: Check if a number is available or not.
		release: Recycle or release a number.
	 * 
	 */
	
	int max;
	Set<Integer> set;
	LinkedList<Integer> queue;
	
	public PhoneDirectory(int maxNumbers){
		
		max = maxNumbers;
		set = new HashSet<>();
		queue = new LinkedList<>();
		
		for(int i=0; i<maxNumbers; i++){
			queue.offer(i);
		}
	}
	
	private int get(){
		if(queue.isEmpty()){
			return -1;
		}
		
		int phoneNumber = queue.poll();
		set.add(phoneNumber);
		return phoneNumber;
	}
	
	private boolean check(int phoneNumber){
		
		if(phoneNumber > max && phoneNumber < 0){
			return false;
		}
		
		return !set.contains(phoneNumber);
	}
	
	private void release(int phoneNumber){
		if(set.remove(phoneNumber)){
			queue.offer(phoneNumber);
		}
	}
	
	public static void main(String[] args){
		PhoneDirectory directory = new PhoneDirectory(4);
		
		int phone1 = directory.get();
		System.out.println(phone1);
		
		System.out.println(directory.check(0));
		
		directory.release(0);
		
		System.out.println(directory.check(0));
	}

}
