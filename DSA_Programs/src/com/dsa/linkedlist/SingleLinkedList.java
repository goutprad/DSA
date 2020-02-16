package com.dsa.linkedlist;

/**
 * Single Linked list operations
 * 
 * @author Goutam
 *
 */
public class SingleLinkedList {
	Node head;

	class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public String toString() {
			return "" + this.data;
		}
	}

	public void insert(int value) {
		Node newNode = new Node(value); // create a node
		newNode.next = null;
		if (head == null) { // when LL is empty
			head = newNode;
		} else { // insert at last
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
	}

	public void insertAtBegining(int value) {
		Node newNode = new Node(value); // create a nodes
		newNode.next = head;
		head = newNode;
	}

	public void insertAtPosition(int value, int pos) {
		int count = 1;
		Node curNode = head;
		if (pos > getSize()) // position is greater than LL size
			return;
		else if (pos == 0) { // position is equal to zero
			insertAtBegining(value);
		} else { // insert at given position and if position is last
			while (curNode != null && count != pos) {
				count++;
				curNode = curNode.next;
			}
			Node newNode = new Node(value);
			newNode.next = curNode.next;
			curNode.next = newNode;
		}
	}

	public int getSize() {
		int size = 0;
		Node curNode = head;
		while (curNode != null) {
			size++;
			curNode = curNode.next;
		}
		return size;
	}

	public void printLL() {
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode + " -> ");
			currNode = currNode.next;
		}
	}

	public static void main(String[] args) {
		SingleLinkedList singlyLL = new SingleLinkedList();
		singlyLL.insert(1);
		singlyLL.insert(2);
		singlyLL.insert(3);
		singlyLL.insertAtBegining(5);
		System.out.println("size: " + singlyLL.getSize());
		singlyLL.insertAtPosition(8, 5);
		System.out.println("size: " + singlyLL.getSize());
		singlyLL.printLL();
	}

}
