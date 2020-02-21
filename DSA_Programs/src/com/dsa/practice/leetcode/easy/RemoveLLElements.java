package com.dsa.practice.leetcode.easy;

/**
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * @author Goutam
 *
 */
public class RemoveLLElements {
	ListNode head;

	class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}

		public String toString() {
			return "" + val;
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode curr = dummyNode;
		while(curr.next!=null) {
			if(curr.next.val==val) {
				curr.next = curr.next.next;
			} else {
				curr=curr.next;
			}
			
		}
		return dummyNode.next;
	}

	public void add(int val) {
		ListNode newNode = new ListNode(val);
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
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + " --> ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		RemoveLLElements remove = new RemoveLLElements();
		remove.add(1);
		remove.add(2);
		remove.add(6);
		remove.add(3);
		remove.add(4);
		remove.add(5);
		remove.add(6);
		remove.printLL(remove.head);
		ListNode head1 = remove.removeElements(remove.head, 1);
		remove.printLL(head1);
	}

}
