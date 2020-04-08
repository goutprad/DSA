package com.dsa.stack;

import java.util.Stack;

/**
 * 
 * @author Goutam
 *
 */
public class BallanceParanthesis {
	public int getUnmatched(String s) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				st.push(ch);
			} else if (ch == ')' && !st.isEmpty() && st.peek() != ch) {
				st.pop();
			} else {
				st.push(ch);
			}
		}
		return st.size();
	}

	public static void main(String[] args) {
		BallanceParanthesis hack = new BallanceParanthesis();
		System.out.println(hack.getUnmatched("()))"));
	}
}
