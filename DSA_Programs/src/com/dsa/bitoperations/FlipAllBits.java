package com.dsa.bitoperations;

/**
 * Flip all the bits for the given Integer Input : 11(eleven) Output : 4
 * Explanation : Eleven is 1011 Flipping bits 0100 which is four
 * 
 * @author Goutam
 *
 */
public class FlipAllBits {
	public static void main(String[] args) {
		int n = 11;
		int noOfBits = (int) (Math.log(n) / Math.log(2) + 1);
		flipBits(n, noOfBits);

		flipBits2(n, noOfBits);
	}

	/**
	 * Time Complexity - o(n)
	 * 
	 * @param n
	 * @param bits
	 */
	static void flipBits(int n, int bits) {
		for (int i = 0; i < bits; i++) {
			n = n ^ (1 << i);
		}
		System.out.println(n);
	}

	/**
	 * Time Complexity - o(1)
	 * 
	 * @param n
	 * @param bits
	 */
	static void flipBits2(int n, int bits) {
		n = n ^ (1 << bits) - 1;
		System.out.println(n);
	}

}
