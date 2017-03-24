// InsertInSorted.java

class MakeLinklist {
	private Node head;
	LinklistOperations ll = new LinklistOperations();;
	
	public void setHead(Node node) {
		head = node;
		ll.setHead(node);
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node makeLinklist() {
		
		for (int i = 2; i < 12; i = i+2) {
			ll.insertEnd(i);
		}
		head = ll.getHead();
		ll.traverse();
		return head;
	}
	
	public void traverse() {
		ll.traverse();
	}
}

// Time Complexity: O(n)
class Solution {
	
	public Node insertSorted(int data, Node head) {
		Node temp = head;
		LinklistOperations op = new LinklistOperations();
		op.setHead(head);
		
		
		if(temp == null) {
			op.insertBeginning(data);
			head = op.getHead();
			return head;	
		}
		if(data < temp.getData()) {
			op.insertBeginning(data);
			head = op.getHead();
			return head;
		}
		while(temp.getNext() != null) {
			if (data == temp.getData()) {
				return null;
			}
			if(data < temp.getNext().getData()) {
				Node newNode = new Node();
				newNode.setData(data);
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
				return head;
			}
			temp = temp.getNext();
		}
		if (temp.getNext() == null) {
			op.insertEnd(data);
			return head;
		}
		return null;
	}
}

class InsertInSorted {
	public static void main(String s[]) {
		MakeLinklist ll = new MakeLinklist();
		Node head = ll.makeLinklist();
		Solution sol = new Solution();
		head = sol.insertSorted(3 , head);
		ll.setHead(head);
		ll.traverse();
	}
}