//ReverseKBlocks.java

//Time Complexity: O(n) , Space Complexity: O(1)

class Reverse {
	
	public Node reverse(Node head, int k) {
		boolean flag = false, first = true;
		Node prev = null, curr = head, next, init= head, temp = head;
		int i = 1, len = 1, j = 1;
		if(head == null) {
			return null;
		}
		
		while (curr.getNext()!= null) {
			len++;
			curr = curr.getNext();
		}
		if( len < k ) {
			return head;
		}
		curr = head;
		len = len - (len%k);
		len = (int) len/k;
		
		while( j <= len ) {
			j++;
			
			while (i <= k) {
				if((i%k) == 1) {
					init = curr;
				}
				flag = true;
				next = curr.getNext();
				curr.setNext(prev);
				prev = curr;
				curr = next;
				i++;
			}
			i = 1;
			
			if (first) {
				head = prev;
			}
			if(!first) {
				if(flag) {
					temp.setNext(prev);
					temp = init;
				}
			}
			first = false;
			flag = false;
		}			
		
		temp.setNext(curr);
		return head;
	} 
}

class ReverseKBlocks {
	public static void main(String s[]) {
		LinklistOperations list = new LinklistOperations();
		
		for (int i = 1 ; i <= 9 ; i ++) {
			list.insertEnd(i);
		}
		list.traverse();
		Reverse r = new Reverse();
		Node head = r.reverse(list.getHead() , 4);
		if(head!= null) {
			list.setHead(head);
			list.traverse();
		}
	}
}