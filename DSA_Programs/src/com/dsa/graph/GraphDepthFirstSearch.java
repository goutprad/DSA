package com.dsa.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * Depth First Search - Algorithm (Using Stack)
 * 
 * @author Goutam
 *
 */
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
			adjacencyList[source].add(destination); // append to LL
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

		public void DFS(int startIndex) {
			boolean visited[] = new boolean[vertex];
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(startIndex); //
			visited[startIndex] = true;
			System.out.print(startIndex + " ");
			while (stack.isEmpty() == false) {
				int nodeIndex = stack.pop();
				if (visited[nodeIndex] == false) {
					System.out.print(nodeIndex + " ");
					visited[nodeIndex] = true;
				}

				LinkedList<Integer> nodeList = adjacencyList[nodeIndex];
				for (int i = 0; i < nodeList.size(); i++) {
					int dest = nodeList.get(i);
					if (visited[dest] == false) {
						stack.push(dest);
					}
				}

				// Special case - it will come only for directed graph if (stack.isEmpty()) {
				for (int i = 0; i < visited.length; i++) {
					if (visited[i] == false) {
						stack.push(i);
					}
				}
			}

		}

		/**
		 * Improvement on GFG code
		 * 
		 * @param s
		 */
		void GFG_DFS(int s) {
			Vector<Boolean> visited = new Vector<Boolean>(vertex);
			for (int i = 0; i < vertex; i++)
				visited.add(false);
			Stack<Integer> stack = new Stack<>();
			stack.push(s);
			visited.set(s, true);
			System.out.print(s + " ");
			while (stack.empty() == false) {
				s = stack.peek();
				stack.pop();

				if (visited.get(s) == false) {
					System.out.print(s + " ");
					visited.set(s, true);
				}

				Iterator<Integer> itr = adjacencyList[s].iterator();

				while (itr.hasNext()) {
					int v = itr.next();
					if (!visited.get(v))
						stack.push(v);
				}
				for (int i = 0; i < visited.size(); i++) {
					if (visited.get(i) == false) {
						stack.push(i);
					}
				}
			}
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
		graph.printGraph();
		graph.DFS(0);
		System.out.println();
		graph.GFG_DFS(0);
	}

}
