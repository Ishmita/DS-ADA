// AVLTreeConstruction.java

class AVLTreeNode {
	
	private int data , height;
	private AVLTreeNode left , right;
	
	public AVLTreeNode(int data) {
		this.data = data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	
	public void setHeight(int heigth) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}
	
	public void setLeft(AVLTreeNode left) {
		this.left = left;
	}
	public AVLTreeNode getLeft() {
		return left;
	}
	
	public void setRight(AVLTreeNode right) {
		this.right = right;
	}
	public AVLTreeNode getRight() {
		return right;
	}
	
}
class AVLTree {
	
	private AVLTreeNode root;
	
	public AVLTree(AVLTreeNode root) {
		this.root = root;
	}
	
	public int height(AVLTreeNode node) {
		return (node == null ? 0 : node.getHeight());
	}
	
    // Time Complexity: O(logn) , Space Complexity: O(n)
	public AVLTreeNode insert(AVLTreeNode root , int data) {
		if (root == null) {
			AVLTreeNode node = new AVLTreeNode(data);
			root = node;
			return root;
		} else if (data < root.getData()) {
			root.setLeft(insert(root.getLeft() , data));
				
			if (Math.abs(height(root.getLeft()) - height(root.getRight())) == 2) {
				if (data < root.getLeft().getData())
					root = RRRotation(root);
				else 
					root = DoubleLRRotation(root);
			} 
		} else if (data > root.getData()){
				root.setRight(insert(root.getRight() , data));
				if (Math.abs(height(root.getLeft()) - height(root.getRight())) == 2) {
					if (data > root.getRight().getData())
						root = LLRotation(root);
					else 
						root = DoubleRLRotation(root);
				}
		} else 
			root.setHeight((height(root.getLeft()) > height(root.getRight()) ? height(root.getLeft()) : height(root.getRight())) + 1);
		return root;
	}

	/** 
	* New node inserted into the right of the right subtree 
	* of the first unbalanced node from the point of insertion.
	* Time Complexity: O(1), Space Complexity: O(1)
	* 6				<- first unbalanced node
	*  \
	*   8
	*    \
	*     10		<- new node
	*/
	
	private AVLTreeNode LLRotation(AVLTreeNode root) {
		AVLTreeNode temp = root;
		root = root.getRight();
		temp.setRight(root.getLeft());
		temp.setHeight((height(temp.getLeft()) > height(temp.getRight()) ? height(temp.getLeft()) : height(temp.getRight())) + 1);
		root.setLeft(temp);
		root.setHeight((height(root.getLeft()) > height(root.getRight()) ? height(root.getLeft()) : height(root.getRight())) + 1);
		return root;
	}
	
	/** 
	* New node is inserted at the left of the left subtree of the 
	* first unbalanced node from the point of insertion.
	* Time Complexity: O(1), Space Complexity: O(1)
	* 		6			<- first unbalanced node
	*      /
	*     4
	*    /
	*   2				<- new node
	*/
	
	private AVLTreeNode RRRotation(AVLTreeNode root) {
		AVLTreeNode temp = root;
		root = root.getLeft();
		temp.setLeft(root.getRight());
		temp.setHeight((height(temp.getLeft()) > height(temp.getRight()) ? height(temp.getLeft()) : height(temp.getRight())) + 1);
		root.setRight(temp);
		root.setHeight((height(root.getLeft()) > height(root.getRight()) ? height(root.getLeft()) : height(root.getRight())) + 1);
		return root;
	}
	
	/**
	* New node is inserted into the right subtree of the left subtree 
	* of the first unbalanced node from the point of insertion.
	* Time Complexity: O(1), Space Complexity: O(1)
	* 		8		<- first unbalanced node
	*	   /
	*     5
	*      \
	*       7		<- new node
	*/
	
	private AVLTreeNode DoubleLRRotation(AVLTreeNode root) {
		AVLTreeNode left = root.getLeft();
		root.setLeft(LLRotation(left));
		return RRRotation(root);
	}
	
	/** 
	* New node is inserted into the left subtree of the right 
	* subtree of the first unbalanced node from the insertion point.
	* Time Complexity: O(1), Space Complexity: O(1)
	* 		8			<- first unbalanced node
	*		 \
	*		  10
	*        /
	*       9			<- new node
	*/
	
	private AVLTreeNode DoubleRLRotation(AVLTreeNode root) {
		AVLTreeNode right = root.getRight();
		root.setRight(RRRotation(right));
		return LLRotation(root);
	}
	
	public void inorder(AVLTreeNode root) {
		if (root != null) {
			inorder(root.getLeft());
			System.out.println(""+root.getData());
			inorder(root.getRight());
		}
	}
}

class AVLTreeConstruction {
	
	public static void main(String s[]) {
		
		AVLTreeNode root = new AVLTreeNode(7);
		AVLTree tree = new AVLTree(root);
		
		tree.insert(root, 5);
		tree.insert(root, 9);
		tree.insert(root, 3);
		tree.insert(root, 4);
		tree.insert(root, 1);
		tree.insert(root, 8);
		tree.inorder(root);
	}
}