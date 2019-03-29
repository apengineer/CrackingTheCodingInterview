package stacksAndQueues;

//LIFO
public class MyStack {

	Node head;
	
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
		Node n = head;
		while(n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}
	
}
