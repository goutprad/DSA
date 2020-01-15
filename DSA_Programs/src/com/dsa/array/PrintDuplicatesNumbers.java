package com.dsa.array;

/**
 * Given Range : 0 to 10. Input : 1,2,2,2,2,4,5,7,8,8 Output : 2, 8 Every
 * duplicate element should be printed only once.
 * 
 * @author Goutam
 *
 */
public class PrintDuplicatesNumbers {

	public static void main(String[] args) {
		int[] input = { 1, 2, 2, 2, 2, 4, 5, 7, 8, 8 };
		int size = input.length;
		findDuplicatsNumber1(input, size); // Duplicates are : 2 8
		System.out.println();
		int[] input2 = { 1, 2, 2, 2, 2, 4, 5, 7, 8, 8 };
		findDuplicatsNumber2(input2, input2.length); // Duplicates are : 2 8
		System.out.println();
		int[] input1 = { 1, 2, 2, 2, 2, 4, 5, 7, 8, 8 };
		findDuplicatsNumber4(input1, input1.length); // Duplicates are : 2 8
	}

	/**
	 * Approach - 1 Time Complexity - o(n) & Space Complexity - o(1)
	 * 
	 * @param arr
	 * @param size
	 */
	static void findDuplicatsNumber1(int[] arr, int size) {
		int duplicate = Integer.MIN_VALUE;
		System.out.print("Duplicates are : ");
		for (int i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] >= 0) {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			} else if (duplicate != Math.abs(arr[i])) {
				duplicate = Math.abs(arr[i]);
				System.out.print(Math.abs(arr[i]) + " ");
			}
		}
	}

	/**
	 * Approach - 2 Time Complexity - o(n) & Space Complexity - o(n)
	 * 
	 * @param arr
	 * @param size
	 */
	static void findDuplicatsNumber2(int[] arr, int size) {
		System.out.print("Duplicates are : ");
		int[] count = new int[size];
		int duplicate = Integer.MIN_VALUE;
		for (int i = 0; i < count.length; i++) {
			if (count[arr[i]] == 1 & duplicate != arr[i]) {
				duplicate = arr[i];
				System.out.print(arr[i] + " ");
			} else {
				count[arr[i]]++;
			}
		}
	}

	/**
	 * Approach - 3 Time Complexity - o(n) & Space Complexity - o(1)
	 * 
	 * array should have only two duplicate and each duplicate value should repeat
	 * once
	 * 
	 * @param arr
	 * @param size
	 */
	static void findDuplicatsNumber3(int[] arr, int size) {
		int sum = 0;
		int prod = 1;
		System.out.println(size);
		int n = size - 2;
		for (int i = 0; i < size; i++) {
			sum = sum + arr[i];
			prod = prod * arr[i];
		}
		sum = sum - n * (n + 1) / 2;
		prod = prod / fact(n);
		int D = (int) Math.sqrt(sum * sum - 4 * prod);
		int x = (D + sum) / 2;
		int y = (sum - D) / 2;
		System.out.println(x + " " + y);
	}

	static int fact(int n) {
		return (n == 0) ? 1 : n * fact(n - 1);
	}

	/**
	 * Approach - 4 Time Complexity - o(n*n) & Space Complexity - o(1)
	 * 
	 * @param arr
	 * @param size
	 */
	static void findDuplicatsNumber4(int[] arr, int size) {
		System.out.print("Duplicates are : ");
		int duplicate = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] == arr[j] & duplicate != arr[i]) {
					duplicate = arr[i];
					System.out.print(arr[i] + " ");
				}
			}
		}
	}

	/**
	 * approach -5 by using XOR
	 */

}
