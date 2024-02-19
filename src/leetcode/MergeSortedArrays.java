package leetcode;

import java.util.Arrays;

public class MergeSortedArrays {
	public static void merge(int[] nums1, int m, int[] nums2, int n) { 
		int x = 0;
		for(int i = m; i < m + n; i++) {
			nums1[i] = nums2[x];
			x++;
		}
		
		Arrays.sort(nums1);		
    }

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};
		int n = 3;
		
		merge(nums1, m, nums2, n);
		
		for(int i =0; i < nums1.length; i++) {
			System.out.print(nums1[i]);
		}
	}
}
