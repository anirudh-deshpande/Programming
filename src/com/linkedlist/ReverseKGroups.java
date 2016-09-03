package com.linkedlist;
public class ReverseKGroups {
	
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
	
	
	private static Node reverseKGroups(Node head, int k){
		
		if(head == null || k<0){
			return head;
		}
		
		Node dummy = new ReverseKGroups().new Node(0);
		dummy.next = head;
		Node tail = dummy;
		Node prev = dummy, temp;
		
		while(true){
			
			int count = k;
			while(count > 0 && tail != null){
				tail = tail.next;
				count--;
			} 
			
			if(tail == null)break;
			
			head = prev.next;
			
			while(prev.next != tail){
				temp = prev.next;
				prev.next = temp.next;
				temp.next = tail.next;
				tail.next = temp;
				
			}
			
			tail = head;
			prev = head;
		}
		return dummy.next;
	}
	
	public static void main(String[] args){
		ReverseKGroups list = new ReverseKGroups();
		
		list.addFront(6);
		list.addFront(5);
		list.addFront(4);
		list.addFront(3);
		list.addFront(2);
		list.addFront(1);
		
		list.display();
		
		Node head = ReverseKGroups.reverseKGroups(list.head, 5);
		
		Node cur = head;
		while(cur != null){
			System.out.println(cur.data);
			cur = cur.next;
		}
	}
}
