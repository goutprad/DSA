package com.dsa.puzzles;

/**
 * Tower of Hanoi/tower of brahma/Lucas' Tower
 * 
 * @author Goutam
 *
 */
public class TowerOfHanoi {

	public static void main(String[] args) {
		towerOfHanoi(3, 'A', 'B', 'C');
		/*move disk 1 from rod A to B
		  move disk 2 from rod A to C
          move disk 1 from rod B to C
          move disk 3 from rod A to B
          move disk 1 from rod C to A
          move disk 2 from rod C to B
          move disk 1 from rod A to B
          */
	}
	
	/**
	 * towerOfHanoi using recursion
	 * 
	 * @param disk
	 * @param from_rod
	 * @param to_rod
	 * @param aux_rod
	 */
	static void towerOfHanoi(int disk, char from_rod, char to_rod, char aux_rod) {
		if(disk == 1) {
			System.out.println("move disk "+disk+" from rod "+from_rod+" to "+to_rod);
			return;
		}
		towerOfHanoi(disk-1, from_rod, aux_rod, to_rod);  //head recursion
		System.out.println("move disk "+disk+" from rod "+from_rod+" to "+to_rod);
		towerOfHanoi(disk-1, aux_rod, to_rod, from_rod); //tail recursion
	}

}
