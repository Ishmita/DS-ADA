// Shuffle.java
// arr[a1, a2, a3....an, b1, b2, b3.....bn], 
// move the elements of the array to transfer 
// it into arr[a1, b1, a2, b2......an,bn], Space Complexity: O(1)

// Time Complexity: O(n^2)

class Shuffle {
	public static void main(String arg[]) {
		int a[] = {1,1,1,1,1,0,0,0,0,0};
		int n = 5;
		int s = n-1, s1, e = n, e1;
		
		for (int i = 1 ; i < n; i++) {
			s1 = s;
			e1 = e;
			while (s1 < e1){
				if (s1 == e1 - 1) {
					int temp = a[s1];
					a[s1] = a[e1];
					a[e1] = temp;
				} else {
					int temp = a[s1];
					a[s1] = a[s1+1];
					a[s1+1] = temp;
					
					temp = a[e1];
					a[e1] = a[e1-1];
					a[e1-1] = temp;
				}
				s1 = s1 + 2;
				e1 = e1 - 2;
			}
			s = s - 1;
			e = e + 1;
		}
		
		for (int i = 0; i < 2*n; i++) {
			System.out.println(a[i]);
		}
	}
} 