package com.dsa.stack;

import java.util.Stack;

public class StackReverseUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		System.out.println("Before Reverse....");
		System.out.println(st);
		stackReverse(st);
		System.out.println("After Reverse....");
		System.out.println(st);
	}

	/**
	 * reverse a stack using recursion
	 * 
	 * @param stack
	 */
	static void stackReverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		} else {
			int top = stack.peek();
			stack.pop();
			stackReverse(stack); 
			insert_at_buttom(stack, top);
		}
	}
	/**
	 * insert at bottom
	 * 
	 * @param stack
	 * @param x
	 */
	static void insert_at_buttom(Stack<Integer> stack, int x) {
		if (stack.isEmpty()) {
			stack.push(x);
		} else {
			int y = stack.peek();
			stack.pop();
			insert_at_buttom(stack, x);
			stack.push(y);
		}
	}

}
