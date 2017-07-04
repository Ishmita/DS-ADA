// TernarySearchTree.java

class Node {
	
	private char data;
	private boolean end;
	private Node less, greater, equal;
	
	public Node(char data) {
		this.data = data;
		end = false;
		less = greater = equal = null;
	}
	
	public char getData() {
		return data;
	}
	
	public Node getLess() {
		return less;
	}
	
	public Node getGreater() {
		return greater;
	}
	
	public Node getEqual() {
		return equal;
	}
	
	public void setData(char d) {
		data = d;
	}
	
	public void setLess(Node l) {
		less = l;
	}
	
	public void setGreater(Node g) {
		greater = g;
	}
	
	public void setEqual(Node e) {
		equal = e;
	}
	
	public void setEnd(boolean e) {
		end = e;
	}
	
	public boolean isEnd() {
		return end;
	}
}

class TST {
	
	private Node head;
	private boolean found;
	
	public void setHead(Node h) {
		head = h;
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node insert(Node node, char data[], int i) {
		if (node == null)
			node = new Node(data[i]);
		if (head == null) {
			head = node;
		}
		
		if (node.getData() > data[i]) {
			node.setLess(insert(node.getLess(), data, i));
		} else if (data[i] > node.getData()) {
			node.setGreater(insert(node.getGreater(), data, i));
		} else {
			if (i < data.length - 1) {
				node.setEqual(insert(node.getEqual(), data, i+1));
			} else {
				node.setEnd(true);
			}
		}
		return node;
	}
	
	public boolean search(Node head, char str[], int i, int m) {
		Node temp = head;
		if (head == null) 
			return false;
		if (i == m-1 && temp.isEnd()) {
			return true;
		} else if (i == m-1) {
			return false;
		}
		if (str[i] == temp.getData()) {
			return search(temp.getEqual() , str, i+1, m);
		} else if (str[i] < temp.getData()) {
			return search(temp.getLess(), str, i , m);
		} else {
			return search(temp.getGreater() , str, i, m);
		}
	}
}

class TernarySearchTree {
	public static void main(String s[]) {
		TST t = new TST();
		Node head = null;
		t.insert(head , "cat".toCharArray(), 0);
		t.insert(head , "bat".toCharArray(), 0);
		t.insert(head , "cats".toCharArray(), 0);
		head = t.getHead();
		System.out.println(t.search(head, "ca".toCharArray(), 0 , "ca".length()));
	}
}