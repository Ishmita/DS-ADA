// FindMedianOfUnion.java
import java.util.*;
class Find {
	
	private int a[];
	private int b[];
	int count = 0;
	
	public Find(int a[], int b[]) {
		this.a = a;
		this.b = b;
	}

	// Time Complexity: O((n+m)/2), Space Complexity: O(n+m)
	public double merge() {
		int n = a.length, m = b.length;
		int mid = (n + m)/2;
		int i = 0, j = 0, k = 0;
		int res[] = new int[a.length + b.length];
		
		while (i < n && j < m) {
			if (a[i] <= b[j]) {
				res[k] = a[i];
				i++;
			} else {
				res[k] = b[j];
				j++;
			}
			
			if (count == mid) {
				if (((n + m) & 1) == 0)
					return ((res[k] + res[k-1])/2.0);
				else 
					return res[k];
			}
			
			k++;
			count++;
		}
		
		while (i < n) {
			res[k] = a[i];
			i++;
			
			if (count == mid) {
				if (((n + m) & 1) == 0)
					return ((res[k] + res[k-1])/2.0);
				else 
					return res[k];
			}
			k++;
		}
		
		while (j < m) {
			res[k] = b[j];
			j++;
			
			if (count == mid) {
				if (((n + m) & 1) == 0)
					return ((res[k] + res[k-1])/2.0);
				else 
					return res[k];
			}
			k++;
		}
		return -1;
	}
	
	public double divide(int a[], int b[]) {
		int n = a.length, m = b.length;
		
		if((n + m) == 2) {
			return (a[0] + b[0])/2.0;
		} 
		
		if (n == 2 && m == 2) {
			return ((int)Math.max(a[0], b[0]) + (int)Math.min(a[1], b[1]))/2.0;
		}
		
		double med1 = ((n & 1) == 0 ? (a[n/2] + a[n/2 -1])/2.0 : a[n/2]);
		double med2 = ((m & 1) == 0 ? (b[m/2] + b[m/2 -1])/2.0 : b[m/2]);
		
		int start = 0; 
		System.out.println("med1: "+ med1+ " med2: "+ med2);
		if (med1 > med2) {
			a = Arrays.copyOfRange(a, 0, n/2 + 1);
			start = (int)Math.floor(m/2.0);
			if ((m & 1) == 0)
				start--;
			b = Arrays.copyOfRange(b, start, m);
			return divide(a, b);
		} else if (med1 < med2) {
			start = (int)Math.floor(n/2.0);
			if ((n & 1) == 0)
				start--;
			a = Arrays.copyOfRange(a, start, n);
			b = Arrays.copyOfRange(b, 0, m/2 +1);
			return divide(a, b);
		} else 
			return med1;
	}
}

class FindMedianOfUnion {
	public static void main(String s[]) {
		int a[] = {4, 7, 9, 12, 15, 25};
		int b[] = {1, 3, 6, 8, 10, 12};
		
		Find f = new Find(a, b);
		//System.out.println(f.merge());
		System.out.println(f.divide(a,b));
	}
}