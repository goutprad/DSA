package com.dsa.practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1122. Relative Sort Array
 * https://leetcode.com/problems/relative-sort-array/
 * 
 * @author Goutam
 *
 */
public class RelativeSortArray {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length];
		int[] bucket = new int[1001];
		int index = 0;
		for(int i : arr1) {
            bucket[i]++;
        }
		for(int i : arr2) {
            while(bucket[i]-- > 0) {
                result[index++] = i;
            }
        }
		for(int i = 0; i < 1001; i++){
            if(bucket[i] > 0) {
                while(bucket[i]-- > 0) {
                    result[index++] = i;
                }
            }
        }
		return result;
	}
	public int[] relativeSortArray_2ndAttempt(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr2) {
			map.put(i, 0);
		}
		int length = arr1.length -1;
		for (int i : arr1) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}else {
				result[length--] = i;
			}
		}
		int k=0;
		for (int i = 0; i < arr2.length; i++) {
			int arr2val = map.get(arr2[i]);
			while (arr2val>0) {
				result[k++] = arr2[i];
				arr2val--;
			}
		}
		Arrays.sort(result, k, arr1.length);
		return result;
	}
	
	
	public int[] relativeSortArray_by1stAttempt(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr1.length; i++) {
			if (!map.containsKey(arr1[i])) {
				map.put(arr1[i], 1);
			} else {
				map.put(arr1[i], map.get(arr1[i]) + 1);
			}
		}

		int i = 0;
		int[] result = new int[arr1.length];
		for (int j = 0; j < arr2.length; j++) {
			if (map.containsKey(arr2[j])) {
				while (map.get(arr2[j]) > 0 && i < result.length) {
					map.put(arr2[j], map.get(arr2[j]) - 1);
					result[i++] = arr2[j];
				}
			}
		}
		int sortfrom = i;
		int l = arr1.length;
		while (l-- > 0 && i < result.length) {
			if (map.get(arr1[l]) != 0) {
				map.put(arr1[l], map.get(arr1[l]) - 1);
				result[i++] = arr1[l];
			}
		}
		
		Arrays.sort(result, sortfrom, arr1.length);
		return result;
	}

	public static void main(String[] args) {
		RelativeSortArray leetcode = new RelativeSortArray();
		int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
		int[] arr2 = { 2, 1, 4, 3, 9, 6 };
		//int[] result = leetcode.relativeSortArray_2ndAttempt(arr1, arr2);
		//int[] result = leetcode.relativeSortArray_by1stAttempt(arr1, arr2);
		int[] result = leetcode.relativeSortArray(arr1, arr2);
		System.out.println(Arrays.toString(result));
		// {2=3, 3=2, 1=1, 4=1, 6=1, 7=1, 9=1, 19=1}
	}

}
