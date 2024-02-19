package recursionbasics;

public class FirstOccurence {
	
	public static int first(int[] nums, int idx, int target) {
		if(idx == nums.length) {
			return -1;
		}
		if(nums[idx] == target) {
			return idx;
		}
		
		return first(nums, idx + 1, target);
	}

	public static void main(String[] args) {
		int[] nums = {1,6,4,8,9,6,7,8,2};
		int target = 4;
		
		System.out.println(first(nums, 0, target));
	}
}
