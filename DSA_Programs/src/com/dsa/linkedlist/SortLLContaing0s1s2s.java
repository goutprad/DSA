package com.dsa.linkedlist;

/**
 * Sort linked list containing 0’s, 1’s and 2’s
 * 
 * @author Goutam
 *
 */
public class SortLLContaing0s1s2s {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}

		public String toString() {
			return "" + this.data;
		}
	}

	public void add(int value) {
		Node newNode = new Node(value);
		newNode.next = null;

		if (head == null) {
			head = newNode;
		} else { // add at last
			Node last = head;
			while (last.next != null) { // traverse and find last.next is null
				last = last.next;
			}
			last.next = newNode;
		}
	}

	public void sort() {
		Node curr = head;
		int[] count = { 0, 0, 0 }; // here we can use three pointer count_0,count_1,count_2 and iterate each and
									// create ll
		while (curr != null) {
			count[curr.data]++;
			curr = curr.next;
		}
		int i = 0;
		curr = head;
		while (curr != null) {
			if (count[i] == 0) { // once the 0's,1's,2's count reach 0 then increase i
				i++;
			} else {
				--count[i];
				curr.data = i; // assign the i value to current node data
				curr = curr.next;
			}
		}
	}

	public void printLL() {
		Node cuNode = head;
		while (cuNode != null) {
			System.out.print(cuNode + " -> ");
			cuNode = cuNode.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SortLLContaing0s1s2s ll = new SortLLContaing0s1s2s();
		ll.add(0);
		ll.add(1);
		ll.add(0);
		ll.add(2);
		ll.add(1);
		ll.add(1);
		ll.add(2);
		ll.add(1);
		ll.add(2);
		ll.printLL();
		ll.sort();
		ll.printLL();
	}

}
