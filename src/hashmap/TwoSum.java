package hashmap;

import java.util.HashMap;

public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			int req = target - nums[i];
			if(map.containsKey(req)) {
				return new int[] {map.get(req), i};
			}
			
			map.put(nums[i], i);
		}
		
		return new int[] {};
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,4};
		int target = 6;
		
		int[] twoSum = twoSum(nums, target);
		
		for(int i : twoSum) {
			System.out.print(i + " ");
		}
	}

}
