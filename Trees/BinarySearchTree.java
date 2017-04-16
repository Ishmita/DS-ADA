// BinaryTreeTest.java
import java.util.*;
class TreeNode {
	private int a;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int a) {
		this.a = a;
		left = null;
		right = null;
	}
	public int getData() {
		return a;
	}
	
	public void setData(int a) {
		this.a = a;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}
}

class BinaryTree {
	
	private TreeNode root;
	
	public BinaryTree(TreeNode root) {
		this.root = root;
		this.nodes = new ArrayList<TreeNode>();
	}
	
	private ArrayList<TreeNode> nodes;
	
	public void insert(TreeNode root ,  TreeNode node) {
		if(root != null) {
			if(node.getData() > root.getData()) {
				if(root.getRight() == null) {
					root.setRight(node);
				}else {
					insert(root.getRight() , node);
				}
			} else {
				if(root.getLeft() == null) {
					root.setLeft(node);
				}else {
					insert(root.getLeft() , node);
				}
			}
		} else {
			root = node;
		}
	}
	
	public void delete (int key) {
		root = del(root , key);
	} 
	
	private TreeNode del(TreeNode root,int data) {
		TreeNode node = null;
		if(root == null) {
			return root;
		}
		
		if (data < root.getData()) {
			root.setLeft(del(root.getLeft(), data));
		}
		else if (data > root.getData()) {
			root.setRight(del(root.getRight(), data));
		}
		
		else {
			if (root.getLeft() == null) 
				return root.getRight();
			else if (root.getRight() == null) 
				return root.getLeft();
			else {
				root.setData(minValue(root.getRight()));
				
				root.setRight(del(root.getRight() , root.getData()));
			}
		}
		
		return root;
	}
	
	private int minValue(TreeNode node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node.getData();
	}
	
	public void search( TreeNode root, int data) {
		if(root != null) {
			if (data == root.getData()) {
				System.out.println(""+root.getData() +" found");
			}
			search(root.getRight() , data);
			search(root.getLeft() , data);
		}
	}
	
	public void inorder(TreeNode root) {
		if(root != null) {
			inorder(root.getLeft());
			System.out.println(""+root.getData());
			inorder(root.getRight());
		}
	}
	
	public void preorder(TreeNode root) {
		if(root != null) {
			System.out.println(""+root.getData());
			inorder(root.getLeft());
			inorder(root.getRight());
		}
	}
	
	public void postorder(TreeNode root) {
		if(root != null) {
			inorder(root.getLeft());
			inorder(root.getRight());
			System.out.println(""+root.getData());
		}
	}
	
	public void levelorder(TreeNode root) {
		if(root != null) {
			nodes.add(root);
			TreeNode node = nodes.remove(0);
			while (true){
				System.out.println("" + node.getData());
				if (node.getLeft() != null) {
					nodes.add(node.getLeft());
				}
				if (node.getRight() != null) {
					nodes.add(node.getRight());
				}
				try {
					node = nodes.remove(0);
				} catch(IndexOutOfBoundsException e) {
					break;
				}	
			}
		}
	}
}

class BinarySearchTree {
	public static void main(String s[]) {
		
		TreeNode root = new TreeNode(7);
		
		BinaryTree bt = new BinaryTree(root);
		bt.insert(root ,new TreeNode(2));
		bt.insert(root , new TreeNode(4));
		bt.insert(root ,new TreeNode(3));		
		bt.insert(root , new TreeNode(8));
		bt.insert(root , new TreeNode(6));
		bt.insert(root , new TreeNode(1));
		bt.insert(root , new TreeNode(9));
		bt.insert(root , new TreeNode(12));
		bt.inorder(root);
		bt.search(root , 6);
		bt.delete(2);
		bt.inorder(root);
		System.out.println("level order: ");
		bt.levelorder(root);
		
	}
}