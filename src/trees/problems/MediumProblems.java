package trees.problems;

import trees.Node;

//https://medium.com/@codingfreak/binary-tree-interview-questions-and-practice-problems-439df7e5ea1f
public class MediumProblems {

	// delete an entire tree
	public static Node deleteTree(Node node) {
		if(node == null) return null;

		deleteTree(node.left);
		deleteTree(node.right);

		return node = null;

	}

	// height of a tree
	public static int height(Node node) {

		if(node == null) return -1;

		int lstHeight = height(node.left) + 1;
		int rstHeight = height(node.right) + 1;

		return lstHeight >= rstHeight ? lstHeight : rstHeight;

	}

	// check if 2 trees are identical
	public static boolean areIdentical(Node rootA, Node rootB) {
		if(rootA == null && rootB != null) return false;
		if(rootA != null && rootB == null) return false;		
		if(rootA == null && rootB == null) return true;
		if(rootA.data != rootB.data) return false;

		boolean isLeftTreeIdentical = areIdentical(rootA.left, rootB.left );
		boolean isRightTreeIdentical = areIdentical(rootA.right, rootB.right );

		return isLeftTreeIdentical && isRightTreeIdentical; 
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node rootA = new Node();
		Node rootB = new Node();
		int arr1[] = { 7, 1, 0, 3, 2, 5, 4,  6, 9, 8, 10};
		int arr2[] = { 7, 1, 0, 3, 2, 5, 4,  6, 9, 8, 9};
		rootA  = rootA.insertLevelOrder(arr1,rootA, 0); 
		rootB  = rootA.insertLevelOrder(arr2,rootB, 0); 
		rootA.printInOrder();
		System.out.println();
		rootB.printInOrder();

		System.out.println();

		System.out.println(areIdentical(rootA, rootB));

		System.out.println(height(rootA));


	}

}
