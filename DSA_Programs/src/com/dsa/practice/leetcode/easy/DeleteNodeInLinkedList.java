package com.dsa.practice.leetcode.easy;

/**
 * 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * 
 * @author Goutam
 *
 */
public class DeleteNodeInLinkedList {
	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}

		public String toString() {
			return "" + val;
		}
	}

	/**
	 * Solution for leetcode
	 * 
	 * @param node
	 */
	public void deleteNode(ListNode node) {
		// solution 1
		/*
		 * ListNode temp = node.next; 
		 * node.val = temp.val; 
		 * node.next = temp.next; 
		 * temp = null;
		 */
		
		// solution 2
		if (node == null || node.next == null) {
			return;
		}
		node.val = node.next.val;
		node.next = node.next.next;

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
		DeleteNodeInLinkedList delNode = new DeleteNodeInLinkedList();
		delNode.add(4);
		delNode.add(5);
		delNode.add(1);
		delNode.add(9);
		delNode.printLL(delNode.head);
		ListNode node = new ListNode(1);
		delNode.deleteNode(node);
	}

}
