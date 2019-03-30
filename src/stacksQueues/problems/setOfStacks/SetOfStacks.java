package stacksQueues.problems.setOfStacks;

import java.util.ArrayList;

import linkedLists.Node;

//Problem 3.3
public class SetOfStacks {

	ArrayList<Stack> stacks = new ArrayList<Stack>();
	int CAPACITY = 3;

	public int getCurrentSize(Stack s) {
		int size = s.getCurrentSize();
		return size;
	}

	public void push(int v) {
		//create first stack and add to list
		if(stacks.size()  == 0) {
			Stack s = new Stack(CAPACITY);			 
			stacks.add(s);
			s.push(v);
		} else {
			Stack stackToFill = getLastStack();
			// check size of stack. If < CAPACITY, add; else create new Stack
			int curSize = getCurrentSize(stackToFill);
			if (curSize < stackToFill.capacity) {
				stackToFill.push(v);
			}else {
				Stack s = new Stack(CAPACITY);
				stacks.add(s);
				s.push(v);
			}

		}

	}


	// all Stacks in list are filled to capacity. Hence return last el from list
	public Stack getLastStack() {
		if(stacks.size() == 0) {
			return null;
		}

		int size = stacks.size();
		return stacks.get(size - 1);
	}


	// get last stack, return last added el from that
	public Node pop() {
		Stack lastStack = getLastStack();
		Node lastEl = lastStack.pop();
		// if no more el left in stack, remove it from ArrayList
		if(lastStack.head == null) 
			stacks.remove(lastStack);
		return lastEl;
	}



	public void show() {
		for(Stack s: stacks) {
			System.out.println(s.toString());
			s.show();
		}
	}



	public static void main(String[] args) {
		SetOfStacks ss = new SetOfStacks();
		ss.push(10);
		ss.push(11);
		ss.push(12);
		ss.push(13);

		ss.show();
		
		System.out.println("Pop");
		ss.pop();
		System.out.println("Pop");
		ss.pop();
		ss.show();
	}

}
