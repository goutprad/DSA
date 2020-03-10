package com.dsa.divideandconquer;

/**
 * Fibonacci series using Divide & conquer or recursion
 * 
 * Time Complexity - o(1.068)^n Space Complexity - o(1)
 * 
 * @author Goutam
 *
 */
public class Fibonacci {
	public int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		int n = 2;
		for (int i = 0; i <= n; i++) {
			System.out.print(fib.fibonacci(i) + " ");
		}
	}
}
