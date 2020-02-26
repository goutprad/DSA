package com.dsa.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BSTOperationsUsingLL {
	public Node root;
	// public Node startNode;

	class Node {
		Node left;
		Node right;
		int val;

		public Node(int x) {
			this.val = x;
			left = right = null;
		}

		public String toString() {
			return "" + this.val;
		}

		public int compareTo(Node that) {
			return this.val - that.val;
		}
	}

	public BSTOperationsUsingLL() {
		this.root = null;
	}

	public void insert(int val) {
		Node newNode = new Node(val);

		if (root == null) {
			root = newNode;
			return;
		} else {
			Node parent = null;
			Node child = root;

			while (true) {
				parent = child;
				if (newNode.val < child.val) {
					child = child.left;
					if (child == null) {
						parent.left = newNode;
						return;
					}
				} else {
					child = child.right;
					if (child == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	public void search() {

	}

	public void display() {
		System.out.println("Pre-order Traversal:");
		preorder(root);
		System.out.println();
		System.out.println("In-order Traversal:");
		inorder(root);
		System.out.println();
		System.out.println("Post-order Traversal:");
		postorder(root);
		System.out.println();
		System.out.println("Level-order Traversal:");
		levelorder(root);
		System.out.println("\n");
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + "\t");
			inorder(root.right);
		}
	}

	public void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.val + "\t");
		}
	}

	public void preorder(Node root) {
		if (root != null) {
			System.out.print(root.val + "\t");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void levelorder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			System.out.print(presentNode.val + "\t");
			if (presentNode.left != null) {
				queue.offer(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.offer(presentNode.right);
			}

		}
	}

	public static void main(String[] args) {
		BSTOperationsUsingLL bstLL = new BSTOperationsUsingLL();
		bstLL.insert(50);
		bstLL.insert(30);
		bstLL.insert(20);
		bstLL.insert(40);
		bstLL.insert(70);
		bstLL.insert(60);
		bstLL.insert(80);
		bstLL.display();
	}

}
