// CycleCheck.java
import java.util.*;
class MakeLinklist {
	private Node head;
	
	
	public Node makeList () {
		LinklistOperations ll = new LinklistOperations();
		int count = 1;
		for (int i = 1 ; i <= 9 ; i++) {
			ll.insertEnd(i);
		}
		
		this.head = ll.getHead();
		Node temp = head, temp2 = null;
		
		while(temp.getNext() != null) {
			if (count == 4) {
				temp2 = temp;
			}
			temp = temp.getNext();
			count ++;
		}
		temp.setNext(temp2);
		//ll.traverse();
		return head;	
	}
}

// Hashing Technique. Time Complexity: O(n) , Space Complexity: O(n)

class HashCycleCheck {
	
	public Node check(Node head) {
		//map <temp.getNext(), temp>
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Node temp = head;
		
		if(temp == null) {
			return null;
		}
		
		map.put(head, temp);
		// loop condition will be false only for linklists not containing cycles.
		while(temp.getNext() != null) {
			
			if(map.containsKey(temp.getNext())) {
				//loop present
				System.out.print("Loop present at: ");
				return temp.getNext();
			}
			map.put(temp.getNext() , temp);
			temp = temp.getNext();
		}
		System.out.println("No loop present");
		return null;
	}
}

class CycleCheck {
	public static void main(String s[]) {
		MakeLinklist list = new MakeLinklist();
		Node head = list.makeList();
		HashCycleCheck cycleCheck = new HashCycleCheck();
		
		Node result = cycleCheck.check(head);
		if (result!= null) {
			System.out.println(""+result.getData());
		}
	}
}