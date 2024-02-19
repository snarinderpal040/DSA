package leetcode;

import java.util.HashMap;

public class ContainsNearByDuplicate {
	public static boolean duplicateExists(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i =0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				Integer integer = map.get(nums[i]);
				integer++;
				map.put(nums[i], integer);
			}else {
				map.put(nums[i], 1);
			}
		}
		
		if(map.containsKey(k) && map.get(k) > 1) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,1};
		System.out.println(duplicateExists(nums, 1));
		
		int abs = Math.abs(1-2);
		System.out.println(abs);

	}

}
