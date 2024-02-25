package com.linkedList;

public class LinkedListDS {
	private Node head; // First Node in LL Is a head.
	private Node tail; // Last Node in LL is a tail.
	private int length; // This depicts length of a linked list.
	
	public LinkedListDS(int value) {
		head = new Node(value); 
		tail = head;
		length=1;
	}
	/*
	 * prepend method is used to inserting an item at start of linked list 
	*/
	public void prepend(int value) {
		head = new Node(value,head);
		length++;
	}
	/*
	 * append method is used to inserting an item at end of linked list 
	*/
	public void append(int value) {
		Node newNode = new Node(value);
		tail.setNext(newNode);
		tail = newNode;
		length++;
	}
	
	public void printList() {
		if(head==null) {
			return;
		}
		Node currNode = head;
		System.out.print(currNode.getValue());
		while(currNode!=null) {
			System.out.print("-->"+currNode.getValue());
			currNode = currNode.getNext();
		}
		System.out.println();
	}
	
	/*
	 * insert method is used to inserting an item at user specified location. 
	*/
	public void insert(int index, int value) {
		index = wrapIndex(index);
		if(index==0) {
			prepend(value);
			return;
		}
		if(index==length-1) {
			append(value);
			return;
		}
		
		Node leader = traverseToIndex(index-1);
		Node nextNode = leader.getNext();
		
		Node newNode = new Node(value,nextNode);
		leader.setNext(newNode);
		length++;
	}
	
	/*
	 * remove method is used to removing an item from linked list using index. 
	*/
	public void remove(int index) {
		index = wrapIndex(index);
		if(index==0) {
			head = head.getNext();
			return;
		}
		Node leader = traverseToIndex(index-1);
		Node nodeRemove =leader.getNext();
		leader.setNext(nodeRemove.getNext());
		length--;
	}
	
	/*
	 * reverse method is used to reverse linked list 
	*/
	public void reverse() {
		Node first = head;
		tail = head;
		Node second = first.getNext();
		for(int i =0 ;i<length-1;i++) {
			Node temp = second.getNext();
			second.setNext(first);
			first = second;
			second = temp;
		}
		head.setNext(null);
		head= first;
	}
	
	public Node traverseToIndex(int index) {
		index =wrapIndex(index);
		Node currNode =head;
		for(int i = 0; i< index;i++) {
			currNode =currNode.getNext();
		}
		return currNode;
	}
	
	private int wrapIndex(int index) {
		//Used for wrapping the given index to make sure it's valid
		return Math.max(Math.min(index, length-1), 0);
		
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public int getLength() {
		return length;
	}

	public static void main(String[] args) {
		LinkedListDS mySinglyLinkedList = new LinkedListDS(5);
		    mySinglyLinkedList.append(8);
		    mySinglyLinkedList.append(4);
		    mySinglyLinkedList.prepend(10);
		    mySinglyLinkedList.printList();
		    mySinglyLinkedList.insert(2,15);
		    mySinglyLinkedList.printList();
		    mySinglyLinkedList.remove(100);
		    mySinglyLinkedList.remove(2);
		    mySinglyLinkedList.printList();
		    mySinglyLinkedList.reverse();
		    mySinglyLinkedList.printList();
		    System.out.println(mySinglyLinkedList);
	}
	
	
}
