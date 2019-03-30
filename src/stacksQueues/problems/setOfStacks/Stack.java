package stacksQueues.problems.setOfStacks;

import linkedLists.Node;

public class Stack {
	Node head;
	int capacity;
	int curSize;

	public Stack(int c) {
		capacity = c;
	}

	public void push(int v) {
		Node n = new Node(v);
		curSize ++;
		if(head == null) {
			head = n;
		}else {
			Node tmp = head;
			head = n;
			head.next = tmp;
		}
	}

	public Node pop() {
		Node lastEl = head;
		head = head.next;
		return lastEl;
	}
	
	public int getCurrentSize() {
		/*Node n = head;
		int size = 0;
		while(n.next != null) {
			n = n.next;
			size++;
		}
		return size;*/
		return curSize;
	} 
		

	public void show() {
		Node n = head;
		while(n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}
}
