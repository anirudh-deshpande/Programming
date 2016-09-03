package com.linkedlist;

public class OddEvenLinkedList {
	
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
	
	private void oddEvenLinkedList(){
		Node odd = head;
		Node even = head.next;
		Node evenHead = even;
		
		while(even != null && even.next != null){
			odd.next = even.next;
			even.next = even.next.next;
			
			odd = odd.next;
			even = even.next;
		}
		
		odd.next = evenHead;
		
		this.display();
	}
	
	public static void main(String[] args){
		
		OddEvenLinkedList list = new OddEvenLinkedList();
		
		list.addFront(6);
		list.addFront(5);
		list.addFront(4);
		list.addFront(3);
		list.addFront(2);
		list.addFront(1);
		
		list.oddEvenLinkedList();
		
		
		
	}

}
