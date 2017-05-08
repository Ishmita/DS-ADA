// PrintInRange.java

class Print {
	
	private boolean inRange;
	
	public void print(TreeNode root , int k1 , int k2) {
		if (root != null) {
			print(root.getLeft() , k1 , k2);
			int temp = k1 > k2 ? k2 : k1;
			k2 = k1 > k2 ? k1 : k2;
			k1 = temp;
			
			if (root.getData() >= k1) {
				inRange = true;
			}
			
			if (root.getData() >= k2) {
				inRange = false;
			}
			
			if (inRange) 
				System.out.println(root.getData());
			
			print(root.getRight() , k1 , k2);
		}
	}
}

class PrintInRange {
	
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
		System.out.println("Inorder: ");
		bt.inorder(root);
		System.out.println("\nIn range: ");		
		Print p = new Print();
		p.print(root , 5 , 13);
	}
}