package stacksQueues.problems;

public class NodeForSortedStack {
	NodeForSortedStack next;
	int data;
	int min;
	
	public NodeForSortedStack(int d) {
		// TODO Auto-generated constructor stub
		this.data = d;
	}

	public NodeForSortedStack(int d, int min) {
		// TODO Auto-generated constructor stub
		this.data = d;
		this.min = min;
	}
}
