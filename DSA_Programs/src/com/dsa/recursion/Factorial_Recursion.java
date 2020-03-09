package com.dsa.recursion;

/**
 * Factorial using Recursion
 * 
 * @author Goutam
 *
 */
public class Factorial_Recursion {

	public int factorial(int n) {
		if (n <= 1) {
			return n;
		}
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		Factorial_Recursion fact = new Factorial_Recursion();
		System.out.println(fact.factorial(3)); //6
	}

}
