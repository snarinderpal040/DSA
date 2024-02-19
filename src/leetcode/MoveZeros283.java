package leetcode;

public class MoveZeros283 {
	
	private static int[] moveZeros(int[] nums) {
		int count = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				continue;
			}else {
				nums[count] = nums[i];
				count++;
			}
		}
		
		for(int i = count; i < nums.length; i++) {
			nums[i] = 0;
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		
		nums = moveZeros(nums);
		for(int i : nums) {
			System.out.print(i + " ");
		}
	}

}
