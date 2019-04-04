package trees.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import trees.Node;

public class PrintLinkedList {
	
	public static void printLinkedLists(Node root) {
		if (root == null) return;
		int level = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Map<Integer, LinkedList> map = new HashMap<Integer, LinkedList>();
		while(!q.isEmpty() && q.peek() != null) {
						
			int count = 0;		
			LinkedList<Node> ll = new LinkedList<Node>();
			while(count <= ((Math.pow(2, level)) - 1)) {
				Node llNode = q.peek();
				if(llNode != null) {
					q.add(llNode.left);
					q.add(llNode.right);
					ll.add(llNode);					
				}
				Node n = q.poll();
				if(n == null) break;
				count++;
			}
			
			map.put(level, ll);
			
			level ++;		
			
		}
		
		
		 Set<Integer> keys = map.keySet();
		 Iterator<Integer>it = keys.iterator();
		 while(it.hasNext()) {
			 Integer key = it.next();
			LinkedList<Node> l =  map.get(key);
			System.out.println("Size: " + l.size());
			for(int i = 0; i< l.size(); i++) {
				System.out.println(l.get(i).data);
			}
					 
		 }
		 
		
		//printMap(map);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr1[] = { 7, 1, 0, 3, 2, 5, 4,  6, 9, 8, 10};
		Node rootA = new Node();
		rootA  = rootA.insertLevelOrder(arr1,rootA, 0); 
		
		rootA.printInOrder();
		System.out.println();
		
		printLinkedLists(rootA);
		

	}

}
