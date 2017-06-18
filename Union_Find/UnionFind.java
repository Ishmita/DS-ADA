// UnionFind.java

class DisjointSets {
	
	private int a[];
	private int values[];
	private int size;
	
	public DisjointSets() {
		a = new int[50];
		values = new int[50];
	}
	public void makeSet(int arr[]) {
		for (int i = 0 ;i < arr.length; i++) {
			a[i] = i;
			values[i] = arr[i];
		}
		size = arr.length;
	}
	
	public boolean find(int i , int j) {
		if (root(i) == root(j)) 
			return true;
		return false;
	}
	
	public int root(int i) {
		
		while (a[i] != i) {
			i = a[i];
		}
		return a[i];
	}
	
	public void union(int i , int j) {
		if (root(i) != root(j)) {
			a[root(i)] = root(j);
		}
	}
	
	public void print() {
		for (int i = 0 ; i < size; i++) {
			System.out.println(a[i]);
		}
	}
}

class UnionFind {
	public static void main(String s[]) {
		DisjointSets d = new DisjointSets();
		int a[] = {3,5,6,7,8,9,2};
		d.makeSet(a);
		d.union(1, 0);
		d.union(0, 2);
		d.union(3, 4);
		d.union(1, 4);
		System.out.println(d.find(1, 4));
		System.out.println(d.find(1, 5));
		d.print();
	}
}