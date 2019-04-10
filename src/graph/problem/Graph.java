package ctci.graph.problem;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {
	
	Map<Integer, LinkedList<Integer>>  adjList = new HashMap<>();

	public void addEdge(Edge edge) {
		adjList.get(edge.src).add(edge.dest);
		adjList.get(edge.dest).add(edge.src);
		
	}
	
	public Graph(int numberOfNodes) {
		// TODO Auto-generated constructor stub
		for(int i = 0; i < numberOfNodes; i++) {
			LinkedList<Integer> ll = new LinkedList<>();
			adjList.put(i, ll);
		}		
	}
	
	public void printGraph() {
		Set<Integer> nodes = adjList.keySet();
		for(Integer node: nodes) {
			LinkedList<Integer> edges = adjList.get(node);
			for(Integer dst: edges) {
				System.out.println("node: " + node + " -- " + dst );
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
			LinkedList<Integer> neighbours = adjList.get(node);
			
			for(Integer edge: neighbours) {
				if(!isVisited.contains(edge)) {
					q.add(edge);
					isVisited.add(edge);					
				}
			}
			
		}		
		
	}
	
	class Node {
		int id;
		int parent;
		
		Node(int id) {
			this.id = id;
		}
		
		Node(int id, int parent) {
			this.id = id;
			this.parent = parent;
		}
		
		
	}
		
	public boolean isCyclic(int startNode) {
		
		Set<Integer> isVisited = new HashSet<>();
		
		Queue<Node> q = new ArrayDeque<>();	
		
		q.add(new Node(startNode, startNode));
		isVisited.add(startNode);		
		
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			LinkedList<Integer> neighbours = adjList.get(current.id);
			
			for(Integer edge: neighbours ) {
				if(!isVisited.contains(edge)) {
					q.add(new Node(edge, current.id));
					isVisited.add(edge);	
				} else {
					if(edge != current.parent) { // cross-edge
						return true;
					}
				}
			}			
			
		}
		return false;
		
		
	}
	
	
	
	

}
