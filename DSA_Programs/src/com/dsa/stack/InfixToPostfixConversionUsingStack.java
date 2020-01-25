package com.dsa.stack;

import java.util.Stack;

/**
 * Convert Infix expression (A+B) + (C-D) to postfix expression AB+CD- using
 * stack.
 * 
 * @author Goutam
 *
 */
public class InfixToPostfixConversionUsingStack {

	static int precedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}
	/**
	 * infixToPostFixConversion
	 * 
	 * @param exp
	 * @return String
	 */
	public static String infixToPostFixConversion(String exp) {
		System.out.println(exp);
		String result = "";
		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (Character.isLetterOrDigit(ch)) { // If the scanned character is an operand, add it to output.
				result += ch;
			} else if (ch == '(') { // If the scanned character is an '(', push it to the stack.
				st.push(ch);
			} else if (ch == ')') { // If the scanned character is an ')', pop and output from the stack until an
									// '(' is encountered.
				while (!st.isEmpty() && st.peek() != '(') {
					result += st.pop();
				}
				if (!st.isEmpty() && st.peek() != '(') {
					return "Invalid!!";
				} else {
					st.pop();
				}
			} else { // an operator is encountered
				while (!st.isEmpty() && precedence(ch) <= precedence(st.peek())) {
					if (st.peek() == '(')
						return "Invalid!!";
					result += st.pop();
				}
				st.push(ch);
			}
		}
		while (!st.isEmpty()) {
			if (st.peek() == '(')
				return "Invalid Expression";
			result += st.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixToPostFixConversion(exp)); //abcd^e-fgh*+^*+i-
	}

}
