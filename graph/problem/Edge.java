package ctci.graph.problem;

public class Edge {

	int src;
	int dest;
	int weight;
	
	public Edge(int src, int dst) {
		// TODO Auto-generated constructor stub
		this.src = src;
		this.dest = dst;
	}
	public Edge(int src, int dst, int weight) {
		// TODO Auto-generated constructor stub
		this.src = src;
		this.dest = dst;
		this.weight = weight;
	}

}
