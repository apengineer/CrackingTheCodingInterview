package stacksAndQueues;

public class MyQueueTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue myQ = new MyQueue();
		myQ.enQueue(1);
		myQ.enQueue(5);
		myQ.enQueue(6);
		myQ.enQueue(20);
		
		myQ.show();
		System.out.println("Dequeue");
		System.out.println((myQ.deQueue().data));
		System.out.println("Afte De-queuue");
		myQ.show();
	}

}
