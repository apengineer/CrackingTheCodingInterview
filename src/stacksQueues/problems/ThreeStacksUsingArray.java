package stacksQueues.problems;

//Problem 3.1
// Main idea is play with array indices. 
public class ThreeStacksUsingArray {

	int SIZE = 100;
	int buffer[] = new int[SIZE * 3];

	int []stackPointer = {0, 0, 0};

	public void push(int stackNum, int value) {
		int index = stackNum * SIZE + stackPointer[stackNum];
		buffer[index] = value;
		stackPointer[stackNum] ++; 
	}

	public int pop(int stackNum) {
		int index = stackNum * SIZE + stackPointer[stackNum] ; // remove el at that index => set it to 0
		int lastEl = buffer[index];
		buffer[index] = 0;
		stackPointer[stackNum]--;
		return lastEl;
	}

	public boolean isEmpty(int stackNum) {
		if(stackPointer[stackNum] == 0) return true;
				else return false;
	}

	public void show(int stackNum) {

		for(int i = stackNum*SIZE; i < stackNum * SIZE + stackPointer[stackNum]; i++) {
			System.out.print(buffer[i] + " " );
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreeStacksUsingArray mySt = new ThreeStacksUsingArray();
		mySt.push(0, 12);
		mySt.push(0, 10);
		
		mySt.push(1, 501);
		mySt.push(1, 502);
		
		System.out.println("Printing stack 1");
		mySt.show(0);
		System.out.println();
		System.out.println("Printing stack 2");
		mySt.show(1);
		
		System.out.println();
		System.out.println("After popping last value from stack 1");		
		mySt.pop(1);
		mySt.show(1);

	}

}
