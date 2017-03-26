// MergeSorted.java

//Time Complexity: O(n) , Space Complexity: O(n)
class MergeLists {
	
	public LinklistOperations merge (LinklistOperations l1 , LinklistOperations l2) {
		LinklistOperations list = new LinklistOperations();
		Node temp1 = l1.getHead();
		Node temp2 = l2.getHead();
		int res = 0;
		
		if (temp1 == null && temp2 == null) {
			return null;
		}
		if(temp1 == null) {
			return l2;
		}
		if(temp2 == null) {
			return l1;
		}
		while(temp1 != null || temp2 != null) {
			if (temp1 != null && temp2 != null) {
				
				res = Integer.compare(temp1.getData() , temp2.getData());
				if( res < 0 ) {
					list.insertEnd(temp1.getData());
					temp1 = temp1.getNext();
				}else if (res == 0){
					list.insertEnd(temp2.getData());
					temp2 = temp2.getNext();
					temp1 = temp1.getNext();
				} else {
					list.insertEnd(temp2.getData());
					temp2 = temp2.getNext();
				}
				
			}else if (temp1 == null) {
				list.insertEnd(temp2.getData());
				temp2 = temp2.getNext();
			}else {
				list.insertEnd(temp1.getData());
				temp1 = temp1.getNext();
			}
		}
		return list;
	}
}

class MergeSorted {
	public static void main(String s[]) {
		LinklistOperations l1 = new LinklistOperations();
		LinklistOperations l2 = new LinklistOperations();
		MergeLists ml = new MergeLists();
		
		for (int i = 1 ; i < 20 ; i = i +3) {
			l1.insertEnd(i);
		}
		for (int i = 4 ; i <20 ; i = i +2 ) {
			l2.insertEnd(i);
		}
		l1.traverse();
		l2.traverse();
		LinklistOperations list = ml.merge(l1 , l2);
		if(list.getHead() != null) {
			list.traverse();
		}
	}
}