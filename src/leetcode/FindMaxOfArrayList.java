package leetcode;

import java.util.List;

public class FindMaxOfArrayList {
	public static int max(List<Integer> list) {
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < list.size(); i++) {
			Integer curr = list.get(i);
			max = Math.max(max, curr);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		List<Integer> list = List.of(4,3,2,2,34,44,22,88,99);
		
		System.out.println(max(list));
		
		
	}

}
