package com.dsa.recursion;

/**
 * We have a number of bunnies and each bunny has two big floppy ears. We want
 * to compute the total number of ears across all the bunnies recursively
 * (without loops or multiplication).
 * 
 * @author Goutam
 *
 */
public class BunnyEars_Recursion {
	public int bunnyEars(int n) {
		if (n == 0)
			return 0;
		return bunnyEars(n - 1) + 2;
	}

	public static void main(String[] args) {
		BunnyEars_Recursion bunny = new BunnyEars_Recursion();
		System.out.println(bunny.bunnyEars(3));

	}

}
