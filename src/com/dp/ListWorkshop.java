package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListWorkshop {
	
	public List<Integer> removeAlternate(List<Integer> list){
		
		int n = list.size();
		ArrayList<Integer> newList = new ArrayList<>(); 
		
		for(int i = 1; i < n; i += 2){	
			newList.add(list.get(i));
		}
		return newList;
	}
	
	
	public static void main(String[] args){
		
		ListWorkshop wk = new ListWorkshop();
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= 9; i++){
			list.add(i);
		}
		
		while(list.size() > 1){
			
			list = wk.removeAlternate(list);
			Collections.reverse(list);
			
			System.out.println(list);
			
		}
		
		System.out.println(list);
		Collections.reverse(list);

		System.out.println(list);
		
	}

}
