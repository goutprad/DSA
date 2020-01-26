package com.dsa.stack;

/**
 * Dynamic Size Stack Implementation By using Array
 * 
 * @author Goutam
 *
 */
public class GrowableStackUsingArray {
	int length=0;
	int dynamicSize=5;
	int top=-1;
	int[] stack=new int[length+dynamicSize];
	
	/**
	 * createNewStack - it will create new size stack dynamically
	 * 
	 * @return int[] new stack
	 */
	public int[] createNewStack() {
		int[] newStack = new int[stack.length+dynamicSize];
		for (int i = 0; i < stack.length; i++) {
			newStack[i]=stack[i];
		}
		return newStack;
	}
	
	/**
	 * push - insert item into stack
	 * 
	 * @param item
	 */
	public void push(int item) {
		if(top==stack.length-1) {
			stack = createNewStack();
		}
		stack[++top] = item;
		//System.out.println("Push: "+item);
	}
	
	/**
	 * pop - pop out the top element
	 *  
	 * @return int 
	 */
	public int pop() {
		return stack[top--];
	}

	public static void main(String[] args) {
		GrowableStackUsingArray growStack = new GrowableStackUsingArray();
		growStack.push(1);
		growStack.push(2);
		growStack.push(3);
		growStack.push(4);
		System.out.println("Pop : "+growStack.pop()); //4
		growStack.push(5);
		growStack.push(6);
		System.out.println("Pop : "+growStack.pop()); //6
		growStack.push(7);
		growStack.push(8);
		System.out.println("Pop : "+growStack.pop()); //8
	}

}
