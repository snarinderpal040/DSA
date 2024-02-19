package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveII {
	
	public static int longest(int[] nums) {
		
		Set<Integer> set = new HashSet<>();
		
		for(int i : nums) {
			set.add(i);
		}
		
		int max = 0;
		
		for(int i : nums) {
			if(!set.contains(i - 1)) {
				int currNum = i;
				int currMax = 1;
				
				while(set.contains(currNum + 1)) {
					currNum = currNum + 1;
					currMax = currMax + 1;
				}
				max = Math.max(currMax, max);
			}
		}
		
		return max;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {100,4,200,1,3,2};
		
		System.out.println(longest(nums));
	}

}
