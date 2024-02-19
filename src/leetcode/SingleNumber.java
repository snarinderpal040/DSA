package leetcode;

import java.util.HashMap;
import java.util.Set;

public class SingleNumber {
	public static int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i< nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		
		Set<Integer> keySet = map.keySet();
		
		for(Integer I:keySet) {
			if(map.get(I) == 1) {
				return I;
			}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {4,1,4,2,1,2,5,5,6,7,3,3,3,3,3};
		
		System.out.println(singleNumber(nums));
		
	}

}
