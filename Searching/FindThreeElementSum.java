// FindThreeElementSum.java
// a[i] + a[j] + a[m] = k, find such i, j, m.
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
	
	// Time Complexity: O(n^3), Space Complexity: O(1)
	public void bruteForce() {		
		for (int i = 0 ;i < size; i++) {
			for (int j = i+1; j < size; j++) {
				for (int m = j+1; m < size ; m++) {
					if (a[i] +a[j] +a[m] == k) {
						System.out.println("brute force: "+ a[i] +"+" + a[j]+ "+" +a[m] +"="+k);
						return;
					}
				}
			}
		}
	}
	
	// Time Complexity: O(n^2), Space Complexity: O(n)
	public void hashing() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = 0;
		
		for (int i = 0 ; i < size; i++) {
			if (!map.containsKey(a[i]))
				map.put(a[i], i);
			for (int j = i+1 ;j < size; j++) {
				res = k - (a[i]+a[j]);
				if (map.containsKey(res) && ((Integer)map.get(res) != i && (Integer)map.get(res) != j)){
					System.out.println("hashing: "+a[i] +"+" + a[j]+ "+" +res +"="+k);
					return;
				}
			}
		}
	}
	
	// Time Complexity: O(nlogn)+O(n^2) ~ O(n^2), Space Complexity: O(1)
	public void sorting() {
		Heap h = new Heap();
		a = h.heapSort(a.length, a);
		int j = 0 , m = 0 ;
		for (int i = 0 ;i < size; i++) {
			j = i+1;
			m = size-1;
			while (j < m) {
				if (a[i]+a[j]+a[m] == k) {
					System.out.println("sorting: "+a[i] +"+" + a[j]+ "+" +a[m] +"="+k);
					return;
				} else if (a[i]+a[j]+a[m] < k) 
					j++;
				else 
					m--;
			}
		}
	}
}

class FindThreeElementSum {
	public static void main(String s[]) {
		int a[] = {2, 7, 4, 6, 3, 9, 1, 5};
		Find f = new Find(a, 8);
		f.bruteForce();
		f.hashing();
		f.sorting();
		
	}
}