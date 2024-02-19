package leetcode;

import java.util.HashMap;

public class SumEqualToTarget {
	public static int[] sum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int required = target - nums[i];
			if (map.containsKey(required)) {
				return new int[] { map.get(required), i };
			}
			map.put(nums[i], i);
		}

		return new int[] {};
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 7, 8, 9 };
		int[] sum = sum(nums, 17);
		for (int i : sum) {
			System.out.println(i);
		}

	}

}
