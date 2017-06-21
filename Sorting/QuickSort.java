// QuickSort.java
// Time Complexity: Avrg O(nlogn) Worst O(n^2)

class Sort {
	
	private int a[];
	private int size;
	
	public Sort(int a[], int n) {
		this.a = a;
		size = n;
	}
	
	private int partition(int start , int end) {
		
		int pivot = a[end];
		int j = start;
		int temp = 0;

		/** j always points to the last changed index + 1, 
		* if a[i] is less than pivot, then we swap it 
		* with a[j] and j starts pointing to next index 
		* and will stay at this index if it is greater 
		* than pivot. So when a[i] becomes less than pivot, 
		* it always get swapped with a[j] which is greater 
		* than pivot.	
		*/
		
		for (int i = start; i < end ;i++) {
			if (a[i] <= pivot) {
				temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				j++;
			}
		}
		
		temp = a[end];
		a[end] = a[j];
		a[j] = temp;
		return j;
	}
	
	public void quickSort(int start , int end) {
		
		if (start < end) {
			int pivot = partition(start, end);
			quickSort(start, pivot-1);
			quickSort(pivot+1, end);
		}
	}
	
	public void print() {
		for (int i = 0 ; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}

class QuickSort {
	public static void main(String s1[]) {
		int a[] = {3,7,4,2,8,6,1,9,4};
		Sort s = new Sort(a , a.length);
		s.quickSort(0, a.length-1);
		s.print();
	}
}