// BasicSorting.java

class Sorting {
	
	/**
	* In each iteration, the first mismatch is given 
	* correct position.
    * Time Complexity: O(n^2)
	*/
	
	public int[] bubbleSort(int a[]) {
		
		for (int j = a.length-1; j >= 0 ; j--) {
			for (int i = 0 ;i <= j-1 ; i++) {
				if (a[i] > a[i+1]) {
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
		return a;
	}
	
	/**
	* Each ith iteration chooses the minimum of (n-i) elements 
	* and place it at ith position(front).
	* Time Complexity: O(n^2)
	*/
	public int[] selectionSort(int a[]) {
		
		for (int i = 0 ;i < a.length; i++) {
			int min = i;
			for (int j = i+1; j < a.length ; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		return a;
	}
	
	/**
	* Pick each element and check if elements to left of it are greater than 
	* current element, if so, move them all right by one place and place current 
	* element after shifting all. 
	* Best out of all three mentioned.
	* Time Complexity: O(n^2) 
	*/
	
	public int[] insertionSort(int a[]) {
		for (int i = 1 ; i < a.length; i++) {
			int curr = a[i];
			int j = i;
			while (a[j-1] > curr && j>=1) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = curr;
		}
		return a;
	}
}

class BasicSorting {
	
	public static void main(String s[]) {
		int a[] = {5, 7, 3 , 1, 8, 9, 0, 4};
		Sorting sort = new Sorting();
		System.out.println("Bubble sort: ");
		printResult(sort.bubbleSort(a));
		
		System.out.println("Selection sort: ");
		printResult(sort.selectionSort(a));
		
		System.out.println("Insertion sort: ");
		printResult(sort.insertionSort(a));
	}
	
	public static void printResult(int a[]) {
		for (int i = 0 ; i < a.length; i ++) {
			System.out.println(" "+ a[i]);
		}
	}
}