package com.dsa.graph;

import java.util.LinkedList;


public class DetectCycleInUnDirectedGraph {

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
			adjacencyList[destination].add(source);
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
			boolean[] visited = new boolean[vertex];
			for (int i = 0; i < vertex; i++) {
				if (visited[i] == false) {
					if (isCycleUtil(i, visited, -1)) {
						return true;
					}
				}
			}
			return false;
		}

		public boolean isCycleUtil(int currVertex, boolean visited[], int parent) {
			visited[currVertex] = true;
			for (int i = 0; i < adjacencyList[currVertex].size(); i++) {
				int vertex = adjacencyList[currVertex].get(i);
				if (vertex != parent) {
					if (visited[vertex]) {
						return true;
					} else {
						if (isCycleUtil(vertex, visited, currVertex)) {
							return true;
						}
					}
				}
			}
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
