package leetcode;

import java.util.Arrays;

public class LargestNumber {

	public static String largestNumber(int[] nums) {
		if (nums.length == 0) return "";
		if (nums.length == 1) return nums[0] + "";

		String[] arr = new String[nums.length];

		for (int i = 0; i < nums.length; i++)
			arr[i] = "" + nums[i];
		
		Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo((s1 + s2)));

		StringBuilder sb = new StringBuilder();

		for (String s : arr)
			sb.append(s);
		
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 30, 34, 5, 9 };
		
		System.out.println(largestNumber(nums));
	}
}
