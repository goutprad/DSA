package com.dsa.array;

import java.util.Arrays;

/**
 * Move all zeros present in the array to the end
 * 
 * @author Goutam
 *
 */
public class MoveAllZerosToEnd {
	/**
	 * move zeros in one pass 
	 * Time Complexity - o(n)
	 * 
	 * @param arr
	 */
	public void moveZerosToEnd(int[] arr) {
		int count=0; //cunter to find non
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0) {
				int temp=arr[count]; //copy zero to temp
				arr[count] = arr[i]; // place non zero at zero's place
				arr[i]=temp; //copy zero to non zero's place
				count++;
			}
		}
	}
	
	/**
	 * move zeros in two pass 
	 * Time Complexity - o(n)
	 * 
	 * @param arr
	 */
	public void moveZerosToEnd2(int[] arr) {
		int count=0; //to find total non zero
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0) {
				arr[count]=arr[i]; //move all non zeros to first
				count++;
			}
		}
		//to fill zeros to array at end
		while(count<arr.length) {
			arr[count]=0;
			count++;
		}
	}

	public static void main(String[] args) {
		MoveAllZerosToEnd moveZero = new MoveAllZerosToEnd();
		int[] arr = { 1, 0, 4, 5, 6, 0, 4, 0, 3, 0, 1, 0, 5 };
		moveZero.moveZerosToEnd(arr);
		System.out.println(Arrays.toString(arr)); //[1, 4, 5, 6, 4, 3, 1, 5, 0, 0, 0, 0, 0]
		int[] arr1 = { 1, 0, 4, 5, 6, 0, 4, 0, 3, 0, 1, 0, 5 };
		moveZero.moveZerosToEnd2(arr1);
		System.out.println(Arrays.toString(arr1)); //[1, 4, 5, 6, 4, 3, 1, 5, 0, 0, 0, 0, 0]
	}

}
