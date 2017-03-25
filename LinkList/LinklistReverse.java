// LinklistReverse.java

//Time Complexity: O(n^2)

class Solution {
	public LinklistOperations reverse(LinklistOperations linklist) {
		Node head = linklist.getHead();
		Node temp = head, temp2 = head, tail;
		
		if(head == null) {
			return null;
		}
		
		if(temp.getNext() == null) {
			return linklist;
		}
		temp = temp.getNext();	
		while(temp.getNext() != null) {
			temp = temp.getNext();
			temp2 = temp2.getNext();
		}
		tail = temp;
		while(temp!=head) {
			temp.setNext(temp2);
			temp = temp2;
			temp2 = head;
			while(temp2.getNext() != temp && temp2 != temp) {
				temp2 = temp2.getNext();
			}
		}
		temp.setNext(null);
		linklist.setHead(tail);
		return linklist;
	}
}

//Time Complexity: O(n) , Space Complexity: O(1)

class BetterSol {
	public LinklistOperations reverse(LinklistOperations linklist) {
		Node curr = linklist.getHead() , prev = null , next;
		
		if(curr == null) {
			return null;
		}
		while (curr != null) {
			next = curr.getNext();
			
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		linklist.setHead(prev);
		return linklist;
	}
}

class LinklistReverse {
	
	public static void main(String s[]) {
		LinklistOperations list = new LinklistOperations();

		for (int i = 2 ; i < 7 ;i ++) {
			list.insertEnd(i);
		}
		list.traverse();
		Solution sol = new Solution();
		list = sol.reverse(list);
		if(list!= null) {
			list.traverse();
		}
		
		BetterSol sol2 = new BetterSol();
		list = sol2.reverse(list);
		if(list != null) {
			list.traverse();
		}
	}
}