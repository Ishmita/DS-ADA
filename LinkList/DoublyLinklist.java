// DoublyLinklist.java

import java.io.*;
class Node {
	private int data;
	private Node previous, next;
	
	public Node(int data, Node prev , Node next) {
		this.data = data;
		this.previous = prev;
		this.next = next;
	}
	
	public Node(int data) {
		this.data = data;
		previous = null;
		next = null;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public void setPrev(Node prev) {
		this.previous = prev;
	}
	
	public Node getPrev() {
		return previous;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}
}

class LinklistOperations {
	
	private Node head;
	private Node temp;
	private int len = 0;
	
	public void insertBeginning(int data) {
		Node node = new Node(data);
		len++;
		node.setNext(head);
		head = node;
	}

	public void insertEnd(int data) {
		len++;
		temp = head;
		Node node = new Node(data);
		if(temp!=null) {
			while (temp.getNext()!=null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setPrev(temp);
		}else {
			head = node;
		}
	}
	
	public void insertPos (int data, int pos) {
		int count = 1;
		
		temp = head;
		Node node = new Node(data);

		if(temp!=null && pos != 1) {
			while(temp!=null && count != pos-1) {
				temp = temp.getNext();
				count++;
			}
			if (temp!=null) {
				len++;
				node.setNext(temp.getNext());
				node.setPrev(temp);
				if(temp.getNext()!=null) {
					temp.getNext().setPrev(node);
				}
				temp.setNext(node);
			}
		}else {
			len++;
			node.setNext(head);
			head = node;
		}
	}
	
	public void traverse () {
		temp = head;
		if(temp!=null) {
			while (temp.getNext()!=null) {
				System.out.print(temp.getData() + "->");
				temp = temp.getNext();
			}
			System.out.println(temp.getData());
		}
	}
	
	public Node deleteBeginning() {
		temp = head;
		if(temp!=null) {
			len--;
			head = head.getNext();
			temp.setNext(null);
			return temp;
		}
		return null;
	}
	
	public Node deleteEnd() {
		temp = head;
		
		if(temp!=null) {
			while(temp.getNext()!=null) {
				temp = temp.getNext();
			}
			len--;
			temp.getPrev().setNext(null);
			temp.setPrev(null);
			return temp;
		}
		return null;
	}
	
	public Node deletePos (int pos) {
		temp = head;
		int count = 1;
		if(pos == 1) {
			return deleteBeginning();
		}
		if(temp!=null) {
			while (temp.getNext()!=null && count!=pos) {
				count++;
				temp = temp.getNext();
			} 
			if (temp.getNext()== null) {
				return deleteEnd();
			}
			len--;
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
			temp.setNext(null);
			temp.setPrev(null);
			return temp;
		}
		return null;
	}
	
	public int getLength() {
		return len;
	}
}

class DoublyLinklist {
	public static void main (String s[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinklistOperations op = new LinklistOperations();
		for (int i = 0; i < 5; i++) {
			try {
			int data = Integer.parseInt(br.readLine());
			op.insertEnd(data);
			}catch (Exception e ) {
				e.printStackTrace();
			}
		}
		op.traverse();
		System.out.println(op.getLength());
		op.insertPos(0 , 6);
		op.insertPos(0 , 1);
		op.insertPos(0 , 3);
		op.traverse();
		System.out.println(op.getLength());
		op.deleteBeginning();
		op.traverse();
		System.out.println(op.getLength());
		op.deleteEnd();
		op.traverse();
		System.out.println(op.getLength());
		op.deletePos(7);
		op.traverse();
		System.out.println(op.getLength());
		
	}
}
