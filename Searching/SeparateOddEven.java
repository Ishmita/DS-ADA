// SeparateOddEven.java
// Time Complexity: O(n) , Space Complexity: O(1)

class SeparateOddEven {
	public static void main(String s[]) {
		int a[] = {12,34,45,9,8,90,3};
		// all even before all odd
		
		int i = 0, j = a.length-1;

		while (i != j && i < j) {
			if((a[i] & 1) == 1) {
				if ((a[j] & 1) == 0) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp; 
				} else 
					j--;
			} else {
				i++;
				if ((a[j] & 1) == 1)
					j--;
			}
		}
		
		for (i = 0 ;i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}