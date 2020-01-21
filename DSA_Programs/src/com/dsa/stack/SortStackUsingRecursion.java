package com.dsa.stack;

import java.util.Stack;

/**
 * Sort a stack using recursion
 * 
 * @author Goutam
 *
 */
public class SortStackUsingRecursion {
	/**
	 * Sort and insert the element to same Stack
	 * 
	 * @param s Stack
	 * @param ele int
	 */
	static void sortAndInsert(Stack<Integer> s, int ele) {
		if(s.isEmpty() || ele > s.peek()) {
			s.push(ele);
			return;
		}
		int a =s.pop();
		sortAndInsert(s, ele);
		s.push(a);
	}
	
	/**
	 * Sort the Stack
	 * 
	 * @param s Stack
	 */
	static void sortStack(Stack<Integer> s) {
		if(!s.isEmpty()) {
			int item = s.pop();
			sortStack(s);
			sortAndInsert(s, item);
		}	
	}

	public static void main(String[] args) {
		Stack<Integer> st=new Stack<Integer>();
		st.push(15);
		st.push(6);
		st.push(4);
		st.push(-7);
		st.push(26);
		st.push(-4);
		System.out.println("Before Sorting: "+st);
		sortStack(st);
		System.out.println("After Sorting: "+st);

	}

}
