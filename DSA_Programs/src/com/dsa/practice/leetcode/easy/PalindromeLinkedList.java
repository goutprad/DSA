package com.dsa.practice.leetcode.easy;

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * @author Goutam
 *
 */
public class PalindromeLinkedList {
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

	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next==null)
			return true;
		ListNode currNode = head;
		
		int nodeCount=0;
		while (currNode != null) {
			nodeCount++;
			currNode = currNode.next;
		}
		
		int midNode = nodeCount/2;;
		
		currNode = head;
		ListNode temp = null;
		ListNode prev = null;
		for(int i=0;i<midNode;i++) {
			temp = currNode.next;
			currNode.next = prev;
			prev = currNode;
			currNode = temp;
		}
		//printLL(currNode);
		//printLL(prev);
		if (nodeCount % 2 == 1) {
            currNode = currNode.next;
        }
		//printLL(currNode);
		for (int j = 0; j < midNode; j++) {
			if(currNode.val != prev.val) {
				return false;
			} else {
				currNode=currNode.next;
				prev = prev.next;
			}
		}
		return true;
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
		PalindromeLinkedList palindrome = new PalindromeLinkedList();
		palindrome.add(1);
		palindrome.add(0);
		palindrome.add(1);
		//palindrome.add(1);
		//palindrome.add(3);
		palindrome.printLL(palindrome.head);
		System.out.println(palindrome.isPalindrome(palindrome.head));
	}
}
