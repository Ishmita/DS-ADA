//MergeFiles.java
import java.util.*;
class Merge {
	
	public int merge(int a[]) {
		int res = 0;
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(a.length, new Comparator<Integer>() {
			public int compare(Integer n1, Integer n2) {
				return (n1 > n2 ? 1: (n1 < n2 ? -1 : 0));
			}
		});
		
		for (Integer i : a) {
			queue.add(i);
		}
		
		while (queue.size() > 1) {
			int x = queue.poll();
			int y = queue.poll();
			res += x + y;
			System.out.println("merge: "+x + " and: "+y);
			queue.add(x+y);
		}
		return res;
	} 
}

class MergeFiles {
	public static void main(String s[]) {
		int a[] = {10,5,100,50,20,15};
		Merge m = new Merge();
		System.out.println("total operations: "+ m.merge(a));
				
	}
}