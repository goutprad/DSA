package com.dsa.hashing;

import java.util.ArrayList;

/**
 * HashTable using separate chaining as collision technique
 * 
 * @author Goutam
 *
 * @param <K>
 * @param <V>
 */
class HashNode<K, V> {
	K key;
	V value;
	HashNode<K, V> next;

	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

public class HashTableSeparateChaining<K, V> {
	private ArrayList<HashNode<K, V>> bucketArr;
	private int numBuckets;
	private int size;

	HashTableSeparateChaining() {
		bucketArr = new ArrayList<HashNode<K, V>>();
		numBuckets = 10;
		size = 0;

		// Create empty chains
		for (int i = 0; i < numBuckets; i++) {
			bucketArr.add(null);
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int getBucketIndex(K key) {
		int hashcode = key.hashCode();
		int index = hashcode % numBuckets;
		return index;
	}

	public V remove(K key) {
		int bucketIndex = getBucketIndex(key);

		// Get head of chain
		HashNode<K, V> head = bucketArr.get(bucketIndex);

		HashNode<K, V> prev = null;

		// Search for key in its chain
		while (head != null) {
			if (head.key.equals(key)) {
				break;
			}
			prev = head;
			head = head.next;
		}
		// If key was not there
		if (head == null) {
			return null;
		}
		size--;
		if (prev != null) {
			prev.next = head.next;
		} else {
			bucketArr.set(bucketIndex, head.next);
		}
		return head.value;
	}

	public V get(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArr.get(bucketIndex);
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public void add(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArr.get(bucketIndex);

		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		size++;
		head = bucketArr.get(bucketIndex);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = head;
		bucketArr.set(bucketIndex, newNode);

		// If load factor goes beyond threshold, then
		// double hash table size
		if ((1.0 * size) / numBuckets >= 0.7) {
			ArrayList<HashNode<K, V>> temp = bucketArr;
			bucketArr = new ArrayList<HashNode<K, V>>();
			numBuckets = 2 * numBuckets;
			size = 0;

			for (int i = 0; i < numBuckets; i++) {
				bucketArr.add(null);
			}
			for (HashNode<K, V> headNode : temp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
	}

	public void printHashMap() {
		for (int i = 0; i < bucketArr.size(); i++) {
			if (bucketArr.get(i) != null) {
				HashNode<K, V> nextNode = bucketArr.get(i).next;
				System.out.println("Bucket:" + i + " [" + bucketArr.get(i).key + ", " + bucketArr.get(i).value + "]"
						+ " -> " + printChain(nextNode));
			}
		}
	}

	public String printChain(HashNode<K, V> nextNode) {
		String result = "";
		if (nextNode == null)
			return null;
		else
			while (nextNode != null) {
				result += "[" + nextNode.key + ", " + nextNode.value + "]";
				nextNode = nextNode.next;
			}
		return result + " -> " + null;
	}

	public static void main(String[] args) {
		HashTableSeparateChaining<String, Integer> map = new HashTableSeparateChaining<String, Integer>();
		map.add("a", 100);
		map.add("B", 200);
		map.add("C", 400);
		map.add("D", 500);
		map.add("E", 600);
		map.add("F", 700);
//		map.add("G", 800);
//		map.add("H", 900);
//		map.add("I", 000);
		map.printHashMap();
		System.out.println("No of Buckets:" + map.numBuckets);
		System.out.println(map.isEmpty());
		System.out.println("Map Size:" + map.size());
		System.out.println("Remove: " + map.remove("G"));
		System.out.println("Map Size:" + map.size());
		System.out.println("Remove: " + map.remove("C"));
		System.out.println("Map Size:" + map.size());
		map.printHashMap();
		System.out.println("get:" + map.get("D"));
	}
}
