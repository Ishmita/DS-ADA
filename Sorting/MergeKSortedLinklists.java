// MergeKSortedLinklists.java
// Time Complexity: O(k*n)
class Merge {
	
	private LinklistOperations[] lists;
	private int k;
	private Node head;
	
	Merge(LinklistOperations[] lists , int k) {
		this.lists = lists;
		this.k = k;
	}
	
	public void setHead(Node h) {
		head = h;
	}
	
	public void mergeLists() {
		Sort s = new Sort(lists[0].getHead());
		LinklistOperations u = new LinklistOperations();
		u.setHead(lists[0].getHead());
		
		for (int i = 1 ; i < k; i++) {
			u.setHead(s.merge(u.getHead(), lists[i].getHead()));
		}
		
		s.setHead(u.getHead());
		s.print();
	}
}

class MergeKSortedLinklists {
	public static void main(String s[]) {
		LinklistOperations u[] = new LinklistOperations[3];
		
		u[0] = new LinklistOperations();
		u[1] = new LinklistOperations();
		u[2] = new LinklistOperations();
		
		u[0].insertEnd(5);
		u[0].insertEnd(7);
		u[0].insertEnd(9);
		u[0].insertEnd(10);
		u[0].insertEnd(15);
		
		u[1].insertEnd(4);
		u[1].insertEnd(5);
		u[1].insertEnd(6);
		u[1].insertEnd(8);
		u[1].insertEnd(17);
		
		u[2].insertEnd(2);
		u[2].insertEnd(3);
		u[2].insertEnd(5);
		u[2].insertEnd(16);

		Merge m = new Merge(u, 3);
		m.mergeLists();
	}
}