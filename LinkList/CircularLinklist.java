// CircularLinklist.java

import java.io.*;
class CLLNode {
	private int data;
	private CLLNode next = this;
	
	public CLLNode(int data) {
		this.data = data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public void setNext(CLLNode node) {
		next = node;
	}
	
	public CLLNode getNext() {
		return next;
	}
}

class CLLOperations {
	
	private CLLNode tail;
	private CLLNode temp;
	private int len;
	
	public CLLNode getTail() {
		return tail;
	}
	
	public void setTail (CLLNode node) {
		tail = node;
	}
	public int getLength() {
		return len;
	}
	
	public void setLength(int len) {
		this.len = len;
	}
	
	public void insertBeginning(int data) {
		CLLNode node = new CLLNode(data);
		len++;
		if (tail == null) {
			tail = node;
			return;
		}
		node.setNext(tail);
		temp = tail.getNext();
		while (temp.getNext()!=tail) {
			temp = temp.getNext();
		}
		temp.setNext(node);
		tail = node;
	}
	
	public void insertEnd(int data) {
		CLLNode node = new CLLNode(data);
		len++;
		if(tail == null) {
			tail = node;
			return;
		}
		/*temp = tail.getNext();
		while (temp.getNext()!=tail) {
			temp = temp.getNext();
		}
		temp.setNext(node);
		node.setNext(tail);*/
		
		node.setNext(tail.getNext());
		tail.setNext(node);
		tail = node;
	}
	
	public CLLNode deleteBeginning() {
		if (tail == null) {
			return null;
		}
		if (tail.getNext() == tail) {
			temp = tail;
			tail = null;
			return temp;
		}
		temp = tail.getNext();
		while (temp.getNext()!=tail) {
			temp = temp.getNext();
		}
		
		temp.setNext(tail.getNext());
		temp = tail;
		tail = tail.getNext();
		return temp;
	}
	
	public CLLNode deleteEnd() {
		if(tail == null) {
			return null;
		}
		if(tail.getNext() == tail) {
			temp = tail;
			tail = null;
			return temp;
		}
		
		temp = tail.getNext();
		while(temp.getNext().getNext() != tail) {
			temp = temp.getNext();
		}
		
		CLLNode temp2 = temp.getNext();
		temp.setNext(tail);
		return temp2;
	}
	
	//HeadNode is displayed at the end of fthe list.
	
	public void traversal() {
		temp = tail.getNext();
		
		while(temp!=tail) {
			System.out.print(temp.getData() + "->");
			temp = temp.getNext();
		}
		System.out.println("" + temp.getData());
	}
}

class CircularLinklist {
	
	public static void main(String s[]) {
		CLLOperations op = new CLLOperations();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0 ;i <5  ;i ++) {
			try {
			int data = Integer.parseInt(br.readLine());
			op.insertEnd(data);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		op.traversal();
		op.deleteBeginning();
		op.traversal();
		op.deleteEnd();
		op.traversal();
	}
}