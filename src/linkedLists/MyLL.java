package linkedLists;

public class MyLL {
	
	public Node head;
	
	public int size() {
		if(head == null) return 0;
		Node n = head;
		int size = 0;
		while(n.next != null) {
			n = n.next;
			
			size++;
		}
		return (size + 1);
	}
	
	// add at last position
	public void add(int d) {
		
		Node node = new Node(d);
		if (head == null) {
			head = node;
		}else {
			Node n = head;
			while(n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}
	
	public void addAt(int index, int data) {
		Node node = new Node(data);
		Node n = head;
		int pos = 1;
		while(n.next != null) {			
			if(index == 0) {// add as head					
				node.next = n;
				head = node;
				break;
			}		
			pos++;
			n = n.next;	
			if (pos == size() ) { // add tail node
				n.next = node;
				node.next = null;
				break;
			}			
			if(pos == index) {				
				Node nextNode = n.next;
				n.next = node;
				node.next = nextNode;
				break;
			}
			
		}
	}
	
	// delete from tail
	public void delete() {
		Node n = head;
		while(n.next != null) {
			Node previousNode = n;
			n = n.next;	
			if(n.next == null) {
				previousNode.next = null;
				break;
			}
		}		
	}
	
	public void deleteAt(int index) {
		Node n = head;
		int pos = 0;
		
		if(index == 0) {
			/*n = n.next;
			head = n;*/			
			head = n.next;
			return;
		}
		
		while(n.next != null) {
			Node previousNode = n;
			n = n.next;
			pos++;
			if(pos == index) {
				previousNode.next = n.next;	
				break;
			}
		}
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
 