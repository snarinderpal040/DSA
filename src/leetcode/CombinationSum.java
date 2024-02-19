package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void combinations(int[] candidates, int target, List<List<Integer>> list, int idx, List<Integer> resList) {
		
		if(idx == -1) {//means candidates length was 0.
			if(target == 0) {
				list.add(new ArrayList<>(resList));
				return;
			}
			return;
		}
		
		if (target == 0) {
			list.add(new ArrayList<>(resList));
			return;
		}
		
		if(target < 0) {
			return;
		}

		resList.add(candidates[idx]);
		combinations(candidates, target - candidates[idx], list, idx, resList);
		resList.remove(resList.size() - 1);
		combinations(candidates, target, list, idx - 1, resList);

	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> resList = new ArrayList<>();
		
		combinations(candidates, target, list, candidates.length - 1, resList);

		return list;
	}

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 8;

		List<List<Integer>> combinationSum = combinationSum(candidates, target);

		for (List<Integer> l : combinationSum) {
			System.out.print(l + " ");
		}
	}

}
