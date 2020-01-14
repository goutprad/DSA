package com.dsa.array;

/**
 * Question : Minimum Sum Sub Array of size given size K Input : {10, 4, 3, 5 ,
 * 6, 3, 8 , 1} , k=3 Output : Index 1 to 3 with Sum as 12
 * 
 * @author Goutam
 *
 */
public class MinimumSumSubArray {

	public static void main(String[] args) {
		int[] arr = { 10, 4, 3, 5, 6, 3, 8, 1 };
		// int[] arr = {6, 4, 3, 5, 1, 9, 2};
		minimunSumSubArray(arr, arr.length, 3);
	}

	/**
	 * Time Complexity - 0(n), Space Complexity- o(1)
	 * 
	 * @param arr
	 * @param size
	 * @param k
	 */
	static void minimunSumSubArray(int[] arr, int size, int k) {

		if (size < k) {
			System.out.println("Invalid");
		}

		int minSum = 0;
		for (int i = 0; i < k; i++) {
			minSum += arr[i];
		}
		int startIndex = 0;
		int endIndex = 0;
		int curr_sum = minSum;
		int start = 0;
		int end = k - 1;
		while (end < size - 1) {
			curr_sum -= arr[start];
			start++;
			end++;
			curr_sum += arr[end];
			if (curr_sum < minSum) {
				minSum = curr_sum;
				startIndex = start;
				endIndex = end;
			}
		}
		System.out.println("Index" +startIndex+ "to" +endIndex+" with Minimum Sum as "+minSum );
	}

}
