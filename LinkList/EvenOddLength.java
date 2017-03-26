// EvenOddLength.java

//Time Comlexity: O(n) , Space Complexity : O(1)
class CheckLength {
	public void check(Node head) {
		Node temp = head;
		
		if(temp == null) {
			System.out.println("Empty list");
			return;
		}
		
		while (temp != null && temp.getNext() != null) {
			temp = temp.getNext().getNext();
		}
		if (temp == null) {
			System.out.println("Even");
		}else {
			System.out.println("Odd");
		}		
	}
}

class EvenOddLength {
	public static void main(String s[]) {
		LinklistOperations list = new LinklistOperations();
		CheckLength len = new CheckLength();
		
		for (int i = 1;  i < 2 ; i++) {
			list.insertEnd(i);
		}
		list.traverse();
		len.check(list.getHead());
	}
}