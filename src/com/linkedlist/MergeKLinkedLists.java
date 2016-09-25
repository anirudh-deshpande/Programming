package com.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLinkedLists {
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
	
	public Node mergeKLists(List<Node> lists){
		
		PriorityQueue<Node> queue = new PriorityQueue<>(lists.size(), new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.data < o2.data)
					return -1;
				if(o1.data == o2.data)
					return 0;
				else
					return 1;
			}
			
		});
		
		Node temp = new Node(Integer.MIN_VALUE);
		Node cur = temp;
		
		for(Node node:lists){
			if(node != null)
				queue.add(node);
		}
		
		while(!queue.isEmpty()){
			
			cur.next = queue.poll();
			cur = cur.next;
			
			//Beauty of references/ pointers
			if(cur.next != null){
				queue.add(cur.next);
			}
			
		}
		
		return temp.next;
		
	}
	
	
	public static void main(String[] args){
		MergeKLinkedLists list1 = new MergeKLinkedLists();
		list1.addFront(10);
		list1.addFront(5);
		list1.addFront(1);
		
		MergeKLinkedLists list2 = new MergeKLinkedLists();
		list2.addFront(8);
		list2.addFront(4);
		list2.addFront(2);
		
		List<Node> lists = new ArrayList<>();
		lists.add(list1.head);
		lists.add(list2.head);
		
		Node head = new MergeKLinkedLists().mergeKLists(lists);
		Node cur = head;
		
		while(cur != null){
			System.out.println(cur.data);
			cur = cur.next;
		}
		
	}

}
