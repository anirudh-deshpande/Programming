package com.linkedlist;

public class PartitonList {
	
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
	
	private void partition(int k){
		
		Node helper1 = new Node(Integer.MIN_VALUE);
		Node cur1 = helper1;
		
		Node helper2 = new Node(Integer.MIN_VALUE);
		Node cur2 = helper2;
		
		Node cur = head;
		while(cur != null){
			if(cur.data < k){
				cur1.next = cur;
				cur1 = cur;
			}else{
				cur2.next = cur;
				cur2 = cur;
			}
			cur = cur.next;
		}
		
		cur2.next = null;
		cur1.next = helper2.next;
		head = helper1.next;
		
	}
		
	
	public static void main(String[] args){
		PartitonList list = new PartitonList();
		
		list.addFront(2);
		list.addFront(5);
		list.addFront(2);
		list.addFront(3);
		list.addFront(4);
		list.addFront(1);
		
		list.display();
		
		list.partition(3);
		
		System.out.println();
		
		list.display();
	}


}
