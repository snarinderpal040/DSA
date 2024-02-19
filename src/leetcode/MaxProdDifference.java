package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class MaxProdDifference {

	public static int maxProductDifference(int[] nums) {
		HashMap<Long, Long> map = new HashMap<>();
		int count = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				map.put((long) count, (long) nums[i] * (long) nums[j]);
				count++;
			}
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (Long I : map.keySet()) {
			max = (int) Math.max(max, map.get(I));
			min = (int) Math.min(min, map.get(I));
		}

		return max - min;
	}

	public static int maxProduct(int[] nums) {
		Arrays.sort(nums);
		int prod1 = nums[0] * nums[1];
		int prod2 = nums[nums.length - 1] * nums[nums.length - 2];
		return prod2 - prod1;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 2, 5, 9, 7, 4, 8 };

		int maxProductDifference = maxProductDifference(nums);

		System.out.println(maxProductDifference);
		System.out.println(maxProduct(nums));
	}
}
