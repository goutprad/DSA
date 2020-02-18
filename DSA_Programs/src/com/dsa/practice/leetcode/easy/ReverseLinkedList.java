package com.dsa.practice.leetcode.easy;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * @author Goutam
 *
 */
public class ReverseLinkedList {
	ListNode head;

	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}

		public String toString() {
			return "" + val;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode curNode = head;
		ListNode next = null;
		ListNode prev = null;
		while (curNode != null) {
			next = curNode.next;
			curNode.next = prev;
			prev = curNode;
			curNode = next;
		}
		head = prev;
		return head;
	}

	public void add(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = null;

		if (head == null) {
			head = newNode;
		} else { // add at last
			ListNode last = head;
			while (last.next != null) { // traverse and find last.next is null
				last = last.next;
			}
			last.next = newNode;
		}
	}

	public void printLL(ListNode head) {
		ListNode cuNode = head;
		while (cuNode != null) {
			System.out.print(cuNode + " -> ");
			cuNode = cuNode.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ReverseLinkedList ll = new ReverseLinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.printLL(ll.head);
		ListNode head = ll.reverseList(ll.head);
		ll.printLL(head);

	}

}
