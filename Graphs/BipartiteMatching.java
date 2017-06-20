// BipartiteMatching.java

/** Time Complexity: O(v + e)
* m -> number of applicants
* n -> number of jobs
*/
	
class Matching {
	private boolean g[][];
	private boolean visited[];
	private int matched[];
	private int res = 0;
	private int n = 6, m = 6;
	
	
	public Matching(boolean g[][]) {
		this.g = g;
		visited = new boolean[n];
		matched = new int[n];
		for (int i = 0 ;i < n; i++) {
			visited[i] = false;
			matched[i] = -1;
		}
	}
	
	public boolean bpm(int u) {
		
		for (int i = 0 ; i < n; i++) {
			if(g[u][i] && !visited[i]) {
				
				visited[i] = true;
				
				/**
				* Either job(i) is umatched or the one who has 
				* matched(i), has another possible matching, 
				* then assign job(i) to applicatant(u) and 
				* return true, indicating that applicant(u) 
				* is assigned a job successfully.
				*
				* This process is repeated for all applicants.
				* And all jobs(i) that an applicant is interested in, 
				* are tried to find a matching.
				*/
				
				if (matched[i] < 0 || bpm(matched[i])) {
					matched[i] = u;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public int maxBPM() {
		
		/** Check matching for each applicatant, 
		* if it is possible, increment the result counter.
		* For each new applicant as it hasn't seen any jobs
		* yet, initialise the visited[] array as false.
		*/
		
		for (int u = 0 ; u < m; u++) {
			
			for (int i = 0 ;i< n; i++) {
				visited[i] = false;
			}
			
			if(bpm(u))
				res++;
		}
		return res;
	}
}

class BipartiteMatching {
	public static void main(String s[]) {
		
		boolean bpGraph[][] = new boolean[][]{
            {false, true, true, false, false, false},
            {true, false, false, true, false, false},
            {false, false, true, false, false, false},
            {false, false, true, true, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, true}
        };
        
		Matching m = new Matching(bpGraph);
        System.out.println( "Maximum number of applicants that can"+
                            " get job is "+m.maxBPM());
	}
}