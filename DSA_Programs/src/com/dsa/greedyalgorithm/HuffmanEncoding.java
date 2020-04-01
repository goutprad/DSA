package com.dsa.greedyalgorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanEncoding {
	/** Custom DS Node to hold tree data */
	static class Node {
		final Integer value;
		Character character;
		Node left;
		Node right;

		public Node(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}

		public Character getCharacter() {
			return character;
		}

		public void setCharacter(Character character) {
			this.character = character;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

	static Map<Character, String> huffmanCoding(Map<Character, Integer> freqMap) {
		final Map<Character, String> resultMap = new HashMap<>();
		final PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		/** Add the leaf nodes to priority queue */
		for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			final Node node = new Node(entry.getValue());
			node.setCharacter(entry.getKey());
			priorityQueue.add(node);
		}

		/** Combine the leaf nodes repeatedly to form tree */
		while (priorityQueue.size() > 1) {
			final Node node1 = priorityQueue.poll();
			final Node node2 = priorityQueue.poll();

			final Node combined = new Node(node1.getValue() + node2.getValue());
			combined.setLeft(node1);
			combined.setRight(node2);

			priorityQueue.add(combined);
		}

		/** Find the huffman encoding for each of the leaf nodes via DFS */
		final Node head = priorityQueue.poll();
		fillEncoding(head, resultMap, "");

		return resultMap;
	}

	static void fillEncoding(Node node, Map<Character, String> resultMap, String encoding) {
		if (isLeaf(node)) {
			resultMap.put(node.getCharacter(), encoding);
			return;
		}
		if (node.getLeft() != null) {
			fillEncoding(node.getLeft(), resultMap, encoding + "0");
		}
		if (node.getRight() != null) {
			fillEncoding(node.getRight(), resultMap, encoding + "1");
		}
	}

	static boolean isLeaf(Node node) {
		if (node.getLeft() != null || node.getRight() != null || node.getCharacter() == null) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		final Map<Character, Integer> freqMap = new HashMap<>();
		freqMap.put('A', 5);
		freqMap.put('B', 9);
		freqMap.put('C', 12);
		freqMap.put('D', 13);
		freqMap.put('E', 16);
		freqMap.put('F', 45);

		System.out.println("Huffman Encoding : ");
		final Map<Character, String> resultMap = huffmanCoding(freqMap);
		resultMap.entrySet().stream().forEach(x -> System.out.printf("%c   =>   %s\n", x.getKey(), x.getValue()));
	}

}
