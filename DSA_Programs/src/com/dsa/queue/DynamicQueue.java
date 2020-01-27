package com.dsa.queue;

/**
 * Dynamic Size Queue implementation
 * 
 * @author Goutam
 *
 */
public class DynamicQueue {
	private static int DEFAULT_CAPACITY;
	int[] queue;
	int front;
	int rear;
	int size;

	/**
	 * constructor to initialize array & variables
	 * 
	 * @param size
	 */
	public DynamicQueue(int size) {
		this.DEFAULT_CAPACITY = size;
		this.size = size;
		queue = new int[this.DEFAULT_CAPACITY];
		this.front = -1;
		this.rear = -1;
	}

	/**
	 * create a new queue when it full
	 * 
	 * @param oldQ
	 * @return int[]
	 */
	public int[] increaseCapacity(int[] oldQ) {
		int[] newQ = new int[size + DEFAULT_CAPACITY];
		for (int i = 0; i < oldQ.length; i++) {
			newQ[i] = oldQ[i];
		}
		this.size = newQ.length;
		return newQ;
	}

	/**
	 * enQueu - insert item to queue
	 * 
	 * @param item
	 */
	public void enQueu(int item) {
		if (isFull()) {
			System.out.println("Queue is full!!..Increasing size...");
			queue = increaseCapacity(queue);
		} else {
			rear = (rear + 1) % size;
			queue[rear] = item;
			if (front == -1) {
				front = rear;
			}
			System.out.println("enQueue: " + item);
		}
	}

	/**
	 * deQueue item from queue
	 * 
	 * @return
	 */
	public int deQueue() {
		int result = Integer.MIN_VALUE;
		if (isEmpty()) {
			System.out.println("Queue is Empty!!");
		} else {
			result = queue[front];
			if (front == rear) {
				front = rear = -1;
			} else {
				front = (front + 1) % size;
			}
		}
		return result;
	}

	/**
	 * isFull - to check queue is full or not
	 * 
	 * @return true if full else false
	 */
	public boolean isFull() {
		return (rear + 1) % size == front;
	}

	/**
	 * isEmpty - to check queue is empty or not
	 * 
	 * @return true if empty else false
	 */
	public boolean isEmpty() {
		return front == -1;
	}

	public static void main(String[] args) {
		DynamicQueue q = new DynamicQueue(5);
		q.enQueu(1);
		q.enQueu(2);
		q.enQueu(3);
		System.out.println("deQueue" + q.deQueue());
		q.enQueu(7);
		System.out.println("deQueue: " + q.deQueue());
		System.out.println("deQueue: " + q.deQueue());
		q.enQueu(8);
		System.out.println("deQueue: " + q.deQueue());
		System.out.println("deQueue: " + q.deQueue());
	}

}
