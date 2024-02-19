package heaps;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestInfiniteSet {

	Set<Integer> set;
	PriorityQueue<Integer> pq;

	public SmallestInfiniteSet() {
		set = new HashSet<>();
		pq = new PriorityQueue<>();
		
		for(int i = 1; i <=1000; i++) {
			set.add(i);
		}
		
		pq.addAll(set);
	}

	public int popSmallest() {
		int remove = pq.remove();
		set.remove(remove);
		return remove;
	}

	public void addBack(int num) {
		if(set.add(num)) {
			pq.add(num);
		}
	}

	public static void main(String[] args) {
		SmallestInfiniteSet sm = new SmallestInfiniteSet();
		int popSmallest = sm.popSmallest();
		System.out.println(popSmallest);
		
		sm.addBack(3);
		System.out.println(sm.popSmallest());
	}

}
