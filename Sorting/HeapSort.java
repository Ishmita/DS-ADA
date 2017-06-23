// HeapSort.java
// Max Heap implementation

class Heap {
	int a[];
	int size;
	
	Heap() {
		this.a = new int[50];
	}
	
	public int getParent(int i) {
		int index = (int) Math.floor((i-1)/2.0);
		return a[index];
	}
	
	public int getTop() {
		return a[0];
	}
	
	public int getLeft(int i) {
		if (2*i+1 < size) {
			return 2*i+1;
		}
		return -1;
	}

	public int getRight(int i) {
		if (2*i+2 < size) {
			return 2*i+2;
		}
		return -1;
	}
	
	//insert
	public void insert(int data) {
		size++;
		int i = size;
		System.out.println("size: "+size+" parentIndex: "+ i);
		while (i > 0 && data > a[(i-1)/2]) {
			a[i] = a[(i-1)/2];
			i = (i-1)/2;
			System.out.println("parentIndex: "+ i);
		}
		a[i] = data;
		System.out.println("insrting: "+ data + " at: "+ i);
	}
	
	//delete top
	public int deleteTop() {
		int temp = a[0];
		a[0] = a[size-1];
		heapify(0);
		size--;
		return temp;
	}
	
	//heapify
	public void heapify(int i) {
		int max = i;
		int left = getLeft(i);
		int right = getRight(i);
		if (i < size) {
			if (left != -1 && a[left] > a[i]) 
				max = left;
			if (right != -1 && a[right] > a[max]) {
				max = right;	
			}
			if (max!= i) {
				int temp = a[i];
				a[i] = a[max];
				a[max] = temp;
				heapify(max);
			}	
		}
	}
	
	public void print(int i) {
		if (i < size) {
			System.out.println(a[i]);
			print(2*i+1);
			print(2*i+2);
		}
		/*for (i = 0 ; i < size ; i++) {
			System.out.println(a[i]);			
		}*/
	}
	
	public void buildHeap(Heap h, int arr[], int n) {
		if(h == null) {
			return;
		}
		h.a = arr;
		h.size = n;
		
		for (int i = n - 1; i >= 0;i--) {
			h.heapify(i);
		}
	}
	
	// Time Complexity: O(nlogn)
	public int[] heapSort(int n , int a[]) {
		Heap h = new Heap();
		buildHeap(h , a , n);
		int oldSize = h.size;
		for (int i = n-1 ; i >= 0 ;i--) {
			int temp = h.a[0];
			System.out.println(temp);
			h.a[0] = h.a[i];
			h.size--;
			h.a[i] = temp;
			h.heapify(0);
		}
		h.size = oldSize;
		return h.a;
	}
	
	private void printArray(int a[], int size) {
		for (int i = 0 ; i < size; i++){
			System.out.print(a[i]+" ");
		}
	}
	
	public int[] getArray() {
		return a;
	}
	
	public int getSize(){
		return size;
	}
}

class HeapSort {
	public static void main(String s[]) {
		Heap heap = new Heap();
		
		heap.insert(3);
		heap.insert(2);
		heap.insert(5);
		heap.insert(6);
		heap.insert(7);
		heap.insert(4);
		heap.insert(1);
		
		System.out.println("max element: "+ heap.getTop());
		heap.print(0);
		System.out.println("deleted max element: " + heap.deleteTop());
		heap.print(0);		
		System.out.println("max element: "+ heap.getTop());
		int a[] = {2, 7, 4, 6, 3, 9,1, 5};
		heap.heapSort(a.length , a);
	}
	
	
}