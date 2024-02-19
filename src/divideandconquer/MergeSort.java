package divideandconquer;

public class MergeSort {
	
	public static void mergeSort(int[] nums, int si, int ei) {
		if(si >= ei) {
			return;
		}
		
		int mid = si + (ei - si)/2;
		mergeSort(nums, si, mid);
		mergeSort(nums, mid + 1, ei);
		merge(nums, si, mid, ei);
	}
	
	private static void merge(int[] nums, int si, int mid, int ei) {
		int k = 0;
		int[] temp = new int[ei - si + 1];
		int i = si;
		int j = mid + 1;
		
		while(i <= mid && j <= ei) {
			if(nums[i] < nums[j]) {
				temp[k] = nums[i];
				i++;
			}else {
				temp[k] = nums[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid) {
			temp[k] = nums[i];
			k++;
			i++;
		}
		
		while(j <= ei) {
			temp[k] = nums[j];
			k++;
			j++;
		}
		
		for(int i1 = 0, j1 = si; i1 < temp.length; i1++, j1++) {
			nums[j1] = temp[i1];
		}
		
		print(nums);
	}
	
	public static void print(int[] nums) {
		for(int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = {6,3,9,5,2,8};
		mergeSort(nums, 0, 5);
		
		System.out.print("FINAL OUTPUT : ");
		
		print(nums);
	}

}
