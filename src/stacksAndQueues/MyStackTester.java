package stacksAndQueues;

public class MyStackTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyStack myStack = new MyStack();
		myStack.push(10);
		myStack.push(2);
		myStack.push(4);
		
		myStack.show();
		System.out.println("Pop");
		System.out.println(myStack.pop().data);
		System.out.println(myStack.pop().data);
		System.out.println(myStack.pop().data);
		System.out.println("After pop");
		myStack.show();
	}

}
