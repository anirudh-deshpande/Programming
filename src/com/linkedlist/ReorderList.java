package com.linkedlist;

public class ReorderList {
	
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
	
	private void reorderList(){
		//Find the middle element
		Node cur = head;
		Node middle = head;
		Node prev = null;
		
		while(cur != null && cur.next != null){
			prev = middle;
			middle = middle.next;
			cur = cur.next.next;
		}
		
		// Reverse from middle to end
		Node middleCur = middle;
		Node next;
		Node interHead;
		Node interPrev = null;
		
		while(middleCur != null){
			next = middleCur.next;
			middleCur.next = interPrev;
			interPrev = middleCur;
			middleCur = next; 
		}
		interHead = interPrev;
		prev.next = interHead;
		middle = prev.next;
		
		//Combine in a zig-zag fashion
		Node cur1 = head;
		Node next1 = head;
		Node cur2 = middle;
		Node next2 = middle;
		
		while(cur2 != null){
			next1 = cur1.next;
			cur1.next = next2;
			
			next2 = cur2.next;
			
			if(next1 == middle){
				cur2.next = null;
			}else{
				cur2.next = next1;
			}
			
			
			cur2 = next2;
			if(cur2 != null)
				cur1 = next1;
			
		}
		
		
		//cur1.next = null;
		
		
	}
	
	public static void main(String[] args){
		ReorderList list = new ReorderList();
		
		list.addFront(6);
		list.addFront(5);
		list.addFront(4);
		list.addFront(3);
		list.addFront(2);
		list.addFront(1);
		
		list.display();
		
		list.reorderList();
		
		System.out.println();
		
		list.display();
	}

}
