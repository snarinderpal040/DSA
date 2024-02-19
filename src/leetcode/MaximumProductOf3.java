package leetcode;

import java.util.Arrays;

public class MaximumProductOf3 {
	
	public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
		int product = 1;
        
        if(nums.length == 3) {
        	return nums[0] * nums[1] * nums[2];
        }
        
        for(int i = nums.length - 1; i >= nums.length - 3; i--) {
        	product *= nums[i];
        }
        
		return product;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1,-2,-3};
		
		System.out.println(maximumProduct(nums));
	}

}
