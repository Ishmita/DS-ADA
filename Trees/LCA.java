// LCA.java
// Time Complexity: O(n) , Space Complexity: O(n)
import java.util.*;
class FindLCA {
	private TreeNode root;
	private boolean finished;
	// at max of size 3.
	ArrayList<TreeNode> ancestor = new ArrayList<TreeNode>();
	
	public TreeNode getAncestor() {
		if (ancestor.size() != 3) {
			return null;
		}
		return ancestor.get(2);
	}
	
	public void find(TreeNode root , int a1 , int a2) {
		if (root == null) {
			return;
		}
		
		if (this.root == null)
			this.root = root;
		
		System.out.println("root: "+ this.root.getData());		
		System.out.println("node: "+ root.getData());
		if((root.getData() == a1 || root.getData() == a2)) {
			ancestor.add(root);
			System.out.println("matched: "+ root.getData());
		}
		if (ancestor.size() == 2)
			return;
		
		find(root.getLeft(), a1, a2);
		
		if(ancestor.size() == 1 && root == this.root) {
			ancestor.add(root);
			System.out.println("reached root from left ");
		}
		
		find(root.getRight(), a1, a2);
		
		if (ancestor.size() > 0 && root == ancestor.get(0))
			finished = true;
		if(ancestor.size() == 2 && finished) { 
			ancestor.add(root);
			System.out.println("ancestor: "+ root.getData());			
		}
		
		if(root == this.root) {
			if (ancestor.size() != 3) { 
				ancestor.clear();		
				System.out.println("not matched other ");
			} else if (ancestor.contains(this.root)){
				TreeNode temp = ancestor.get(2) , temp2 = ancestor.get(1);
				ancestor.remove(temp);
				ancestor.remove(temp2);
				ancestor.add(temp);
				ancestor.add(temp2);
			}
		}
	}
}

class LCA {
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
		bt.insert(root , new TreeNode(10));
		bt.insert(root , new TreeNode(15));
		bt.inorder(root);
		FindLCA lca = new FindLCA();
		lca.find(root , 15 , 10);
		TreeNode ann = lca.getAncestor();
		if (ann != null) {
			System.out.println("Ancestor: "+ann.getData());
		} else {
			System.out.println("Invalid input");
		}
	}
}