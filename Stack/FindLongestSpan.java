// FindLongestSpan.java

class FindSpan {
	
		//Time Complexity: O(n^2) , Space Complexity: O(n)
	public void naive (int a[]) {
		int len = a.length;
		int b[] = new int[len];
		for (int i = 0 ; i < len ; i ++) {
			int span = 1;
			int j = i-1;
			while(j>=0 && a[j] <= a[j+1]) {
				span ++;
				j--;
			}
			b[i] = span;
		}
		for (int i = 0 ; i < len ;i ++) {
			System.out.println("Span of "+ a[i] + " is: " + b[i]);
		}
	}
	
	//Time Complexity: O(n) , Space Complexity: O(n)
	public void find(int a[]) {
		int len = a.length;
		int b[] = new int[len];
		
		b[0] = 1;
		
		for (int i = 1 ;i < len ; i++) {
			if(a[i] >= a[i-1]) {
				b[i] = b[i-1] +1;
			}else {
				b[i] = 1;
			}
		}
		
		for (int i = 0 ; i < len ;i ++) {
			System.out.println("Span of "+ a[i] + " is: " + b[i]);
		}
	}
}

class FindLongestSpan {
	public static void main(String s[]) {
		int a[] = new int[5];
		a[0] = 6;
		a[1] = 3;
		a[2] = 2;
		a[3] = 2;
		a[4] = 2;
		FindSpan span = new FindSpan();
		span.find(a);
		System.out.println("naive: ");
		span.naive(a);
	}
}