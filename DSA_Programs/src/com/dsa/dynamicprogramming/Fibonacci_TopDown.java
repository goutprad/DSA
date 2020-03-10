package com.dsa.dynamicprogramming;

/**
 * Fibonacci series using Dynamic Approach(TopDown Approach)
 * 
 * Time Complexity - o(n) 
 * Space Complexity - o(n) 
 * It uses internal Stack
 * 
 * @author Goutam
 *
 */
public class Fibonacci_TopDown {
	public int fibonacci(int[] memoize, int n) {
		if (n <= 1)
			return n;
		if (memoize[n] == 0) {
			memoize[n] = fibonacci(memoize, n - 1) + fibonacci(memoize, n - 2);
		}
		return memoize[n];
	}

	public static void main(String[] args) {
		Fibonacci_TopDown fib = new Fibonacci_TopDown();
		int n = 5;
		int[] memoize = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print(fib.fibonacci(memoize, i) + " "); //0 1 1 2 3
		}
	}
}
