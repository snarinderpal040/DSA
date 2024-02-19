package leetcode;

import java.util.Arrays;

public class MaxNumberOfKSumPairs1679 {

	public static int maxOperations(int[] nums, int k) {
		Arrays.sort(nums);
		int left = 0, right = nums.length - 1, max = 0;
		while (left < right) {
			if (nums[left] + nums[right] < k) {
				left++;
			} else if (nums[left] + nums[right] > k) {
				right--;
			} else {
				max += 1;
				left++;
				right--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 3, 4, 3 };
		int k = 6;
		System.out.println(maxOperations(nums, k));
	}

}
