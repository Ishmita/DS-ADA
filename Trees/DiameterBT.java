// DiameterBT.java

// Time Complexity: O(n) , Space Complexity: O(n)

class Diameter {
	private int height;
	
	public int getHeight() {
		return height;
	}
	public void diameter (TreeNode root) {		
		calculate(root);
	}
	public int calculate (TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left;
		int right = left = 0;
		
		if (root.getLeft() != null) {
			left = calculate(root.getLeft());
			left++;
		}
		if (root.getRight() != null) {
			right = calculate(root.getRight());
			right++;
		}
		int ht = left + right + 1;
		if (height < ht) 
			height = ht;
		return (left > right ? left : right);	
	}
}

class DiameterBT {
	public static void main(String s[]) {
		TreeNode root = new TreeNode(5);
		
		BinaryTree bt = new BinaryTree(root);
		bt.insert(root ,new TreeNode(2));
		bt.insert(root , new TreeNode(4));
		bt.insert(root ,new TreeNode(3));		
		//bt.insert(root , new TreeNode(8));
		//bt.insert(root , new TreeNode(6));
		bt.insert(root , new TreeNode(1));
		//bt.insert(root , new TreeNode(9));
		//bt.insert(root , new TreeNode(12));
		bt.inorder(root);
		Diameter d = new Diameter();
		d.diameter(root);
		System.out.println("Diameter: "+d.getHeight());
	}
}