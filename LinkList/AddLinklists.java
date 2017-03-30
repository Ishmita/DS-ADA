// AddLinklists.java
// Time Complexity : O(n) or O(m) , Space Complexity: O(1)
class AddList {
	
	public Node add(Node head1 , Node head2) {
		Node temp1 = head1 , temp2 = head2;
		LinklistOperations list = new LinklistOperations();
		int sum = 0 , carry = 0 , n = 0;
		
		if (temp1 == null && temp2 == null) {
			return null;
		} 
		
		while (temp1 != null || temp2 !=null) {
		if (temp1 != null && temp2 != null) {
			sum = temp1.getData() + temp2.getData() + carry;
			n = sum/10;
			if ( n!= 0) {
				sum = sum % 10;
			}
			list.insertEnd(sum);
			temp1 = temp1.getNext();
			temp2 = temp2.getNext();
			
			if ( n!= 0) {
				carry = n;
			} else{
				carry = 0;
			}
			
		}else if (temp1 == null) {
			sum = temp2.getData() + carry;
			n = sum/10;
			if (n != 0) {
				sum = sum %10;
			}
			if (temp2.getNext() == null) {
				list.insertEnd(temp2.getData() + carry);
			}else{
				list.insertEnd(sum);
			}
			temp2 = temp2.getNext();
			if ( n!= 0) {
				carry = n;
			} else{
				carry = 0;
			}
		}else if (temp2 == null) {
			sum = temp1.getData() + carry;
			n = sum/10;
			if (n != 0) {
				sum = sum %10;
			}	
			if (temp1.getNext() == null) {
				list.insertEnd(temp1.getData() + carry);
			}else{
				list.insertEnd(sum);
			}
			temp1 = temp1.getNext();
			if ( n!= 0) {
				carry = n;
			} else{
				carry = 0;
			}

		}
	}
	return list.getHead();
	}
}	

class AddLinklists {
	public static void main(String s[]) {
		LinklistOperations list1 = new LinklistOperations();
		int i;
		for (i = 1 ; i< 6 ; i ++) {
			list1.insertEnd(i);
		}
		list1.traverse();
		LinklistOperations list2 = new LinklistOperations();
		for (i = 5 ; i< 9 ; i ++) {
			list2.insertEnd(i);
		}
		list2.traverse();
		AddList l = new AddList();
		Node head = l.add(list1.getHead() , list2.getHead());
		if(head != null) {
			list1.setHead(head);
			list1.traverse();
		}
	}
}	