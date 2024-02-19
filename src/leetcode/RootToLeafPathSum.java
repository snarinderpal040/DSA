package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RootToLeafPathSum {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	static int idx = -1;
	public static TreeNode createTree(int[] arr) {
		idx = idx + 1;
		if(arr[idx] == -1) {
			return null;
		}
		TreeNode node = new TreeNode(arr[idx]);
		node.left = createTree(arr);
		node.right = createTree(arr);
		
		return node;
	}
	
	public static void levelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			TreeNode remove = q.remove();
			if(remove == null) {
				System.out.println();
				if(q.isEmpty()) {
					break;
				}else {
					q.add(null);
				}
			}else {
				System.out.print(remove.val + " ");
				if(remove.left != null) {
					q.add(remove.left);
				}
				if(remove.right != null) {
					q.add(remove.right);
				}
			}
		}
	}
	
	public static int countOfNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = countOfNodes(root.left);
		int right = countOfNodes(root.right);
		return left + right + 1;
	}
	
	public static int sumOfNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int left = sumOfNodes(root.left);
		int right = sumOfNodes(root.right);
		
		return left + right + root.val;
	}
	
	public static boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		if(root.left == null && root.right == null) {
			return targetSum == root.val;
		}
		
		boolean left = hasPathSum(root.left, targetSum - root.val);
		boolean right = hasPathSum(root.right, targetSum - root.val);
		
		if(left || right) {
			return true;
		}
		
		return false;
	}
	
	public static int height(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		
		return Math.max(left, right) + 1;
	}
	
	//CLASS
	static class SumToLeaf{
		int leftLeaf;
		int rightLeaf;
		
		public SumToLeaf(int leftLeaf, int rightLeaf) {
			this.leftLeaf = leftLeaf;
			this.rightLeaf = rightLeaf;
		}
	}
	
	public static SumToLeaf sumOfPathToLeaf(TreeNode root) {
		if(root == null) {
			return new SumToLeaf(0, 0);
		}
		
		int left = sumOfNodes(root.left);
		int right = sumOfNodes(root.right);
		
		return new SumToLeaf(left + root.val, right + root.val);
	}
	
	//CLASS to calculate diameter of a tree
	static class NodeInfo{
		int height;
		int diameter;
		
		public NodeInfo(int height, int diameter) {
			this.height = height;
			this.diameter = diameter;
		}
	}
	
	public static NodeInfo diameter(TreeNode root) {
		if(root == null) {
			return new NodeInfo(0, 0);
		}
		
		NodeInfo left = diameter(root.left);
		NodeInfo right = diameter(root.right);
		
		int leftHeight = left.height;
		int rightHeight = right.height;
		
		int myHeight = Math.max(leftHeight, rightHeight) + 1;
		
		int leftDiameter = left.diameter;
		int rightDiameter = right.diameter;
		int finalDiameter = leftHeight + rightHeight + 1;
		
		int myDiameter = Math.max(finalDiameter, Math.max(leftDiameter, rightDiameter));
		
		return new NodeInfo(myHeight, myDiameter);
	}
	
	public static void main(String[] args) {
		int[] arr = {5,4,11,7,-1,-1,2,-1,-1,-1,8,13,-1,-1,4,-1,1,-1,-1};
		TreeNode root = createTree(arr);
		
		levelOrder(root);
		
		System.out.println("Number of Nodes : " + countOfNodes(root));
		
		System.out.println("Sum of Nodes : " + sumOfNodes(root));
		
		SumToLeaf sumOfPathToLeaf = sumOfPathToLeaf(root);
		System.out.println(sumOfPathToLeaf.leftLeaf + " " + sumOfPathToLeaf.rightLeaf);
		
		
		System.out.println(hasPathSum(root, 22));
		
		System.out.println("height is : " + height(root));
		
		NodeInfo diameter = diameter(root);
		
		int max = Math.max(diameter.diameter, diameter.height);
		System.out.println(max);
	}

}
