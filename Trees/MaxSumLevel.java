// MaxSumLevel.java

//TimeComplexity: O(n) , Space Complexity : O(n)
import java.util.*;

class TreeLevelSum {
	private int level;
	private int sum;

	public int getLevel() {
		return level;
	}
	public void calWidhSum(TreeNode root) {
		if (root == null) {
			return;
		}
		
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		int count = 0;
		queue.add(root);
		count++;
		sum = root.getData();
		int s = sum , l = 0;
		while(queue.size() != 0) {
			TreeNode node = queue.get(0);
			queue.remove(node);
			count--;
			
			if (count == 0) {
				l++;
				if (sum < s) {
					sum = s;
					level = l;
				}
				s = 0;
			}
			
			if(node.getLeft() != null) {
				queue.add(node.getLeft());
				s += node.getLeft().getData();
			}
			if(node.getRight() != null) {
				queue.add(node.getRight());
				s += node.getRight().getData();
			}
			
			if (count == 0 && queue.size() != 0) { 
				count = queue.size();
			}
		}
		
	}
} 

class MaxSumLevel {
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
		TreeLevelSum sum = new TreeLevelSum();
		sum.calWidhSum(root);
		System.out.println("Level with max sum: "+ (sum.getLevel()-1));
	}
}