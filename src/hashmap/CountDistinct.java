package hashmap;

import java.util.HashSet;

public class CountDistinct {
	
	public static void countDistinct(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		
		for(int i : arr) {
			set.add(i);
		}
		
		System.out.println(set);
		
	}
	
	public static void main(String[] args) {
		int[] arr = {4,3,2,5,6,7,4,2,1};
		
		countDistinct(arr);
	}
}
