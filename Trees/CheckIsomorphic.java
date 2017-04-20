// CheckIsomorphic.java
// Time Complexity: O(n) , Space Complexity: O(n)
class Isomorphic {
	
	public boolean check(TreeNode root1 , TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		
		if ((root1 != null && root2 == null) || (root1 == null && root2 != null)) {
			return false;
		}
		
		return (check(root1.getLeft() , root2.getLeft()) && check(root1.getRight() , root2.getRight()));
	}
}

class CheckIsomorphic {
	
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
		
		TreeNode root2 = new TreeNode(14);
		
		BinaryTree bt2 = new BinaryTree(root2);
		bt2.insert(root2 ,new TreeNode(4));
		bt2.insert(root2 , new TreeNode(8));
		bt2.insert(root2 ,new TreeNode(6));		
		bt2.insert(root2 , new TreeNode(16));
		bt2.insert(root2 , new TreeNode(12));
		bt2.insert(root2 , new TreeNode(2));
		bt2.insert(root2 , new TreeNode(18));
		bt2.insert(root2 , new TreeNode(24));
		Isomorphic i = new Isomorphic();
		boolean status = i.check(root , root2);
		System.out.println("are isomorphic: " + status);
	}
} 