package heaps;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	List<Integer> arr;

	public Heap() {
		arr = new ArrayList<>();
	}

	public void insert(int val) {
		arr.add(val);

		int x = arr.size() - 1;// index of added val
		int par = (x - 1) / 2;

		while (arr.get(x) < arr.get(par)) {
			Integer temp = arr.get(x);
			arr.set(x, arr.get(par));
			arr.set(par, temp);
			x = par;
			par = (x - 1) / 2;
		}
	}

	public int peek() {
		return arr.get(0);
	}

	public int remove() {
		int data = arr.get(0);

		// Step 1. Swap first and last
		int temp = arr.get(0);
		arr.set(0, arr.get(arr.size() - 1));
		arr.set(arr.size() - 1, temp);

		// Step 2. Delete last
		arr.remove(arr.size() - 1);

		// Step 3. Heapify()
		heapify(0);
		return data;
	}

	private void heapify(int idx) {
		int left = 2 * idx + 1;
		int right = 2 * idx + 2;

		int min = idx;

		if (left < arr.size() && arr.get(min) > arr.get(left)) {
			min = left;
		}

		if (right < arr.size() && arr.get(min) > arr.get(right)) {
			min = right;
		}

		if (min != idx) {
			int temp = arr.get(idx);
			arr.set(idx, arr.get(min));
			arr.set(min, temp);

			heapify(min);
		}
	}

	public boolean isEmpty() {
		return arr.size() == 0;
	}
	
	public void print() {
		arr.forEach(n -> System.out.print(n + " "));
		System.out.println();
	}

	public static void main(String[] args) {
		Heap minHeap = new Heap();

		minHeap.insert(3);
		minHeap.insert(4);
		minHeap.insert(1);
		minHeap.insert(5);
		minHeap.insert(0);
		minHeap.insert(9);
		minHeap.insert(8);
		minHeap.insert(-1);
		
		minHeap.print();

		while (!minHeap.isEmpty()) {
			System.out.print(minHeap.peek() + " ");
			minHeap.remove();
		}
		System.out.println();

	}

}
