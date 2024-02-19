package leetcode;

public class RotateAnArray {

	public static void rotate(int[] nums, int k) {
		if(nums.length == 1 && k > 1) {
			return;
		}
		k = k % nums.length;
		int begin = nums.length - k;
		int start = begin;
		
		int[] arr = new int[nums.length];
		
		int i = 0;
		
		while(start < nums.length) {
			arr[i] = nums[start];
			i++;
			start++;
		}
		
		for(int z = 0; z < begin; z++) {
			arr[i] = nums[z];
			i++;
		}
		
		
		int u = 0;
		for(int x = 0; x < arr.length; x++) {
			nums[u] = arr[x];
			u++;
		}
		
		
	}
	
	public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int n = nums.length;
        reverseNum(nums,0,n-1);
        reverseNum(nums,0,k-1);
        reverseNum(nums,k,n-1);
    }
    public void reverseNum(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

	public static void main(String[] args) {
		int[] nums = {1,-100,3,99};
		rotate(nums, 2);
	}

}
