package ctci.trees.problems;

public class BinaryTree {

	Node root ;
	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();		
		bt.root = new Node(7);
		bt.root.insert(1);
		bt.root.insert(0);
		bt.root.insert(3);
		bt.root.insert(2);
		bt.root.insert(5);
		bt.root.insert(4);

		
		/*root.insert(2);
		root.insert(3);
		root.insert(4);
		root.insert(5);
		root.insert(6);
		root.insert(6);
		root.insert(6);
		root.insert(6);
		root.insert(6); */
		 
       // int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 }; 
		/* int arr[] = { 7, 1, 0, 3, 2, 5, 4,  6, 9, 8, 10};
        Node root  = bt.root.insertLevelOrder(arr, bt.root, 0); */ 
		bt.root.printInOrder();
		System.out.println();
	
		System.out.println("height: " + bt.root.height(bt.root));
		
		System.out.println(bt.root.maxDepth(bt.root));
		System.out.println(bt.root.minDepth(bt.root));

	}

}
