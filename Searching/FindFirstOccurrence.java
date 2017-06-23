// FindFirstOccurrence.java
// Time Complexity: O(logn) , Space Complexity: O(1)
class Find {
	
	private int a[];
	private int k;
	private int size;
	
	Find(int a[], int k) {
		this.a = a;
		this.k = k;
		size = a.length;
	}
	
	public int binarySearch(int start, int end) {
		while (start <= end) {
			int m = start + (end - start)/2;
			
			if ((m == 0 && a[m] == k) || (m-1) >= 0 && a[m-1] != k && a[m] == k)
				return m;
			if (a[m] >= k)
				end = m - 1;
			else 
				start = m + 1;
		}
		return -1;
	}
}

class FindFirstOccurrence {
	public static void main(String s[]) {
		int a[] = {1,1,1,1,1,3, 3, 3, 4, 5, 7, 10};
		Find f = new Find(a, 10);
		int r = f.binarySearch(0 , a.length -1);
		System.out.println(r);
	}
}