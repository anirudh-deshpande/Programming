package com.linkedlist;

public class MergeTwoLinkedLists {
	
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
	
	public Node mergeTwoLists(Node a, Node b){
		
		Node temp = new Node(Integer.MIN_VALUE);
		Node cur = temp;
		Node head = cur;
		
		while(a != null && b != null){
			if(a.data <= b.data){
				cur.next = a;
				cur = a;
				a = a.next;
			}else{
				cur.next = b;
				cur = b;
				b = b.next;
			}
		}
		
		cur.next = a==null ? b : a;
		
		return head.next;
		
	}
	
	
	public static void main(String[] args){
		MergeTwoLinkedLists list1 = new MergeTwoLinkedLists();
		list1.addFront(10);
		list1.addFront(5);
		list1.addFront(1);
		
		MergeTwoLinkedLists list2 = new MergeTwoLinkedLists();
		list2.addFront(8);
		list2.addFront(4);
		list2.addFront(2);
		
		Node head = new MergeTwoLinkedLists().mergeTwoLists(list1.head, list2.head);
		Node cur = head;
		
		while(cur != null){
			System.out.println(cur.data);
			cur = cur.next;
		}
		
	}
}
