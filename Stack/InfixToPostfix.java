// InfixToPostfix.java
// Time Complexity: O(n^2) , Space Complexity: O(n)
import java.util.*;

class Convert {
	
	HashMap<Integer , Integer> map;
	
	public Convert() {
		map = new HashMap<Integer , Integer>();
	}
	
	public String convert(String s) {
		Stack stack = new Stack();
		String res = "";
		int top = -1 , topElement = -1;
		try{
			
			if(s.length() <= 0) {
				return null;
			}
			s = "("+s.trim().replaceAll(" +", "")+")";
			makeOperatorDictionary();
			int symbol;
			
			for (int i = 0 ;i < s.length() ; i++) {
				symbol = s.charAt(i);
				System.out.println("symbol: " + (char)symbol);
				System.out.println("top: " + top);
				if (symbol == (int)'(') {
					stack.push(symbol);
					top = stack.getTop();
					System.out.println("symbol: " + (char)symbol + " open bracket");
				} else if (!Character.isLetter(s.charAt(i)) && !(symbol == ')')) {
					System.out.println("symbol: " + (char)symbol + " is an operator");					
					if(map.containsKey(symbol)) {
						topElement = stack.getTopElement();
						System.out.println("top element: " + (char)topElement + " priority of top: "+ map.get(topElement));											
						if (map.get(topElement).compareTo(map.get(symbol)) < 0) {
							System.out.println("pushing: " + (char)symbol + " on top of: "+ (char)topElement);																		
							stack.push(symbol);
							top = stack.getTop();
						} else {
							while ((map.get(topElement)).compareTo(map.get(symbol)) >= 0) {
								System.out.println("top element: " + (char)topElement + " priority of top: "+ map.get(topElement));											
								int t = stack.pop();
								topElement = stack.getTopElement();
								top = stack.getTop();
								res = res + (char)t; 
							}
							stack.push(symbol);
							top = stack.getTop();							
						}
					} else {
						System.out.println("Invalid operator: " + (char)symbol);
						return null;
					}
				} else if (symbol == ')') {
					System.out.println("symbol: " + (char)symbol + " closing bracket");					
					topElement = stack.getTopElement();
					int t = -1;
					while(topElement != (int)'(' && top != -1) {
						t = stack.pop();
						topElement = stack.getTopElement();
						top = stack.getTop();
						System.out.println("symbol: " + (char)symbol + " ");						
						res = res +(char)t;
					}
					/*if (top == -1) {
						return null;
					}*/
					stack.pop();
					top = stack.getTop();
				} else {
					
					System.out.println("symbol: " + (char)symbol + " alphabet");					
					// alphabets & digits 
					res = res + (char)symbol;
				}
			}
			//stack.pop();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		if (top == -1) {
			System.out.println("top: " + top);											
			return res;
		}
		return null;
	}	
	
	private void makeOperatorDictionary() {
		map.put((int)'(' , 0);		
		map.put((int)',' , 1);
		map.put((int)'=' , 2);
		map.put((int)'|' , 6);
		map.put((int)'^' , 7);
		map.put((int)'&' , 8);
		map.put((int)'>' , 10);
		map.put((int)'<' , 10);
		map.put((int)'+' , 12);
		map.put((int)'-' , 12);
		map.put((int)'*' , 13);
		map.put((int)'/' , 13);
		map.put((int)'%' , 13);
		map.put((int)'!' , 15);
		map.put((int)'.' , 17);
	}
}

class InfixToPostfix {
	public static void main(String s[]){
		Convert c = new Convert();
		String res = c.convert("(a+b)*C-D");
		if(res != null) {
			System.out.println(""+res);
		}
	}
} 