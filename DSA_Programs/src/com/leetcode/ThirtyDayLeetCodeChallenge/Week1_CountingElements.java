package com.leetcode.ThirtyDayLeetCodeChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Week1_CountingElements {
	public int countElements(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		for (Entry<Integer, Integer> i : map.entrySet()) {
			if (map.containsKey(i.getKey() + 1)) {
				count += map.get(i.getKey());
			}
		}
		return count;
	}

	public int countElements_bruteforce(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[i] + 1 == arr[j]) {
					count++;
				}
			}
		}
		return count;
	}

	public int countElements_TwoPointer(int[] arr) {
		int count = 0;
		Arrays.sort(arr);
		for (int i = 0, j = 1; j < arr.length;) {
			if (arr[i] + 1 == arr[j]) {
				count += j - i;
				i = j;
				j++;
			} else if (arr[i] == arr[j]) {
				j++;
			} else {
				i = j;
				j++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Week1_CountingElements leetCode = new Week1_CountingElements();
		int[] arr = { 1, 3, 2, 3, 5, 0 };
		System.out.println(leetCode.countElements(arr));
		System.out.println(leetCode.countElements_bruteforce(arr));
		System.out.println(leetCode.countElements_TwoPointer(arr));
	}
}
