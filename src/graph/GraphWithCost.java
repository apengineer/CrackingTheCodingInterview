package graph;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;

public class GraphWithCost {

	public Map<Node, LinkedList<Node>> adjacencyList = new HashMap<Node, LinkedList<Node>>();
	HashMap<Integer, Node> nodeLookUp = new HashMap<Integer, Node>();

	public void addNode(int id) {
		Node n = new Node(id);
		nodeLookUp.put(id,  n);
	}
	
	public int getCost(Node n) {
		return n.cost;
	}
	
	public HashMap getNodeLookUp() {
		return nodeLookUp;
	}
	
	public List<Node> getNeighbours(Node node) {
		//return the adjacencyList entry for the node		
		 return adjacencyList.get(node);		
	}
	
	public Node getNode(int id) {
		Node node = nodeLookUp.get(id);
		if(node == null) {
			node = new Node(id);
			nodeLookUp.put(id, node);
		}
		return nodeLookUp.get(id);
	}
	
	public void addEdge(int src, int dest, int cost) {
		// add key Node if not existing
		Node source = getNode(src);
		Node destination = getNode(dest);
		
		// get adjacency List for the node		
		LinkedList<Node> sll = adjacencyList.get(source);
		Node edge = new Node(dest, cost);
		if(sll == null) {
			sll = new LinkedList<Node>();			
			sll.add(edge);			
		} else {
			sll.add(edge);
		}
		adjacencyList.put(source, sll);
		
		LinkedList<Node> dll = adjacencyList.get(destination);
		Node edgeBi = new Node(src, cost);
		if(dll == null) {
			dll = new LinkedList<Node>();			
			dll.add(edgeBi);			
		} else {
			dll.add(edgeBi);
		}
		adjacencyList.put(destination, dll);		
	}
	
	public void printGraph() {
		for(int i = 0; i < adjacencyList.size(); i++) {
			//System.out.println("Vertex: " + i);
			LinkedList<Node> ll = adjacencyList.get(getNode(i));
			if(ll != null) {
				Iterator<Node> it = ll.iterator();
				while(it.hasNext()) {
					Node n = it.next();
					System.out.println(i + "--" + n.id + " cost " + n.cost);
				}	
			}
		}
	}
	
	public void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		Set<Integer> isVisited = new HashSet<Integer>();
		
		// gte the first node from adjacencyList
		q.add(getNode(0));
		isVisited.add(getNode(0).id);
		
		while(!q.isEmpty()) {			
			Node n = q.poll();
			LinkedList<Node> neighbours = adjacencyList.get(getNode(n.id));			
			for(Node node : neighbours) {
				System.out.println(n.id +  " --" + node.id + " cost " + node.cost);
				if(!isVisited.contains(node.id)) {
					q.add(node);
					isVisited.add(node.id);
				}				
			}			
		}		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GraphWithCost g = new GraphWithCost();
		g.addEdge(0, 1, 3); 
		g.addEdge(0, 4, 2); 
		g.addEdge(1, 2, 1);	
		g.addEdge(1, 4, 6);		
		g.addEdge(3, 4, 7);
		g.addEdge(1, 3, 1);
		g.addEdge(3, 5, 3);

		//g.printGraph();
		
		g.BFS();

	}

}
