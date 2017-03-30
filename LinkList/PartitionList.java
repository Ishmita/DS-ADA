// PartitionList.java
// Time Complexity: O(n) , Space Complexity: O(1)
class Partition {
	
	public Node partition(Node head , int k) {
		Node temp = head , temp2 = null , temp3 = null;
		
		
		if (temp == null) {
			return null;
		}
		
		while(temp.getNext() != null) {
			if (temp.getNext().getData() == k && temp2 == null) {
				temp2 = temp;
			}
			if(temp2 != null && temp.getNext() != null &&temp.getNext().getData() < k) {
				temp3 = temp.getNext();
				temp.setNext(temp3.getNext());
				temp3.setNext(temp2.getNext());
				temp2.setNext(temp3);
				temp2 = temp3;
			}else {
				temp = temp.getNext();
			}
		}
		if (temp2 != null) 
		{
			temp2 = temp2.getNext();
			temp = head;
			while(temp.getData() != k) {
				if (temp.getNext()!= null && temp.getNext().getData() > k ) {
					temp3 = temp.getNext();
					temp.setNext(temp3.getNext());
					temp3.setNext(temp2.getNext());
					temp2.setNext(temp3);
					temp2 = temp2.getNext();
				}else {
					temp = temp.getNext();
				}
			}
		}
		return head;
	}
}

class PartitionList {
	
	public static void main(String s[]) {
		LinklistOperations list1 = new LinklistOperations();
		int i;
		
		list1.insertEnd(1);
		list1.insertEnd(7);
		list1.insertEnd(4);
		list1.insertEnd(2);
		list1.insertEnd(0);
		list1.insertEnd(3);
		list1.insertEnd(8);

		for (i = 1 ; i< 6 ; i ++) {
			list1.insertEnd(i);
		}
		list1.traverse();
		Partition p = new Partition();
		Node head = p.partition(list1.getHead(), 4);
		if(head!= null) {
			list1.setHead(head);
			list1.traverse();
		}
	}
}
