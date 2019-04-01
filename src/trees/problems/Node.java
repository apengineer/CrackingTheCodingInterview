package ctci.trees.problems;

public class Node {

	public Node left;
	public Node right;
	public int data;
	static int levelOfNode; 
	static boolean isBST = false;


	public Node() {
		super();
	}
	
	public Node(int d) {
		data = d;
	}

	public int height(Node root) {
		if(root==null)
			return -1;
		else {
			int lHeight = height(root.left);
			int rHeight = height(root.right);

			if(lHeight > rHeight) return lHeight + 1;
			else return rHeight + 1;
		}

	}
	
	public int maxDepth(Node node) {
		if(node == null) {
			return -1;
		} else {
			return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
		}		
	}
	
	public int minDepth(Node node) {
		if(node == null) {
			return -1;
		} else {
			return 1 + Math.min(minDepth(node.left), minDepth(node.right));
		}		
	}
	


	// Always adding to the left node
	public void insert(int value) {						
		if(left == null) {
			left = new Node(value);
		} else if( left != null){
			if (right == null) {
				right = new Node(value);
			} else {
				left.insert(value);
			}			
		} else {
			right.insert(value);
		}
	}


	public Node insertLevelOrder(int[] arr, Node root, 
			int i) 
	{ 
		// Base case for recursion 
		if (i < arr.length) { 
			Node temp = new Node(arr[i]); 
			root = temp; 

			// insert left child 
			root.left = insertLevelOrder(arr, root.left, 
					2 * i + 1); 

			// insert right child 
			root.right = insertLevelOrder(arr, root.right, 
					2 * i + 2); 
		} 
		return root; 
	} 
	

	public int find(int value) {				
		if(data == value) {
			return 0;
		}		
		if(value <= data) { // travel left
			levelOfNode ++;
			left.find(value);
		} else { // travel right
			levelOfNode++;
			right.find(value);
		}
		return levelOfNode;		

	}




	public void printInOrder() { // left, root, right
		if(left != null) {
			left.printInOrder();
		}
		System.out.print(data + "  ");
		if (right != null) {
			right.printInOrder();
		}		
	}

	public void printPreOrder() { // root, left, right
		System.out.print(data + " ");
		if(left != null) {
			left.printPreOrder();
		}
		if (right != null) {
			right.printPreOrder();
		}
	}

	public void printPostOrder() { // left, right, root		
		if(left != null) {
			left.printPostOrder();
		}
		if (right != null) {
			right.printPostOrder();
		}

		System.out.print(data + " ");
	}

}
