package com.dsa.linkedlist;

/**
 * LinkListOperations
 * 
 * @author Goutam
 *
 */
public class LinkListOperations {
	static Node startNode;
	Node currentNode;
	Node parentNode;
	Node childNode;

	/**
	 * insertAtBegining
	 * 
	 * @param item
	 */
	public void insertAtBegining(int item) {
		Node newNode = new Node(item);
		if (startNode == null) {
			startNode = newNode;
		} else {
			newNode.next = startNode;
		}
		startNode = newNode;
	}

	/**
	 * insertAtEnd
	 * 
	 * @param item
	 */
	public void insertAtEnd(int item) {
		Node newNode = new Node(item);
		newNode.next = null;
		Node tempNode;
		if (startNode == null) {
			startNode = newNode;
		} else {
			tempNode = startNode;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = newNode;
		}
	}
	
	/**
	 * getSize
	 * 
	 * @return
	 */
	public static int getSize() {
		int count = 0;
		Node tempNode = startNode;
		while (tempNode != null) {
			++count;
			tempNode = tempNode.next;
		}
		return count;
	}

	/**
	 * searchByValue
	 * 
	 * @param item
	 */
	public void searchByValue(int item) {
		Node tempNode = startNode;
		int index = 0;
		boolean flag = false;
		while (tempNode != null) {
			if (tempNode.data == item) {
				System.out.println("value " + item + " exist!! at " + index);
				flag = true;
			}
			tempNode = tempNode.next;
			index++;
		}
		if (!flag)
			System.out.println("value " + item + " not found!!");
	}

	/**
	 * searchByIndex
	 * 
	 * @param index
	 */
	public void searchByIndex(int index) {
		Node tempNode = startNode;
		int count = 0;
		if (index < getSize()) {
			while (tempNode != null) {
				if (count == index) {
					System.out.println("value at index " + index + " is " + tempNode.data);
				}
				tempNode = tempNode.next;
				count++;
			}
		} else {
			System.out.println("index " + index + " does not exist");
		}
	}

	/**
	 * deleteByValue
	 * 
	 * @param item
	 * @return boolean
	 */
	public boolean deleteByValue(int item) {
		boolean isDeleted = false;
		if (startNode.data == item) {
			startNode = startNode.next;
		} else {
			parentNode = startNode;
			childNode = startNode.next;
			while (childNode != null) {
				if (childNode.data == item) {
					parentNode.next = childNode.next;
					isDeleted = true;
					break;
				}
				parentNode = childNode;
				childNode = childNode.next;
			}
		}
		return isDeleted;
	}

	/**
	 * deleteByIndex
	 * 
	 * @param index
	 * @return boolean
	 */
	public boolean deleteByIndex(int index) {
		int count = 0;
		boolean isDeleted = false;
		parentNode = startNode;
		childNode = startNode.next;
		while (childNode != null) {
			if (count == index) {
				isDeleted = true;
				parentNode.next = childNode.next;
			}
			parentNode = childNode;
			childNode = childNode.next;
			count++;
		}
		return isDeleted;
	}

	Node head;
	
	/**
	 * printList
	 * 
	 * @param head
	 */
	private void printList(Node head) {
		Node tempNode;
		tempNode = head;
		while (tempNode != null) {
			System.out.print(tempNode.data + "-->");
			tempNode = tempNode.next;
		}
		System.out.print("null");
		System.out.println();
	}

	/**
	 * printLinkedList
	 */
	public void printLinkedList() {
		Node tempNode;
		tempNode = startNode;
		while (tempNode != null) {
			System.out.print(tempNode.data + "-->");
			tempNode = tempNode.next;
		}
		System.out.print("null");
		System.out.println();
	}

	/*
	 * Node sort(Node head) { if (head == null || head.next == null) return head;
	 * Node newHead = head; Node slow = head; Node fast = head; while (slow != null
	 * || slow.next != null) { slow = slow.next; } if (slow == null) return newHead;
	 * else { newHead = slow; } while (slow != null || fast.next != null) { if
	 * (slow.next == null) return newHead; if (slow.next.data == 0) { slow =
	 * slow.next; continue; } else { fast = slow; } if (fast.next.data == 1) { fast
	 * = fast.next; } else { } } return newHead; }
	 */

	/**
	 * reverse using recursion
	 * 
	 * @param head
	 * @return
	 */
	private Node reverse(Node head) {
		Node result;
		if (head.next == null) {
			return head;
		}
		result = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return result;
	}

	public static void main(String[] args) {
		LinkListOperations ll = new LinkListOperations();
		ll.insertAtBegining(1);
		ll.insertAtBegining(2);
		ll.insertAtBegining(3);
		ll.insertAtEnd(5);
		ll.insertAtBegining(4);
		ll.searchByValue(6);
		ll.printLinkedList();
		Node rev = ll.reverse(startNode);
		ll.printList(rev);
		ll.printLinkedList();
		ll.searchByIndex(7);
		System.out.println("size of LinkedList : " + ll.getSize());
		System.out.println("Delete a node by value 3 : " + ll.deleteByValue(3));
		System.out.println("Delete a node by index 2 : " + ll.deleteByIndex(2));
		// l.printList(l.rev(startNode , startNode.next));
		// l.displayList();
		// l.skipAndDelete(2, 4, startNode);
		// l.displayList();
		// l.printReverse(startNode);
	}
}
