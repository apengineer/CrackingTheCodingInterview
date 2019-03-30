package stacksQueues.problems;

import stacksAndQueues.Node;
import stacksAndQueues.MyStack;

public class QueueUsingStacks {

	MyStack s1, s2; // 2 Stacks

	public QueueUsingStacks() {
		s1 = new MyStack();
		s2 = new MyStack();
	}

	public void enQueue(int v) {
		if(s1 == null) {
			s1 = new MyStack();
			s1.push(v);
		}
		else {
			s1.push(v);		
		}
	}

	public Node deQueue() {
		// pop from s1 and push to s2
		Node n = s1.head;
		while(!s1.isEmpty()) {
			Node toPush = s1.pop();	
			s2.push(toPush.data);			
		}
		Node ret = s2.pop();
		return ret;
	}

	public void showOriginalIP() {
		if(s1.head == null) return;
		Node n = s1.head;
		while(n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	public void show() {
		if(s2.head == null) return;
		Node n = s2.head;
		while(n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}

	public static void main(String args[]) {
		QueueUsingStacks q = new QueueUsingStacks();
		q.enQueue(10);
		q.enQueue(12);
		q.enQueue(13);
		System.out.println("Q : read from top to bottom, first at top");
		q.showOriginalIP();
		System.out.println("Dequeueing: " );
		System.out.println(q.deQueue().data);
		System.out.println(q.deQueue().data);
		System.out.println("Remaining Q");
		q.show();
	}
}
