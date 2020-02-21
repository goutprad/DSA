package com.dsa.practice.leetcode.easy;
/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 * 
 * @author Goutam
 *
 */
public class LinkedListCycle {
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

	public static void printLL(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + " --> ");
			curr = curr.next;
		}
		System.out.println();
	}

	public boolean hasCycle(ListNode head) {
		if(head==null)
			return false;
        ListNode slow = head; // moves 1 ListNodes at a time
        ListNode fast = head; // moves 2 ListNodes at a time
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){ //If they meet at same node, there is a cycle
                return true;
            }
        }
        
        return false;
    }
	public boolean hasCycle_01(ListNode head)
	{
		if(head==null||head.next==null)
			return false;
		ListNode node=head.next;
		while(node!=null)
		{
			if(node.val==node.hashCode())
				return true;
			node.val=node.hashCode();
			node=node.next;
		}
		
		return false;
	}

	public static void main(String[] args) {
		LinkedListCycle ll = new LinkedListCycle();
		ll.head = new ListNode(3);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(0);
		ll.head.next.next.next = new ListNode(4);
		printLL(ll.head);
	    System.out.println(ll.hasCycle(ll.head));
	    System.out.println(ll.hasCycle_01(ll.head));
	}

}
