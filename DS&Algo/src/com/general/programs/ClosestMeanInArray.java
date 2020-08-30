package com.general.programs;

public class ClosestMeanInArray {

	public static void main(String[] args) {
		int[] arr = { 50, 24, 10, 16 }; // 24
		int[] arr1 = { 55, 35, 18, 12, 40 }; // 35
		int[] arr2 = { 20, 42, 68, 60, 15, 35 }; // 42
		int[] arr3 = { 10, 20, 30 }; // 20
		System.out.println(findClosestMeanInArray(arr, 4));
		System.out.println(findClosestMeanInArray(arr1, 5));
		System.out.println(findClosestMeanInArray(arr2, 6));
		System.out.println(findClosestMeanInArray(arr3, 3));
	}

	public static int findClosestMeanInArray(int[] arr, int size) {
		int target = 0;
		for (int i : arr) {
			target += i;
		}
		int mean = target / size;

		int closest = arr[0];
		int diff = Math.abs(closest - mean);
		for (int ele : arr) {
			int diff1 = Math.abs(ele - mean);
			if (diff > diff1) {
				closest = ele;
				diff = diff1;
			}
		}
		return closest;
	}
}
