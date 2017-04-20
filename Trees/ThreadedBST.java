// ThreadedBST.java

class ThreadedNode {
	
	int data;
	ThreadedNode left;
	ThreadedNode right;
	ThreadedNode lptr, rptr;
	
	public ThreadedNode(int data) {
		this.data = data;
		left = right = lptr = rptr = null;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public void setLeft(ThreadedNode left) {
		this.left = left;
	}
	public ThreadedNode getLeft() {
		return left;
	}
	
	public void setRight(ThreadedNode right) {
		this.right = right;
	}
	public ThreadedNode getRight() {
		return right;
	}
	
	public void setLptr(ThreadedNode lptr) {
		this.lptr = lptr;
	}
	public ThreadedNode getLptr() {
		return lptr;
	}
	
	public void setRptr(ThreadedNode rptr) {
		this.rptr = rptr;
	}
	public ThreadedNode getRptr() {
		return rptr;
	}
}
class InorderThreadedBT {
	
	private ThreadedNode root;
	private Stack<ThreadedNode> stack;
	
	public InorderThreadedBT (ThreadedNode root) {
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
				make(root.getLeft());
				ThreadedNode n = stack.pop();
				if(root.getRight() != null) { 
					make(root.getRight());
				} else if (root.getRight() == null && stack.getTop() != -1){
					n.setRptr(stack.getTopElement());
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void inorder(ThreadedNode root) {
		while (root != null && root.getLeft() != null) {
			root = root.getLeft();
		}
		
		while (root != null){
			System.out.println(""+ root.getData());
			if (root.getRight() != null) {
				root = root.getRight();
			} else {
				root = root.getRptr();
			}
		}
	}
}

class ThreadedBST {
	
	public static void main(String s[]) {
	    ThreadedNode root = new ThreadedNode(7);
		
		InorderThreadedBT bt = new InorderThreadedBT(root);
		bt.insert(root , new ThreadedNode(2));
		bt.insert(root , new ThreadedNode(4));
		bt.insert(root ,new ThreadedNode(3));		
		bt.insert(root , new ThreadedNode(8));
		bt.insert(root , new ThreadedNode(6));
		bt.insert(root , new ThreadedNode(1));
		bt.insert(root , new ThreadedNode(9));
		bt.insert(root , new ThreadedNode(12));

		bt.make(root);
		bt.inorder(root);
	}
}