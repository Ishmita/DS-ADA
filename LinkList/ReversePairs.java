//ReversePairs 

// Time Complexity: O(n), Space Complexity: O(1)

class Reverse {
	
	public Node reverse(Node head) {
		Node curr = head.getNext(), prev = head , next;
		Node pprev = null;
		head = curr;
		
		if (head == null) {
			return null;
		}
		if (head.getNext() == null) {
			return head;
		}
		while (curr != null) {
			next = curr.getNext();
			
			curr.setNext(prev);
			prev.setNext(next);
			
			if (pprev != null) {
				pprev.setNext(curr);
			}
			prev = prev.getNext();
			pprev = curr.getNext();
			if (next != null) {
				curr = next.getNext();
			}else {
				curr = null;
			}
		}
		return head;
	}
}

class ReversePairs {
	public static void main (String s[]) {
		LinklistOperations list = new LinklistOperations();
		Reverse r = new Reverse();
		int i;
		
		for (i = 1 ; i < 9 ; i ++) {
			list.insertEnd(i);
		}
		list.traverse();
		Node head = r.reverse(list.getHead());
		if (head != null) {
			list.setHead(head);
			list.traverse();
		}
	}
 }