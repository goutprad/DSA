package com.dsa.practice.leetcode.easy;

/**
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/
 * 
 * @author Goutam
 *
 */
public class FibonacciNumber {
	public int fib(int N) {
		if (N <= 1)
			return N;
		int a = 0;
		int b = 1;
		int c = 0;
		for (int i = 2; i <= N; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public static void main(String[] args) {
		FibonacciNumber leetcode = new FibonacciNumber();
		int res = leetcode.fib(4);
		System.out.println(res);
	}

}
