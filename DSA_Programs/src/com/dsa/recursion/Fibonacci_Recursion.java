package com.dsa.recursion;

/**
 * Fibonacci - using recursion
 * 
 * @author Goutam
 *
 */
public class Fibonacci_Recursion {
	public int fibonacci(int n) {
		if (n <= 1)
			return n;
		return fibonacci(n - 2) + fibonacci(n - 1);
	}

	public static void main(String[] args) {
		Fibonacci_Recursion fib = new Fibonacci_Recursion();
		int max = 10;
		for (int i = 0; i <= max; i++) {
			System.out.print(fib.fibonacci(i) + " ");
		}
	}

}
