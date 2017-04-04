// BinaryTreeFindMax.java

class BSTFindMax {
	
	public TreeNode find(TreeNode root) {
		if (root != null) {
			while(root.getRight() != null) {
				root = root.getRight();
			}
			return root;
		}
		return null;
	}
}

class BTFindMax {
	
	private int max;
	public int getMax() {
		return max;
	}
	
	public void find(TreeNode root) {
		if (root != null) {
			if(root.getLeft() != null){
					if(root.getData() > root.getLeft().getData()) {
						if(root.getData() > max)
							max = root.getData();
					}else {
						if(root.getLeft().getData() > max)
							max = root.getLeft().getData();
					}
			}
			find(root.getLeft());
			if(root.getRight() != null) {
				if(root.getData() > root.getRight().getData()) {
					if(root.getData() > max)
						max = root.getData();
				}else {
					if(root.getRight().getData() > max)
						max = root.getRight().getData();
				}
			}
			find(root.getRight());
		}	
	}
}

class BinaryTreeFindMax {
	
	public static void main(String s[]) {
		
		TreeNode root = new TreeNode(5);
		
		BinaryTree bt = new BinaryTree(root);
		bt.insert(root ,new TreeNode(3));
		bt.insert(root , new TreeNode(4));
		bt.insert(root , new TreeNode(8));
		bt.insert(root , new TreeNode(6));
		bt.insert(root , new TreeNode(1));
		bt.insert(root , new TreeNode(9));
		bt.inorder(root);
		BSTFindMax f = new BSTFindMax();
		TreeNode node = f.find(root);
		if (node != null) {
			System.out.println("Max node in BST: "+ node.getData());
		}else {
			System.out.println("Empty tree");
		}
		root.setLeft(new TreeNode(8));
		root.setRight(new TreeNode(1));
		root.getLeft().setLeft(new TreeNode(10));
		root.getLeft().setRight(new TreeNode(12));
		
		BTFindMax btf = new BTFindMax();
		btf.find(root);
		System.out.println("Max in Binary Tree: "+ btf.getMax());
	}
}