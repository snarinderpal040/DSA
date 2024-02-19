package leetcode;

import java.util.HashMap;

public class ContainsDuplicateWithAbsValue {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			Integer oldValueOfKey = map.put(nums[i], i);
			
			if (oldValueOfKey != null && Math.abs(oldValueOfKey - i) <= k) {
				
				return true;
			}
		}
		System.out.println(map);
		return false;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 0, 1, 1 };
		System.out.println(containsNearbyDuplicate(nums, 1));
	}

}
