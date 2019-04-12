package heap;

import java.util.Arrays;

public class MinHeap {
	int CAPACITY = 10;
	int size = 0;

	int []items = new int[CAPACITY];

	public int getLeftChildIndex(int index) {
		return 2 * index + 1;
	}
	public int getRightChildIndex(int index) {
		return 2 * index + 2;
	}		
	public int getParentIndex(int index) {
		return (index - 1)/2;
	}

	public boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	public boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	public boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	public int getLeftChild(int index) {
		return items[2*index + 1];
	}
	public int getRightChild(int index) {
		return items[2*index + 2];
	}
	public int getParent(int index) {
		return items[(index -1) / 2];
	}

	public boolean isMinHeap(int []items) {
		int index = 0;
		while((2*index + 2) < size) {
			if(2*index + 1 == size) return true;
			int root = items[(index -1)/2];
			int left = items[2*index + 1];
			int right = items[2*index + 2];
			if((root < left) && (root < right)) {
				index++;
			} else {
				return false;
			}
		}
		return true;
	}

	public int[] buildMinHeap(int []items) {
		int index = 0;
		int []minHeap = new int[items.length];
		
		
		while( index < items.length) {
			minHeap[index] = items[index];
			minHeap = heapifyDown(minHeap);
			index++;
		}
		
		return minHeap;

	}

	public int[] heapifyDown(int []items) {
		System.out.println("here");
		int i = 0;
	//	if((2*i + 1) <= items.length) return items;
		System.out.println("now");
		while(items[2*i +1] <  items[(i -1) /2]) {
			int swapNode = items[2*i +1];
			int swapIndex = 2*i  + 1;
			if(items[2*i + 2] < items[(i -1) /2]) {
				swapNode = items[2*i +2];
				swapIndex  = 2*i + 2;
			}
			swap(i, swapIndex);
			i = swapIndex;
			System.out.println("swap" + swapIndex);

		}
		for(int it : items) {
			System.out.print(it + "++");
		}
		return items;
	}



	private void swap(int from, int to) {
		int tmp = items[from];
		items[from] = items[to];
		items[to]= tmp;		
	}

	public void ensureCapacity() {
		if(size == CAPACITY) {
			items = Arrays.copyOf(items, CAPACITY*2);
			CAPACITY = CAPACITY *2;
		}
	}

	public int peek() {
		return items[0];
	}

	// etract min element. Redo array by copying last el to first pos and then bubbling down
	public int poll() {
		int returnItem = items[0];
		items[0] = items[size -1];
		size--;		
		//heapify down
		heapifyDown();

		return returnItem;

	}

	public void add(int el) {
		ensureCapacity();

		items[size] = el;
		size++;

		// heapify up
		heapifyUp();
	}

	public void heapifyUp() {
		int index = size - 1;
		//if parent > current el, swap
		while(hasParent(index) && (getParent(index) > items[index])) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}

	public void heapifyDown() {
		int index = 0;

		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChild(index);
			if(hasRightChild(index) && getRightChild(index) > getLeftChild(index)) {
				smallerChildIndex = getRightChild(index);
			}

			if(items[index] > items[smallerChildIndex]) {
				swap(index, smallerChildIndex);
				index = smallerChildIndex;
			}

		}

	}

}
