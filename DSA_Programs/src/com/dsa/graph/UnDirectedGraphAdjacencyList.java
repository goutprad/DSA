package com.dsa.graph;

import java.util.LinkedList;

/**
 * UnDirected Graph implementation using Adjacency List
 *  
 * @author Goutam
 *
 */
public class UnDirectedGraphAdjacencyList {

	static class Graph {
		int vertex;
		LinkedList<Integer> adjacencyList[];

		public Graph(int v) {
			this.vertex = v;
			// define the size of array as
			// number of vertices
			adjacencyList = new LinkedList[vertex];

			// Create a new list for each vertex
			// such that adjacent nodes can be stored
			for (int i = 0; i < vertex; i++) {
				adjacencyList[i] = new LinkedList<Integer>();
			}
		}
	}

	static void addEdge(Graph graph, int src, int dest) {
		//undirected so add both the way
		graph.adjacencyList[src].add(dest);
		graph.adjacencyList[dest].add(src);
	}
	
	static void printGraph(Graph graph) {
		for (int i = 0; i < graph.vertex; i++) {
			System.out.print("Vertex " + i + " is connected to: ");
			for (int element : graph.adjacencyList[i]) {
				System.out.print("->"+element);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int vertex = 5;
		Graph graph = new Graph(vertex);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 4);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		printGraph(graph);
	}

}
