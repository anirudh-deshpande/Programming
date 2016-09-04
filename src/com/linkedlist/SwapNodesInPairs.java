package com.linkedlist;

public class SwapNodesInPairs {
	
	private class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	Node head;
	
	private void addFront(int data){
		Node newNode = new Node(data);
		newNode.data = data;
		
		if(head == null){
			head = newNode;
			return;
		}
		
		newNode.next = head;
		head = newNode;
	}
	
	private void display(){
		Node cur = this.head;
		
		while(cur != null){
			System.out.println(cur.data);
			cur = cur.next;
		}
	}
	
	private void swapNodesInPairs(){
		
		if(head == null || head.next == null){
			return;
		}
		
		Node temp = new Node(-1);
		Node newHead = temp;
		newHead.next = head;
		Node one, two;
		
		while(temp.next != null && temp.next.next != null){
			one = temp.next;
			two = temp.next.next;
			
			one.next = two.next;
			two.next = one;
			
			temp.next = two;
			temp = one;
			
		}
		head = newHead.next;
	}
	
	public static void main(String[] args){
		SwapNodesInPairs list = new SwapNodesInPairs();
		
		list.addFront(4);
		list.addFront(3);
		list.addFront(2);
		list.addFront(1);
		
		list.display();
		list.swapNodesInPairs();
		System.out.println();
		
		list.display();
	}

}
