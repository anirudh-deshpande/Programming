package com.linkedlist;

public class RotateAList {
	
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
	
	private void reverse(){
		Node prev = null;
		Node cur = head;
		Node next;
		
		while(cur != null){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		
		head = prev;
		
	}
	
	private void rotate(int k){
		
		int count = 0;
		Node hare = head;
		Node tortoise = head;
		
		while(hare !=null && count != k){
			hare = hare.next;
			count++;
		}
		
		if(hare == null){
			if((k % 2) == 0)
				return;
			else{
				this.reverse();
				return;
			}
		}
		
		while(hare.next != null){
			hare = hare.next;
			tortoise = tortoise.next;
		}
		
		hare.next = head;
		head = tortoise.next;
		tortoise.next = null;
		
		
	}
	
	public static void main(String[] args){
		RotateAList list = new RotateAList();
		
//		list.addFront(5);
//		list.addFront(4);
//		list.addFront(3);
		list.addFront(2);
		list.addFront(1);
		
		list.display();
		
		list.rotate(3);
		
		System.out.println();
		
		list.display();
	}

}
