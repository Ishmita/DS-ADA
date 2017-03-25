// MiddleNode.java

//Time Complexity: O(n) , Space Complexity: O(1) , Scans = 1
// Ceiling function.

class FindMiddle {
	public Node find(Node head) {
		if(head == null) {
			return null;
		}
		Node temp1, temp2;
		temp1 = temp2 = head;
		
		while(temp1 != null && temp1.getNext()!=null) {
			temp1 = temp1.getNext().getNext();
			temp2 = temp2.getNext();
		}
		return temp2;
	}
}

class MiddleNode {
	public static void main(String s[]) {
		LinklistOperations list = new LinklistOperations();
		
		for ( int i = 1 ; i < 6 ; i++) {
			list.insertEnd(i);
		}
		list.traverse();
		
		FindMiddle mid = new FindMiddle();
		Node middle = mid.find(list.getHead());
		
		if(middle != null) {
			System.out.println("Middle node: " + middle.getData());
		}
	}
}