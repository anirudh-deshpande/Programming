package com.linkedlist;


public class ReverseAList {

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
	
	public static void main(String[] args){
		ReverseAList list = new ReverseAList();
		
		list.addFront(4);
		list.addFront(3);
		list.addFront(2);
		list.addFront(1);
		
		list.display();
		
		list.reverse();
		
		System.out.println();
		
		list.display();
	}
}
