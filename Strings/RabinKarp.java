// RabinKarp.java
// Time Complexity: O(nm), Space Complexity: O(1)

class RabinKarp {
	
	public static void main(String s[]) {
		
		String t = "abbbacabbacab", p = "acab";
		int prime = 101;
		int k = 1;
		int m = p.length();
		int n = t.length();
		int j = 0, q = m;
		int hp = 0, h = 0,a1,a2;
		
		for (int i = 0 ;i < m ; i++) {
			a1 = p.charAt(i);
			a2 = t.charAt(i);
			hp = hp + (a1*k);
			h = h + (a2*k);
			k = k * prime;
		}
		
		for (int i = 0 ;i < n-m; i++) {
			j = 0;
			if (h == hp) {
				while (j < m && t.charAt(i+j) == p.charAt(j)) {
					j = j+1;
				}
				if (j == m) {
					System.out.println("found at: " + (i+1));
					return;
				}
			}
			
			a2 = t.charAt(i);
			h = (h - a2) / prime;
			a2 = t.charAt(q);
			h = h + a2 * (int)Math.pow(prime, m-1);
			q++;
		}
	}
}