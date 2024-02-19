package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidWIthMostCandies1431 {

	public static List<Boolean> kidWithMostCandies(int[] candies, int extraCandies) {
		List<Boolean> result = new ArrayList<>();
		int maxCandies = Arrays.stream(candies).max().orElse(-1);

		if (maxCandies != -1) {
			for (int i : candies) {
				result.add(i + extraCandies >= maxCandies);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] candies = {2,3,5,1,3};
		int extraCandies = 3;
		
		System.out.println(kidWithMostCandies(candies, extraCandies));
	}

}
