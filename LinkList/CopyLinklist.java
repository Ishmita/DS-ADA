// CopyLinklist.java

import java.util.*;
class CopyList {
	
	public Node copy (Node head) {
		if (head == null) {
			return null;
		}
		
		HashMap<Node , Node> map = new HashMap<Node , Node>();
		Node temp = head;
		
		while (temp != null) {
			Node node = new Node();
			node.setData(temp.getData());
			map.put(temp , node);
			temp = temp.getNext();
		}
		temp = head;
		Node head2 = (Node)map.get(temp);
		
		while(temp.getNext() != null) {
			Node node1 = (Node)map.get(temp);
			Node node2 = (Node)map.get(temp.getNext());
			node1.setNext(node2);
			temp = temp.getNext();
		}
		return head2;
	}
}

class CopyLinklist {
	public static void main(String s[]) {
		LinklistOperations list = new LinklistOperations();
		
		for (int i = 1 ; i< 8 ; i ++) {
			list.insertEnd(i);
		}
		list.traverse();
		CopyList c = new CopyList();
		Node head = c.copy(list.getHead());
		if (head!= null) {
			list.setHead(head);
			list.traverse();
		}
	}
}