package com.datastructures.hashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class OptimalAccountTransfers {
	
public int minTransfers(int[][] transactions) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < transactions.length; i++){
            
            int fromPerson = transactions[i][0];
            int toPerson = transactions[i][1];
            int amount = transactions[i][2];
            
            map.put(fromPerson, map.getOrDefault(fromPerson, 0) - amount);
            map.put(toPerson, map.getOrDefault(toPerson, 0) + amount);
            
        }
        
        /*System.out.println(map);
        
        Stack<Integer> positive = new Stack<>();
        Stack<Integer> negative = new Stack<>();
        
        for(int key : map.keySet()){
            
            int value = map.get(key);
            
            if(value > 0){
                positive.push(value);
            }else if(value < 0){
                negative.push(Math.abs(value));
            }
            
        }
        
        System.out.println(positive);
        System.out.println(negative);*/
        
        
        int minTransactions = Integer.MAX_VALUE;
        Stack<Integer> positive = new Stack<>();
        Stack<Integer> negative = new Stack<>();
        
        for(int i = 0; i < 1000; i++){
            int count = 0;
            
            for(int key : map.keySet()){
            
                int value = map.get(key);
                
                if(value > 0){
                    positive.push(value);
                }else if(value < 0){
                    negative.push(Math.abs(value));
                }
                
            }
        
            Collections.shuffle(positive);
            Collections.shuffle(negative);
            
            while(!positive.isEmpty() && !negative.isEmpty()){
                
                int p = positive.pop();
                int n = negative.pop();
                
                if(p > n){
                    positive.push(p - n);
                    count++;
                }else if(n >= p){
                	if(n - p != 0)
                		negative.push(n - p);
                    count++;
                }
            }
            
            if(count < minTransactions){
            	System.out.println(count == 2);
                minTransactions = count;
            }
            
        }
        
        return minTransactions;
        
    }

	public static void main(String[] args){
		
		int[][] transactions = {{2,0,5},{3,4,4}}; //[[0,1,10],[2,0,5]]
		OptimalAccountTransfers obj = new OptimalAccountTransfers();
		System.out.println(obj.minTransfers(transactions));
		
	}

}
