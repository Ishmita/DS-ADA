// TrieDataStructure.java
// Time Complexity: O(length)
import java.util.*;
class Node {
	private HashMap<Character, Node> map;
	private boolean end;
	
	public Node() {
		map = new HashMap<Character, Node>();
		end = false;
	}
	
	public boolean isEnd() {
		return end;
	} 
	
	public void makeEnd() {
		end = true;
	}
	
	public boolean contains(Character c) {
		return map.containsKey(c);
	}
	
	public Node getNext(Character c) {
		Node next = null;
		if (map.containsKey(c))
			next = (Node) map.get(c);
		return next;
	}
	
	public void put(Character c, boolean end) {
		Node n = new Node();
		n.end = end;
		map.put(c, n);
	}
}
class Trie {
	
	private Node head;
	
	public Trie(Node head) {
		this.head = head;
	}
	
	public void insert(String s) {
		char c[] = s.toCharArray();
		
		Node temp = head;
		int i = 0;
		
		while (i < s.length()-1) {
			if (temp.contains(c[i])) {
				temp = temp.getNext(c[i]);
				i++;
			} else {
				temp.put(c[i], false);
			}
		}
		
		if (!temp.contains(c[i])) {
			temp.put(c[i], true);
		} else {
			temp = temp.getNext(c[i]);
			temp.makeEnd();
		}
	}
	
	public boolean search(String s) {
		int i = 0;
		char c[] = s.toCharArray();
		Node temp = head;
		while (temp != null && i < s.length() && temp.contains(c[i])) {
			temp = temp.getNext(c[i]);
			i++;
		}
		
		if (i == s.length() && temp.isEnd()) 
			return true;
		return false;
	}
}

class TrieDataStructure {
	public static void main(String s[]) {
		Node head = new Node();
		
		Trie trie = new Trie(head);
		String str = "bat";
		trie.insert(str);
		trie.insert("batman");
		trie.insert("battle");
		trie.insert("ba");
		System.out.println(trie.search("ba"));
	}
}