// ModularNodeFromEnd.java

// Time Complexity: O(n) , Space Complexity: O(1)

class ModularEnd {
	public Node modular (Node head , int k) {
		Node temp = head, temp2 = head;
		int i = 1;
		if (head == null) {
			return null;
		}
		
		while (temp.getNext() != null) {
			if (i > k) {
				temp2 = temp2.getNext();
			}	
			temp = temp.getNext();
			i++;
		}
		return temp2;
	}
}

class ModularNodeFromEnd {
	public static void main(String s[]) {
		LinklistOperations list = new LinklistOperations();
		
		for (int i = 1 ; i<= 19 ; i ++) {
			list.insertEnd(i);
		}
		list.traverse();
		ModularEnd m = new ModularEnd();
		Node node = m.modular(list.getHead() , 3);
		if(node != null) {
			System.out.println("Modular node: " + node.getData());
		}
	}
}