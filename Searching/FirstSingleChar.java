// FirstSingleChar.java
// Time complexity: O(n), Space Complexity: O(n)
// Time complexity of map.containsKey(), get(), put() is O(1). 
import java.util.*;
class FirstSingleChar {
	public static void main(String s[]) {
		char str[] = "abgyuehgsabcncj".toCharArray();
		LinkedHashMap<String , Integer> map = new LinkedHashMap<String, Integer>();
		String ch; 
		
		for (char c:str) {
			ch = c + "";
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch)+1);
			}
		}
		
		Set set = map.entrySet();
		Iterator i = set.iterator();
		
		while (i.hasNext()) {
			Map.Entry e = (Map.Entry)i.next();
			if (((Integer)e.getValue()).equals(1)) {
				System.out.println(e.getKey());
				break;
			}
		}
	}
}