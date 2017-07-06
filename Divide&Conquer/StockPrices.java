// StockPrices.java
// Time Complexity : O(nlogn), Space Complexity: O(1) -> excluding space for recursive calls 
class StockPrices {
	
	private int profit;
	private int bd;
	private int sd;
	
	public int getBuyDate() {
		return bd;
	}
	
	public int getSellingDate() {
		return sd;
	}
	
	public int getProfit() {
		return profit;
	}
	
	public void dates(int a[], int s, int e) {
		
		if (s == e) {
			return;
		}
		
		int mid = s + (e-s)/2;
		int buyDate = findMin(a, s, mid);
		int sellDate = findMax(a, mid+1, e);
		
		int p = a[sellDate] - a[buyDate];
		if (p > profit) {
			profit = p;
			bd = buyDate;
			sd = sellDate;
		}
		
		dates(a, s, mid);
		dates(a, mid+1, e);
	}
	
	private int findMax(int a[], int s, int e) {
		int max = s;
		for (int i = s+1 ;i <= e; i++) {
			if (a[i] > a[max]) {
				max = i;
			}
		}
		return max;
	}
	
	private int findMin(int a[], int s, int e) {
		int min = s;
		for (int i = s+1; i <= e; i++) {
			if (a[i] < a[min]) {
				min = i;
			}
		}
		return min;
	}
	
	public static void main(String s[]) {
		int a[] = {3,4,9,2, 10,8, 5};
		StockPrices sp = new StockPrices();
		
		sp.dates(a, 0, a.length-1);
		System.out.println("max profit: "+ sp.getProfit());
		System.out.println("buying date: "+ (sp.getBuyDate()+1));
		System.out.println("selling date: "+ (sp.getSellingDate()+1));
	}
	
	
}