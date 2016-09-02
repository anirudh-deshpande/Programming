package com.linkedlist;

import java.util.HashMap;

public class CopyRandomList {
	
	private class Node{
		
		int data;
		Node next;
		Node random;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	int count;
	Node head;
	
	private void addFront(int data){
		Node newNode = new Node(data);
		newNode.data = data;
		this.count++;
		
		if(head == null){
			head = newNode;
			return;
		}
		
		newNode.next = head;
		newNode.random = head;
		head = newNode;
	}
	
	private void display(){
		Node cur = this.head;
		
		while(cur != null){
			System.out.println(cur.data);
			cur = cur.next;
		}
	}
	
	private void displayRandom(){
		Node cur = this.head;
		
		while(cur != null){
			System.out.println(cur.data);
			cur = cur.random;
		}
	}
	
	private Node copyRandomList(Node head){
		
		if(head == null){
			return null;
		}
		
		HashMap<Node, Node> map = new HashMap<>();
		Node newHead = new Node(head.data);
		Node tail = newHead;
		
		map.put(newHead, head);
		
		Node cur = head.next;
		while(cur != null){
			
			Node newNode = new Node(cur.data);
			map.put(newNode, cur);
			
			if(tail != null)
				tail.next = newNode;
			
			tail = newNode;
			cur = cur.next;
		}
		
		tail = newHead;
		
		while(tail != null){
			tail.random = map.get(tail).random;
			tail = tail.next;
		}
		
		return newHead;
		
	}
	
	
	
	public static void main(String[] args){
		
		CopyRandomList list = new CopyRandomList();
		
		list.addFront(4);
		list.addFront(3);
		list.addFront(2);
		list.addFront(1);
		
		list.display();
		System.out.println();
		list.displayRandom();
		
		Node newHead = new CopyRandomList().copyRandomList(list.head);
		
		Node cur = newHead;
		
		System.out.println();
		while(cur != null){
			System.out.println(cur.data);
			cur = cur.random;
		}
		
	}


}
