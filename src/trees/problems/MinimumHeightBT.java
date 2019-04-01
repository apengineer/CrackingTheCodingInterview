package trees.problems;

import trees.Node;

public class MinimumHeightBT {

	public static Node addToTree(int arr[], int start, int end) {
		if(end < start) return null;
		
		int mid = (start + end) /2;
		
		Node n = new Node(arr[mid]);
		n.left = addToTree(arr, start, mid - 1);
		n.right = addToTree(arr, mid + 1, end);
		
		return n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []arr =  {1, 2, 3, 4, 5, 6};
		Node root = addToTree(arr, 0, arr.length - 1);
		
		root.printInOrder();

	}

}
