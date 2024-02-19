package leetcode;

public class MoveZeros {
	public static void moveZeros(int[] nums) {        
        int i = 0;
        
        for(int j = 0; j < nums.length; j++) {
        	if(nums[j] != 0) {
        		nums[i] = nums[j];
        		i++;
        	}
        }
        
        while(i < nums.length) {
        	nums[i] = 0;
        	i++;
        }
  }
	
	public static void print(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeros(nums);
		print(nums);
		
	}

}
