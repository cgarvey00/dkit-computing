package Queues;

import java.util.NoSuchElementException;

public class Queue {
	protected int numElements;
	private Node  first;
	private Node last;

	public Queue () {
		first = null;
		last = null;
	}

	private static class Node<E> {
		private String data;
		private Node next;

		public Node(String data) {
			this.data = data;
			this.next = null;
		}

	}

	public int size() {
		return numElements;
	}

	public boolean isEmpty() {
		boolean isTrue = false;
		if (numElements == 0) {
			isTrue = true;
		} else {
			isTrue = false;
		}
		return isTrue;
	}

	public String peek() {
		Node current = first;
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		return current.data;

	}

	public String get(int pos) {
		if (isEmpty() || pos >= numElements || pos < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			Node current = first;
			for (int i = 0; i < pos; i++) {
				current = current.next;
			}
			return current.data;

		}
	}

	public boolean add(String data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		numElements++;
		return true;
	}

//   

	public String remove() {
		String temp = "";

		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			temp = first.data;
			first = first.next;

		}
		numElements--;

		return temp;
	}
	
	//	The following methods should be created within the Queue class:
	//	1. A method called poll() that:
	//	a. Takes no parameters.
	//	b. Checks that the queue is not empty.
	//	i. If the queue is empty, returns null.
	//	c. Removes the first element from the queue:
	//	i. Store a copy of the data from the first element in a temp variable.
	//	ii. Set first = first.next (i.e. snip the element out of the queue by skipping it)
	//	d. Updates the number of elements currently stored
	//	e. Returns the removed element (that you stored in the temporary variable)
	public String poll() {
		String str = "";
		if (isEmpty()) {
			return null;
		} else {
			str = first.data;
			first = first.next;
		}
		numElements--;
		return str;

	}

//     public void push(String data) {
//    	Node newNode= new Node(data);
//    	if (isEmpty()) {
//    		first=newNode;
//    	}
//    	else {
//    		newNode.next=first;
//    		first=newNode;
//    	}
//    	numElements++;
//    }

}
