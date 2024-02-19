package leetcode;

public class RemoveDuplicatesInPlaceFromArray {
	public static int removeDuplicates(int[] nums) {
		if(nums.length <= 2) {
			return nums.length;
		}
		
		int idx = 2;
		
		for(int i = 2; i < nums.length; i++) {
			if(nums[i] != nums[idx-2]) {
				nums[idx] = nums[i];
				idx++;
			}
		}
		
		return idx;
	}

	public static void main(String[] args) {
		int[] nums = { 0,0,1,1,1,1,2,3,3};

		System.out.println(removeDuplicates(nums));

	}

}
