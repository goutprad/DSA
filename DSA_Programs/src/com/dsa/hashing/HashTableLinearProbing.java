package com.dsa.hashing;

/**
 * HashTable using Open Addressing (Linear Probing)
 * 
 * @author Goutam
 *
 */
public class HashTableLinearProbing {
	private String[] keys;
	private String[] vals;
	private int currentSize, maxSize;

	public HashTableLinearProbing(int capacity) {
		currentSize = 0;
		maxSize = capacity;
		keys = new String[maxSize];
		vals = new String[maxSize];
	}

	public int size() {
		return currentSize;
	}

	public boolean isFull() {
		return currentSize == maxSize;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int getHash(String key) {
		return key.hashCode() % maxSize;
	}

	public void insert(String key, String value) {
		int index = getHash(key);
		int i = index;
		do {
			if (keys[i] == null) {
				keys[i] = key;
				vals[i] = value;
				currentSize++;
				return;
			}
			if (keys[i].equals(key)) {
				vals[i] = value;
				return;
			}
			i = (i + 1) % maxSize;
		} while (i != index);

		// If load factor goes beyond threshold, then
		// double hash table size
		if ((1.0 * currentSize) / maxSize >= 0.7) {
			System.out.println("collision at(SizeOverflow): " + i + " " + key);
			maxSize = 2 * maxSize;
			currentSize = 0;
			String[] tempKeys = keys;
			String[] tempVals = vals;
			keys = new String[maxSize];
			vals = new String[maxSize];
			for (int j = 0; j < tempKeys.length; j++) {
				insert(tempKeys[j], tempVals[j]);
			}
			insert(key, value);
		}
	}

	public String get(String key) {
		int index = getHash(key);
		while (keys[index] != null) {
			if (keys[index].equals(key)) {
				return vals[index];
			}
			index = (index + 1) % maxSize;
			System.out.println("index:" + index);
		}
		return null;
	}

	public void remove(String key) {
		if (!containsKey(key)) {
			return;
		}

		int index = getHash(key);
		while (!key.equals(keys[index])) {
			index = (index + 1) % maxSize;
		}

		keys[index] = vals[index] = null; // removed

		// Rehashing all key
		for (index = (index + 1) % maxSize; keys[index] != null; index = (index + 1) % maxSize) {
			String tempKey = keys[index];
			String tempVal = vals[index];
			keys[index] = vals[index] = null;
			currentSize--;
			insert(tempKey, tempVal);
		}
		currentSize--;
	}

	public void printHashTable() {
		System.out.println("Hash Table: ");
		for (int i = 0; i < maxSize; i++)
			if (keys[i] != null)
				System.out.println("index:" + i + " [" + keys[i] + ", " + vals[i] + "]");
		System.out.println();
	}

	public boolean containsKey(String key) {
		return get(key) != null;
	}

	public static void main(String[] args) {
		HashTableLinearProbing map = new HashTableLinearProbing(10);
		map.insert("A", "10");
		map.insert("B", "10");
		map.insert("C", "10");
		map.insert("D", "10");
		map.insert("E", "10");
		map.insert("F", "10");
		map.insert("G", "10");
		map.insert("H", "10");
		map.insert("I", "10");
		map.insert("J", "10");
		// map.printHashTable();
		System.out.println(map.size());
		map.insert("K", "20");
		System.out.println(map.size());
		map.printHashTable();
		map.remove("E");
		System.out.println(map.size());
		map.printHashTable();
		System.out.println(map.get("GG"));
	}
}
