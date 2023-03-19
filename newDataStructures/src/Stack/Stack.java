package Stack;

import java.util.EmptyStackException;

public class Stack {

	// b. An int called count or numElements – this will track how many elements are
	// stored in the stack.
	// c. A Node called first – this will store the first element in the stack
	// (initialized to null)
	protected int numElements;
	protected Node first;

	// 2. Create one constructor:
	// a. A default constructor that sets the first element in the stack to null.
	public Stack() {
		first = null;
	}

	private static class Node {
		protected String data;
		protected Node next;

		public Node(String data) {
			this.data = data;
			this.next = null;
		}

		public Node getNext() {
			return next;
		}
	}

	// 1. A method called size() that:
	// a. Takes no parameters
	// b. Returns the number of elements currently stored in your stack.
	public int size() {
		return numElements;
	}

	// 2. A method called isEmpty() that:
	// a. Takes no parameters.
	// b. Returns true if the stack contains no elements, and false otherwise.
	public boolean isEmpty() {
		boolean isTrue = false;
		if (numElements == 0) {
			isTrue = true;
		} else {
			isTrue = false;
		}
		return isTrue;
	}

	// 3. A method called peek() that:
	//		a. Checks if the stack is empty
	//		i. If the stack is empty, it should throw an EmptyStack exception
	//		b. Returns the data stored in the first node.
	public String peek() {
		Node current = first;
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return current.data;

	}

	//	4. A method called push() that:
	//		a. Takes 1 parameter, the String to be stored in your stack.
	//		b. Creates a new Node (newNode) containing the data to be added.
	//		c. Adds newNode to the start of the data in the list. To do this, you should:
	//		i. Set newNode.next = first (add the new node to the start of the list, in front of the original
	//		first element)
	//		ii. Set first = newNode (set the new node to be the official start of the list)
	//		d. Updates the number of elements currently stored.
	public void push(String data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			first = newNode;
		} else {
			newNode.next = first;
			first = newNode;
		}
		numElements++;
	}

	// 1. A method called pop() that:
	// a. Takes no parameters.
	// b. Checks that the stack is not empty.
	// i. If the stack is empty, throws an EmptyStackException
	// c. Removes the first element from the stack:
	// i. Store a copy of the data from the first element in a temp variable.
	// ii. Set first = first.next (i.e. snip the element out of the stack by
	// skipping it)
	// d. Updates the number of elements currently stored
	// e. Returns the popped element (that you stored in the temporary variable)
	public String pop() {
		String temp = "";
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			temp = first.data;
			first = first.getNext();

		}
		numElements--;

		return temp;
	}

}
