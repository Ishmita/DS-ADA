// GenerateBT.java

class Generate {
	public TreeNode generate(String s , int i) {
		if (s.length() != 0) {
			int data = Integer.parseInt(s.substring(0,1));
			TreeNode root = new TreeNode(data);
			System.out.println("node: "+ root + " data: "+ data);
			if (data == 1) {
				root.setLeft(generate(s.substring(i, s.length()) , 1));
				System.out.println("node: "+ root + " left: "+ root.getLeft().getData());				
				i++;
				root.setRight(generate(s.substring(i, s.length()) , 1));
				System.out.println("node: "+ root + " right: "+ root.getRight().getData());				
			} else if (data == 0) {
				return root;
			} 
			return root;
		} else {
			return null;
		}
	}
}

class GenerateBT {
	
	public static void main(String s[]) {
		Generate g = new Generate();
		TreeNode root = g.generate("10100" , 1);
		
		if (root != null) {
			BinaryTree bt = new BinaryTree(root);
			bt.inorder(root);
		}
	}
}