// ChangeOrder.java

// Time Complexity: O(n) , Space Complexity : O(n)

class ChangeOrderLinklist {
	
	private Node temp;
	private LinklistOperations list;
	private LinklistOperations list2;
	private int counter = 1;
	private int len; 
	
	public ChangeOrderLinklist(LinklistOperations list, int i) {
		this.list = list;
		list2 = new LinklistOperations();
		temp = list.getHead();
		len = i;
	}
	
	public Node getHead() {
		return list2.getHead();
	}
	
	public Node change(Node head , int k) {
		if(head == null) {
			return null;
		}
		
		Node node = change(head.getNext(), k);
		if(node != null && counter <= k) {
			if (counter == k && (len%2 != 0)) {
				list2.insertEnd(temp.getData());
				list2.insertEnd(node.getData());
				counter ++;
				
			} else if(counter == k) {
				list2.insertEnd(temp.getData());
				counter++;
			} else {
				list2.insertEnd(temp.getData());
				list2.insertEnd(node.getData());
				temp = temp.getNext();
				counter ++;
			}
		}
		return head;
	}
}

class ChangeOrder {
	public static void main( String s[]) {
		LinklistOperations list = new LinklistOperations();
		int i;
		for (i = 1 ; i< 10 ; i ++) {
			list.insertEnd(i);
		}
		list.traverse();
		ChangeOrderLinklist c = new ChangeOrderLinklist(list , i);
		if ((i-1) % 2 == 0) {
			c.change(list.getHead(), i/2);

		}else {
			c.change(list.getHead(), (int)Math.ceil(i/2.0));
		}
		Node head = c.getHead();
		if(head != null) {
			list.setHead(head);
			list.traverse();
		}
	}
}