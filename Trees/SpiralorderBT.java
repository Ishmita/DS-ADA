// SpirlorderBT.java
import java.util.*;
class Spiralorder {
	private int level, count;
	
	public void spiral(TreeNode root) {
		if (root == null)
			return;
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		count++;
		Stack<Integer> stack = new Stack<Integer>();
		
		while (queue.size() != 0) {
			TreeNode node = queue.get(0);
			queue.remove(node);
			count--;
			if(level%2 != 0) {
				try {
					stack.push(node.getData());
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(node.getData()+" ");
			}
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if(node.getRight() != null) {
				queue.add(node.getRight());
			}				
			
			if (count == 0){
				count = queue.size();
				if (level%2 != 0) {
					while(true){
							try{
							System.out.println(stack.pop() + " ");
							} catch(Exception e) {
								break;
							}
					}
				}
				level++;
			}	

		}
	}
}

class SpiralorderBT {
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
		//bt.inorder(root);
		Spiralorder so = new Spiralorder();
		so.spiral(root);
	}
}