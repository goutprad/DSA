package com.dsa.practice.leetcode.easy;

import java.util.Stack;

/**
 * 155. Min Stack - By using two stack
 * https://leetcode.com/problems/min-stack/
 * 
 * Time Complexity - o(1)
 * Space Complexity -o(n)
 * 
 * @author Goutam
 *
 */
public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minStack;

	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty())
			minStack.push(x);
		else if (minStack.peek() > x)
			minStack.push(x);
	}

	public int top() {
		return stack.peek();
	}

	public int pop() {
		int popped = stack.pop();
		if (popped == minStack.peek())
			minStack.pop();
		return stack.pop();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(5);
		minStack.push(4);
		minStack.push(9);
		minStack.push(7);
		minStack.push(3);
		System.out.println("min: " + minStack.getMin()); // 3
		minStack.push(6);
		minStack.push(2);
		minStack.push(2);
		System.out.println("min: " + minStack.getMin()); // 3
		minStack.push(10);
		System.out.println("top: " + minStack.top());
		System.out.println("pop: " + minStack.pop());
		System.out.println("min: " + minStack.getMin()); // 2
		System.out.println("pop: " + minStack.pop());
		System.out.println("min: " + minStack.getMin()); // 3
	}

}
