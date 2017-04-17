// PrintAllPaths.java
// Time Complexity: O(n) , Space Complexity: O(n)

class PrintPaths {
	private String path= "";
	
	public void print(TreeNode root) {
		if (root == null)
			return;
		
		String pth = "";
		path = path +  root.getData() + " ";
		pth = path;
		if (root.getLeft() == null && root.getRight() == null) {
			System.out.println(path);
			return;
		}
		print(root.getLeft());
		path = pth;
		print(root.getRight());
	} 
}

class PrintAllPaths {
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
		System.out.println();
		PrintPaths paths = new PrintPaths();
		paths.print(root);
	}
}