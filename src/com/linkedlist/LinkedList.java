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
		
	}
}
