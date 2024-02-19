package leetcode;

public class SearchInRotatedSortedArray33 {

	public static int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && nums[mid] > target) {
					high = mid - 1;
				}else {
					low = mid + 1;
				}
			}
			
			else {
				if(nums[mid] < target && nums[high] >= target) {
					low = mid + 1;
				}else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1 };
		int target = 1;
		System.out.println(search(nums, target));
	}

}








