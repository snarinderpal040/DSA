package leetcode;

public class SearchInsert {
	public static int searchInsert(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;
        
        while(start <= end) {
        	int mid = start + end - start/2;
        	
        	if(nums[mid] == target) {
        		return mid;
        	}
        	
        	if(nums[mid] < target) {
        		start = mid + 1;
        	}
        	
        	if(nums[mid] > target) {
        		end = mid - 1;
        	}
        }
		
		return start;
    }
	
	public static void main(String[] args) {
		int[]  nums = {1,3,5,6};
		int target = 5;
		
		int searchInsert = searchInsert(nums, target);
		System.out.println(searchInsert);
	}

}
