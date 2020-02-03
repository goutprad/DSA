package com.dsa.sort.algos;

/**
 * Bubble Sort-(In-Place Sort)
 * 
 * Time Complexity- O(n^2)
 * Space Complexity - O(1)
 * 
 * @author Goutam
 *
 */
public class BubbleSort {
	
	public int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		BubbleSort bubble=new BubbleSort();
		int[] input= {3,5,4,7,9,6,2,1,8};
		System.out.print("Before Sorting : ");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]+" "); 
		}
		System.out.println();
		int[] sorted = bubble.bubbleSort(input);
		System.out.print("After Sorting : ");
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i]+" "); //9 8 7 6 5 4 3 2 1 
		}
	}

}
