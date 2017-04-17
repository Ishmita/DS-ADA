// WidthBT.java

//TimeComplexity: O(n) , Space Complexity : O(n)
import java.util.*;

class TreeWidth {
	private int width;

	public int getWidth() {
		return width;
	}
	public void calculateWidth(TreeNode root) {
		if (root == null) {
			return;
		}
		
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		int count = 0;
		queue.add(root);
		count++;
		width = count;
		
		while(queue.size() != 0) {
			TreeNode node = queue.get(0);
			queue.remove(node);
			count--;
			
			if(node.getLeft() != null) 
				queue.add(node.getLeft());
			if(node.getRight() != null) 
				queue.add(node.getRight());
			
			if (count == 0) 
				count = queue.size();
			if(width < count) 
				width = count;
		}
		
	}
} 

class WidthBT {
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
		bt.insert(root , new TreeNode(0));
		bt.insert(root , new TreeNode(10));
		bt.insert(root , new TreeNode(5));
		bt.insert(root , new TreeNode(15));
		bt.inorder(root);
		TreeWidth width = new TreeWidth();
		width.calculateWidth(root);
		System.out.println("Width: "+ width.getWidth());
	}
}