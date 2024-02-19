package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindTheDifferneceOfTwoArrays2215 {

	public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		
		Arrays.stream(nums1).forEach(n -> map1.put(n, map1.getOrDefault(n, 0) + 1));
		Arrays.stream(nums2).forEach(n -> map2.put(n, map2.getOrDefault(n, 0) + 1));
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		for(Integer i : map1.keySet()) {
			if(!map2.containsKey(i)) {
				list1.add(i);
			}
		}
		
		for(Integer i : map2.keySet()) {
			if(!map1.containsKey(i)) {
				list2.add(i);
			}
		}
		
		return List.of(list1, list2);
	}

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,3}, nums2 = {1,1,2,2};
		List<List<Integer>> findDifference = findDifference(nums1, nums2);
		
		findDifference.stream().forEach(n -> System.out.println(n));
	}

}
