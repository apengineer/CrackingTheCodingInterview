package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class Graph {

	int numOfVertices;
	HashMap<Node, LinkedList<Node>> adjList = new HashMap<Node, LinkedList<Node>>();
	HashMap<Integer, Node> nodeLookUp = new HashMap<Integer, Node>();

	public List<Node> getNeighbours(Node node) {
		//return the adjacencyList entry for the node		
		 return adjList.get(node);		
	}
	
	public int getCost(Node n) {
		return n.cost;
	}
	
	public HashMap getNodeLookUp() {
		return nodeLookUp;
	}
	
	public Graph(int v) {
		this.numOfVertices = v;		
	}

	public void addNode(int i) {
		Node n = new Node(i);		
		nodeLookUp.put(i, n);
		adjList.put(n, null);
	}
	public Node getNode(int i) {
		return nodeLookUp.get(i);
	}
	public void addEdge(int src, int dest) {
		Node source = getNode(src);		
		Node dst = getNode(dest);	
		
		// get existing list
		LinkedList<Node> ll = adjList.get(source);
		LinkedList<Node> dll = adjList.get(dst); // for undirected graph
		//if empty, create one and put the first edge
		if(ll == null) {
			ll = new LinkedList<Node>();
			ll.add(dst);			
			adjList.put(source, ll);
		} else {
			ll.add(dst);
		}

		if(dll == null) {
			dll = new LinkedList<Node>();
			dll.add(source);
			adjList.put(dst, dll);
		} else {
			dll.add(source);
		}	

	}

	public void printGraph() {			
		for(int i = 0; i < adjList.size(); i++) {
			//System.out.println("Vertex: " + i);
			LinkedList<Node> ll = adjList.get(getNode(i));
			if(ll != null) {
				Iterator<Node> it = ll.iterator();
				while(it.hasNext()) {
					Node n = it.next();
					System.out.println(i + "--" + n.id + " cost " + n.cost);
				}	
			}

		}
	}

	public boolean hasPathDFS(int src, int dest) {
		HashSet<Node> visited = new HashSet<Node>();
		Node source = getNode(src);
		Node dst = getNode(dest);
		return hasPathDFS(source, dst, visited);

	}

	public boolean hasPathDFS(Node src, Node dest, HashSet<Node> visited) {
		if(visited.contains(src)) return false; // no path

		visited.add(src);
		if(src == dest) return true;

		LinkedList<Node> linkedNodes = adjList.get(src);
		Iterator<Node> it = linkedNodes.iterator();
		while(it.hasNext()) {
			Node child = it.next();
			if(hasPathDFS(child, dest, visited)) return true;
		}

		return false;

	}

	public boolean BFS(int src, int dest) {
		Node source = getNode(src);
		Node dst = getNode(dest);	
		
		HashSet<Node> visited = new HashSet<Node>();
		
		if(source == dst) return true;
		
		LinkedList<Node> q = new LinkedList<Node>();
		
		q.add(source);
		visited.add(source);
		
		while(!q.isEmpty()) {
			Node nodeToCheck = q.remove();
			visited.add(nodeToCheck);
			if(nodeToCheck == dst) {
				return true;
			}
			
			LinkedList<Node> ll = adjList.get(nodeToCheck);
			for (Node node : ll) {
				if(!visited.contains(node))
					q.add(node);
			}			
		}
		
		return false;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph(5);

		g.addNode(0);
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		g.addNode(5);

		g.addEdge(0, 1); 
		g.addEdge(0, 4); 
		g.addEdge(1, 2);	
		g.addEdge(1, 4);		
		g.addEdge(3, 4);
		g.addEdge(1, 3);

		g.printGraph();

		System.out.println( "DFS: " + g.hasPathDFS(3, 5));

		System.out.println("BFS: " + g.BFS(3, 5));
	}

}
