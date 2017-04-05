// ReverseLevelorder.java

??Time Complexity: O(n) , Space Complexity: O(n)
import java.util.*;
class ReverseOrder {
	
	public void reverse(TreeNode root) {
		if (root != null) {
			ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
			nodes.add(root);
			Stack<TreeNode> stack = new Stack<TreeNode>();
			
			while (true) {
				try {
					TreeNode node = nodes.remove(0);
					stack.push(node);
					if (node.getLeft() != null) {
						nodes.add(node.getLeft());
					}
					if (node.getRight() != null) {
					  	nodes.add(node.getRight());
					}
				} catch(IndexOutOfBoundsException e) {
					break;
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			while (stack.getTop() != -1) {
				try {
					System.out.println(""+stack.pop().getData());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class ReverseLevelorder {
	public static void main(String s[]) {
		TreeNode root = new TreeNode(5);
		
		BinaryTree bt = new BinaryTree(root);
		bt.insert(root ,new TreeNode(3));
		bt.insert(root , new TreeNode(4));
		bt.insert(root , new TreeNode(8));
		bt.insert(root , new TreeNode(6));
		bt.insert(root , new TreeNode(2));
		bt.insert(root , new TreeNode(9));
		bt.insert(root , new TreeNode(12));
		System.out.println("Inorder: ");
		bt.inorder(root);
		
		ReverseOrder r = new ReverseOrder();
		System.out.println("Reverse level order: ");
		r.reverse(root);
	}
}