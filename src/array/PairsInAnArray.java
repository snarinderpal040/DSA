package array;

public class PairsInAnArray {
	
	public static void pairs(int[] nums) {
		int totalPairs = 0;
		for(int i = 0; i < nums.length - 1; i++) {
			System.out.print("Starting from " + nums[i] + " : ");
			for(int j = i + 1; j < nums.length; j++) {
				System.out.print("(" + nums[i] + ", " + nums[j] + ")" + " ");
				totalPairs += 1;
			}
			System.out.println();
		}
		System.out.println("Total number of pairs are : " + totalPairs);
	}
	
	public static int numberOfPairs(int[] nums) {
		return nums.length * (nums.length - 1) / 2;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,4,6,8,10};
		pairs(nums);
		
		System.out.println(numberOfPairs(nums));
		
	}

}
