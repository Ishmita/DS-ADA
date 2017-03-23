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

// Floyd algorithm. Time Complexity: O(n) , Space Complexity: O(1)

class FloydAlgo {
	
	public Node check(Node head) {
		Node slow, fast;
		slow = fast = head;
		if (head == null) {
			return null;
		}
		while (slow.getNext() != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			
			if(slow == fast) {
				System.out.print("Loop present at: ");
				break;
			}
		}
		
		if (slow.getNext()!=null && fast.getNext()!= null) {
			fast = head;
			
			while (fast != slow) {
				slow = slow.getNext();
				fast = fast.getNext();
			}
			return fast;
		}
		System.out.println("No loop present");
		return null;
		
	}
}

class CycleCheck {
	public static void main(String s[]) {
		MakeLinklist list = new MakeLinklist();
		Node head = list.makeList();
		HashCycleCheck sol1 = new HashCycleCheck();
		FloydAlgo sol2 = new FloydAlgo();
		
		Node result = sol1.check(head);
		
		if (result!= null) {
			System.out.println(""+result.getData() + "-> Hash Tables");
		}
		Node result2 = sol2.check(head);
		if (result2!= null) {
			System.out.println(""+result2.getData() + "-> Floyd Algorithm");
		}
	}
}