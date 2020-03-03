package com.dsa.graph;

import java.util.LinkedList;
import java.util.Stack;


public class GraphDepthFirstSearch {

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

		public void DFS() {
			boolean visited[] = new boolean[vertex];
			Stack<Integer> stack = new Stack<Integer>();

			for (int startIndex = 0; startIndex < vertex; startIndex++) {
				stack.push(startIndex);
				visited[startIndex] = true;
				while (stack.isEmpty() == false) {
					int nodeIndex = stack.pop();
					System.out.print(nodeIndex + " ");
					LinkedList<Integer> nodeList = adjacencyList[nodeIndex];
					for (int i = 0; i < nodeList.size(); i++) {
						int dest = nodeList.get(i);
                        if (visited[dest] == false) {
                            stack.push(dest);
                            visited[dest] = true;
                        }
					}
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 4);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.printGraph();
		graph.DFS();
	}

}
