// BalancedSymbol.java

class CheckBalance {
	public boolean check(String s) {
		if (s.length() <= 0 ) {
			return false;
		}
		Stack stack = new Stack();
		int a= 0 , b = 0;
		
		for (int i = 0 ; i < s.length() ; i++) {
			if(s.charAt(i) == '('){
				a = s.charAt(i);
				try{
					stack.push(a);
				}catch(Exception e ) {
					e.printStackTrace();
				}
			} else {
				try{
					b = stack.pop();
					if(s.charAt(i) != ')'){
						return false;
					}
				}catch(Exception e) {
					return false;
				}
			}
		}
		if(stack.getTop() == -1) {
			return true;
		}
		return false;
	}
}

class BalancedSymbol {
	public static void main(String s[]) {
		CheckBalance c = new CheckBalance();
		boolean res = c.check("(((()))");
		if(res) {
			System.out.println("Balanced");
		}else {
			System.out.println("Not balanced");			
		}
	}
}