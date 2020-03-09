package com.dsa.general;

/**
 * Fibonacci - Using iterative approach
 * 
 * @author Goutam
 *
 */
public class Fibonacci {
	public void fibonacci(int n) {
		int n1 = 0;
		int n2 = 1;
		for (int i = 0; i < n; i++) {
			System.out.print(n1 + " ");
			int sum = n1 + n2;
			n1 = n2;
			n2 = sum;
		}
	}

	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		fib.fibonacci(4);
	}

}
