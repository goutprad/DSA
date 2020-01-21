package com.dsa.queue;

import java.util.Stack;

/**
 * Create Queue using stacks
 * Approach 1:using two stack
 * 
 * @author Goutam
 *
 */
public class QueueUsingStack {

	Stack<Integer> st1 = new Stack<Integer>();
	Stack<Integer> st2 = new Stack<Integer>();

	public void enQueue(int item) {
		System.out.println("enQueue: " + item);
		//Moving all elements from st1 to st2
		while (!st1.isEmpty()) {
			st2.push(st1.pop());
		}
		
		st1.push(item);
		// Pushing everything back to st1
		while (!st2.isEmpty()) {
			st1.push(st2.pop());
		}
	}

	public void deQueue() {
		if (st1.isEmpty()) {
			System.out.println("Queue is Empty!!");
			System.exit(0);
		}
		int a = st1.peek();
		st1.pop();
		System.out.println("Dequeu: " + a);
	}

	public void printQueue() {
		Stack<Integer> tempSt = new Stack<Integer>();
		for (int i = st1.size() - 1; i >= 0; i--) {
			tempSt.push(st1.elementAt(i));
		}
		System.out.println(tempSt);
	}
	
	public void pool() {
		System.out.println("Pool: "+st1.peek());
	}

	public static void main(String[] args) {
		QueueUsingStack st = new QueueUsingStack();
		st.enQueue(1);
		st.enQueue(2);
		st.enQueue(3);
		st.enQueue(4);
		st.enQueue(5);
		st.printQueue();
		st.pool();
		st.deQueue();
		st.deQueue();
		st.printQueue();
	}
}
