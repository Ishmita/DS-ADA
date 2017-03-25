// MergePoint.java
import java.util.*;

//Hash Table solution, Time Complexity: O(n) or O(m) , Space Complexity: O(n + m)
class FindMergePoint {
	
	public Node find(Node head1 , Node head2) {
		Node temp1 = head1, temp2 = head2;
		HashMap<Node, Integer> map = new HashMap<Node, Integer>();
		if(temp1 == null || temp2 == null) {
			return null;
		}
		
		while(temp1 !=null || temp2 !=null) {
			if(temp1 != null) {
				if(!map.containsKey(temp1)) {
					//System.out.println("list1 key being added: " + temp1.getData());
					map.put(temp1, 1);
				}else {
					if(((Integer)map.get(temp1)).equals(2)) {
						//System.out.println("list1 key duplicate: " + temp1.getData());
						return temp1;
					}
				}
				temp1 = temp1.getNext();
			}
			
			if(temp2 != null) {
				if(!map.containsKey(temp2)) {
					//System.out.println("list2 key being added: " + temp2.getData());
					map.put(temp2, 2);
				}else {
					if(((Integer)map.get(temp2)).equals(1)) {
						//System.out.println("list2 key duplicate: " + temp2.getData());
						return temp2;
					}
				}
				temp2 = temp2.getNext();
			}
		}
		return null;
	}
}

class MergePoint {
	public static void main(String s[]) {
		LinklistOperations list1 = new LinklistOperations();
		LinklistOperations list2 = new LinklistOperations();
		Node temp1, temp2;
		
		for (int i = 1; i < 4 ; i++) {
			list1.insertEnd(i);
		}
		list1.traverse();
		
		for (int i = 1; i < 8 ; i++) {
			list2.insertEnd(i);
		}
		list2.traverse();
		
		temp1 = list1.getHead();
		temp2 = list2.getHead();
		int count = 1;
		
		while(temp2.getNext()!=null && count < 5) {
			temp2 = temp2.getNext();
			count ++;
		}
		
		while(temp1.getNext()!=null) {
			temp1 = temp1.getNext();
		}
		temp1.setNext(temp2);
		list1.traverse();
		list2.traverse();
		
		FindMergePoint findPoint = new FindMergePoint();
		Node point = findPoint.find(list2.getHead(), list1.getHead());
		if(point != null) {
			System.out.println("Merge point: " + point.getData());
		} else{
			System.out.println("No merge point");
		}
	}
}