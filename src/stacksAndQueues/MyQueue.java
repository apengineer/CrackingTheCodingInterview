package stacksAndQueues;

//FIFO
public class MyQueue {
	
	Node head ;
	
	// add at tail
	public void enQueue(int d) {
		Node tail = new Node(d);
		if(head == null) { // add as head
			head = tail;			
		}
		else {
			Node n = head;
			while(n.next != null) {
				n = n.next;				
			}			
			n.next = tail;
		}
	
	}
	
	// return head node;
	public Node deQueue() {
		Node n = head;
		if(head == null) return null;
		
		Node nextNode = n.next;
		head = nextNode;
		
		return n;	
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
