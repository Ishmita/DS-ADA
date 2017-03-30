// RemoveDuplicates.java
// Time Complexity: O(n) , Space Complexity: O(n)
import java.util.*;
class Remove {
	
	public Node remove(Node head) {
		Node temp = head , temp2 = null;
		
		if(temp == null) {
			return temp;
		}
		HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
		int i = 1;
		map.put(temp.getData() , i);
		
		while (temp.getNext() != null) {

			i++;
			if(!map.containsKey(temp.getNext().getData())) {
				System.out.println(""+temp.getNext().getData());
				map.put(temp.getNext().getData() , i);
				temp = temp.getNext();
			} else{
				temp2 = temp.getNext();
				temp.setNext(temp2.getNext());
				temp2.setNext(null);
			}
		}
		return head;
	}
} 

class RemoveDuplicates {
	public static void main(String s[]) {
		LinklistOperations list1 = new LinklistOperations();
		int i;
		
		list1.insertEnd(1);
		list1.insertEnd(7);
		list1.insertEnd(5);
		list1.insertEnd(2);
		list1.insertEnd(0);
		list1.insertEnd(3);
		list1.insertEnd(8);

		for (i = 1 ; i< 6 ; i ++) {
			list1.insertEnd(i);
		}
		list1.traverse();
		Remove r = new Remove();
		Node head = r.remove(list1.getHead());
		if(head != null) {
			list1.setHead(head);
			list1.traverse();
		}
	}
}