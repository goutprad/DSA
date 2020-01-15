package com.dsa.general;

/**
 * Swap two variable
 * 
 * @author Goutam
 *
 */
public class Swap {

	public static void main(String[] args) {

		swapUsingTemp(4, 6);
		swapUsingArithmetic(7, 4);
		swapUsingMulAndDiv(4, 5);
		swapUsingXOR(6, 8);
	}

	/**
	 * Swap using temp variable
	 * 
	 * @param a
	 * @param b
	 */
	static void swapUsingTemp(int a, int b) {
		System.out.println("Before swaping : a-" + a + " " + "b-" + b);
		int temp = a;
		a = b;
		b = temp;
		System.out.println("After swaping : a-" + a + " " + "b-" + b);
	}

	/**
	 * swap without using temp - using arithmetic operation
	 * 
	 * @param a
	 * @param b
	 */
	static void swapUsingArithmetic(int a, int b) {
		System.out.println("Before swaping : a-" + a + " " + "b-" + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After swaping : a-" + a + " " + "b-" + b);
	}

	/**
	 * swap using multiplication and division (for zero value it will not work)
	 * 
	 * @param a
	 * @param b
	 */
	static void swapUsingMulAndDiv(int a, int b) {
		System.out.println("Before swaping : a-" + a + " " + "b-" + b);
		a = a * b;
		b = a / b;
		a = a / b;
		System.out.println("After swaping : a-" + a + " " + "b-" + b);
	}

	/**
	 * swap using XOR
	 * 
	 * @param a
	 * @param b
	 */
	static void swapUsingXOR(int a, int b) {
		System.out.println("Before swaping : a-" + a + " " + "b-" + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("After swaping : a-" + a + " " + "b-" + b);
	}

}
