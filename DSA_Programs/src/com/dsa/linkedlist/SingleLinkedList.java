package com.dsa.linkedlist;

/**
 * Single Linked list operations
 * 
 * @author Goutam
 *
 */
public class SingleLinkedList {
	Node head;

	class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public String toString() {
			return "" + this.data;
		}
	}

	public void insert(int value) {
		Node newNode = new Node(value); // create a node
		newNode.next = null;
		if (head == null) { // when LL is empty
			head = newNode;
		} else { // insert at last
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
	}

	public void insertAtBegining(int value) {
		Node newNode = new Node(value); // create a nodes
		newNode.next = head;
		head = newNode;
	}

	public void insertAtPosition(int value, int pos) {
		int count = 1;
		Node curNode = head;
		if (pos > getSize()) // position is greater than LL size
			return;
		else if (pos == 0) { // position is equal to zero
			insertAtBegining(value);
		} else { // insert at given position and if position is last
			while (curNode != null && count != pos) {
				count++;
				curNode = curNode.next;
			}
			Node newNode = new Node(value);
			newNode.next = curNode.next;
			curNode.next = newNode;
		}
	}

	public void searchByValue(int value) {
		Node temp = head;
		int index = -1;
		boolean flag = false;
		while (temp != null) {
			index++;
			if (temp.data == value) {
				flag = true;
				System.out.println("Value " + value + " present index at :" + index);
			}
			temp = temp.next;
		}
		if (!flag) {
			System.out.println("Value " + value + " not present!!");
		}
	}

	public void searchByIndex(int index) {
		Node temp = head;
		int i = -1;
		boolean flag = false;
		while (temp != null) {
			i++;
			if (index == i) {
				flag = true;
				System.out.println("Value at " + index + " is :" + temp.data);
			}
			temp = temp.next;
		}
		if (!flag) {
			System.out.println("Indext " + index + " is not availbale!!");
		}
	}

	public boolean deleteByValue(int value) {
		Node currNode = head;
		Node prev = null;
		boolean flag = false;
		if (currNode != null && currNode.data == value) {
			head = currNode.next;
			flag = true;
			return flag;
		}
		while (currNode != null) {
			if (currNode.data == value) {
				prev.next = currNode.next;
				flag = true;
			} else {
				prev = currNode;
			}
			currNode = currNode.next;
		}
		return flag;
	}

	public boolean deleteByIndex(int index) {
		Node curNode = head;
		int i = -1;
		Node prev = null;
		boolean flag = false;
		;
		if (index < getSize()) {
			if (curNode != null && index == 0) {
				head = curNode.next;
				flag = true;
				return flag;
			}
			while (curNode != null) {
				i++;
				if (index == i) {
					prev.next = curNode.next;
					flag = true;
				} else {
					prev = curNode;
				}
				curNode = curNode.next;
			}
		} else {
			System.out.println("Index not present");
		}
		return flag;
	}

	public void reverseLL() {
		Node curNode = head;
		Node next = null;
		Node prev = null;
		while (curNode != null) {
			next = curNode.next;
			curNode.next = prev;
			prev = curNode;
			curNode = next;
		}
		head = prev;
	}

	public Node reverseUsingTailRecursion(Node curNode, Node prev) {
		if (curNode.next == null) {
			head = curNode;
			curNode.next = prev;
			return head;
		}
		Node next1 = curNode.next;
		curNode.next = prev;
		reverseUsingTailRecursion(next1, curNode);
		return head;
	}

	public int getSize() {
		int size = 0;
		Node curNode = head;
		while (curNode != null) {
			size++;
			curNode = curNode.next;
		}
		return size;
	}

	public void printLL() {
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode + " -> ");
			currNode = currNode.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SingleLinkedList singlyLL = new SingleLinkedList();
		singlyLL.insert(1);
		singlyLL.insert(2);
		singlyLL.insert(3);
		singlyLL.insertAtBegining(5);
		System.out.println("size: " + singlyLL.getSize());
		singlyLL.insertAtPosition(8, 5);
		System.out.println("size: " + singlyLL.getSize());
		singlyLL.printLL();
		singlyLL.searchByValue(6);
		singlyLL.searchByIndex(7);
		System.out.println(singlyLL.deleteByValue(6));
		singlyLL.printLL();
		System.out.println(singlyLL.deleteByIndex(2));
		singlyLL.printLL();
		singlyLL.reverseLL();
		singlyLL.printLL();
		singlyLL.reverseUsingTailRecursion(singlyLL.head, null);
		singlyLL.printLL();
	}

}
