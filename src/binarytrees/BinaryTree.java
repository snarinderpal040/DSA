package binarytrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Operations : buildTree, preOrderTraversal, inOrderTraversal, postOrderTraversal, levelOrderTraversal,
 *              height, countOfNodes, sumOfNodes, diameterOfTree, invertTree, topView, rightView, kthLevel
 */
public class BinaryTree {
	
	/**
	 * Node class to be used internally
	 */
	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	private int idx = -1;
	
	/**
	 * Builds the Tree.
	 * 
	 * @param nodes array
	 * 
	 * @return the Root of the Tree
	 */
	public Node buildTree(int[] nodes) {
		idx++;
		if(nodes[idx] == -1) {
			return null;
		}
		
		Node newNode = new Node(nodes[idx]);
		newNode.left = buildTree(nodes);
		newNode.right = buildTree(nodes);
		
		return newNode;
	}
	
	/**
	 * Pre order traversal, root left right
	 * @param root
	 */
	public void preOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	/**
	 * In order traversal, left root right
	 * @param root
	 */
	public void inOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}
	
	/**
	 * Post order traversal, left right root
	 * @param root
	 */
	public void postOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}
	
	/**
	 * Level order traversal, it uses the queue to do the in order traversal
	 * @param root
	 */
	public void levelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			Node head = queue.remove();
			if(head == null) {
				if(queue.isEmpty()) {
					break;
				}else {
					System.out.println();
					queue.add(null);
				}
			}else {
				System.out.print(head.data + " ");
				if(head.left != null) {
					queue.add(head.left);
				}
				if(head.right != null) {
					queue.add(head.right);
				}
			}
		}
		
	}
	
	/**
	 * Calculates the height of the tree
	 * @param root
	 * @return height in int
	 */
	public int height(Node root) {
		if(root == null) {
			return 0;
		}
		
		return Math.max(height(root.left), height(root.right)) + 1;
	}
	
	/**
	 * Counts the number of the nodes
	 * @param root
	 * @return
	 */
	public int countOfNodes(Node root) {
		if(root == null) {
			return 0;
		}
		
		return countOfNodes(root.left) + countOfNodes(root.right) + 1;
	}
	
	/**
	 * Sums all the node values
	 * @param root
	 * @return sum of nodes in int
	 */
	public int sumOfNodes(Node root) {
		if(root == null) {
			return 0;
		}
		
		return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
	}
	
	/**
	 * calculates the diameter of the tree using the height method which increases the time complexity of the code.
	 * 
	 * Time complexity is O(n ^ 2) because we have to go to every node and calculate height as well which is
	 * increasing the time complexity of the algorithm.
	 * 
	 * @param root
	 * @return diamter of the Tree
	 */
	public int diameterOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftDiameter = diameterOfTree(root.left);
		int leftHeight = height(root.left);
		
		int rightDiameter = diameterOfTree(root.right);
		int rightHeight = height(root.right);
		
		int selfDiameter = leftHeight + rightHeight + 1;
		
		return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
	}
	
	
	/**
	 * Using this class to calculate the diameter of the tree to reduce the time complexity
	 * @author narinderpalsingh
	 *
	 */
	public static class TreeInfo{
		int diameter;
		int height;
		
		public TreeInfo(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
		}
	}
	
	/**
	 * Preferred method to calculate the diameter
	 * @param root
	 * @return
	 */
	public TreeInfo diameter(Node root) {
		if(root == null) {
			return new TreeInfo(0, 0);
		}
		
		TreeInfo leftTreeInfo = diameter(root.left);
		TreeInfo rightTreeInfo = diameter(root.right);
		
		int height = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;
		int diameter = Math.max(leftTreeInfo.height+rightTreeInfo.height+1, Math.max(leftTreeInfo.diameter,rightTreeInfo.diameter));
		
		return new TreeInfo(diameter, height);
	}
	
	public boolean isSubTree(Node root, Node subRoot) {
		if(root == null) {
			return false;
		}
		
		if(subRoot == null) {
			return true;
		}
		
		if(root.data == subRoot.data) {
			if(isIdentical(root, subRoot)) {
				return true;
			}
		}
		
		return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
	}

	private boolean isIdentical(Node root, Node subRoot) {
		if(root == null && subRoot == null) {
			return true;
		}
		
		if(root == null || subRoot == null || root.data != subRoot.data) {
			return false;
		}
		
		if(!isIdentical(root.left, subRoot.left)) {
			return false;
		}
		
		if(!isIdentical(root.right, subRoot.right)) {
			return false;
		}
		
		return true;
	}
	
	public Node invertTree(Node root) {
		if(root == null) {
			return null;
		}
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		
		invertTree(root.left);
		invertTree(root.right);
		
		return root;
	}
	
	public static class NodeHdDistanceAndValue {
		int hd;
		Node node;
		
		public NodeHdDistanceAndValue(int hd, Node node){
			this.hd = hd;
			this.node = node;
		}
	}
	
	public void topView(Node root) {
		Queue<NodeHdDistanceAndValue> queue = new LinkedList<>();
		HashMap<Integer, Node> map = new HashMap<>();
		
		//to loop over the map in the left to right order
		int min = 0, max = 0;
		
		queue.add(new NodeHdDistanceAndValue(0, root));
		queue.add(null);
		
		while(!queue.isEmpty()) {
			NodeHdDistanceAndValue remove = queue.remove();
			if(remove == null) {
				if(queue.isEmpty()) {
					break;
				}else {
					queue.add(null);
				}
			}else {
				if(!map.containsKey(remove.hd)) {
					map.put(remove.hd, remove.node);
				}
				
				if(remove.node.left != null) {
					queue.add(new NodeHdDistanceAndValue(remove.hd - 1, remove.node.left));
					min = Math.min(min, remove.hd - 1);
				}
				
				if(remove.node.right != null) {
					queue.add(new NodeHdDistanceAndValue(remove.hd + 1, remove.node.right));
					max = Math.max(max, remove.hd + 1);
				}
			}
		}
		
		for(int i = min; i <= max; i++) {
			System.out.print(map.get(i).data + " ");
		}
		System.out.println();
	}
	
	public static class RightSideView{
		int vd;
		Node node;
		
		public RightSideView(int vd, Node node) {
			this.vd = vd;
			this.node = node;
		}
	}
	
	public List<Integer> rightSideView(Node root) {
		Queue<RightSideView> q = new LinkedList<>();
		HashMap<Integer, Node> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		int max = 0;
		
		q.add(new RightSideView(0, root));
		q.add(null);
		
		while(!q.isEmpty()) {
			RightSideView curr = q.remove();
			if(curr == null) {
				if(q.isEmpty()) {
					break;
				}else {
					q.add(null);
				}
			}else {
				if(!map.containsKey(curr.vd)) {
					map.put(curr.vd, curr.node);
				}
				
				if(curr.node.right != null) {
					q.add(new RightSideView(curr.vd + 1, curr.node.right));
					max = Math.max(max, curr.vd + 1);
				}
				
				if(curr.node.left != null) {
					q.add(new RightSideView(curr.vd + 1, curr.node.left));
					max = Math.max(max, curr.vd + 1);
				}
			}
		}
		
		for(int i = 0; i <= max; i++) {
			list.add(map.get(i).data);
		}
		
		return list;
	}
	
	public void kthLevel(Node root, int levelToPrint, int currentLevel) {
		if(root == null) 
			return;
		
		if(levelToPrint == currentLevel) {
			System.out.print(root.data + " ");
			return;
		}
		
		kthLevel(root.left, levelToPrint, currentLevel + 1);
		kthLevel(root.right, levelToPrint, currentLevel + 1);
	}

	public static void main(String[] args) {
		int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree bt = new BinaryTree();
		Node root = bt.buildTree(nodes);
		
		System.out.println("********* Pre  Order  Traversal *********");
		bt.preOrderTraversal(root);
		System.out.println();
		
		System.out.println("********* In   Order  Traversal *********");
		bt.inOrderTraversal(root);
		System.out.println();
		
		System.out.println("********* Post Order  Traversal *********");
		bt.postOrderTraversal(root);
		System.out.println();
		
		System.out.println("********* Level Order Traversal *********");
		bt.levelOrderTraversal(root);
		System.out.println();
		
		System.out.println("********* Height    of   Tree   *********");
		System.out.println(bt.height(root));
		
		System.out.println("*********  Count   of   Nodes   *********");
		System.out.println(bt.countOfNodes(root));
		
		System.out.println("*********   Sum   of    Nodes   *********");
		System.out.println(bt.sumOfNodes(root));
		
		System.out.println("********* Diameter  of  Tree    *********");
		System.out.println(bt.diameterOfTree(root));
		
		System.out.println("********* Diameter  of  Tree  2 *********");
		System.out.println(bt.diameter(root).diameter);
		
		
		System.out.println("********* Is Sub tree of a tree *********");
		//creating a subtree
		BinaryTree subTree = new BinaryTree();
		int[] arr = {2,4,-1,-1,5,-1,-1};
		Node subRoot = subTree.buildTree(arr);
		
		boolean isSubTree = bt.isSubTree(root, subRoot);
		System.out.println(isSubTree);
		
//		System.out.println("********* Invert    the   Tree  *********");
//		Node invertTreeRoot = bt.invertTree(root);
//		bt.levelOrderTraversal(invertTreeRoot);
		
		System.out.println("********* Top view of the Tree  *********");
		bt.topView(root);
		
		System.out.println("*********Right view of the Tree *********");
		List<Integer> rightSideView = bt.rightSideView(root);
		System.out.println(rightSideView);
		
		System.out.println("*********Print kth level of Tree*********");
		bt.kthLevel(root, 3, 1);
		
	}

}
