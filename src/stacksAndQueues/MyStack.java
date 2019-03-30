package stacksAndQueues;

//LIFO
public class MyStack {

	public Node head;
	
	public boolean isEmpty() {
		if(head == null) return true;
		else return false;
	}
	
	// not so good implementation. Can implement with O(1), by moving head to currently added el.
	// add to tail
	public void push(int d) {
		
		Node node = new Node(d);		
		if(head == null) {
			head = node;
		}else {
			Node n = head;
			while(n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}
	
	// remove last node
	public Node pop(){
		Node n = head;
		if(n.next == null) {			
			head.next = null;
			head = null;
			return n;
		}
		Node secondLastNode = null;
		while (n.next != null) {
			secondLastNode = n;
			n = n.next;			
		}
		Node lastNode = n;
		secondLastNode.next = null;
			
		return lastNode;		
	}
	
	public void show() {
		if(head == null) return;
		Node n = head;
		while(n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	
	
}
