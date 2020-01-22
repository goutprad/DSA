package com.dsa.stack;

import java.util.Stack;

/**
 * Delete Middle Element without extra space
 * 
 * @author Goutam
 *
 */
public class DeleteMiddleElementInStack {
	/**
	 * deleteMiddle - will delete the middle element 
	 * 
	 * @param st
	 * @param stackSize
	 * @param current
	 */
	static void deleteMiddle(Stack<Integer> st, int stackSize, int current) {
		if (st.isEmpty()) {
			return;
		}
		int item = st.pop();
		deleteMiddle(st, stackSize, current + 1);
		if (current != stackSize / 2) {
			st.push(item);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		System.out.println("Before Remove: "+st);
		deleteMiddle(st, st.size(), 0);
		System.out.println("After Remove: "+st);
	}

}
