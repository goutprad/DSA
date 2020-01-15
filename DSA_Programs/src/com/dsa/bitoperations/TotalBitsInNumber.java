package com.dsa.bitoperations;

/**
 * Give the number of bits required to form the Number Input : 11 Output : 4 (
 * Since it has 4 bits) Input : 32 Output : 6 (Since it has 6 bits)
 * 
 * @author Goutam
 *
 */
public class TotalBitsInNumber {

	public static void main(String[] args) {

		countBits(32); //Output: 6
		countBitsUsingLog(32); //Output: 6
		countBitsUsingBitTraversal(32); //Output: 6
	}

	/**
	 * Time Complexity - , Space Complexity - o(1)
	 * 
	 * @param num
	 */
	static void countBits(int num) {
		int bits = 0;
		while (num > 0) {
			num = num / 2;
			bits++;
		}
		System.out.println("Output: " + bits);
	}

	/**
	 * Time Complexity - log(n)
	 * 
	 * @param num
	 */
	static void countBitsUsingLog(int num) {
		int bits = (int) (Math.log(num) / Math.log(2) + 1);
		System.out.println("Output: " + bits);
	}

	/**
	 * Time Complexity- 
	 * 
	 * @param num
	 */
	static void countBitsUsingBitTraversal(int num) {
		int bits = 0;
		//00100000 - 00010000 - 00001000 - 00000100  00000010 - 00000001 -00000000
		while (num != 0) { 
			bits++;
			num >>= 1;
		}
		System.out.println("Output: " + bits);
	}

}
