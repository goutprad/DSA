package com.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Reverse a queue using recursion
 * 
 * @author Goutam
 *
 */
public class ReverseQueueUsingRecursion {

	public void reverseUsingRecursion(Queue<Integer> q) {
		if (!q.isEmpty()) {
			int front = q.peek();
			q.poll();
			reverseUsingRecursion(q);
			q.offer(front);
		}
	}

	public static void main(String[] args) {
		ReverseQueueUsingRecursion rev = new ReverseQueueUsingRecursion();
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		System.out.println("Before reverse: " + q);
		rev.reverseUsingRecursion(q);
		System.out.println("After reverse: " + q);

	}

}
