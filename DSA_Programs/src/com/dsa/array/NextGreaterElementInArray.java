package com.dsa.array;

/**
 * Next Greater element in an array. Input : 11, 13, 21, 3 42, 5 
 * output : 
 * 11 -->13, 13 -->21, 21 -->42, 3 -->42, 42 --> -1, 5 --> -1
 * 
 * @author Goutam
 *
 */
public class NextGreaterElementInArray {
	public static void main(String[] args) {
		int[] input = { 11, 13, 21, 3, 42, 5 };
		nextGreaterElementInArray(input, input.length);
		System.out.println();
		printNextGreaterElementInArray(input, input.length);
	}

	/**
	 * Time Complexity - o(n*n)
	 * 
	 * @param arr
	 * @param size
	 */
	static void nextGreaterElementInArray(int[] arr, int size) {
		for (int i = 0; i < size; i++) {
			int next = -1;
			for (int j = i + 1; j < size; j++) {
				if (arr[i] < arr[j]) {
					next = arr[j];
					break;
				}
			}
			System.out.println(arr[i] + "->" + next);
		}
	}

	/**
	 * Time Complexity - o(n)
	 * 
	 * @param arr
	 * @param size
	 */
	static void printNextGreaterElementInArray(int[] arr, int size) {
		Stack st = new Stack(size);
		st.push(arr[0]);
		int element, next;
		for (int i = 1; i < size; i++) {
			next = arr[i];
			if (st.isEmpty() == false) {
				element = st.pop();
				while (element < next) {
					System.out.println(element + " --> " + next);
					if (st.isEmpty() == true)
						break;
					element = st.pop();
				}
				if (element > next)
					st.push(element);
			}
			st.push(next);
		}
		while (st.isEmpty() == false) {
			element = st.pop();
			next = -1;
			System.out.println(element + " --> " + next);
		}
	}

	static class Stack {
		int topOfStack;
		int[] st;

		Stack(int size) {
			this.st = new int[size];
			this.topOfStack = -1;
		}

		void push(int a) {
			if (topOfStack == 19) {
				System.out.println("Stack is full!");
			} else {
				st[++topOfStack] = a;
			}
		}

		int pop() {
			if (topOfStack == -1) {
				System.out.println("Underflow error!");
				return -1;
			} else {
				int element = st[topOfStack];
				topOfStack--;
				return element;
			}
		}

		boolean isEmpty() {
			return (topOfStack == -1) ? true : false;
		}

	}

}
