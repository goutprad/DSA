package com.dsa.practice.leetcode.easy;

/**
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * 
 * @author Goutam
 *
 */
public class MiddleOfTheLinkedList {
	ListNode head;

	class ListNode {
		int data;
		ListNode next;

		public ListNode(int x) {
			data = x;
		}

		public String toString() {
			return "" + data;
		}
	}

	public ListNode middleNode(ListNode head) {
		int start = (getSize(head)/2)+1;
		int i=0;
		ListNode current = head;
		ListNode startHead = null;
		while(current!=null) {
			i++;
			if(i==start) {
				startHead = current;
			}
			current = current.next;
		}
		return startHead;
	}
	
	public int getSize(ListNode head) {
		int size = 0;
		ListNode curNode = head;
		while (curNode != null) {
			size++;
			curNode = curNode.next;
		}
		return size;
	}

	public void add(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = null;
		
		if (head == null) {
			head = newNode;
		} else {
			ListNode last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
	}

	public void printLL(ListNode head) {
		ListNode currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + " --> ");
			currNode = currNode.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MiddleOfTheLinkedList middle = new MiddleOfTheLinkedList();
		middle.add(1);
		middle.add(2);
		middle.add(3);
		middle.add(4);
		middle.add(5);
		//middle.add(6);
		middle.printLL(middle.head); //1 --> 2 --> 3 --> 4 --> 5 --> 
		ListNode head1 = middle.middleNode(middle.head);
		middle.printLL(head1); //3 --> 4 --> 5 --> 
	}

}
