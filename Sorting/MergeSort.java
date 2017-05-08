/** 
* MergeSort.java 
* First we recursively break the array into two halves,
* until we are left with a single element in the array.
* An array of singl element is always sorted,
* So, we just merge the two sorted array (left , right)
* back into the parent array.
* Time Complexiy: O(nlogn) , Space Complexity: O(n)
*/

import java.util.Arrays;
class MergeSortAlgo {
	
	public int[] mergeSort(int a[] , int start , int end) {
 
		if (start == end) {
			return Arrays.copyOfRange(a , start , end+1);
		}
		
		int mid = start + (int) Math.floor((end - start + 1)/2);		
		int left[] = mergeSort(a , start , mid-1);
		int right[] = mergeSort(a, mid , end);
		
		a = merge(left , right);
		return a;
	}
	
	private int[] merge(int left[] , int right[]) {
		int i = 0 , j = 0, k = 0, a[] = new int[left.length+right.length]; 
		System.out.println("left len: "+left.length);
		System.out.println("right len: "+right.length);
		while (i < left.length && j < right.length) {
			System.out.println("k: "+k);
			if(left[i] < right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i < left.length) {
			a[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			a[k] = right[j];
			j++;
			k++;
		}
		
		return a;
	} 
}

class MergeSort {
	
	public static void main(String s[]) {
		int a[] = {3, 6 , 2, 1 , 8 , 5, 9, 4};
		MergeSortAlgo m = new MergeSortAlgo();
		a = m.mergeSort(a, 0 , a.length-1);
		for (int e:a) {
			System.out.println(e);
		}
	}
}
