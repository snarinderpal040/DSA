package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumLevelSumOfBinaryTree1161 {
	public static class TreeNode {
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
	
	private static int idx = -1;
	
	public static TreeNode buildTree(int[] nodes) {
		idx++;
		if(nodes[idx] == -1) {
			return null;
		}
		
		TreeNode root = new TreeNode(nodes[idx]);
		root.left = buildTree(nodes);
		root.right = buildTree(nodes);
		
		return root;
	}
	
	public static void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static int maxLevelSum(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int levelSum = 0;
		int level = 1;
		
		while(!q.isEmpty()) {
			TreeNode curr = q.remove();
			if(curr == null) {
				if(q.isEmpty()) {
					map.put(level, levelSum);
					break;
				}else {
					q.add(null);
					map.put(level++, levelSum);
					levelSum = 0;
				}
			}else {
				levelSum += curr.val;
				if(curr.left != null) 
					q.add(curr.left);
				if(curr.right != null) 
					q.add(curr.right);
			}
		}
		
		return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
	
	public static void main(String[] args) {
		int[] nodes = {1, 7, 7, -1, -1, -8, -1, -1, 0, -1, -1};
		TreeNode root = buildTree(nodes);
		preOrder(root);
		System.out.println();
		int maxLevelSum = maxLevelSum(root);
		System.out.println(maxLevelSum);
	}

}
