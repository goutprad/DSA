package com.dsa.stack;

import java.util.Stack;

public class PostfixEvaluationUsingStack {
	public static int evaluatePostFix(String exp) {
		Stack<Integer> st = new Stack<Integer>();
		// String newExp = exp.replace(" ", "");
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (Character.isSpaceChar(ch)) {
				continue;
			} else if (Character.isDigit(ch)) {
				int n=0;
				while(Character.isDigit(ch)) {
					n=n*10+(ch-48);
					i++;
					ch=exp.charAt(i);
				}
				i--;
				st.push(n);
			} else {
				int item1 = st.pop();
				int item2 = st.pop();

				switch (exp.charAt(i)) {
				case '+':
					st.push(item2 + item1);
					break;
				case '-':
					st.push(item2 - item1);
					break;
				case '*':
					st.push(item2 * item1);
					break;
				case '/':
					st.push(item2 / item1);
					break;
				case '^':
					st.push(item2 ^ item1);
					break;
				}
			}
		}
		return st.pop();
	}

	public static void main(String[] args) {
		String postfixExp = "2 3 1 * + 9 -";
		System.out.println(evaluatePostFix(postfixExp)); //-4
		String postfixExp2 = "5 10 2 * + 3 -";
		System.out.println(evaluatePostFix(postfixExp2)); //22

	}

}
