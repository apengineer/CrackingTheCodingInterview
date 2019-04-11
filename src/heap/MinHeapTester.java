package heap;

public class MinHeapTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinHeap minHeap = new MinHeap();
		
		minHeap.add(10);
		minHeap.add(20);
		minHeap.add(15);
		minHeap.add(18);
		minHeap.add(12);
		
		for(int i : minHeap.items) {
			System.out.print(i + " ");
		}
		

	}

}
