package com.dsa.general;

/**
 * factorial using iterative way
 * 
 * @author Goutam
 *
 */
public class Factorial {
	public void factorial(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		System.out.println(fact);
	}

	public static void main(String[] args) {
		Factorial fact = new Factorial();
		fact.factorial(4); //24

	}

}
