// KMP.java
// Time Complexity: O(m+n), Space Complexity: O(1)

class Find {
	
	private String t, p;
	private int pre[];
	
	Find(String t, String p) {
		this.t = t;
		this.p = p;
		this.pre = new int[p.length()];
	}
	
	public void preCompute() {
		int j = 0;
		int i = 1;
		pre[0] = 0;
		
		while (i < p.length()) {
			if (p.charAt(i) == p.charAt(j)) {
				pre[i] = j+1;
				i++;
				j++;
			} else if(j == 0) {
				pre[i] = 0;
				i++;
			} 
			else {
				j = j - 1;
				j = pre[j];
			}
		}
		
		for (int k = 0 ; k < pre.length; k++) {
			//System.out.println(pre[k]);
		}
	}
	
	public int find() {
		preCompute();
		int j = 0;
		int i = 0;
		
		while(i < t.length()) {
			if (j == p.length() -1) {
				return (i - j + 1);
			} else if (t.charAt(i) == p.charAt(j)) {
				j++;
				i++; 
			} else if (j == 0) {
				i++;
			} else {
				j--;
				j = pre[j];
			}
		}
		return -1;
	} 
}

class KMP {
	public static void main(String s[]) {
		String t = "abbbacabbacab", p = "ca";
		Find f = new Find(t,p);
		System.out.println("Found at: "+f.find());
	}
}