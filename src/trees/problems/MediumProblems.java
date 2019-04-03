package trees.problems;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import sun.tracing.PrintStreamProviderFactory;
import trees.Node;

//https://medium.com/@codingfreak/binary-tree-interview-questions-and-practice-problems-439df7e5ea1f
public class MediumProblems {


	public static void printLinkedLists(Node root) {
		if (root == null) return;
		int level = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Map<Integer, LinkedList> map = new HashMap<Integer, LinkedList>();
		while(!q.isEmpty()) {
			Node n = q.peek();
			level ++;
			int count = 0;		
			LinkedList<Node> ll = new LinkedList<Node>();
			while(count < (2^level - 1)) {
				Node llNode = q.peek();
				if(llNode != null) {
					q.add(llNode.left);
					q.add(llNode.right);
					ll.add(llNode);					
				}
				q.poll();
				count++;
			}
			while(ll.iterator().hasNext()) {
				System.out.println(ll.iterator().next());
			}
			map.put(level, ll);
		}
		
		//printMap(map);
	}

	public static void printMap(Map map) {
		Set<Entry<Integer, LinkedList>>myEntrySet = (Set<Entry<Integer, LinkedList>>) map.entrySet();
		Iterator<Entry<Integer, LinkedList>> myEntrySetIt = myEntrySet.iterator();
		
		while(myEntrySetIt.hasNext()) {
			Entry<Integer, LinkedList> entry = myEntrySetIt.next();
			System.out.println("Key :" + entry.getKey() + " Value: " + entry.getValue());
			LinkedList ll = entry.getValue();
			while(ll.iterator().hasNext()) {
				System.out.println(ll.iterator().next());
			}
		}
		
	}
	public static void printNextSibling(Node root, int node) {
		if (root == null) return;

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while(!q.isEmpty()) {
			Node n = q.peek();
			q.add(n.left);
			q.add(n.right);

			if(q.peek().data == node) {			
				q.poll();
				Node sibling = q.poll();
				System.out.println("Sibling: " + sibling.data );	
				q = null;
				break;		
			}

			q.poll();

		}

	}


	// bad implementation O(n°2) RT and O(n) space
	public static void printSpiralOrder(Node node) {
		int level = 0;
		Stack<Node> s = new Stack<Node>();
		Stack<Node> sOdd = new Stack<Node>();	
		s.push(node);
		while(!s.isEmpty() || !sOdd.isEmpty()) {
			if( level % 2  == 0) { // Stack right to left
				while(!s.isEmpty()) {
					Node current = s.peek();
					if(current != null) {
						sOdd.push(current.right);
						sOdd.push(current.left);	
						System.out.print(current.data + " ");
					}
					s.pop();
				}				
			} 
			else { 

				while(!sOdd.isEmpty()) {
					Node current = sOdd.peek();
					if(current != null) {
						s.push(current.left);
						s.push(current.right);
						System.out.print(current.data + " ");

					}

					sOdd.pop();
				}

			}	
			level ++;
		}	 

	}



	public static void printLevelOrder(Node node) {
		if(node == null) return ;

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while(q.peek() != null) {
			Node current = q.peek();
			if(current != null)
				System.out.print(current.data + " ");
			if(current.left != null)
				q.add(current.left);
			if(current.right != null)
				q.add(current.right);
			q.poll();
		}		

	}


	// delete an entire tree
	public static Node deleteTree(Node node) {
		if(node == null) return null;

		deleteTree(node.left);
		deleteTree(node.right);

		node = null;

		return node;

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

		//rootA = deleteTree(rootA);

		//rootA.printInOrder();

		//printLevelOrder(rootA);

		printSpiralOrder(rootA);

		System.out.println();

		printNextSibling(rootA, 5);
		
		System.out.println();
		
		printLinkedLists(rootA);


	}

}
