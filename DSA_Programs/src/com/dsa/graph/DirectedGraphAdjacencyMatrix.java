package com.dsa.graph;

/**
 * Directed Graph using Adjacency Matrix
 * 
 * @author Goutam
 *
 */
public class DirectedGraphAdjacencyMatrix {
	int vertex;
	int[][] graph;
	public DirectedGraphAdjacencyMatrix(int vertex) {
		this.vertex = vertex;
		graph = new int[vertex][vertex];
	}
	
	public void addEdge(int source, int destination) {
		graph[source][destination] = 1;
	}
	
	public void printGraph() {
		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < vertex; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
		for (int i = 0; i < vertex; i++) {
			System.out.print("Vertex " + i + " is connected to: ");
			for (int j = 0; j < vertex; j++) {
				if(graph[i][j]==1)
					System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		DirectedGraphAdjacencyMatrix graph = new DirectedGraphAdjacencyMatrix(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 4);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.printGraph();

	}

}
