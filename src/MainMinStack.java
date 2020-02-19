/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack(); 
 * minStack.push(-2); 
 * minStack.push(0);
 * minStack.push(-3); 
 * minStack.getMin(); --> Returns -3. 
 * minStack.pop();
 * minStack.top(); --> Returns 0. 
 * minStack.getMin(); --> Returns -2.
 * 
 * @author fabiano
 */
public class MainMinStack {
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(-2);
		stack.push(0);
		stack.push(-1);
		System.out.println(stack.getMin());
		System.out.println(stack.top());
		System.out.println(stack.getMin());
	}
}

class MinStack {

	public Elem top;
	
    /** initialize your data structure here. */
    public MinStack() {
    	
    }
    
    public void push(int x) {
        if (top == null) {
        	top = new Elem(x, x);
        } else {
        	int min = Math.min(top.min, x);
        	Elem newElem = new Elem(x, min);
        	newElem.next = top;
        	top = newElem;
        }
        
    }
    
    public void pop() {
        if (top != null) {
        	top = top.next;
        }
    }
    
    public int top() {
    	if (top == null)
    		return -1;
        return top.value;
    }
    
    public int getMin() {
    	if (top == null)
    		return -1;
        return top.min;
    }
}

class Elem {
	int value;
	int min;
	Elem next;
	
	public Elem(int value, int min) {
		this.value = value;
		this.min = min;
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
