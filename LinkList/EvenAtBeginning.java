//EvenAtBeginning.java
//Time Complexity: O(n) , Space Complexity: O(1)
class EvenOdd {
	public Node change(Node head) {
		Node temp = head, temp2;
		int i = 0;
		
		if(temp == null) {
			return null;
		}
		temp2 = head.getNext();
		while (temp2 != null) {
			if(temp.getData() % 2 == 1) {
				if(temp2.getData() % 2 == 0) {
					i = temp2.getData();
					temp2.setData(temp.getData());
					temp.setData(i);
					temp = temp.getNext();
					temp2 = temp.getNext();
				}else {
					temp2 = temp2.getNext();
				}
			}else {
				temp = temp.getNext();
				temp2 = temp2.getNext();
			}
		}
		return head;
	}
}

class EvenAtBeginning {
	public static void main(String s[]) {
		LinklistOperations list1 = new LinklistOperations();
		int i;
		
		list1.insertEnd(1);
		list1.insertEnd(7);
		list1.insertEnd(5);
		list1.insertEnd(2);
		list1.insertEnd(0);
		list1.insertEnd(5);
		list1.insertEnd(8);

		for (i = 1 ; i< 6 ; i ++) {
			list1.insertEnd(i);
		}
		list1.traverse();
		EvenOdd r = new EvenOdd();
		Node head = r.change(list1.getHead());
		if(head != null) {
			list1.setHead(head);
			list1.traverse();
		}
	}
}

