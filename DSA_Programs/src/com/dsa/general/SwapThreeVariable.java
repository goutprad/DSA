package com.dsa.general;

/**
 * Swap Three Variables
 * 
 * @author Goutam
 *
 */
public class SwapThreeVariable {

	public static void main(String[] args) {
		swapUsingTemp(4, 6, 8);
		swapUsingArithmetic(4, 6, 8);
		swapUsingXOR(4, 6, 8);
	}

	/**
	 * swapUsingArithmetic
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	static void swapUsingArithmetic(int a, int b, int c) {
		System.out.println("Before swaping : a-" + a + " " + "b-" + b + " c-" + c);
		a = a + b + c;
		b = a - (b + c);
		c = a - (b + c);
		a = a - (b + c);
		System.out.println("After swaping : a-" + a + " " + "b-" + b + " c-" + c);
	}

	/**
	 * swapUsingXOR
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	static void swapUsingXOR(int a, int b, int c) {
		System.out.println("Before swaping : a-" + a + " " + "b-" + b + " c-" + c);
		a = a ^ b ^ c;
		b = a ^ b ^ c;
		c = a ^ b ^ c;
		a = a ^ b ^ c;
		System.out.println("After swaping : a-" + a + " " + "b-" + b + " c-" + c);
	}

	/**
	 * swapUsingTemp
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	static void swapUsingTemp(int a, int b, int c) {
		System.out.println("Before swaping : a-" + a + " " + "b-" + b + " c-" + c);
		int temp = a;
		a = c;
		c = b;
		b = temp;
		System.out.println("After swaping : a-" + a + " " + "b-" + b + " c-" + c);
	}

}
