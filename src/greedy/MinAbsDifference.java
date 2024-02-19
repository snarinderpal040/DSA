package greedy;

import java.util.Arrays;

public class MinAbsDifference {

	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[] b = {2,1,3};
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int absDiff = 0;
		
		for(int i = 0; i < a.length; i++) {
			absDiff = absDiff + Math.abs(a[i] - b[i]);
		}
		
		System.out.println(absDiff);
	}
}
