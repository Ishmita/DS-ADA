// StringSortingTest.java
// Time Complexity: O(nlogn) -> Arrays.sort()
import java.util.*;

class StringSortingTest {
	public static void main(String s[]) {
		String str = "aaa bbb bcs bbg bfgt hji aaa bbb rty saa bbb opu";
		String words[] = str.split(" ");
		
		Arrays.sort(words);
		int count = 1;
		int index1 = -1, index2 = -1;
		int max = 0;
		int ssmax = 0;
		
		for (int i = 1; i < words.length; i ++) {
			if (words[i].equals(words[i-1])) {
				count++;
			} else {
				if (count > max) {
					ssmax = max;
					index2 = index1;
					max = count;
					index1 = i-1;
				} else if (count > ssmax && count < max) {
					ssmax = count;
					index2 = i-1;
				}
				count = 1;
			}
		}
		
		System.out.println("max repeated: "+words[index1] + ", count: "+ max);
		System.out.println("second max repeated: "+words[index2] + ", count: "+ ssmax);
	}
}