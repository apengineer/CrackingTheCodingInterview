package stacksQueues.problems;

// Problem 3.2
public class SortedStack {

	NodeForSortedStack head;	

	// add behind head and move head pointer back
	public void add(int value) {

		NodeForSortedStack n = new NodeForSortedStack(value);
		if(head == null) {
			head = n;
			head.min = value;
			head.next = null;
		} else {
			// get min value from Node beneath it
			int min = min();
			NodeForSortedStack tmp = head;
			head = n;
			head.min =  min < value ? min : value;
			head.next = tmp;		
		}
	}

	// move head forwards. 
	public NodeForSortedStack pop() {
		NodeForSortedStack n = head;
		head = n.next;
		return n;
	}

	// return head
	public NodeForSortedStack peek() {
		return head;
	}

	public int min() {
		return peek().min;
	}
	
	public void show() {
		NodeForSortedStack n = head;
		while(n.next !=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.print(n.data);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortedStack ss= new SortedStack();
		ss.add(10);
		ss.add(20);
		ss.add(5);
		ss.add(6);

		ss.show();
		System.out.println();
		System.out.println("Minimum");
		System.out.println(ss.min());
	}

}




