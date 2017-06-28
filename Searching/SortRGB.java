// SortRGB.java
// Given an array consisting of 0's, 1's and 
// 2's in random order. Sort array in order: 0..1..2..2

class SortRGB {
	public static void main(String s[]) {
		int a[] = {0,1,1,2,0,2,1,0,0,2,1,2,0};
		
		int count[] = new int[3];
		
		for (int i = 0 ;i < count.length; i++) {
			count[i] = 0;
		}
		
		for (int i = 0 ; i < a.length; i++) {
			count[a[i]] +=1;
		}
		
		for (int i = 1 ;i < count.length; i++) {
			count[i] += count[i-1];
		}
		
		int b[] = new int[a.length+1];
		
		for (int i = 0 ;i < a.length; i++ ) {
			b[count[a[i]]] = a[i];
			count[a[i]] -= 1;
		}
		
		for (int i = 1 ; i <= a.length; i++) {
			System.out.println(b[i]);
		}
	}
}  