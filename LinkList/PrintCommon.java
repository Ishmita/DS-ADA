// PrintCommon.java
// Time Complexity: O(n+m) , Space Complexity: O(1)
class CommonNode {
	public void printCommon(Node head1 , Node head2) {
		Node temp1 = head1 , temp2 = head2;
		
		if(temp1 == null && temp2 == null) {
			return;
		}
		
		while(temp1 != null && temp2 != null) {
			if(temp1.getData() == temp2.getData()) {
				System.out.println(""+temp1.getData());
				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
			} else if(temp1.getData() > temp2.getData()) {
				temp2 = temp2.getNext();
			}else {
				temp1 = temp1.getNext();
			}
		}
	}
}

class PrintCommon {
	public static void main(String s[]) {
		LinklistOperations list1 = new LinklistOperations();
		LinklistOperations list2 = new LinklistOperations();
		int i;
		
		list1.insertEnd(3);
		list1.insertEnd(5);
		list1.insertEnd(6);
		list1.insertEnd(8);
		list1.insertEnd(10);
		list1.insertEnd(13);
		list1.insertEnd(16);

		for (i = 1 ; i< 19 ; i = i +2) {
			list2.insertEnd(i);
		}
		list1.traverse();
		list2.traverse();
		CommonNode c = new CommonNode();
		c.printCommon(list1.getHead() , list2.getHead());
	}
}