package leetcode;

public class TrappingRainWater11 {

	public static int maxArea(int[] height) {
		int left = 0, right = height.length - 1, max = 0;
		
		while(left < right) {
			if(height[left] < height[right]) {
				max = Math.max(max, height[left] * (right - left));
				left += 1;
			}else {
				max = Math.max(max, height[right] * (right - left));
				right -= 1;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}

}
