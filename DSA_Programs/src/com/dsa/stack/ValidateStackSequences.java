package com.dsa.stack;

import java.util.Stack;

/**
 * Validate Stack Sequences
 * 
 * @author Goutam
 *
 */
public class ValidateStackSequences {

	/**
	 * approach 1: 
	 * 
	 * @param pushed
	 * @param poped
	 * @return boolean
	 */
	static boolean validateStackSequences_01(int[] pushed, int[] poped) {
		int len = pushed.length;
		int i = 0;
		int j = 0;
		Stack<Integer> st = new Stack<Integer>();
		while (i < len) {
			if (pushed[i] == poped[j]) {
				j++;
				while (!st.isEmpty() && st.peek() == poped[j]) {
					st.pop();
					j++;
				}
			} else {
				st.add(pushed[i]);
			}
			i++;
		}
		while (!st.isEmpty()) {
			if (st.pop() == poped[j])
				j++;
			else
				return false;
		}
		return st.isEmpty();
	}

	/**
	 * Approach 2
	 * 
	 * @param pushed
	 * @param poped
	 * @return boolean
	 */
	static boolean validateStackSequences_02(int[] pushed, int[] poped) {
		int j = 0;
		int len = pushed.length;
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			st.push(pushed[i]);
			while (!st.isEmpty() && j < len && st.peek() == poped[j]) {
				st.pop();
				j++;
			}
		}
		return len == j;
	}

	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] poped = { 4, 5, 3, 2, 1 };
		System.out.println(validateStackSequences_02(pushed, poped) ? "True" : "false");
		System.out.println(validateStackSequences_01(pushed, poped) ? "True" : "false");
	}

}
