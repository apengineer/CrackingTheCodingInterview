package ctci.graph.problem;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {
	
	Map<Integer, LinkedList<Edge>>  adjList = new HashMap<>();

	public void addEdge(Edge edge) {
		adjList.get(edge.src).add(edge);
		adjList.get(edge.dest).add(edge);
		
	}
	
	public Graph(int numberOfNodes) {
		// TODO Auto-generated constructor stub
		for(int i = 0; i < numberOfNodes; i++) {
			LinkedList<Edge> ll = new LinkedList<>();
			adjList.put(i, ll);
		}		
	}
	
	public void printGraph() {
		Set<Integer> nodes = adjList.keySet();
		for(Integer node: nodes) {
			LinkedList<Edge> edges = adjList.get(node);
			for(Edge edge: edges) {
				System.out.println("node: " + node + " " + edge.src + " -- " + edge.dest );
			}
		}
	}
	
	public void printGraphWithWeights() {
		Set<Integer> nodes = adjList.keySet();
		for(Integer node: nodes) {
			LinkedList<Edge> edges = adjList.get(node);
			for(Edge edge: edges) {
				System.out.println("node: " + node + " " + edge.src + " -- " + edge.dest + " (" + edge.weight + ")" );
			}
		}
	}
	
	// iterative implementation
	public void BFS(int startNode) {
		
		Set<Integer> isVisited = new HashSet<>();
		
		Queue<Integer> q = new ArrayDeque<>();
		
		q.add(startNode);
		isVisited.add(startNode);
		
		
		while(!q.isEmpty()) {
			
			Integer node = q.poll();
			System.out.print(node + " -- ");
			LinkedList<Edge> neighbours = adjList.get(node);
			
			for(Edge edge: neighbours) {
				if(!isVisited.contains(edge.dest)) {
					q.add(edge.dest);
					isVisited.add(edge.dest);					
				}
			}
			
		}
		
		
	}

}
