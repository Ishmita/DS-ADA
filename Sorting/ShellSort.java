// ShellSort.java

class Sorting {
	
	/**
	* Extension of Insertion sort
	* Makes h passes, h being the distance or 
	* gap between elements to be compared.
	* h = 1, for insertion sort. 
	* Ends with h = 1, that is classical insertion
	* sort in its last pass but number of changes are 
	* every few in last pass, i.e. , array is alomst 
	* sorted by the last pass. 
	* As, insertion sort works almost O(n) on sorted input, 
	* shell sort has better complexity.
	* Time Complexity, Best case: O(n)
	* Time Complexity, Worst case: O(n(logn)^2)
	*/
	
	public int[] shellSort(int a[]) {
		for (int h = 3 ; h >= 0; h--) {
			System.out.println("\nh: "+ h);
			for (int i = 1; i < a.length ; i++) {
				int curr = a[i];
				int j = i-h+1;
				boolean change = false;
				System.out.println("current: "+curr);
				while(j>=1 && a[j-1] > curr) {
					System.out.println("a[j]: "+a[j]);
					System.out.println("a[j-1]: "+a[j-1]);
					if (j == (i-h+1)) {
						System.out.println("a[i] : "+a[i] + " = a[j-1]: " + a[j-1]);
						a[i] = a[j-1];
					} else {
						System.out.println("a[j] : "+a[j] + " = a[j-1]: " + a[j-1]);
						a[j] = a[j-1];
						
					}
					change = true;
					j--;
				}
				if (change) {
					a[j] = curr;
				}
			}
		}
		return a;
	}
}

class ShellSort {
	
	public static void main(String s[]) {
		int a[] = {4, 6, 2, 9, 3, 0, 5, 7};
		Sorting sort = new Sorting();
		a = sort.shellSort(a);
		for(int i = 0 ; i < a.length; i++) {
			System.out.println("" + a[i]);
		} 
	}
}