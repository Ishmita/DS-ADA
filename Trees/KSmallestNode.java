// KSmallestNode.java

class FindNode {
	
	private int count; 
	
	public void find(TreeNode root , int k) {	
		if (root != null) {
			find(root.getLeft() , k);
			count++;
			if (count == k) {
				System.out.println("k = " + k + " smallest: " + root.getData());
			}
			find(root.getRight() , k);
		}
	}
}

class KSmallestNode {
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
		FindNode n = new FindNode();
		n.find(root , 5);
	}
}