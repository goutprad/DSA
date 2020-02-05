package com.dsa.heap;

/**
 * Min heap/Binary min heap Operations/Priority Queue 
 * 
 * @author Goutam
 *
 */
public class MinHeapByArray {
	int[] heap;
	int heapSize;

	/**
	 * Constructor to initialize
	 * 
	 * @param size
	 */
	public MinHeapByArray(int size) {
		this.heap = new int[size];
		this.heapSize = 0;
	}

	/**
	 * isHeapEmpty
	 * 
	 * @return boolean
	 */
	public boolean isHeapEmpty() {
		return heapSize == 0;
	}

	/**
	 * sizeOfHeap
	 * 
	 * @return int
	 */
	public int sizeOfHeap() {
		return heapSize;
	}

	/**
	 * insert
	 * 
	 * @param item insert item
	 */
	public void insert(int item) {
		if (heapSize == heap.length)
			System.out.println("Heap Leakage , Overflowing!");
		else {
			heap[++heapSize] = item;
			heapifyBottomToTop(heapSize);
		}
	}

	/**
	 * delMin
	 * 
	 * @return int deleted item
	 */
	public int delMin() {
		if (heapSize == 0) {
			System.out.println("Heap is empty!!");
			return -1;
		} else {
			int min = heap[1];
			heap[1] = heap[heapSize--];
			heapifyTopToBottom(1);
			return min;
		}
	}

	/**
	 * heapifyBottomToTop/Swim
	 * 
	 * @param index
	 */
	public void heapifyBottomToTop(int index) {  //Swim
		int parent = index / 2;
		if (index <= 1) {
			return;
		}
		if (heap[index] < heap[parent]) {
			int temp = heap[index];
			heap[index] = heap[parent];
			heap[parent] = temp;
		}
		heapifyBottomToTop(parent);
	}

	/**
	 * heapifyTopToBottom/sink
	 * 
	 * @param index
	 */
	public void heapifyTopToBottom(int index) {  //sink
		int leftChild = 2*index;
		int rightChild = (2*index)+1;
		int smallestChild = 0;
		if(leftChild > heapSize) {  ////If there is no child of this node
			return;
		} else if(leftChild == heapSize) { //If there is only left child of this node
			if(heap[index] > heap[leftChild]) {
				int temp = heap[index];
				heap[index] = heap[leftChild];
				heap[leftChild] = temp;
			}
			return;
		} else { //If both children are there
			if(heap[leftChild] < heap[rightChild]) {
				smallestChild=leftChild;
			} else {
				smallestChild =rightChild;
			}
			if(heap[index]>heap[smallestChild]) { //If Parent is greater than smallest child
				int temp = heap[index];
				heap[index] = heap[smallestChild];
				heap[smallestChild] = temp;
			}
		}
		heapifyTopToBottom(smallestChild);
	}
	
	/**
	 * getMin
	 * 
	 * @return
	 */
	public int getMin() {
		return heap[1];
	}

	/**
	 * levelOrderTraverse
	 */
	public void levelOrderTraverse() {
		for (int i = 1; i < heap.length; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println("\n");
	}

	/**
	 * deleteHeap
	 */
	public void deleteHeap() {
		heap = null;
	}

	public static void main(String[] args) {
		MinHeapByArray minHeap = new MinHeapByArray(10);
		System.out.println("isHeapEmpty: " + minHeap.isHeapEmpty());
		System.out.println("Size of Heap: " + minHeap.sizeOfHeap());
		minHeap.levelOrderTraverse();
		minHeap.insert(6);
		minHeap.insert(2);
		minHeap.insert(2);
		minHeap.insert(2);
		minHeap.insert(2);
		minHeap.insert(4);
		minHeap.insert(1);
		minHeap.insert(-11);
		minHeap.levelOrderTraverse();
		System.out.println("isHeapEmpty: " + minHeap.isHeapEmpty());
		System.out.println("Min: " + minHeap.getMin());
		System.out.println("delete: "+minHeap.delMin());
		System.out.println("Min: " + minHeap.getMin());
		System.out.println("Delete Min: "+minHeap.delMin());
		System.out.println("Min: " + minHeap.getMin());
		System.out.println("Delete Min: "+minHeap.delMin());
		System.out.println("Min: " + minHeap.getMin());
		System.out.println("Delete Min: "+minHeap.delMin());
		System.out.println("Min: " + minHeap.getMin());
		System.out.println("Delete Min: "+minHeap.delMin());
		minHeap.levelOrderTraverse();
		System.out.println("isHeapEmpty: " + minHeap.isHeapEmpty());
	}

}
