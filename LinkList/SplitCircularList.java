// SplitCircularList.java

class SplitList {
	
	private CLLNode tail1 , tail2;
	
	public CLLNode getTail1() {
		return tail1;
	}
	
	public CLLNode getTail2() {
		return tail2;
	}
	
	public void split(CLLNode tail) {
		if (tail == null) {
			return; 
		}
		if (tail.getNext() == tail) {
			return;
		}
		
		CLLNode temp = tail.getNext();
		CLLNode temp2 = temp;
		
		while (temp != tail && temp.getNext() != tail) {
			temp = temp.getNext().getNext();
			temp2 = temp2.getNext();
		}
		
		tail1 = temp2;
		tail2 = tail;
		tail = tail.getNext();
		tail2.setNext(temp2.getNext());
		temp2.setNext(tail);
	} 
}

class SplitCircularList {
	public static void main(String s[]) {
		CLLOperations op = new CLLOperations();
		SplitList sl = new SplitList();
		
		for (int i = 1 ;i < 8 ;i ++) {
			op.insertEnd(i);
		}
		op.traversal();
		sl.split(op.getTail());
		CLLOperations l1 = new CLLOperations();
		CLLOperations l2 = new CLLOperations();
		CLLNode tail1 = sl.getTail1();
		CLLNode tail2 = sl.getTail2();
		if(tail1 != null) {
			l1.setTail(tail1);
			l1.traversal();
		}
		if (tail2 != null) {
			l2.setTail(tail2);
			l2.traversal();
		}
	}
}
