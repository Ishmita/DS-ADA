// BinaryTreeTest.java

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
	}
	
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
	
	public TreeNode delete() {
		return null;
	}
	
	public TreeNode search( TreeNode root, int data) {
		if(root != null) {
			if (data == root.getData()) {
				return root;
			}
			search(root.getRight() , data);
			search(root.getLeft() , data);
		}
		return null;
	}
	
	public void inorder(TreeNode root) {
		if(root != null) {
			inorder(root.getLeft());
			System.out.println(""+root.getData());
			inorder(root.getRight());
		}
	}
	
	public void preorder() {
		if(root != null) {
			System.out.println(""+root.getData());
			inorder(root.getLeft());
			inorder(root.getRight());
		}
	}
	
	public void postorder() {
		if(root != null) {
			inorder(root.getLeft());
			inorder(root.getRight());
			System.out.println(""+root.getData());
		}
	}
	
	public void levelorder() {
		
	}
}

class BinaryTreeTest {
	public static void main(String s[]) {
		
		TreeNode root = new TreeNode(5);
		
		BinaryTree bt = new BinaryTree(root);
		bt.insert(root ,new TreeNode(3));
		bt.insert(root , new TreeNode(4));
		bt.insert(root , new TreeNode(8));
		bt.insert(root , new TreeNode(6));
		bt.insert(root , new TreeNode(1));
		bt.insert(root , new TreeNode(9));
		bt.insert(root , new TreeNode(12));
		bt.inorder(root);
		TreeNode node = bt.search(root , 6);
		if(node != null) {
			System.out.println(""+node.getData());
		}else {
			System.out.println("not found");
		}
	}
}