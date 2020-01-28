package com.dsa.practice.leetcode.medium;

import java.util.Stack;

/**
 * 901. Online Stock Span
 * https://leetcode.com/problems/online-stock-span/
 * @author C56086A
 *
 */
public class StockSpan {
	int[] result;

	/**
	 * stockSpanByStack
	 * @param stocks
	 */
	public void stockSpanByStack(int[] stocks) {
		result = new int[stocks.length];
		Stack<Integer> st = new Stack<Integer>();
		result[0] = 1;
		st.push(0);
		for (int i = 1; i < stocks.length; i++) {
			if (stocks[i] < stocks[st.peek()]) {
				result[i] = i - st.peek();
				st.push(i);
			} else {
				while (!st.isEmpty() && stocks[i] > stocks[st.peek()]) {
					st.pop();
				}
				if (!st.isEmpty())
					result[i] = i - st.peek();
				else
					result[i] = i - (-1);
				st.push(i);
			}
		}
	}

	public static void main(String[] args) {
		StockSpan span = new StockSpan();
		int[] input = { 100, 80, 60, 70, 60, 75, 85, 105 };
		span.stockSpanByStack(input); // 1, 1, 1, 2, 1, 4, 6, 8
		for (int i = 0; i < span.result.length; i++) {
			System.out.print(span.result[i]+" "); 
		}
	}

}
