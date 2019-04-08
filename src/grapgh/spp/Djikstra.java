package grapgh.spp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import graph.GraphWithCost;
import graph.Node;
import linkedlist.problems.GetLastNElements;
import sun.security.provider.certpath.AdjacencyList;


public class Djikstra {

	private static int INIFINITY = Integer.MAX_VALUE;

	public static List<Object> djikstra(GraphWithCost graph, Node start) {

		Queue<Node> minQ = new LinkedList<Node>();
		Set<Integer> visitedNodes = new HashSet<Integer>();	
		Map<Node, Integer> costMap = new HashMap<Node, Integer>();		
		Map<Node, Node> prevNode = new HashMap<Node, Node>();

		minQ.add(start); // add start node in priority q;
		prevNode.put(start, start);


		// iterate through map and put infinity as cost for all nodes
		HashMap<Integer, Node> nodeLookUp = graph.getNodeLookUp();		
		Set<Integer> keys = nodeLookUp.keySet();
		for(Integer key : keys) {
			Node n = nodeLookUp.get(key);
			costMap.put(n, INIFINITY);
		}	

		costMap.put(start, 0);

		while(!minQ.isEmpty()) {

			Node newSmallest = minQ.poll();
			visitedNodes.add(newSmallest.id);

			List<Node> neighbours = graph.getNeighbours(newSmallest);

			for(Node neighbour: neighbours) {

				if(!visitedNodes.contains(neighbour.id)) {
					int costToNeighbour = 0;
					LinkedList<Node> ll = graph.adjacencyList.get(newSmallest);
					for(Node n : ll) {
						if(n.id == neighbour.id) costToNeighbour = n.cost;
					}
					int altPath = costMap.get(newSmallest) + costToNeighbour;

					if(altPath < costMap.get(graph.getNode(neighbour.id))) { // check if new cost is better
						costMap.put(graph.getNode(neighbour.id), altPath); // update path for node
						prevNode.put(graph.getNode(neighbour.id), newSmallest);						
					}

					visitedNodes.add(neighbour.id);
					minQ.add(graph.getNode(neighbour.id)); // add the lowest distance node to front of Q

				}
				
				
			}
		}

		Map<Node, Stack<Node>> routeTable = new HashMap<>();
		
		
		Set<Node> key = prevNode.keySet();
		Iterator<Node> it = key.iterator();
		
		for(Node k: key) {
			Node previous = prevNode.get(k);
			Stack<Node> s = new Stack<Node>();
			s.push(previous);			
			routeTable.put(k, s);
		}
	
	Set<Node> nodeSet = routeTable.keySet();
	
	for(Node tmp: nodeSet) {
		Stack<Node> s = routeTable.get(graph.getNode(tmp.id));
		Node n = prevNode.get(graph.getNode(tmp.id));		
		while(n != start) {			
			n = prevNode.get(graph.getNode(n.id));	
			s.push(n);
		}				
	}
	System.out.println();
	for(Node tmp: nodeSet) {
		Stack<Node> s = routeTable.get(graph.getNode(tmp.id));
		System.out.print(tmp.id + " --- ");
		while(!s.isEmpty()) {
			System.out.print(s.pop().id + " ");
		}
		System.out.println();
	}
		
	
	
	
		
		
		
		
		List<Object> result = new ArrayList<>();

		//result.add(costMap);
		result.add(prevNode);

		return result;



	}


	public static void main(String[] args) {


		GraphWithCost g = new GraphWithCost();

		g.addNode(0);
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		g.addNode(5);

		g.addEdge(0, 1, 3); 
		g.addEdge(0, 4, 2); 
		g.addEdge(1, 2, 1);	
		g.addEdge(1, 4, 6);		
		g.addEdge(3, 4, 7);
		g.addEdge(1, 3, 1);
		g.addEdge(3, 5, 3);

		g.printGraph();

		List<Object> res = Djikstra.djikstra(g, g.getNode(0));

		/*for(Object o: res) {
			HashMap<Node, Node> prev = (HashMap)o;
			
			
			System.out.println(prev.get(g.getNode(5)).id);
		} */

	}
}
