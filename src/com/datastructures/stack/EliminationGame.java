package com.datastructures.stack;

import java.util.LinkedList;
import java.util.Queue;

public class EliminationGame {
	
	public static void main(String[] args){
		
		EliminationGame game = new EliminationGame();
		
		int last = game.lastRemaining(17);
		
		System.out.println(last);
		
       
	}
	
	
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 ==1) {
                head = head + step;
                System.out.println("Head: "+head);
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

}
