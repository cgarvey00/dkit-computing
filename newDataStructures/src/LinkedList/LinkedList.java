package LinkedList;

public class LinkedList {

	// b. An int called count or numElements – this will track how many elements are
	// stored in the list.
	private int numElements;
	// c. A Node called first – this will store the first element in the list
	// ( initialised to null).
	private Node first = null;

	// a. A class called Node. This should:
	// i. Be created within the same file as the LinkedList class.
	// ii. Be created as a private static class.
	private static class Node {
		// 1. A String called data – The information to be stored in the list.
		// 2. A Node called next – This will point to the node after this one in the
		// list.
		private String data;
		private Node next;

		// 3. A constructor that takes a single parameter, a String representing the
		// data to be
		// stored. This constructor should store the incoming information in your data
		// variable,
		// and set your next node to null.
		public Node(String data) {
			this.data = data;
			this.next = null;
		}

		// public String getData() {
		// return data;
		// }

		// public Node getNext() {
		// return next;
		// }

		// 4. A method called hasNext() that returns whether or not next == null.
		public boolean hasNext() {
			return next != null;
		}
	}

	// 2. Create one constructor:
	// a. A default constructor that sets the first element in the list to null.
	public LinkedList() {
		first = null;
	}

	// 1. A method called size() that:
	// a. Takes no parameters
	// b. Returns the number of elements currently stored in your list.
	public int size() {
		return numElements;
	}

	// 2. A method called get() that:
	// a. Takes 1 parameter, the position (an int) of the element to be retrieved
	// b. Checks that the position is within the bounds of the data in the list
	// i. If the position is invalid, throws an IndexOutOfBounds exception
	// ii. If the position is valid, returns the data in this position
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

	// 3. A method called indexOf() that:
	// a. Takes 1 parameter, the element (a String) to find within the LinkedList
	// b. Performs a linear search to find a match for the supplied element:
	// i. Loops through the data in the list from the start up as far as the last
	// node in the list
	// (remember, the last node in the list will have its next element set to null)
	// and checks each
	// one to see if it matches the specified element using .equals()
	// ii. If it finds a match, it should return the position of the element
	// iii. If it reaches the end of the list and hasn’t found a match, it should
	// return -1
	public int indexOf(String text) {
		Node current = first;
		int count = 0;
		while (current != null) {
			if (current.data.equals(text)) {
				return count;
			} else {
				current = current.next;
				count++;
			}
		}
		return -1;
	}

	// for ints
	public int indexOf(int value) {
		if (first == null) {
			return -1;
		}
		int pos = -1;
		Node current = first;
		for (int i = 0; i < size(); i++) {
			if (current.data.equals(value)) {
				return i;
			}
			current = current.next;
		}
		return pos;
	}

	// 4. A method called addFirst() that:
	// a. Takes 1 parameter, the String to be stored in your list.
	// b. Creates a new Node (newNode) containing the data to be added.
	// c. Adds newNode to the start of the data in the list. To do this, you should:
	// i. Set newNode.next = first (add the new node to the start of the list, in
	// front of the original
	// first element)
	// ii. Set first = newNode (set the new node to be the official start of the
	// list)
	// d. Updates the number of elements currently stored
	public void addFirst(String str) {
		Node newNode = new Node(str);
		if (isEmpty()) {
			first = newNode;
		} else {
			newNode.next = first;
			first = newNode;
		}
		numElements++;
	}

	// 5. A method called add() that:
	// a. Takes 1 parameter, the String to be stored in your list.
	// b. Creates a new Node (newNode) containing the data to be added.
	// c. Adds newNode to the end of the data in the list. If the list is empty, you
	// can just set first = newNode.
	// If the list contains data, you will need to loop to the end of the list by:
	// i. Creating a current variable and setting it equal to the first node in the
	// list.
	// ii. While current.hasNext() != null (i.e. while you’re not at the end of the
	// list), set current =
	// current.next (move to the next element in the list)
	// iii. When this loop ends, current will be pointing to the last node in the
	// list. To add your new
	// element to the end, set current.next = newNode.
	// d. Updates the number of elements currently stored.
	public void add(String str) {
		Node newNode = new Node(str);
		if (isEmpty()) {
			first = newNode;
		} else {
			Node current = first;
			while (current.hasNext()) {
				current = current.next;
			}
			current.next = newNode;
		}
		numElements++;
	}

	// 1. A method called add() that:
	// a. Takes 2 parameters:
	// i. The String to be stored in your list.
	// ii. The position (an int) in which the data should be added
	// b. Checks that the position is valid
	// i. If the position is invalid, throws an IndexOutOfBoundsException
	// c. Shift-inserts the new element at the specified position. In a link-based
	// list, this means inserting the
	// new element BETWEEN the node immediately before the specified position (i.e.
	// at position – 1) and
	// the node at the specified position. You should do this by:
	// i. Creating a new Node (newNode) containing the data to be added.
	// ii. Looping to the element BEFORE the position you want to insert at.
	// iii. Setting the next variable of newNode as the next from your current
	// element (i.e. the one at
	// which you stopped looping).
	// iv. Setting the next variable of the current element to point to newNode.
	// d. Updates the number of elements currently stored
	public void add(String str, int pos) {
		Node newNode = new Node(str);
		if (pos > numElements || pos < 0) {
			throw new IndexOutOfBoundsException("Position is out of bounds");
		} else if (pos == 0) {
			newNode.next = first;
			first = newNode;
		} else {
			Node current = first;
			for (int i = 0; i < pos - 1; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
		numElements++;
	}

	public boolean add2(String str, int pos) {
		if (size() == 0 || pos < 0 || pos > numElements) {
			throw new IndexOutOfBoundsException("Position is out of bounds");
		}
		Node current = first;
		Node newNode = new Node(str);
		for (int i = 0; i < pos - 1; i++) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
		numElements++;
		return true;

	}

	public boolean add3(String str, int pos) {
		if (size() == 0 || pos < 0 || pos > numElements) {
			throw new IndexOutOfBoundsException("Position is out of bounds");
		}
		if (pos == 0) {
			Node newNode = new Node(str);
			newNode.next = first;
			first = newNode;
		}
		Node current = first;
		Node newNode = new Node(str);
		for (int i = 0; i < pos - 1; i++) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
		numElements++;
		return true;

	}

	// 2. A method called remove() that:
	// a. Takes 1 parameter, the position (an int) of the element to be removed
	// b. Checks that the position is valid
	// i. If the position is invalid, throws an IndexOutOfBoundsException
	// c. Checks if they wish to remove the first element (i.e. the data at
	// position). If so:
	// i. Store a copy of the data at that position in a temp variable.
	// ii. Set first = first.next (i.e. snip the element out of the list by skipping
	// it)
	// d. Otherwise:
	// i. Creates a temporary Node called current (to point to the element you’re
	// currently on) and
	// sets it equal to first.
	// ii. Creates a temporary Node called previous (to point to the element before
	// the one you’re
	// currently on) and sets it to null.
	// Remember: It’s ok to have more
	// than one method in the same
	// class with the same name, as long
	// as they have different parameter
	// lists.
	// iii. Loops through the list until you reach the position from which to
	// delete, updating the
	// previous and current nodes as you go.
	// iv. Saves the data in current to a temp variable.
	// v. Sets previous.next = current.next (i.e. snip the element out of the list
	// by skipping it)
	// e. Updates the number of elements currently stored
	// f. Returns the deleted element (that you stored in the temporary variable)
	public String remove(int pos) {
		if (pos >= numElements || pos < 0) {
			throw new IndexOutOfBoundsException("Position is not valid, Please try again");
		}
		String data = null;
		if (pos == 0) {
			data = first.data;
			first = first.next;
		} else {
			Node current = first;
			Node previous = null;
			for (int i = 0; i < pos; i++) {
				previous = current;
				current = current.next;
			}
			data = current.data;
			previous.next = current.next;

		}
		numElements--;
		return data;
	}

	// 1. A method called set() that:
	// a. Takes 2 parameters:
	// i. The String to be stored in your list.
	// ii. The position (an int) the new element should replace.
	// b. Checks that the position is valid
	// i. If the position is invalid, throws an IndexOutOfBoundsException
	// c. Overwrites the element at the specified position with the new one. In a
	// link-based list, this is done
	// by:
	// i. Looping to the element at the position you wish to overwrite.
	// ii. Storing a copy of the data stored in that element in a temporary variable
	// (String temp = current.data;)
	// iii. Setting the data variable within your current element (current.data) to
	// be equal to the new
	// value.
	// iv. Returning the copy of the data that was in the specified position
	// originally (the one you
	// stored in your temporary variable).
	public String set(String str, int pos) {
		String temp = "";
		int i = 0;
		if (pos >= numElements || pos < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node current = first;
		Node previous = first.next;
		while (current != null) {
			if (i == pos) {
				temp = current.data;
				current.data = str;
				break;
			}
			previous = current;
			current = current.next;
			i++;
		}
		return temp;
	}

	// method2
	public String set2(int pos, String value) {
		String temp = "";
		if (isEmpty() || pos >= numElements || pos < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			Node current = first;
			for (int i = 0; i < pos; i++) {
				current = current.next;
			}
			temp = current.data;
			current.data = value;
			return temp;
		}
	}

	// 2. A method called remove() that:
	// a. Takes 1 parameter: the element to be removed (A String)
	// b. Checks if the list is empty and returns false if it is.
	// c. Checks if the first element’s data matches the information to be removed.
	// If it does:
	// i. Set first = first.next (remove the first element from the chain)
	// ii. Update the number of elements currently stored
	// iii. Return true
	// d. Otherwise, loops through the list started at first.next (tracking the
	// current element (set to first.next)
	// AND the previous element (set to first) using temporary nodes) and for each:
	// i. Checks if the current node equals what is being searched for. If it is:
	// 1. Set previous.next = current.next (i.e. snips the element out of the list
	// by skipping it)
	// 2. Update the number of elements currently stored
	// 3. Return true
	// ii. If it’s not:
	// 1. Updates previous and current
	// e. If it reaches the end of the list, the element cannot be found and the
	// method should return false.
	public boolean remove(String data) {
		boolean isRemove = false;
	
		if (first.data.equals(data)) {
			first = first.next;
			numElements--;
			isRemove = true;
		}
		Node current = first.next;
		Node previous = first;
		
		while (current != null) {
			if (current.data.equals(data)) {
				previous.next = current.next;
				numElements--;
				isRemove = true;
			}
			previous = current;
			current = current.next;

		}
		return isRemove;
	}

	public String remove2(int pos) {
		if (pos < 0 || pos >= numElements) {
			throw new IndexOutOfBoundsException();
		}
		String val;
		if (pos == 0) {
			val = first.data;
			first = first.next;
			numElements--;
			return val;
		}
		Node current = first;
		for (int i = 0; i < pos - 1; i++) {
			current = current.next;
		}
		val = current.next.data;
		current.next = current.next.next;
		numElements--;
		return val;
	}

	
	// 3. A method called contains() that:
	// Again, it’s ok to have two
	// methods called remove() in the
	// same class, because they have
	// different parameters.
	// a. Takes 1 parameter: the element to be found (a String)
	// b. Locates the element within the list (bonus points if you can see how to
	// use a method you’ve already
	// written to do this!)
	// i. Returns true if the element can be found
	// ii. Returns false if the element can’t be found
	public boolean contains(String str) {
		boolean isTrue = true;
		if (first == null) {
			isTrue = false;
		}
		Node current = first;
		while (current != null) {
			if (current.data == str) {
				isTrue = true;
			}
			current = current.next;
		}
		return isTrue;

	}

	// 4. A method called clear() that:
	// a. Takes no parameters
	// b. Deletes all elements in the list
	// i. This can be done the slow way (deleting each element, one at a time) or
	// the quick way – can
	// you find the quick way?
	// c. Resets the number of elements to 0
	// d. Returns nothing
//	public void clear() {
//		Node current = null;
//		Node head = null;
//		numElements = 0;
//	}

	// Second method clear
	public void clear() {
		Node first = null;
		numElements = 0;
	}

	// 7. A method called isEmpty() that takes no parameters. This should return
	// whether or not there is data currently
	// stored in the list.
	// checking first is null
	public boolean isEmpty() {
		boolean isTrue = false;
		if (numElements == 0) {
			isTrue = true;
		} else {
			isTrue = false;
		}
		return isTrue;
	}

	public boolean isEmpty2() {
		// return numElements==0;
		return first == null;
	}
}
