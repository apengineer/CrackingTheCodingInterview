package ctci.graph.problem;

public class GraphTester {

	public GraphTester() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Graph graph = new Graph(4);
		Edge edge01 = new Edge(0, 1, 6);
		Edge edge13 = new Edge(1, 3, 1);
		Edge edge02 = new Edge(0, 2, 5);
		Edge edge23 = new Edge(2, 3, 3);
		
		graph.addEdge(edge01);
		graph.addEdge(edge13);
		graph.addEdge(edge02);
		graph.addEdge(edge23); // creates the cycle
		
		
		
		graph.BFS(0);
		System.out.println();
		
		System.out.println(graph.isCyclic(0));
		
		
		

	}

}
