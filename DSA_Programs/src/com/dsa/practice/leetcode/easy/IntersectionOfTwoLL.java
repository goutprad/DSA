package com.dsa.practice.leetcode.easy;

/**
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * @author Goutam
 *
 */
public class IntersectionOfTwoLL {
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

	/**
	 * bruteForce
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode_bruteForce(ListNode headA, ListNode headB) {
		for (ListNode a = headA; a != null; a = a.next) {
			for (ListNode b = headB; b != null; b = b.next) {
				if (a == b) {
					return a;
				}
			}
		}
		return null;
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int nodeSizeA = 0;
		int nodeSizeB = 0;
		ListNode a = headA;
		ListNode b = headB;
		while(a!=null) {
			nodeSizeA++;
			a=a.next;
		}
		while(b!=null) {
			nodeSizeB++;
			b=b.next;
		}
		
		if(nodeSizeA>=nodeSizeB) {
			while(nodeSizeA!=nodeSizeB) {
				headA = headA.next;
				nodeSizeA--;
			}
		} else {
			while(nodeSizeA!=nodeSizeB) {
				headB = headB.next;
				nodeSizeB--;
			}
		}
		while(headA!=headB && headA!=null && headB!=null) {
			headA = headA.next;
			headB=headB.next;
		}
		return headA;
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
		IntersectionOfTwoLL ll1 = new IntersectionOfTwoLL();
		IntersectionOfTwoLL ll2 = new IntersectionOfTwoLL();
		ll1.add(4);
		ll1.add(1);
		ll1.add(8);
		ll1.add(4);
		ll1.add(5);
		ll2.add(5);
		ll2.add(0);
		ll2.add(1);
		ll2.add(8);
		ll2.add(4);
		ll2.add(5);
		ll1.printLL(ll1.head);
		ll1.printLL(ll2.head);

		System.out.println(ll1.getIntersectionNode(ll1.head, ll2.head)); 
		System.out.println(ll1.getIntersectionNode_bruteForce(ll1.head, ll2.head));
	}

}
