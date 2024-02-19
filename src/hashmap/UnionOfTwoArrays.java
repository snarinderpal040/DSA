package hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoArrays {
	
	public static Set<Integer> union(int[] arr1, int[] arr2) {
		Set<Integer> set = new HashSet<>();
		
		Arrays.stream(arr1).forEach(n -> set.add(n));
		Arrays.stream(arr2).forEach(n -> set.add(n));
		
		return set;
	}

	public static void main(String[] args) {
		int[] arr1 = {7,3,9};
		int[] arr2 = {6,3,9,2,9,4};
		
		System.out.println(union(arr1, arr2));
	}

}
