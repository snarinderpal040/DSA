package leetcode;

public class IncreasingTriplets334 {
	
	public static boolean increasingTriplet(int[] nums) {
		int small = Integer.MAX_VALUE;
		int mid = Integer.MAX_VALUE;
		
		for(int i : nums) {
			if (i <= small)
				small = i;
			else if (i <= mid)
				mid = i;
			else
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,1,5,0,4,6};
		boolean increasingTriplet = increasingTriplet(nums);
		if(increasingTriplet) {
			System.out.println("It is increasing triplets");
		}else {
			System.out.println("Try another array");
		}
	}

}
