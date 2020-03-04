package com.dsa.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Breadth First Search - using Queue
 * 
 * @author Goutam
 *
 */
public class GraphBreadthFirstSearch {

	static class Graph {
		int vertex;
		LinkedList<Integer>[] adjacencyList;

		public Graph(int vertex) {
			this.vertex = vertex;
			adjacencyList = new LinkedList[vertex];

			for (int i = 0; i < vertex; i++) {
				adjacencyList[i] = new LinkedList<Integer>();
			}
		}

		public void addEdge(int source, int destination) {
			adjacencyList[source].add(destination);
		}

		public void printGraph() {
			for (int i = 0; i < vertex; i++) {
				System.out.print("Vertex " + i + " is connected to: ");
				for (int j = 0; j < adjacencyList[i].size(); j++) {
					System.out.print(adjacencyList[i].get(j) + " ");
				}
				System.out.println();
			}
		}

		public void BFS(int start) {
			LinkedList<Integer> queue = new LinkedList<Integer>();
			boolean visited[] = new boolean[vertex];

			visited[start] = true;
			queue.add(start);
			System.out.println(start + " ");
			while (queue.isEmpty() == false) {
				int ele = queue.poll();
				if (!visited[ele]) {
					System.out.println(ele + " ");
					visited[ele] = true;
				}

				Iterator<Integer> itr = adjacencyList[ele].listIterator();
				while (itr.hasNext()) {
					int n = itr.next();
					if (!visited[n]) {
						queue.add(n);
					}
				}
				for (int i = 0; i < visited.length; i++) {
					if (visited[i] == false && queue.isEmpty() == false) {
						queue.add(i);
					}
				}
			}
			System.out.println(Arrays.toString(visited));
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(6);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(2, 3);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(5, 4);

//		graph.addEdge(0, 1);
//		graph.addEdge(0, 2);
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 0);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 3);
		graph.printGraph();
		graph.BFS(0); // 0,2,3,4,1,5
	}

}
