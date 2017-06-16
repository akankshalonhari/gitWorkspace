package SamplesProject.examples;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeImpl {

	public BinaryTreeImpl(){
		    TreeNode root = new TreeNode(20);
	        root.left = new TreeNode(10);
	        root.right = new TreeNode(30);
	        root.left.left = new TreeNode(5);
	        root.left.right = new TreeNode(15);
	        root.left.left.left = new TreeNode(3);
	        root.left.left.right = new TreeNode(7);
	        root.left.right.right = new TreeNode(17);
	        System.out.println(" Common ancestor node :  " + root.commonAnsc(root, 7, 17));
	        root.listOfDepths(root);
	        System.out.println("\n\n is Balanced? " + root.isBalancedTree(root));
	        
	        int[] arr = new int[]{2, 4, 5, 6, 7, 8, 9, 10, 11};
	        TreeNode rootN = new TreeNode();
	        rootN = rootN.minBalancedTree(arr);
	        System.out.println("\n root -> " + rootN.data + " lt " + rootN.left.data + " rt " + rootN.right.data);
	        System.out.println(" root.left -> " + rootN.left.data + " lt " + rootN.left.left.data + " rt " + rootN.left.right.data);
	        System.out.println(" root.right -> " + rootN.right.data + " lt " + rootN.right.left.data + " rt " + rootN.right.right.data);
	        System.out.println(" last rt"+ rootN.right.right.right.data);
	        System.out.println(" last lt "+ rootN.left.right.right.data);
	        System.out.println(" is Balanced? " +  rootN.isBalancedTree(rootN));
	        System.out.println(" check is BST " + rootN.checkIsBST(rootN));
	        
	        
	        int[] arr2 = new int[]{2, 5, 4,  9, 10, 11, 6, 7};
	        TreeNode rootN2 = new TreeNode();
	        rootN2 = rootN2.minBalancedTree(arr2);
	        System.out.println("\n root -> " + rootN2.data + " lt " + rootN2.left.data + " rt " + rootN2.right.data);
	        System.out.println(" root.left -> " + rootN2.left.data + " lt " + rootN2.left.left.data + " rt " + rootN2.left.right.data);
	        System.out.println(" root.right -> " + rootN2.right.data + " lt " + rootN2.right.left.data + " rt " + rootN2.right.right.data);
	        System.out.println(" last rt"+ rootN2.right.right.right.data);
	        System.out.println(" is Balanced? " +  rootN2.isBalancedTree(rootN2));
	        System.out.println(" check is BST " + rootN2.checkIsBST(rootN2));
	}
}

class TreeNode{
	int data;
	TreeNode left, right;
	
	TreeNode(){
		
	}
	
	TreeNode(int value){
		this.data = value;
		this.left = null;
		this.right = null;
	}
	
	/* Given a binary tree, check if its a valid binary search tree */
	public boolean checkIsBST(TreeNode root){
		return checkBST(root, null, null);
	}
	
	private boolean checkBST(TreeNode root, Integer min, Integer max){
		if(root == null) return true;
		
		//If in the current recursion, the current root is less than lowest element so far  or
		// if in the current recursion, the current root is greater than biggest element so far
		if((min != null && root.data <= min) || (max != null && root.data > max))
			return false;
		
		//if either of the calls return false 
		if((!checkBST(root.left, min, root.data))  || (!checkBST(root.right, root.data, max)))
			return false;
		
		return true;
	}
	
	/* Checking if a binary tree is balanced i.e one node difference between heights */
	public boolean isBalancedTree(TreeNode root){
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	private int checkHeight(TreeNode root){
		if(root == null) return -1;
		
		int leftHt = checkHeight(root.left);
		if(leftHt == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int rightHt = checkHeight(root.right);
		if(rightHt == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int diff = Math.abs(leftHt - rightHt);
		if(diff >1)
			return Integer.MIN_VALUE;
		else
			return Math.max(leftHt, rightHt) + 1;
		
	}
	
	/* Lists of Depths of a binary tree */
	public ArrayList<LinkedList<TreeNode>> listOfDepths(TreeNode root){
		ArrayList<LinkedList<TreeNode>> resultLists = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> currentList = new LinkedList<TreeNode>();
		if(root != null)
			currentList.add(root); //starting the current list with depth 0 node
		
		while(currentList.size() > 0){
			resultLists.add(currentList); //adding  current list of depth i to results
			LinkedList<TreeNode> parents = currentList; //getting parents of current list
			currentList = new LinkedList<TreeNode>(); 
			for(TreeNode parent : parents){
				if(parent.left != null){
					currentList.add(parent.left);
				}
				if(parent.right != null){
					currentList.add(parent.right);
				}
			}
		}
		int i=0;
		for(LinkedList<TreeNode> t : resultLists){
			System.out.print("\nList for depth " + i + "\t");
			for(TreeNode n : t){
				System.out.print(n.data + " - ");
			}
			i++;
		}
		return resultLists;
	}
	
	/* given sorted increasing only array, build a binary tree thatis balanced */
	public TreeNode minBalancedTree(int[] array){
		return buildMinTree(array, 0, array.length-1);
	}
		
	private TreeNode buildMinTree(int[] arr, int start, int end){
		if(end < start) return null;
		
		int mid = (start+end)/2;
		TreeNode newNode = new TreeNode(arr[mid]);
		newNode.left = buildMinTree(arr, start, mid-1);
		newNode.right = buildMinTree(arr, mid+1, end);
		return newNode;
	}
	
	/* Find common ancestor between 2 nodes of binary tree */
	public int commonAnsc(TreeNode root, int p, int q){
		if(root == null)
			return -1;
		
		if(root.data == p || root.data == q) return root.data;
		
		TreeNode x = new TreeNode();
		x.data = commonAnsc(root.left, p, q);
		if(x.data != -1 && x.data != p && x.data != q){
			return x.data;
		}
		
		TreeNode y = new TreeNode();
		y.data = commonAnsc(root.right, p, q);
		if(y.data != -1 && y.data != p && y.data != q){
			return y.data;
		}
		
		if(x.data != -1 && y.data != -1){
			return root.data;
		} else if(root.data == p || root.data == q) {
			return root.data;
		} else if(x.data == -1 && y.data != -1){
			return y.data;
		} else if(x.data != -1 && y.data == -1){
			return x.data;
		} else {
			return -1;
		}
    }
}