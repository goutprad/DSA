package com.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Create Stack using queues
 * approach 1- By using two queues
 * 
 * @author Goutam
 *
 */
public class StackUsingTwoQueues {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	public void push(int x) {
		System.out.println("Push: " + x);
		q1.offer(x);
	}

	public void pop() {
		Integer item = null;
		if (!q1.isEmpty()) {
			while (!q1.isEmpty()) {
				item = q1.poll();
				if (!q1.isEmpty()) { //here we are not adding the last item
					q2.add(item);
				}
			}
			swapQueue();
		} else {
			System.out.println("Stack is Empty!!");
		}
		System.out.println("Pop: " + item);
	}

	public void peek() {
		Integer item = null;
		if (!q1.isEmpty()) {
			while (!q1.isEmpty()) {
				item = q1.poll(); //last item will return as peek 
				q2.add(item);
			}
			swapQueue();
		} else {
			System.out.println("Stack is Empty!!");
		}
		System.out.println("Peek: " + item);
	}

	public void swapQueue() {
		Queue<Integer> tempQ = q1;
		q1 = q2;
		q2 = tempQ;
	}

	public boolean isEmpty() {
		System.out.println("Stack isEmpty: " + q1.isEmpty());
		return q1.isEmpty();
	}

	public void print() {
		System.out.println(q1);
	}

	public static void main(String[] args) {
		StackUsingTwoQueues stackQueueObj = new StackUsingTwoQueues();
		stackQueueObj.push(1);
		stackQueueObj.push(2);
		stackQueueObj.push(3);
		stackQueueObj.push(4);
		stackQueueObj.push(5);
		stackQueueObj.print();
		stackQueueObj.isEmpty();
		stackQueueObj.pop();
		stackQueueObj.print();
		stackQueueObj.peek();
		stackQueueObj.pop();
		stackQueueObj.pop();
		stackQueueObj.pop();
		stackQueueObj.pop();
		stackQueueObj.pop();
		stackQueueObj.peek();
	}
}
