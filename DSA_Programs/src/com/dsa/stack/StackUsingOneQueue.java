package com.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Create Stack using queues
 * approach 2: By Using Single Queue
 * 
 * @author Goutam
 *
 */
public class StackUsingOneQueue {

	Queue<Integer> q1 = new LinkedList<Integer>();
	static int topOfQueue = -1;

	public void push(int item) {
		//System.out.println("Push :" + item);
		q1.offer(item);
		topOfQueue++;
	}

	public void pop() {
		int a = -1;
		for (int i = 0; i < topOfQueue + 1; i++) {
			a = q1.poll();
			if (i != topOfQueue)
				push(a);
			topOfQueue--;
		}
		System.out.println("pop: " + a);
	}

	public void peek() {
		int a = -1;
		for (int i = 0; i < topOfQueue + 1; i++) {
			a = q1.poll();
			push(a);
			topOfQueue--;
		}
		System.out.println("Peek: " + a);
	}

	public void print() {
		System.out.println(q1);
	}

	public static void main(String[] args) {
		StackUsingOneQueue st = new StackUsingOneQueue();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.print();
		st.peek();
		st.pop();
		st.print();
		st.pop();
		st.print();
		st.pop();
		st.print();
		st.peek();
	}

}
