// FindRepeated.java
// Time Complexity: O(n), Space Complexity: O(1)
// Given an array of size s and elements are in 
// range 1 to n, two elements are repeated twice. Find these two.

class FindRepeated {
	
	public static void main(String s[]) {
		int a[] = {4,2,1,5,2,3,1};
		
		for (int i = 0 ;i < a.length; i++) {
			if (a[Math.abs(a[i])] > 0) {
				a[Math.abs(a[i])] = - a[Math.abs(a[i])];
			} else {
				System.out.println(Math.abs(a[i]));
			}
		
		}
	}
}