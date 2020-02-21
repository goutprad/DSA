package com.dsa.practice.leetcode.easy;

/**
 * 83.Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * @author Goutam
 *
 */
public class RemoveDuplicatesFromSortedList {
	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}

		public String toString() {
			return "" + val;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return head;
		ListNode current = head;
		while(current.next!=null) {
			if(current.val == current.next.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}
	
	public void printLL(ListNode head) {
		ListNode curr = head;
		while(curr!=null) {
			System.out.print(curr.val+" --> ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList ll = new RemoveDuplicatesFromSortedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(1);
		ll.head.next.next = new ListNode(2);
		ll.head.next.next.next = new ListNode(3);
		ll.head.next.next.next.next = new ListNode(3);
		ll.printLL(ll.head);
		ListNode head = ll.deleteDuplicates(ll.head);
		ll.printLL(head);
	}

}
