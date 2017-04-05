// GenericStack.java

@SuppressWarnings("unchecked")
class Stack<T> {
	
	int top = -1;
	Object a[];
	
	public Stack() {
		a = new Object[30];
	}
	
	public int getTop() {
		return top;
	}
	
	public void setTop(int top) {
		this.top = top;
	}
	
	public T getTopElement() {
		
		T var = (T) a[top];
		return var;
	}
	
	public void push(T data) throws Exception {
		if(top < 30) {
			a[++top] = data;
		} else {
			throw new Exception("Stack Overflow");
		}
	}
	
	public T pop() throws Exception{
		if(top != -1) {

			T var = (T) a[top--];
			return var;
		} else {
			throw new Exception("Stack Underflow");
		}
	}
}

class GenericStack {
	
	public static void main(String s[]) {
		Stack<String> stack = new Stack<String>();
		for (int i = 1 ; i < 6 ; i ++) {
			try {
				stack.push("A"+i);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0 ;i < 3 ; i++) {
			try {
				Object o = stack.pop();
				System.out.println("id: " + o);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}