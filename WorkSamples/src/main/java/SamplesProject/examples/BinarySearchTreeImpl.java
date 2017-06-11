package SamplesProject.examples;

import java.util.Vector;

public class BinarySearchTreeImpl{
	
	public BinarySearchTreeImpl(){
	  BinarySearchTree bst = new BinarySearchTree();

      bst.insert(10);
      bst.insert(8);
      bst.insert(7);
      bst.insert(6);
      bst.insert(5);
      System.out.print("\nInorder : ");
      bst.printInorder(bst.root);
      System.out.print("\nPreorder : ");
      bst.printPreorder(bst.root);
      System.out.print("\nPostorder : ");
      bst.printPostorder(bst.root);
      
      System.out.println("\nMax element in BST : " + bst.maxBST(bst.root));
      System.out.println("Min element in BST : " + bst.minBST(bst.root));

      System.out.println("Depth :" + bst.depthBST(bst.root));
      
      bst.predecessorSuccessorBST(bst.root, 8);
      System.out.println("Predecessor of K : " + bst.predecessor + "\nSuccessor of K : " + bst.successor);
      
      bst.root = createBalancedTree(bst.root);
      System.out.print("Balanced tree Inorder : ");
      bst.printInorder(bst.root);
	}
	

    /* Create a balanced BST given sorted inorder of BST */
    public static Nodes createBalancedTree(Nodes head){
	    Vector<Nodes> nodes = new Vector<Nodes>();
	    	storeSortedOrder(head, nodes);
	    	int n = nodes.size();
	    	return buildTree(nodes, 0, n-1);
    }
    
    /* Storing sorted order of BST */
    private static void storeSortedOrder(Nodes head, Vector<Nodes> nodes){
    		if(head == null)
    			return;
    		if(head != null){
    			storeSortedOrder(head.left, nodes);
    			nodes.add(head);
    			storeSortedOrder(head.right, nodes);
    		}
    }
    
    /* Building balanced BST from vector of nodes */
    private static Nodes buildTree(Vector<Nodes> nodes, int start, int end){
    		if(start > end)
    			return null;
    		int mid = (start+end)/2;
    		Nodes newNode = nodes.get(mid);
    		newNode.left = buildTree(nodes, start, mid-1);
    		newNode.right = buildTree(nodes, mid+1, end);
    		return newNode;
    }
}

class BinarySearchTree{
	Nodes root = null;
	static int predecessor;
	static int successor;
	
	BinarySearchTree(){
		
	}
	
	public void insert(int i){
		Nodes newNode = new Nodes(i);
		if(root == null){
			root = newNode;
			return;
		}
		Nodes current = root;
		Nodes parent = null;
		while(true){
			parent = current;
			if(current.data > i){
				current = current.left;
				if(current == null){
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if(current == null){
					parent.right = newNode;
					return;
				}
			}	
		}	
	}
	
	public int depthBST(Nodes head){
		Nodes current = head;
		if(current == null)
			return 0;
		
		if(current.right == null && current.left == null)
			return 1;
	
		if(current.left == null && current.right != null)
			return depthBST(current.right);
		
		if(current.left != null && current.right == null)
			return depthBST(current.left);
		
		return Math.min(depthBST(current.left), depthBST(current.right)) + 1;
	}
	
	public void predecessorSuccessorBST(Nodes head, int K){
		if(head != null){
			if(head.data == K){
				if(head.left != null){
					Nodes temp = head.left;
					while(temp.right != null){
						temp = temp.right;
					}
					predecessor = temp.data;
				}
				if(head.right != null){
					Nodes temp = head.right;
					while(temp.left != null){
						temp = temp.left;
					}
					successor = temp.data;
				}
			} else if(head.data < K){
				//parent/head is the predecessor if the next node doesn't have right subtree
				predecessor = head.data;
				predecessorSuccessorBST(head.right, K);
			} else if(head.data > K){
				//parent/head is the successor if the next node doesn't have right subtree
				successor = head.data;
				predecessorSuccessorBST(head.left, K);
			}
		}	
	}
	
	public int maxBST(Nodes head){
		Nodes current = head;
		while(current.right != null){
			current = current.right;
		}
		return current.data;
	}
	
	public int minBST(Nodes head){
		Nodes current = head;
		while(current.left != null){
			current = current.left;
		}
		return current.data;
	}
	
	public void printInorder(Nodes head){
		Nodes current = head;
		if(current != null){
			printInorder(current.left);
			System.out.print(" " + current.data);
			printInorder(current.right);
		}
	}
	
	public void printPostorder(Nodes head){
		Nodes current = head;
		if(current != null){
			printPostorder(current.left);
			printPostorder(current.right);
			System.out.print(" " + current.data);
		}
	}

	public void printPreorder(Nodes head){
		Nodes current = head;
		if(current != null){
			System.out.print(" " + current.data);
			printPreorder(current.left);
			printPreorder(current.right);
		}
	}
}

class Nodes{
	Nodes left;
	Nodes right;
	int data;
	
	Nodes(){
	
	}

    Nodes(int i){
		this.left = null;
		this.right = null;
		this.data = i;
	}
}