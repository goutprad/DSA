package com.dsa.stack;

import java.util.Stack;

/**
 * insert at buttom by using recursion
 * 
 * @author Goutam
 *
 */
public class InsertAtButtom {

	public static void main(String[] args) {
		Stack<Integer> st =new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println("Original Stack...");
		System.out.println(st); //[1, 2, 3]
		insert_at_buttom(st, 4);
		System.out.println("After inserting at bottom...");
		System.out.println(st); //[4, 1, 2, 3]
	}
	
	/**
	 * insert_at_buttom
	 * 
	 * @param stack
	 * @param a
	 */
	static void insert_at_buttom(Stack<Integer> stack, int a) {
		if(stack.isEmpty()) {
			stack.push(a);
		} else {
			int b = stack.peek();
			stack.pop();
			insert_at_buttom(stack, a);
			stack.push(b);
		}
	}
}
