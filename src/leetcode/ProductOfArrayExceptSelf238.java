package leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {
	
	public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int product = Arrays.stream(nums).reduce(1, (a,b) -> a * b);
        
        for(int i = 0; i < nums.length; i++) {
        	answer[i] = nums[i] == 0 ? 0 : product/nums[i];
        }
        
		return answer;
    }
	
	public static int[] productExceptSelfII(int[] nums) {
        int[] answer = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
        	int product = 1;
        	for(int j = 0; j < nums.length; j++) {
        		if(i == j)
        			continue;
        		product *= nums[j];
        	}
        	answer[i] = product;
        }
        return answer;
    }
	
	public static int[] productExceptSelfIII(int[] nums) {
		int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        
        prefixProduct[0] = 1;
        
        for(int i = 1; i < n; i++) {
        	prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }
        
        suffixProduct[n - 1] = 1;
        for(int i = suffixProduct.length -2; i >= 0; i--) {
        	suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        }
        
        for(int i = 0; i < n ; i++) {
        	nums[i] = prefixProduct[i] * suffixProduct[i];
        }
        
        return nums;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1,1,0,-3,3};
		int[] answer = productExceptSelfIII(nums);
		Arrays.stream(answer).forEach(System.out::println);
	}

}
