package graph;


public class Node {
	public int id;
	public int cost;

	public Node(int id) {
		this.id = id;
	}
	
	public Node(int id, int cost) {
		this.id = id;
		this.cost = cost;
	}
}