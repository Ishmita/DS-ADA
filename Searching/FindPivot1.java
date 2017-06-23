// FindPivot1.java
// a[1]..a[k] increasing order, a[k+1]...a[n] decreasing order. Find k
// Time Complexity: O(logn), Space Complexity: O(n) -> stack space
class Find {
	private int a[];
	private int size;
	
	Find(int a[]) {
		this.a = a;
		size = a.length;
	}
	
	public int binarySearch(int start , int end) {
		if (start > end)
			return -1;
		int mid = start + (end-start)/2;

		if (a[mid] > a[mid-1] && a[mid] > a[mid+1]) {			
			return mid; 
		}
		
		int res = 0;
		if (a[mid] > a[mid-1] && a[mid] < a[mid+1])
			return binarySearch(mid +1, end);
		if (a[mid] < a[mid-1] && a[mid] > a[mid+1]) 
			return binarySearch(start, mid-1);
		return -1;
	}
}

class FindPivot1 {
	public static void main(String s[]) {
		int a[] = {3,5,7,8,10,7,5,4,2,1,0};
		Find f = new Find(a);
		System.out.println(a[f.binarySearch(0, a.length-1)]);
	}
	
}