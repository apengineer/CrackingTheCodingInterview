package heap;

public class MaxHeap {

	int CAPACITY = 16;
	int size = 0;
	int []items = new int[CAPACITY];


	// getLeftChild, getRightChild, getRightChildIndex, getLeftChildIndex, getParentIndex

	public void add(int d) {	
		//added as last and bubbled up
		items[size] = d;
		size++;
		heapifyUp();

	}

	public int getRightChild( int index) {
		return items[2*index + 2];
	}
	public int getLeftChild( int index) {
		return items[2*index + 1];
	}
	public int getParent(int index) {
		return items[(index - 1) /2];
	}
	public int getParentIndex(int index) {
		return (index - 1) /2;
	}

	public int getLeftChildIndex(int index) {
		return 2*index + 1;
	}

	public int getRightChildIndex(int index) {
		return 2*index + 2;
	}

	public void swap(int from, int to) {
		int tmp = items[from];
		items[from] = items[to];
		items[to] =tmp;
	}
	public void heapifyUp() {
		int curEl = items[size - 1];
		int curIndex = size - 1;
		while(curIndex >= 0 && getParent(curIndex) < curEl) {
			swap(curIndex, getParentIndex(curIndex));
			curIndex = getParentIndex(curIndex);
		}

	}


	public int poll() {
		int el = items[0];
		items[0] = items[size - 1];
		items[size - 1] = 0;
		size--;
		heapifyDown();		
		return el;
	}

	public void heapifyDown() {
		int index = 0; int smallerChild = 0;
		int curEl = items[0]; int replaceIndex = 0;

		while(curEl < getRightChild(index) || curEl < getLeftChild(index)) {
			
			if(getRightChild(index) > getLeftChild(index)) {
				smallerChild = getRightChild(index);		
				replaceIndex = getRightChildIndex(index);
			}else {
				smallerChild = getLeftChild(index);
				replaceIndex  = getLeftChildIndex(index);
			}
			if(smallerChild > curEl) {
				swap(index, replaceIndex);
				index  = replaceIndex;
			}
		}
	}


	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap();

		maxHeap.add(10);
		maxHeap.add(20);
		maxHeap.add(15);
		maxHeap.add(18);
		maxHeap.add(12);

		for(int i : maxHeap.items) {
			System.out.print(i + " ");
		}
		
		System.out.println(maxHeap.poll());
		
		for(int i : maxHeap.items) {
			System.out.print(i + " ");
		}
		
		
	}

}
