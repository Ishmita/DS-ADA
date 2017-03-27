// PalindromeList
//Time Complexity: O(n)
class PalindromeCheck {
	private int len = 1;
	private Node tail;
	
	public boolean prepare (Node head) {
		Node temp = head;
		boolean b = false;
		
		if (temp == null) {
			return false;
		}
		
		while (temp.getNext() != null) {
			len ++;
			temp = temp.getNext();
		}
		tail = temp;
		if (len%2 == 0) {
			b = true;
			len = (int)Math.floor(len/2);			//use floor()
		} else {
			len = (int)Math.ceil(len/2.0);
		}
		
		
		return check(head, len, b);
	}
	
	public boolean check(Node head, int len, boolean b) {
		
		if (b && len == 0) {
			return true;
		}
		if(!b && len == 1) {
			return true;
		}
		
		boolean flag = check(head.getNext(), len-1 , b);
		if (!flag) {
			return false;
		}
		if(b) {
			if (len == 1) {
				tail = head.getNext();
			}else {
				tail = tail.getNext();
			}
		} else {
			if (len == 2) {
				tail = head.getNext().getNext();
			} else {
				tail = tail.getNext();
			}
		}
		
		if ( Integer.compare( tail.getData() , head.getData()) == 0) {
			return true;
		}else {
			return false;
		}
	}
}

class PalindromeList {
	public static void main(String s[]) {
		LinklistOperations list = new LinklistOperations();
		PalindromeCheck p = new PalindromeCheck();
		int i;
		
		for (i = 1 ; i < 5 ; i ++) {
			list.insertEnd(i);
		}
		i = i - 1;
		for(; i > 0 ; i--) {
			list.insertEnd(i);
		}
		list.traverse();
		boolean res = p.prepare(list.getHead());
		if (res) {
			System.out.println("yes, is a palindrome");
		} else {
			System.out.println("No, not a palindrome");
		}
	} 
}