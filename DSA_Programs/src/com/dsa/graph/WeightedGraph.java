package com.dsa.graph;

import java.util.LinkedList;

/**
 * Weighted Graph implementation using adjacency List
 * 
 * @author Goutam
 *
 */
public class WeightedGraph {

	static class Edges {
		int source;
		int destination;
		int weight;

		public Edges(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}

	static class Graph {
		int vertex;
		LinkedList<Edges> adjacencyList[];

		Graph(int vertex) {
			this.vertex = vertex;
			adjacencyList = new LinkedList[vertex];

			for (int i = 0; i < vertex; i++) {
				adjacencyList[i] = new LinkedList<>();
			}
		}

		public void addEdge(int source, int destination, int weight) {
			Edges edge = new Edges(source, destination, weight);
			adjacencyList[source].add(edge); // directed
			// adjacencyList[destination].add(edge); // undirected
		}

		public void printGraph() {
			for (int i = 0; i < vertex; i++) {
				LinkedList<Edges> list = adjacencyList[i];
				for (int j = 0; j < list.size(); j++) {
					System.out.println("vertex-" + i + " is connected to " + list.get(j).destination + " with weight "
							+ list.get(j).weight);
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 2, 5);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 0, 4);
		graph.addEdge(4, 1, 4);
		graph.addEdge(4, 5, 6);
		graph.printGraph();
	}

}
