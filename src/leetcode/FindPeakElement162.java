package leetcode;

public class FindPeakElement162 {

	public static int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		
		while(left < right) {
			int mid = left + (right - left)/2;
			if(nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,6,5};
		
		int findPeakElement = findPeakElement(nums);
		System.out.println(findPeakElement);
		
	}

}
















