// ArrRemoveDuplicate.java
// Remove duplicates in a sorted 
// array without using extra space.
// Time Complexity: O(n)

class Remove {
	
	private int a[];
	private int size;
	
	Remove(int a[], int size) {
		this.a = a;
		this.size = size;
	}
	
	public int removeDulplicates() {
		
		int j = 0; 
		for (int i = 1 ;i < size; i++) {
			if (a[j] != a[i]) {
				a[j+1] = a[i];
				j++;
			}
		}
		return j+1;
	}
}

class ArrRemoveDuplicate {
	public static void main(String s[]) {
		int a[] = {1,2,3,3, 5, 7 , 8, 8, 9, 10, 10};
		Remove r = new Remove(a, a.length);
		System.out.println("new size: " + r.removeDulplicates());
	}
}

