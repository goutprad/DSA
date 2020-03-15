package com.dsa.hashing;

/**
 * HashTable using Open Addressing (Quadratic Probing)
 * 
 * @author Goutam
 *
 */
public class HashTableQuadraticProbing {
	private String[] keys;
	private String[] values;
	private int currentSize, maxSize;

	public HashTableQuadraticProbing(int capacity) {
		maxSize = capacity;
		currentSize = 0;
		keys = new String[maxSize];
		values = new String[maxSize];
	}

	public int size() {
		return currentSize;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == maxSize;
	}

	public int getHash(String key) {
		int hash = key.hashCode() % maxSize;
		System.out.println("Hash:" + key + " - " + hash);
		return hash;
	}

	public String get(String key) {
		int index = getHash(key);
		int h = 1;
		System.out.println(index);
		while (keys[index] != null & h < maxSize) { // is this correct
			if (keys[index].equals(key)) {
				return values[index];
			}
			index = (index + h * h++) % maxSize;
			System.out.println("index:" + index + " " + h);
		}
		return null;
	}

	public boolean containsKey(String key) {
		return get(key) != null;
	}

	public void insert(String key, String value) {
		int index = getHash(key);
		int i = index;
		int h = 1;
		do {
			if (keys[i] == null) {
				keys[i] = key;
				values[i] = value;
				currentSize++;
				return;
			}
			if (keys[i].equals(key)) {
				values[i] = value;
				return;
			}
			i = (i + h * h++) % maxSize;
			// System.out.println(key+"---i---->"+i+" "+h);
		} while (index != i);

		// If load factor goes beyond threshold, then
		// double hash table size
		if ((1.0 * currentSize) / maxSize >= 0.7) {
			System.out.println("collision at(SizeOverflow): " + i + " " + key);
			maxSize = 2 * maxSize;
			currentSize = 0;
			String[] tempKeys = keys;
			String[] tempVals = values;
			keys = new String[maxSize];
			values = new String[maxSize];
			for (int j = 0; j < tempKeys.length; j++) {
				insert(tempKeys[j], tempVals[j]);
			}
			insert(key, value);
		}
	}

	public void remove(String key) {
		if (!containsKey(key)) {
			return;
		}

		int i = getHash(key), h = 1;
		while (!key.equals(keys[i])) {
			i = (i + h * h++) % maxSize;
		}
		keys[i] = values[i] = null;

		for (i = (i + h * h++) % maxSize; keys[i] != null; i = (i + h * h++) % maxSize) {
			String tmp1 = keys[i], tmp2 = values[i];
			keys[i] = values[i] = null;
			currentSize--;
			insert(tmp1, tmp2);
		}
		currentSize--;
	}

	public void printHashTable() {
		System.out.println("Hash Table: ");
		for (int i = 0; i < maxSize; i++)
			if (keys[i] != null)
				System.out.println("index:" + i + " [" + keys[i] + ", " + values[i] + "]");
		System.out.println();
	}

	public static void main(String[] args) {
		HashTableQuadraticProbing quadProb = new HashTableQuadraticProbing(10);
		System.out.println(quadProb.isEmpty());
		System.out.println(quadProb.isFull());
		System.out.println(quadProb.get("A"));
		quadProb.insert("A", "10");
		quadProb.insert("K", "10");
		quadProb.insert("B", "10");
		quadProb.insert("C", "10");
		quadProb.insert("D", "10");
		quadProb.insert("E", "10");
		quadProb.insert("F", "10");
		quadProb.insert("G", "10");
		quadProb.insert("H", "10");
		quadProb.insert("I", "10");
		// quadProb.insert("J", "10");
		quadProb.printHashTable();
		// quadProb.insert("K", "10");
		System.out.println(quadProb.size());
		System.out.println(quadProb.get("KK"));
		quadProb.printHashTable();
	}

}
