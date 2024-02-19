package binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public Node insert(Node root, int i) {
		if (root == null) {
			return new Node(i);
		}

		if (i < root.data) {
			root.left = insert(root.left, i);
		}
		if (i > root.data) {
			root.right = insert(root.right, i);
		}

		return root;
	}

	public void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public void preOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder(Node root) {
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public boolean search(Node root, int key) {
		if (root == null)
			return false;
		if (root.data == key)
			return true;
		if (key > root.data)
			return search(root.right, key);
		else
			return search(root.left, key);

	}

	public Node delete(Node root, int key) {
		if (root.data > key) {
			root.left = delete(root.left, key);
		} else if (root.data < key) {
			root.right = delete(root.right, key);
		} else {// found
				// case 1, no child node
			if (root.left == null && root.right == null) {
				return null;
			}
			// case 2, one child node
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			// case 3, both child nodes
			Node IS = inOrderSuccessor(root.right);
			root.data = IS.data;
			root.right = delete(root.right, IS.data);
		}

		return root;
	}

	private Node inOrderSuccessor(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	public void paths(Node root, List<Integer> list) {
		if(root == null)
			return;
		
		list.add(root.data);
		
		if(root.left == null && root.right == null) {
			System.out.println(list);
		}
		
		paths(root.left, list);
		paths(root.right, list);
		
		list.remove(list.size() - 1);
	}
	
	public static boolean isValid(Node root, Node min, Node max) {
		if(root == null) {
			return true;
		}
		
		if(min != null && root.data <= min.data) {
			return false;
		}
		
		if(max != null && root.data >= max.data) {
			return false;
		}
		return isValid(root.left, min, root) && isValid(root.right, root, max);
	}
	
	public Node createBalancedBST(int[] arr, int startIndex, int endIndex) {
		if(startIndex > endIndex) {
			return null;
		}
		
		int mid = startIndex + (endIndex - startIndex) / 2;
		Node root = new Node(arr[mid]);
		root.left = createBalancedBST(arr, startIndex, mid - 1);
		root.right = createBalancedBST(arr, mid + 1, endIndex);
		return root;
	}
	
	public List<Integer> inOrderSec(Node root, List<Integer> list) {
		if(root == null) {
			return list;
		}
		inOrderSec(root.left, list);
		list.add(root.data);
		inOrderSec(root.right, list);
		return list;
	}

	public static void main(String[] args) {
		int[] nodes = { 5, 1, 3, 4, 2, 7 };
		BinarySearchTree bst = new BinarySearchTree();
		Node root = null;

		/**
		 *			 5 
		 *			/ \
		 *		   1   7
		 *		    \
		 *			 3
		 *		    / \
		 *		   2   4
		 */

		for (int i : nodes) {
			root = bst.insert(root, i);
		}

		System.out.println("********* In Order **********");
		bst.inOrder(root);
		System.out.println();

		System.out.println("********* Pre Order *********");
		bst.preOrder(root);
		System.out.println();

		System.out.println("******** Post Order *********");
		bst.postOrder(root);
		System.out.println();

		System.out.println("******** Search Key *********");
		System.out.println(bst.search(root, 4));

		System.out.println("******** Delete a node ******");
		/*bst.inOrder(root);
		System.out.println();
		Node delete = bst.delete(root, 3);
		bst.inOrder(delete);
		System.out.println();*/
		
		System.out.println("****** Paths to leaves ******");
		bst.paths(root, new ArrayList<>());
		
		boolean isValid = isValid(root, null, null);
        if(isValid) {
        	System.out.println("BST is Valid");
        }else {
        	System.err.println("BST is Invalid");
        }
        
        int[] arr = {3,5,6,8,10,11,12};
        Node balancedTreeRoot = bst.createBalancedBST(arr, 0, arr.length - 1);
        bst.preOrder(balancedTreeRoot);
        System.out.println();
        bst.inOrder(balancedTreeRoot);
        System.out.println();
        
        List<Integer> inOrderSec = bst.inOrderSec(root, new ArrayList<>());
        
        int[] newArr = new int[inOrderSec.size()];
        for(int i = 0; i < inOrderSec.size(); i++) {
        	newArr[i] = inOrderSec.get(i);
        }
        
        Node createBalancedBST = bst.createBalancedBST(newArr, 0, newArr.length - 1);
        bst.inOrder(createBalancedBST);
        System.out.println();
        bst.preOrder(createBalancedBST);
        System.out.println();
        bst.paths(balancedTreeRoot, new ArrayList<>());
	}

}
