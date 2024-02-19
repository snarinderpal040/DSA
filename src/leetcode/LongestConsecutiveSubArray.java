package leetcode;

public class LongestConsecutiveSubArray {

	public static int longest(int[] nums) {
		int start = 0;
		int end = 1;
		int max = Integer.MIN_VALUE;
		int currMax = 1;
		
		while(end < nums.length) {
			if(nums[start] <= nums[end]) {
				currMax++;
				max = Math.max(max, currMax);
				start++;
				end++;
			}else {
				start = end;
				end++;
				currMax = 1;
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 4, 6, 7, 6, 7, 8, 9,10, 11,12, 3, 4, 5, 6, 7, 8 };

		System.out.println(longest(nums));
	}
}
