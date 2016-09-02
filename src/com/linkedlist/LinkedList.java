package com.linkedlist;

public class LinkedList<T> {
	
	private class Node<T>{
		T data;
		Node<T> next;
		
		public Node(T data){
			this.data = data;
		}
	}
	
	Node<T> head;
	
	private void addFront(T data){
		
		Node<T> newNode = new Node<T>(data);
		
		if(head == null){
			head = newNode;
		}else{
			newNode.next = head;
			head = newNode;
		}
	}
	
	private void addBack(T data){
		
		Node<T> newNode = new Node<T>(data);
		
		if(head == null){
			head = newNode;
			return;
		}
		
		Node<T> cur = head;
		
		while(cur.next != null){
			cur = cur.next;
		}
		
		cur.next = newNode;
		newNode.next = null;
		
	}
	
	private T removeFront(){
		
		if(head == null){
			return null;
		}
		
		T data = head.data;
		this.head = this.head.next;
		return data;
	}
	
	private T removeBack(){
		
		if(head == null){
			return null;
		}
		
		Node<T> cur = head;
		Node<T> prev = null;
		
		while(cur.next != null){
			prev = cur;
			cur = cur.next;
		}
		
		T data = cur.data;
		
		if(prev != null){
			prev.next = null;
		}
		
		return data;
		
	}
	
	public void display(){
		if(head != null){
			Node<T> cur = this.head;
			
			while(cur != null){
				System.out.println(cur.data);
				cur = cur.next;
			}
		}
	}
	
	public static void main(String[] args){
		LinkedList<Integer> list = new LinkedList<>();
		
		list.addFront(10);
		list.addFront(9);
		list.addFront(8);
		
		list.display();
		
		LinkedList<String> stringList = new LinkedList<>();
		stringList.addFront("Colors");
		stringList.addFront("Red");
		stringList.addFront("Deshpande");
		
		stringList.display();
		
		LinkedList<Double> doubleList = new LinkedList<>();
		doubleList.addBack(10.00);
		doubleList.addBack(11.00);
		doubleList.addBack(12.00);
		
		doubleList.display();
		
		stringList.removeFront();
		stringList.display();
		
		doubleList.removeBack();
		doubleList.display();
		
		
	}
}
