package com.dsa.graph;

import java.util.LinkedList;

public class DetectCycleInDirectedGraph {

	static class Graph {
		int vertex;
		LinkedList<Integer> adjacencyList[];

		public Graph(int vertex) {
			this.vertex = vertex;
			adjacencyList = new LinkedList[vertex];

			for (int i = 0; i < vertex; i++) {
				adjacencyList[i] = new LinkedList<Integer>();
			}
		}

		public void addEdge(int source, int destination) {
			adjacencyList[source].add(destination);
			// adjacencyList[destination].add(source);
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

		public boolean isCycle() {
			boolean result= false;
			boolean[] visited = new boolean[vertex];
			boolean recursiveArr[] = new boolean[vertex];
			for (int i = 0; i < vertex; i++) {
				if (visited[i] == false) {
					if (isCycleUtil(i, visited, recursiveArr)) {
						result= true;
					}
				}
			}
			return result;
		}

		public boolean isCycleUtil(int currVertex, boolean visited[], boolean[] recursiveArr) {
			visited[currVertex] = true;
			for (int i = 0; i < adjacencyList[currVertex].size(); i++) {
				int adjVertex = adjacencyList[currVertex].get(i);
				if (!visited[adjVertex] && isCycleUtil(adjVertex, visited, recursiveArr)) {
					return true;
				} else if (recursiveArr[adjVertex]) {
					return true;
				}
				recursiveArr[adjVertex] = true;
			}
			//recursiveArr[adjVertex] = false;
			return false;
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 2);
		graph.printGraph();
		System.out.println(graph.isCycle());
	}

}
