// BalancedTreeFromArray.java
// Time Complexity: O(n) , Space Complexity: O(n)

class CreateBalancedtree {
	
	public TreeNode create(int a[] , int start , int end) {
		if (a.length <= 0 || start > end) {
			return null;
		}
		
		if (end == start) {
			TreeNode node = new TreeNode(a[start]);
			return node;
		}
		try {
			int mid = start + (int) Math.floor((end - start + 1)/2);
			System.out.println("mid: "+ mid);
			TreeNode root = new TreeNode(a[mid]);
			
			TreeNode left = create(a , start , mid - 1);
			root.setLeft(left);
			TreeNode right = right = create(a, mid + 1 , end);
			root.setRight(right);
		
		return root;
		} catch (Exception e) {
			
		}
		return null;
	}
}

class BalancedTreeFromArray {
	public static void main(String s[]) {
		int a[] = {1, 3 , 5 , 6 , 8};
		
		CreateBalancedtree t = new CreateBalancedtree();
		TreeNode root = t.create(a , 0 , a.length-1);
		
		if (root != null) {
			BinaryTree bt = new BinaryTree(root);
			bt.inorder(root);			
		}
	}
}