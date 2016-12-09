package com.datastructures.hashmap;

import java.util.HashMap;
import java.util.HashSet;

// Leetcode 403
public class CanFrogCross {
public boolean canCross(int[] stones) {
        
        int n = stones.length;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(stones[0]).add(1);
        
        for(int i = 0; i < n; i++){
            int stone = stones[i];
            HashSet<Integer> steps_i = map.get(stone);
            int reach = 0;
            for(int step: steps_i){
                reach = step + stone;
                if(reach == stones[stones.length - 1]){
                	System.out.println(map);
                    return true;
                }
                HashSet<Integer> set = map.get(reach);
                if(set != null){
                    set.add(step);
                    if(step - 1 > 0)
                        set.add(step - 1);
                    set.add(step + 1);
                }
                
            }
            
        }
        return false;
    }

	public static void main(String[] args){
		int[] stones = {0,1,3,6,7};
		System.out.println(new CanFrogCross().canCross(stones));
	}

}
