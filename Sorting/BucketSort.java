// BucketSort.java
// Time Complexity: O(n)
import java.util.*;

class Sort {
	
	private double a[];
	private int size;
	private List<List<Double>> buckets;

	public Sort(double a[], int n) {
		this.a = a;
		size = n;
		buckets = new ArrayList<List<Double>>(10);
	}
	
	public void bucketSort() {
	
		for (int i = 0 ; i < 10 ; i++) {
			buckets.add(new ArrayList<Double>());
		}
		int bNum = 0;
		for (int i = 0 ;i < size; i++) {
			bNum = (int)Math.floor(a[i]*10);
			buckets.get(bNum).add(a[i]);
			
		}
		int index = 0;
		
		for (List<Double> bucket: buckets) {
			Collections.sort(bucket);
			for (Double i: bucket) {
				a[index++] = i;
			}
		}
	}
	
	public void print() {
		for (int i = 0 ;i < size;i++) {
			System.out.println(a[i]);
		}
	}
}

class BucketSort {
	public static void main(String s1[]) {
		double a[] = {0.22, 0.45, 0.12, 0.8, 0.1,0.6 , 0.72, 0.81, 0.33, 0.18 , 0.50, 0.14};
		
		Sort s = new Sort(a, a.length);
		s.bucketSort();
		System.out.println("Sorted array: ");
		s.print();
	}
}