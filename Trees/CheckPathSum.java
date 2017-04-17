// CheckPathSum.java
// Time Complexity: O(n) , Space Complexity: O(n)

class CheckSum {
	private int sum;
	
	public boolean print(TreeNode root, int check) {
		if (root == null)
			return false;
		
		int s = 0;
		sum = sum + root.getData();
		s = sum;
		boolean res = false, res1= false;
		if (s == check) {
			System.out.println("Yes sum present");
			return true;
		}
		if (root.getLeft() != null) {
			res = print(root.getLeft() , check);
			sum = s;
		}
		if (root.getRight() != null) {
			res1 = print(root.getRight() , check);
		}
		if(res || res1) {
			return true;
		}
		return false;
	} 
}

class CheckPathSum {
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
		CheckSum sum = new CheckSum();
		if(!sum.print(root , 13)){
			System.out.println("Sum not present");
		}
	}
}