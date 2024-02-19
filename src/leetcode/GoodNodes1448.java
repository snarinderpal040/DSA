package leetcode;

public class GoodNodes1448 {

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
	
	private int max = 0;

	public int goodNodes(TreeNode root) {
		traversal(root, root.val);
		return max;
	}

	private void traversal(TreeNode root, int maxVal) {
		if(root == null) {
			return;
		}
		
		if(root.val >= maxVal) {
			max += 1;
			maxVal = root.val;
		}
		
		traversal(root.left, maxVal);
		traversal(root.right, maxVal);
	}

}
