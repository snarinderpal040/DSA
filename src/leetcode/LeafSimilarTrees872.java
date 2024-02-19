package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees872 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode() {

		}

		public TreeNode(int val) {
			this.val = val;
		}

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		leafValues(root1, list1);
		leafValues(root1, list2);

		return list1.equals(list2);
	}

	private void leafValues(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			list.add(root.val);
			return;
		}

		leafValues(root.left, list);
		leafValues(root.right, list);

	}

}
