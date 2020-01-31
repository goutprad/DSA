package com.dsa.practice.leetcode.easy;

import java.util.Stack;

/**
 * 155. Min Stack - Without using any extra space
 * https://leetcode.com/problems/min-stack/
 * 
 * Time Complexity - o(1)
 * Space Complexity -o(1)
 * 
 * @author Goutam
 *
 */
public class MinStackWithOutExtraSpace {
	Stack<Integer> stack;
	int newMin;
	int oldMin;
	int top;
	public MinStackWithOutExtraSpace() {
		stack=new Stack<Integer>();
	}
	
	public void push(int item) {
		if(stack.isEmpty()) {
			newMin=item;
			stack.push(item);
		} else if(newMin>item) {
			oldMin=newMin;
			newMin=item;
			top=newMin-oldMin;
			stack.push(top);
		} else {
			stack.push(item);
		}	
	}
	
	public int top() {
		if(stack.peek()<0) {
			return stack.peek()+oldMin;
		} else {
			return stack.peek();
		}
	}
	public int getMin() {
		return newMin;
	}
	public int pop() {
		int popped = Integer.MIN_VALUE;
		if(!stack.isEmpty() && stack.peek()<0) {
			stack.pop();
			newMin=oldMin;
			oldMin=newMin-top;
			top=newMin-oldMin;
			popped=newMin+top;
		} else if(!stack.isEmpty()) {
			popped = stack.pop();
		}
		return popped;
	}
	
	public static void main(String[] args) {
		MinStackWithOutExtraSpace minStack=new MinStackWithOutExtraSpace();
		minStack.push(5);
		minStack.push(4);
		minStack.push(9);
		minStack.push(7);
		minStack.push(3);
		System.out.println("min: " + minStack.getMin()); // 3
		minStack.push(6);
		minStack.push(2);
		minStack.push(2);
		System.out.println("min: " + minStack.getMin()); // 2
		minStack.push(10);
		System.out.println("top: " + minStack.top());
		System.out.println("pop: " + minStack.pop());
		System.out.println("min: " + minStack.getMin()); // 2
		System.out.println("pop: " + minStack.pop());
		System.out.println("min: " + minStack.getMin()); // 2
		System.out.println("pop: " + minStack.pop());
		System.out.println("min: " + minStack.getMin()); // 3
	}

}
