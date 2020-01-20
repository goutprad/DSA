package com.dsa.array;

/**
 * Check if a sub-array with Sum 0 exits
 * 
 * @author Goutam
 *
 */
public class SubArrayWithSumZero {
	static int start=0;
	static int end=0;
	/**
	 * Time Complexity o(n)
	 * 
	 * @param arr
	 * @return boolean
	 */
	static boolean subArrayWithZeroSumExist(int arr[]) {
		int sum = 0;
		for (int i = start; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0 || arr[i] == 0) {
				end=i;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, -2, -3, 5, -4, 3 };
		if(subArrayWithZeroSumExist(arr)) {
			System.out.println("There is a subarray with zero sum from index "+ start+" to "+end);
		} else {
			System.out.println("There is no subarray with zero sum.");
		}
	}
}
