// SortLinklist.java

class Sort {
	
	private Node head;
	
	public Sort(Node head) {
		this.head = head;
	} 
	
	public void setHead(Node h) {
		head = h;
	}
	
	public Node mergeSort(Node head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		LinklistOperations u = new LinklistOperations();
		LinklistOperations v = new LinklistOperations();		
		Node temp = head;
		while(temp != null) {
			u.insertEnd(temp.getData());
			temp = temp.getNext();
			if (temp != null) {
				v.insertEnd(temp.getData());
				temp = temp.getNext();
			}
		}
		
		u.setHead(mergeSort(u.getHead()));
		v.setHead(mergeSort(v.getHead()));
		return merge(u.getHead() , v.getHead());
	}
	
	public Node merge(Node head1, Node head2) {
		Node temp1 = head1, temp2 = head2;
		LinklistOperations u = new LinklistOperations();
		
		while (temp1 != null && temp2 != null) {
			if (temp1.getData() < temp2.getData()) {
				u.insertEnd(temp1.getData());
				temp1 = temp1.getNext();
			} else if (temp1.getData() > temp2.getData()) {
				u.insertEnd(temp2.getData());
				temp2 = temp2.getNext();
			} else {
				u.insertEnd(temp1.getData());
				u.insertEnd(temp1.getData());
				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
			}		
		}
		
		while (temp1 != null) {
			u.insertEnd(temp1.getData());
			temp1 = temp1.getNext();
		}
		
		while (temp2 != null) {
			u.insertEnd(temp2.getData());
			temp2 = temp2.getNext();
		}
		return u.getHead();
	}
	
	public void print() {
		Node temp = head;
		while (temp.getNext() != null) {
			System.out.print(temp.getData() + "->");
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
}

class SortLinklist {
	public static void main(String s[]) {
		
		LinklistOperations op = new LinklistOperations();
		
		op.insertEnd(5);
		op.insertEnd(8);
		op.insertEnd(2);
		op.insertEnd(9);
		op.insertEnd(3);
		op.insertEnd(4);
		op.insertEnd(5);
		op.insertEnd(6);
		op.insertEnd(0);
		
		Sort sort = new Sort(op.getHead());
		Node head = sort.mergeSort(op.getHead());
		sort.setHead(head);
		sort.print();
	}
}