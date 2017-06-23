// FindTwoElementSum.java
// a[i] + a[j] = k, Find such a[i] & a[j]
import java.util.*;

class Find {
	
	private int a[];
	private int k;
	private int size;
	
	Find(int a[], int k) {
		this.a = a;
		this.k = k;
		size = a.length;
	}
	
	//Time Complexity: O(n^2), Space Complexity :O(1)
	public void bruteForce() {
		boolean flag = false;
		for (int i = 0 ;i < size; i++) {
			for (int j = i+1; j < size; j++) {
				if(a[i]+a[j] == k) {
					flag = true;
					System.out.println("bruteForce: "+ a[i] + "+" + a[j] + "=" + k);
					break;
				}
			}
			if (flag)
				break;
		}
	}
	
	//Time Complexity: O(n), Space Complexity: O(n)
	public void hashing() {
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0 ;i < size; i++) {
			res = k - a[i];
			if (map.containsKey(res)) {
				System.out.println("hashing: "+a[i] + "+" + res + "=" + k);
				break;
			} else if (!map.containsKey(a[i])){
				map.put(a[i], i);
			}
		}
	}
	
	//Time Complexity: O(nlogn), Space Complexity: O(1);
	public void bySorting() {
		Heap h = new Heap();
		this.a = h.heapSort(size , a);
		int j = size-1;
		int i = 0;
		while (i < j){
			if (a[i] + a[j] == k) {
				System.out.println("sorting: "+a[i] + "+" + a[j]+ "=" + k);
				break;
			} else if(a[i] + a[j] < k) 
				i++;
			else 
				j--;
		}
	}
	
	void print() {
		for (int i = 0 ;i < size; i++) {
			System.out.println("a["+i+"]: "+a[i]);
		}
	}
}

class FindTwoElementSum {
	public static void main(String s[]) {
		int a[] = {2, 7, 4, 6, 3, 9, 0, 1, 5};
		Find f = new Find(a , 8);
		f.bruteForce();
		f.hashing();
		f.bySorting();
	}
}