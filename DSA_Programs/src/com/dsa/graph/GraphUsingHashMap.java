package com.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


public class GraphUsingHashMap {
	static class Graph {
		HashMap<Object, LinkedList<Object>> adjacencyList = new HashMap<Object, LinkedList<Object>>();
		HashMap<Object, Integer> indexes = new HashMap<Object, Integer>();
		int index = -1;

		public Graph(ArrayList<Object> vertices) {
			for (int i = 0; i < vertices.size(); i++) {
				Object vertex = vertices.get(i);
				LinkedList<Object> list = new LinkedList<Object>();
				adjacencyList.put(vertex, list);
				indexes.put(vertex, ++index);
			}
		}
		
		public void addEdge(Object source, Object destination) {
			LinkedList<Object> list;
            list = adjacencyList.get(source);
            list.addFirst(destination);  //directed graph
            adjacencyList.put(source, list);
		}
		
		public void printGraph() {
			Set<Object> set = adjacencyList.keySet();
            Iterator<Object> iterator = set.iterator();

            while(iterator.hasNext()){
                Object vertex = iterator.next();
                System.out.print("Vertex " + vertex + " is connected to: ");
                LinkedList<Object> list = adjacencyList.get(vertex);
                for (int i = 0; i <list.size() ; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }
		}
	}

	public static void main(String[] args) {
		ArrayList<Object> vertices = new ArrayList<Object>();
		vertices.add('A');
		vertices.add('B');
		vertices.add('C');
		vertices.add('D');
		vertices.add('E');
		vertices.add('F');
		vertices.add('G');
		Graph graph = new Graph(vertices);
		graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'D');
        graph.addEdge('D', 'E');
        graph.addEdge('G', 'E');
        graph.addEdge('A', 'G');
		graph.printGraph();

	}

}
