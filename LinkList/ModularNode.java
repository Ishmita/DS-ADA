//ModularNode 

// Time Complexity: O(n) , Space Complexity: O(1)
class Modular {
	
	public Node modular(Node head, int k) {
		int i = 1;
		Node modularNode = null;
		if(head == null) {
			return null;
		}
		Node temp = head;
		while(temp != null) {
			if(i%k == 0) {
				modularNode = temp;
			}
			temp = temp.getNext();
			i++;
		}
		return modularNode;
	}
}

class ModularNode {
	public static void main(String s[]) {
		LinklistOperations list = new LinklistOperations();
		
		for (int i = 1 ; i<= 10 ; i ++) {
			list.insertEnd(i);
		}
		list.traverse();
		Modular m = new Modular();
		Node node = m.modular(list.getHead() , 4);
		if(node != null) {
			System.out.println("Modular node: " + node.getData());
		}
	}
}