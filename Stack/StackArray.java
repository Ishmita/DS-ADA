// Stack.java
// Time Complexity: O(1) , Space Complexity : O(n)
class Stack 
{
	private int top = -1;
	private int a[] = new int[20];

	public void setTop (int i) 
	{
		top = i;	
	}

	public int getTop()
	{
		return top;
	}

	public void push(int data) throws Exception
	{
		if(top < 19) {
			a[++top] = data;
		}else {
			throw new Exception("Stack Overflow");
		} 	
	}

	public int pop() throws Exception
	{
		if(top >= 0) 
		{
			int p = a[top];
			--top;
			return p;
		} else { 
			throw new Exception("Stack Underflow");
		}			
	}
}

class StackArray {
	public static void main(String s[]) {
		Stack stack = new Stack();
		for (int i = 1; i < 12 ; i++) {
			try {
				stack.push(i);
			}catch(Exception e) {
				e.printStackTrace();
			} 
		}
		
		for(int i = 0 ; i < 7 ; i ++) {
			try {
				System.out.println(""+stack.pop());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}