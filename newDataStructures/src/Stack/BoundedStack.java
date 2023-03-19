package Stack;

public class BoundedStack extends Stack {
	private final int maxCapacity;

	public BoundedStack() {
		super();
		this.maxCapacity = 10;
	}

	public BoundedStack(int maxCapacity) {
		super();
		if (maxCapacity <= 0) {
			throw new IllegalArgumentException();
		} else {
			this.maxCapacity = maxCapacity;
		}
	}

	//	1. A method called push() that:
	//		a. Takes 1 parameter, the String to be stored in your stack.
	//		b. Checks if there is sufficient space left in the Stack to add this element
	//		i. If the Stack is full, throws an IllegalArgumentException*
	//		c. If sufficient space exists, uses the push method from the super class to carry out the push logic
	public void push(String data) {
		if (numElements == maxCapacity) {
			throw new IllegalArgumentException();
		} else {
			super.push(data);
			
			}
		}
	
	//	2. A method called isFull() that:
	//		a. Takes no parameters.
	//		b. Returns true if there is space remaining in the stack.
	//		c. Returns false if there is no space remaining in the stack.
	public boolean isFull() {
		if (numElements == maxCapacity) {
			return false;
		} else {
			return true;
		}
	}
}
