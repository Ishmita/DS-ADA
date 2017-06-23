// FindPivot2.java 
// Find an element in a sorted rotated array.
// Time Complexity: O(logn), Space Complexity: O(1)
class Find {
	
	private int a[];
	
	Find (int a[]) {
		this.a = a;
	}
	
	public int findPivot(int start, int end) {
		int size = a.length;
		
		while (start <= end) {
			int mid = start + (end - start)/2;
			
			if ((mid + 1) < size && a[mid+1] < a[mid])
				return mid;
			if (a[start] > a[mid])
				end = mid-1;
			else 
				start = mid +1;
		}
		return -1;
	}
	
	public int findK(int k) {
		int start = 0;
		int end = a.length-1;
		int p = findPivot(start, end);
		if (k > a[end] && p!= -1)
			end = p;
		else if (k <= a[end] && p != -1)
			start = p + 1;
		
		while (start <= end) {
			int mid = start + (end - start)/2;
			
			if (a[mid] == k)
				return mid;
			else if(a[mid] > k) {
				end = mid -1;
			} else 
				start = mid + 1;
		}
		return -1;
	}
}

class FindPivot2 {
	public static void main(String s[]) {
		int a[] = {19, 20,  25, 1, 3, 4, 5, 7, 10, 14, 15, 16};
		Find f = new Find(a);
		int r = f.findK(10);
		if (r != -1)
			System.out.println(r);
	}
}