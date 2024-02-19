package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestWithoutSorting {
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for(int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
		}
		
		
		int i = 0;
		while(i < k-1) {
			pq.remove();
			i++;
		}
		
		Integer peek = pq.peek();
		
		return peek;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		
		int findKthLargest = findKthLargest(nums, k);
		
		System.out.println(findKthLargest);
	}

}
