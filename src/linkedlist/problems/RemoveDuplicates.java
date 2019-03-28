package linkedlist.problems;
import linkedLists.MyLL;
import linkedLists.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RemoveDuplicates {

	public static void removeDuplicates(LinkedList<Integer> ll) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();		
		for(int i = 0; i < ll.size() ; i++) {
			Integer element = ll.get(i);			
			if(map.containsKey(element)) {
				ll.remove(element);
			}else {
				map.put(element, 1);
			}
			
		}
		
		System.out.println(ll.toString());
	}
	
	public static void removeDupsWithoutBuffer(MyLL ll) {
		Node curNode = ll.head;
		while(curNode.next != null) {
			Node runnerNode = curNode.next;
			Node tmpNode = curNode;
			while(runnerNode.next != null) {				
				if(runnerNode.data == curNode.data) {// remove runner node					
					tmpNode.next = runnerNode.next;
					runnerNode = runnerNode.next;
				} else {
					tmpNode = runnerNode;
					runnerNode = runnerNode.next;
				}
				if(runnerNode.next == null && (runnerNode.data == curNode.data)) { // remove last node
					tmpNode.next = null;
				}
				
			}
			if(curNode.next != null)
				curNode = curNode.next;
		}		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLL ll = new MyLL();
		ll.add(5);
		ll.add(3);
		ll.add(8);
		ll.add(5);
		ll.add(3);
		
		
		
		removeDupsWithoutBuffer(ll);
		
		ll.show();
		
	}

}
