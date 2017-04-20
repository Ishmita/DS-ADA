// PreorderThreadedBST

class PreBST {
	private ThreadedNode root;
	private Stack<ThreadedNode> stack;
	
	public PreBST (ThreadedNode root) {
		this.root = root; 
		stack = new Stack<ThreadedNode>();
	}
	
	public void insert(ThreadedNode root , ThreadedNode node) {
		if(root != null) {
			if(node.getData() > root.getData()) {
				if(root.getRight() == null) {
					root.setRight(node);
				}else {
					insert(root.getRight() , node);
				}
			} else {
				if(root.getLeft() == null) {
					root.setLeft(node);
				}else {
					insert(root.getLeft() , node);
				}
			}
		} else {
			root = node;
		}
	}
	
	public void make(ThreadedNode root) {
		if (root != null) {
			try {
				stack.push(root);
				while(stack.getTop() != -1) {
					ThreadedNode n = stack.pop();
					if (n.getRight() != null) {
						stack.push(n.getRight());
					} else if(stack.getTop() != -1) {
						n.setRptr(stack.getTopElement());
					} 
					if (n.getLeft() != null) {
						stack.push(n.getLeft());
					}
					
				}		
			}catch(Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	public void preorder(ThreadedNode root) {
		while (root != null) {
			System.out.println(""+ root.getData());
			if (root.getLeft() != null) {
				root = root.getLeft();
			} else if (root.getRptr() != null) {
				root = root.getRptr();
			} else {
				root = root.getRight();
			}
		}
	}
}

class PreorderThreadedBST {
	
	public static void main(String s[]) {
	    ThreadedNode root = new ThreadedNode(7);
		
		PreBST bt = new PreBST(root);
		bt.insert(root , new ThreadedNode(2));
		bt.insert(root , new ThreadedNode(4));
		bt.insert(root ,new ThreadedNode(3));		
		bt.insert(root , new ThreadedNode(8));
		bt.insert(root , new ThreadedNode(6));
		bt.insert(root , new ThreadedNode(1));
		bt.insert(root , new ThreadedNode(9));
		bt.insert(root , new ThreadedNode(12));

		bt.make(root);
		bt.preorder(root);
	}
}