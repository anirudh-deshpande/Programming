package com.strings;

import java.util.PriorityQueue;

public class SmallestNumber {
	/*
	 * Replace two adjacent digits with larger one to find the smallest number that can be obtained
	 */
	
	public int obtainSmallest(int num){

		String strNum = String.valueOf(num);
		PriorityQueue<Integer> queue = new PriorityQueue<>();
			
		for(int i=0; i<strNum.length()-1; i++){
			String newString = i == 0 ? "" : strNum.substring(0,i);
			if(strNum.charAt(i) > strNum.charAt(i+1)){
				newString += strNum.charAt(i) + strNum.substring(i+2, strNum.length());
			}else{
				newString += strNum.charAt(i+1) + strNum.substring(i+2, strNum.length());
			}
			queue.add(Integer.valueOf(newString));
		}
		
		return queue.poll();
		
	}
	
	public static void main(String[] args){
		SmallestNumber sn = new SmallestNumber();
		System.out.println(sn.obtainSmallest(656575));
	}
}
