package com.dsa.puzzles;

/**
 * Get the Starting Point of the Circular Trip
 * 
 * @return index of the petrol pump if solution exist , else -1 if solution
 *         doesn't exist
 * @author Goutam
 *
 */
public class PetrolPump {

	static int getStartIndex(int[] distance, int[] petrol) {
		int nPumps = petrol.length;
		int start, currentPetrol;
		int i = start = 0;
		while (start < nPumps) {
			currentPetrol = petrol[i] - distance[i];
			while (currentPetrol >= 0) {
				i = (i + 1) % nPumps;
				currentPetrol += petrol[i] - distance[i];
				if (start == i) {
					return start;
				}
			}
			start = ++i;
			i = i % nPumps;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] distance = { 4, 7, 4, 8, 4, 1 };
		int[] petrol = { 3, 5, 3, 8, 3, 6 };
		int index = getStartIndex(distance, petrol);
		if (index == -1) {
			System.out.println("There is no starting point!!");
		} else {
			System.out.println("Petrol Pump Number : " + (index + 1));
		}
	}

}
