//PrintReverse.java

//Time Complexity: O(n) , Space Complexity: O(n)
class Reverse {
	
	public void print (Node head) {
		if (head == null) {
			return;
		}
		
		print(head.getNext());
		System.out.println("" + head.getData());
	}
}

class PrintReverse {
	public static void main(String s[]) {
		LinklistOperations list = new LinklistOperations();
		Reverse rev = new Reverse();
		for (int i = 1 ; i < 7 ; i++) {
			list.insertEnd(i);
		}
		list.traverse();
		System.out.println("In reverse order: ");
		rev.print(list.getHead());
	}
}