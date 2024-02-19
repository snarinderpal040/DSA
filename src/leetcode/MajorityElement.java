package leetcode;

import java.util.HashMap;

public class MajorityElement {
	public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
        	map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for(Integer I : map.keySet()) {
        	System.out.println(I + " -> " + map.get(I));
        	if(map.get(I) > nums.length/2) {
        		return I;
        	}
        }
		return 0;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,2,1,1,1,2,2};
		
		System.out.println(majorityElement(nums));
	}

}
