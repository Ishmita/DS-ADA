// LinklistTest.java
import java.io.*;
class Node {
	
	int data;
	Node next = null;
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public int getData() {
		return this.data;
	}
	
	public Node getNext() {
		return this.next;
	}
}

class LinklistOperations {
	
	// head is the pointer pointing to the first node of the linklist
	public Node head;
	
	public void insertBeginning(int data) {
		Node node = new Node();
		node.setData(data);
		
		node.setNext(head);
		head = node;
	}
	
	public void insertEnd(int data) {
		Node temp = head;
		Node node = new Node();
		node.setData(data);
		if(temp == null) {
			head = node;
			return;
		}
		while (temp.getNext()!= null) {
			temp = temp.getNext();
		}
		temp.setNext(node);
	}
	
	public void insertPosition(int data , int pos) {
		Node node = new Node();
		node.setData(data);
		int count = 1;
		Node temp = head;
		if(pos == 1) {
			insertBeginning(data);
		}else {
			while(temp!=null && count != pos-1) {
				count++;
				temp = temp.getNext();
			}
			if(temp!=null) {
			node.setNext(temp.getNext());
			temp.setNext(node);
			} else {
				System.out.println("Invalid position");
			}
		}
	}
	
	public void traverse() {
		Node temp = head;
		if(temp!=null) {
			
			while(temp.getNext()!=null) {
				System.out.print(temp.getData()+"->");
				temp = temp.getNext();
			}
			System.out.println(""+temp.getData());
		}
	}
	
	public Node deleteBeginning() {
		Node temp = head;
		if(head!=null){
			head = head.getNext();
			temp.setNext(null);
			return temp;
		}
		return null;
	}
	
	public Node deleteEnd() {
		Node temp = head, temp2 = head;
		if(temp!=null){
			temp = temp.getNext();
			while(temp.getNext()!=null){
				temp = temp.getNext();
				temp2 = temp2.getNext();
			}
			temp2.setNext(null);
			temp.setNext(null);
			return temp;
		}
		return null;
	}
	
	public Node delPosition(int pos) {
		Node temp = head, temp2 = head;
		int count = 1;
		if(pos == 1) {
			return deleteBeginning();
		}
		if(temp != null) {
			temp = temp.getNext();
			while(temp!=null && count != pos-1) {
				temp = temp.getNext();
				temp2 = temp2.getNext();
			}
			if(temp2!=null) {
				if(temp!=null){
					temp2.setNext(temp.getNext());
					temp.setNext(null);
					return temp;
				}else {
					return deleteEnd();
				}
			}
		}
		return null;
	}
	
}

class LinklistTest {
	public static void main ( String s[]) {
		
		LinklistOperations op = new LinklistOperations();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0 ; i< 5 ; i++) {
			try {
			int data = Integer.parseInt(br.readLine());
			op.insertEnd(data);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		op.traverse();
		op.insertPosition(0, 4);
		op.traverse();
		op.deleteBeginning();
		op.traverse();
		op.deleteEnd();
		op.traverse();
		op.delPosition(4);
		op.traverse();
	}
}