package com.dsa.recursion;

/**
 * Factorial using Recursion
 * 
 * @author Goutam
 *
 */
public class Factorial {

	public int factorial(int n) {
		if (n == 1) {
			return n;
		}
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		Factorial fact = new Factorial();
		System.out.println(fact.factorial(3)); //6
	}

}
