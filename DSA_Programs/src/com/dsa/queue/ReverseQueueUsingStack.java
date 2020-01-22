package com.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Reverse a Queue using Stack
 * 
 * @author Goutam
 *
 */
public class ReverseQueueUsingStack {
	public void reverseQueue(Queue<Integer> q) {
		Stack<Integer> st = new Stack<Integer>();
		while (!q.isEmpty()) {
			st.push(q.poll());
		}
		while (!st.isEmpty()) {
			q.offer(st.pop());
		}
	}

	public static void main(String[] args) {
		ReverseQueueUsingStack rev = new ReverseQueueUsingStack();
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		System.out.println("Before reverse: " + q);
		rev.reverseQueue(q);
		System.out.println("After reverse: " + q);
	}
}
