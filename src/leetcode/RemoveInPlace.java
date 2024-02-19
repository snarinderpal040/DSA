package leetcode;

public class RemoveInPlace {

	public static int removeElement(int[] nums, int val) {
        int idx = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != val) {
        		nums[idx] = nums[i];
        		idx++;
        	}
        }
		
		return idx;
    }
	
	
	public static void main(String[] args) {
		int[] nums = {3,2,2,3};
		
		System.out.println(removeElement(nums, 2));
	}
}
