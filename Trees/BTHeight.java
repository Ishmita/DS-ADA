// BTHeight.java

// Time Complexity: O(n) , Space Complexity: O(n)

class Height {
	
	private int height;
	private int maxHt;
	
	public int getMaxHt() {
		return maxHt;
	}
	
	public void find(TreeNode root) {
		if(root!= null) {
			int count = height;
			if(root.getLeft() != null) {
				height ++;
				find(root.getLeft());
			}
			maxHt = height;
			if(root.getRight()!= null) {
				height = count + 1;
				find(root.getRight());
			}
			if(height > maxHt) {
				maxHt = height;
			}
		}
	}
}

class BTHeight {
	
	public static void main(String s[]) {
		TreeNode root = new TreeNode(5);
		
		BinaryTree bt = new BinaryTree(root);
		bt.insert(root ,new TreeNode(3));
		bt.insert(root , new TreeNode(4));
		bt.insert(root , new TreeNode(8));
		bt.insert(root , new TreeNode(6));
		bt.insert(root , new TreeNode(2));
		bt.insert(root , new TreeNode(9));
		bt.insert(root , new TreeNode(12));
		System.out.println("Inorder: ");
		bt.inorder(root);
		
		Height h = new Height();
		h.find(root);
		System.out.println("Height of binary tree: " + h.getMaxHt());		
	}
}