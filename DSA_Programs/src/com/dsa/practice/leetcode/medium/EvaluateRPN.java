package com.dsa.practice.leetcode.medium;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation or evaluate postfix
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * @author Goutam
 *
 */
public class EvaluateRPN {
	/**
	 * evaluate postfix with out using stack 
	 * 
	 * @param exp
	 * @return int result
	 */
	public static int evaluateRPN(String[] exp) {
		int[] result = new int[exp.length / 2 + 1];
		int index = 0;
		for (String token : exp) {
			switch (token) {
			case "+":
				result[index - 2] = result[index - 2] + result[index - 1];
				index--;
				break;
			case "-":
				result[index - 2] = result[index - 2] - result[index - 1];
				index--;
				break;
			case "*":
				result[index - 2] = result[index - 2] * result[index - 1];
				index--;
				break;
			case "/":
				result[index - 2] = result[index - 2] / result[index - 1];
				index--;
				break;
			case "^":
				result[index - 2] = result[index - 2] ^ result[index - 1];
				index--;
				break;
			default:
				result[index++] = Integer.parseInt(token);
				break;
			}
		}
		return result[0];
	}
	
	/**
	 * evaluate postfix with using stack 
	 * 
	 * @param exp
	 * @return int result
	 */
	public static int evaluateRPNUsingStack(String[] exp) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < exp.length; i++) {
			if (exp[i].equals("+")) {
				st.push(st.pop() + st.pop());
			} else if (exp[i].equals("-")) {
				st.push(-st.pop() + st.pop());
			} else if (exp[i].equals("*")) {
				st.push(st.pop() * st.pop());
			} else if (exp[i].equals("/")) {
				int divisor= st.pop();
				st.push(st.pop() / divisor);
			} else if (exp[i].equals("^")) {
				st.push(st.pop() / st.pop());
			} else {
				st.push(Integer.parseInt(exp[i]));
			}
		}
		return st.pop();
	}

	public static void main(String[] args) {
		String[] input = { "2", "1", "+", "3", "*" };
		String[] input2 = { "4", "13", "5", "/", "+" };
		String[] input3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(evaluateRPN(input)); // 9
		System.out.println(evaluateRPN(input2)); // 6
		System.out.println(evaluateRPN(input3)); // 22

		System.out.println(evaluateRPNUsingStack(input)); //9
		System.out.println(evaluateRPNUsingStack(input2)); //6
		System.out.println(evaluateRPNUsingStack(input3)); //22
	}

}
