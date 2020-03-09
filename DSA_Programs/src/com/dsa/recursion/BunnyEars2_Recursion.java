package com.dsa.recursion;

/**
 * bunnyEars2(0) -> 0 bunnyEars2(1) -> 2 bunnyEars2(2) -> 5 bunnyEars2(3) -> 7
 * bunnyEars2(4) -> 10 bunnyEars2(5) -> 12 bunnyEars2(6) -> 15 bunnyEars2(10) -> 25
 * 
 * @author Goutam
 *
 */
public class BunnyEars2_Recursion {
	public int bunnyEars2(int bunnies) {
		if (bunnies == 0)
			return bunnies;
		if (bunnies % 2 == 1)
			return 2 + bunnyEars2(bunnies - 1);
		return 3 + bunnyEars2(bunnies - 1);
	}

	public static void main(String[] args) {
		BunnyEars2_Recursion bunny2 = new BunnyEars2_Recursion();
		System.out.println(bunny2.bunnyEars2(2));
	}

}
