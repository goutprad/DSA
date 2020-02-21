package com.dsa.practice.leetcode.easy;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * @author Goutam
 *
 */
public class MergeTwoSortedLists {
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

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null & l2 ==null)
			return null;
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		ListNode result = new ListNode(-1);
		ListNode curr = result;
		//boolean flag=false;
		while(l1!=null && l2!=null) {
			if(l1.val <=l2.val) {
				//flag = true;
				curr.next = l1;
				l1 = l1.next;
			} else {
				//flag = false;
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		if(l1!=null)
			curr.next = l1;
		if(l2!=null)
			curr.next = l2;
		return result.next;
	}

	public static void printLL(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + " --> ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MergeTwoSortedLists ll1 = new MergeTwoSortedLists();
		MergeTwoSortedLists ll2 = new MergeTwoSortedLists();
		ll1.head = new ListNode(1);
		ll1.head.next = new ListNode(2);
		ll1.head.next.next = new ListNode(4);
		printLL(ll1.head);
		ll2.head = new ListNode(1);
		ll2.head.next = new ListNode(3);
		ll2.head.next.next = new ListNode(5);
		printLL(ll2.head);
		ListNode head = ll1.mergeTwoLists(ll1.head, ll2.head);
		printLL(head);
	}

}
