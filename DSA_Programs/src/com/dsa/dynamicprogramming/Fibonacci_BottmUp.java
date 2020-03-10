package com.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * Fibonacci series using Dynamic Approach(BottmUp Approach)
 * 
 * Time Complexity - o(n) 
 * Space Complexity - o(n)
 * 
 * @author Goutam
 *
 */
public class Fibonacci_BottmUp {
	public int[] fibnacci(int n) {
		int[] table = new int[n];
		table[0] = 0;
		table[1] = 1;
		if (n > 2) // to handle below 3
			for (int i = 3; i <= table.length; i++) {
				table[i] = table[i - 2] + table[i - 3];
			}
		return table;
	}

	public static void main(String[] args) {
		Fibonacci_BottmUp fib = new Fibonacci_BottmUp();
		int[] result = fib.fibnacci(2);
		System.out.println(Arrays.toString(result)); //[0,1]
	}
}
