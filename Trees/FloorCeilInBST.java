// FloorCeilInBST.java
// Time Complexity: O(n) , Space Complexity: O(n)
class Find {
	
	private TreeNode prev, bigger; 
	private String res = "";
	boolean set;
	
	public void find (TreeNode root, int key) {
		
		if (root == null) {
			return;
		}
		if (!set)
			res = "-1 " + root.getData();
		
		find (root.getLeft() , key);
		
		if (root.getData() >= key && !set) {
			set = true;
			if (prev != null && root.getData() != key) {
				res = ("" + prev.getData()) + (" " + root.getData());
			} else if (root.getData() == key){
				res = ("" + root.getData()) + (" " + root.getData());
			}
			
		}
		prev = root;
		find(root.getRight() , key);
		if (prev.getData() < key) {
			res = prev.getData() + " -1";
		}
	}
	
	public String getRes() {
		return res;
	}
}

class FloorCeilInBST {
	
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
		
		Find f = new Find();
		f.find(root  , 10);
		String res = f.getRes();
		if (res.length() > 0) {
			String r[] = res.split(" ");
			if (!r[0].equals("-1"))
				System.out.println("floor: "+r[0]);
			if (!r[1].equals("-1"))
				System.out.println("ceil: "+r[1]);
		}
	}
}

