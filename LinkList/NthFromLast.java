// NthFromLast.java
import java.io.*;

class MakeList {
	
	private Node head;
	
	public void setHead(Node node) {
		this.head = node;
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node makeList() {
		LinklistOperations ll = new LinklistOperations();
		
		for (int i = 1 ; i<= 5 ; i++) {
				ll.insertEnd(i);
		}
		ll.traverse();
		this.head = ll.getHead();
		return head;
	}
	
}

//Brute Force Solution. Time Complexity: O(n^2)

class NaiveSolution {
	
	public Node result(int n, Node head) {
		int count = 1;
		Node temp1, temp2;
		temp1 = head;
		if(temp1 == null) {
			return null;
		}
		
		while (temp1.getNext() != null) {
			temp1 = temp1.getNext();
		}
		
		while (count != n && temp1 != head) {
			temp2 = head;
			while (temp2.getNext() != temp1) {
				temp2 = temp2.getNext();
			}
			count++;
			temp1 = temp2;
		}
		
		if (temp1 == head && count != n) {
			System.out.println("Invalid Input");
			return null;
		}
		return temp1;
	}
}

// Better solution. Time Complexity: O(n), scans = 2

class LenCountSolution {
	private int len = 1;
	
	public Node result(int n , Node head) {
		Node temp = head;
		int count = 1;
		if (temp == null) {
			return null;
		}
		while(temp.getNext() != null) {
			len ++;
			temp = temp.getNext();
		}
		temp = head;
		while (count != (len-n+1) && temp != null) {
			temp = temp.getNext();
			count ++;
		}
		if (temp == null) {
			System.out.println("Invalid Input");
			return null;
		}
		return temp;
	}
} 

//Efficient solution with one scan only. Time Complexity: O(n)

class BestSolution {
	Node temp1, temp2;
	int count = 1;
	
	public Node result (int n , Node head) {
		temp1 = temp2 = head;
		
		if(head == null) {
			return null;
		}
		
		while (temp1.getNext() != null) {
			if (count >= n) {
				temp2 = temp2.getNext();
			}
			temp1 = temp1.getNext();
			count ++;
		}
		
		if ((temp1.getNext() == null && count < n) || n < 1) {
			System.out.println("Invalid Input");
			return null;
		}
		return temp2;
	}
}
class Testing {
	
	public static void main (String s[]) {
		MakeList list = new MakeList();
		NaiveSolution sol1 = new NaiveSolution();
		LenCountSolution sol2 = new LenCountSolution();
		BestSolution sol3 = new BestSolution();
		
		Node head = list.makeList();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			Node res = sol1.result(n , head);
			Node res2 = sol2.result(n , head);
			Node res3 = sol3.result(n , head);
			if(res != null && res2 != null && res3 != null){
				System.out.println("NaviteSolution result: "+res.getData());
				System.out.println("LengthCountSolution result: "+res2.getData());
				System.out.println("BestSolution result: "+res3.getData());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
