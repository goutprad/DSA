package com.dsa.practice.leetcode.easy;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * Input: head = [1,0,1] Output: 5
 * 
 * @author Goutam
 *
 */
public class ConvertBinaryNumInLLToInteger {
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

	public int getDecimalValue(ListNode head) {
		int size = getSize(head);
		ListNode currNode = head;
		int sum=0;
		while(currNode != null) {
			sum += currNode.val* Math.pow(2, --size);
			currNode = currNode.next;
		}
		return sum;
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

	public void add(int value) {
		ListNode newNode = new ListNode(value);
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

	public void printLL() {
		ListNode currNode = head;
		while (currNode != null) {
			System.out.print(currNode.val + " --> ");
			currNode = currNode.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ConvertBinaryNumInLLToInteger converter = new ConvertBinaryNumInLLToInteger();
		converter.add(1);
		converter.add(0);
		converter.add(1);
		converter.printLL();
		System.out.println(converter.getDecimalValue(converter.head));
	}

}
