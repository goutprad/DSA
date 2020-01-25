package com.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Sort a queue using recursion
 * 
 * @author Goutam
 *
 */
public class SortQueueUsingRecursion {
	/**
	 * enqueue front to last
	 * 
	 * @param q
	 * @param qsize
	 */
	public static void frontToLast(Queue<Integer> q, int qsize) {
		if(qsize<=0) {
			return;
		}
		q.offer(q.peek());
		q.poll();
		frontToLast(q, qsize-1);
	}
	
	/**
	 * enqueue item to queue 
	 * 
	 * @param q
	 * @param qsize
	 * @param temp
	 */
	public static void enqueueToQueue(Queue<Integer> q, int qsize, int temp) {
		if(q.isEmpty() || qsize==0) {
			q.offer(temp);
			return;
		} else if(temp<=q.peek()) {
			q.offer(temp);
			frontToLast(q, qsize);
		} else {
			q.offer(q.peek());
			q.poll();
			enqueueToQueue(q, qsize-1, temp);
		}
		
	}

	/**
	 * sort an queue using recursion
	 * 
	 * @param q
	 */
	public static void sortQueue(Queue<Integer> q) {
		if(q.isEmpty()) {
			return;
		}
		int temp=q.peek();
		q.poll();
		sortQueue(q);
		enqueueToQueue(q,q.size(),temp);
	}

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(15);
		q.offer(6);
		q.offer(4);
		q.offer(-7);
		q.offer(26);
		q.offer(-4);
		System.out.println("Before Sorting: " + q);
		sortQueue(q);
		System.out.println("After Sorting: " + q);
	}

}
