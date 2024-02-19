package leetcode;

public class RemoveDuplicates {

	public static int removeDuplicates(int[] nums) {
		int count = 0;
		int temp = Integer.MIN_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != temp) {
				temp = nums[i];
				nums[count] = nums[i];
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,2};
		
		System.out.println(removeDuplicates(nums));
	}

}
