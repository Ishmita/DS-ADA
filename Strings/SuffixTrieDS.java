// SuffixTrieDS.java

class SuffixTrie {
	
	private Node head;
	
	public void make(String str) {
		str = str + "$";
		String suffix = null;
		int len = str.length();
		Trie t = new Trie(new Node());
		
		for (int i = 0 ;i < len; i++) {
			suffix = str.substring(i , len);
			t.insert(suffix);
		}
		this.head = t.getHead();
	}
	
	public boolean search(String s) {
		Node temp = head;
		
		if (temp == null)
			return false;
		int i = 0 ;
		char c[] = s.toCharArray();
		
		while (temp != null && i < s.length() && temp.contains(c[i])) {
			temp = temp.getNext(c[i]);
			i++;
		}
		
		if (i == s.length())
			return true;
		return false;
	}
}

class SuffixTrieDS {
	public static void main(String s[]) {
		SuffixTrie st = new SuffixTrie();
		String str = "pananabanana";
		st.make(str);
		System.out.println(st.search("bana"));
	}
}