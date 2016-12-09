package com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ObtainSmallest {

	public int obtainSmallest(int num){
		String strNum = String.valueOf(num);
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=0; i<strNum.length()-1; i++){
			String newString = i == 0 ? "" : strNum.substring(0,i);
			if(strNum.charAt(i) < strNum.charAt(i+1)){
				newString += strNum.charAt(i) + strNum.substring(i+2, strNum.length());
			}else{
				newString += strNum.charAt(i+1) + strNum.substring(i+2, strNum.length());
			}
			queue.add(Integer.valueOf(newString));
		}
		return queue.poll();
	}
	
	
	public int obtainSmallestList(int num){

		ArrayList<Integer> list = new ArrayList<>();
		
		int reminder;
		while(num > 0){
			reminder = num % 10;
			num = num / 10;
			list.add(reminder);
		}
		
		//Collections.reverse(list);
		int i = 0;
		for(i = 0; i < list.size() - 1; i++){
			if(list.get(i) < list.get(i  + 1)){
				list.set(i + 1, list.get(i));
				list.remove(i);
				break;
			}
		}
		
		
		if(i == list.size() - 1){
			list.remove(i);
		}
		//Collections.reverse(list);
		
		int ret = 0;
		for(i = list.size() - 1; i >= 0; i--){
			ret = ret * 10 + list.get(i);
		}
		
		System.out.println(list);
		
		return ret;
	}
	
	
	public static void main(String[] args){
		ObtainSmallest obj = new ObtainSmallest();
		int smallest = obj.obtainSmallest(233614);
		System.out.println(smallest);
		int smallestNum = obj.obtainSmallestList(233614);
		System.out.println(smallestNum);
	}
	
}
