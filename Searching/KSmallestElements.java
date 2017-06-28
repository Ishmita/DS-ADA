// KSmallestElements.java

class Find {
	
	private int k;
	private int a[];
	
	Find(int a[],int k) {
		this.k = k;
		this.a = a;
	}
	
	// Time Complexity: O(n^2), Space Complexity: O(1)
	public void bruteForce() {
		int min;
		int temp;
		
		for (int i = 0 ; i < k ; i++) {
			min = i;
			for (int j = i+1; j < a.length; j++) {
				if(a[j] < a[min]) {
					min = j;
				}
			}
			temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		
		for (int i = 0 ;i < k ;i++) {
			System.out.println(a[i]);
		}
	}
	
	// Time Complexity: O(nlogn), Space Complexity: O(1)
	public void sorting() {
		Heap h = new Heap();
		a = h.heapSort(a.length, a);
		System.out.println("By sorting: ");
		for (int i = 0 ;i < k; i++) {
			System.out.println(a[i]);
		}
	}
	// Time Complexity: O(n^2) -> worst case, Space Complexity: O(1)
	public void partition (int start , int end) {
		
		
		if (start < end) {
			int p = partitioning(start, end);
			if (p == k-1) {
				for (int i = start ;i < k; i++) {
					System.out.println(a[i]);
				}
				return;
			}
			else if (k < p) 
				partition(start, p-1);
			else 
				partition(p+1, end);
		}
	}
	
	public int partitioning(int start, int end) {
		int j = start;
		int pivot = end;
		for (int i = start; i < end; i++) {
			if (a[i] <= a[pivot]){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				j++;
			}
		}
		int temp = a[pivot];
		a[pivot] = a[j];
		a[j] = temp;
		return j;
	}
	
	public void print () {
		for (int i : a)
			System.out.println(i);
	}
}

class KSmallestElements {
	public static void main(String s[]) {
		int a[] = {3,5,11,9,6,7,20,16};
		int k = 4;
		
		Find f = new Find(a,k);
		//f.bruteForce();
		f.sorting();
		//f.partition(0 , a.length-1);
		
	}
}