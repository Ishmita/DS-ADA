// RotateRight.java

//Time Coplexity: O(n) , Space Complexity:(1)

class Rotate {
	
	public Node rotate(Node head , int k) {
		if (head == null) {
			return null;
		}
		
		Node temp = head, head2 = head, temp2 = head;
		int c = 1;
		
		/*while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(head2);
		temp = head;*/
		while (temp.getNext()!=null) {
			if(c > k) {
				temp2 = temp2.getNext();
			}
			temp = temp.getNext();
			c++;
		}
		head2 = temp2.getNext();
		temp2.setNext(null);
		temp.setNext(head);
		return head2;
	}
}

class RotateRight {
	public static void main(String s[]) {
		LinklistOperations list = new LinklistOperations();
		int i;
		for (i = 1 ; i< 6 ; i ++) {
			list.insertEnd(i);
		}
		list.traverse();
		Rotate r = new Rotate();
		Node head = r.rotate(list.getHead() , 3);
		if (head!= null) {
			list.setHead(head);
			list.traverse();
		}
	}
}