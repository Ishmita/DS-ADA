// FindThriceRepeated.java
// Time Complexity: O(n), Space Complexity: O(1)
// Given an array of size s and elements are in 
// range 1 to n, n-1 elements are repeated thrice,
// rest are repeated twice. Find the elements repeated twice.

class FindThriceRepeated {
	
	public static void main(String s[]) {
		int a[] = {4,2,1,3,5,1,3,2,5,3,1,4};
		int n = 5;
		for (int i = 0 ;i < a.length; i++) {
			a[Math.abs(a[i])] = - a[Math.abs(a[i])];
		}
		
		for (int i = 1 ;i <= n; i++) {
			if (a[i] > 0) {
				System.out.println(i);
			}
		}
	}
}