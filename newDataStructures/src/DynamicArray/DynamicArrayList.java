	package DynamicArray;
	
	public class DynamicArrayList {
		private int numElements;
		private String[] elements;
	
		public DynamicArrayList() {
			elements = new String[10];
			numElements = 0;
		}
	
		public DynamicArrayList(int size) {
			elements = new String[size];
			numElements = 0;
		}
	
		// 1. A method called size() that:
		// a. Takes no parameters
		// b. Returns the number of elements currently stored in your list’s data array.
	
		public int size() {
			return numElements;
		}
	
		// 2. A method called get() that:
		// a. Takes 1 parameter, the position (an int) of the element to be retrieved
		// b. Checks that the position is within the bounds of the data in the array
		// i. If the position is invalid, throws an IndexOutOfBounds exception
		// ii. If the position is valid, returns the data in this position
	
		public String get(int pos) {
			if (pos < 0 || pos > numElements) {
				throw new IndexOutOfBoundsException("Incorrect postion");
			} else {
				return elements[pos];
			}
		}
	
		// 3. A method called indexOf() that:
		// a. Takes 1 parameter, the element (a String) to find within the
		// DynamicArrayList
		// b. Performs a linear search to find a match for the supplied element:
		// i. Loops through the data in the array from the start up as far as the last
		// slot containing data
		// (remember, the array might have blanks at the end – what is the position of
		// the first empty
		// space?) and checks each one to see if it matches the specified element using
		// .equals()
		// ii. If it finds a match, it should return the position of the element
		// iii. If it reaches the end of the array and hasn’t found a match, it should
		// return -1
	
		public int indexOf(String str) {
			int pos = -1;
			for (int i = 0; i < numElements; i++) {
				if (elements[i].equals(str)) {
					pos = i;
	
				}
			}
			return pos;
		}
	
		public int indexOf1(String str) {
			for (int i = 0; i < numElements; i++) {
				if (elements[i].equalsIgnoreCase(str)) {
					return i;
	
				}
			}
			return -1;
		}
	
		// 4. A method called add() that:
		// a. Takes 1 parameter, the String to be stored in your list’s data array
		// b. Checks that there is enough space to fit the new element
		// i. If there is not enough space – grow the array by:
		// Data Structures Dynamic Arrays
		// 1. Creating a new array 10 elements larger than the original
		// 2. Copy the data from the original array to the new one (either using
		// arraycopy or
		// manually copying it)
		// 3. Replace the original array with the new array
		// c. Adds the new element to the end of the data in the array
		// d. Updates the number of elements currently stored
		public String[] grow() {
			int slot = 0;
			String[] newArray = new String[elements.length + 10];
	
			for (int i = 0; i <numElements; i++) {
	
				newArray[slot] = elements[i];
				slot++;
			}
	
			return newArray;
		}
	
		public String[] grow1() {
			int slot = 0;
			String[] newArray = new String[elements.length + 1];
			for (int i = 0; i < numElements; i++) {
				newArray[slot] = elements[i];
				slot++;
			}
			return newArray;
		}
	
		public boolean add(String str) {
			if (numElements == elements.length) {
				elements = grow1();
			}
			elements[numElements] = str;
			numElements++;
			return true;
		}
	//		1. A method called add() that:
	//			a. Takes 2 parameters:
	//			i. The String to be stored in your list’s data array
	//			ii. The position (an int) in which the data should be added
	//			b. Checks that the position is valid
	//			i. If the position is invalid, throws an IndexOutOfBoundsException
	//			c. Checks that there is enough space to fit the new element
	//			i. If there is not enough space – grow the array
	//			d. Shift-inserts the new element at the specified position
	//			e. Updates the number of elements currently stored
	
		public boolean shiftInsert(String str, int pos) {
			boolean isTrue = false;
			if (pos > numElements || str == null || pos < 0) {
				throw new IndexOutOfBoundsException("Position is out of bounds");
			} else {
				String prev = str;
				for (int i = pos; i < numElements; i++) {
					String temp = elements[i];
					elements[i] = prev;
					prev = temp;
				}
				isTrue = true;
			}
			return isTrue;
		}
	
		public boolean add(String str, int pos) {
			if (pos > numElements || pos < 0) {
				throw new IndexOutOfBoundsException("Position is out of bounds");
			}
			if (numElements == elements.length) {
				elements = grow();
			}
			shiftInsert(str, pos);
			numElements++;
			return true;
		}
		
		public boolean add2(String str, int pos) {
			if (pos >= numElements || pos < 0) {
				throw new IndexOutOfBoundsException("Position is out of bounds");
			}
			if (numElements == elements.length) {
				elements = grow();
			}
			String prev = str;
			for (int i = pos; i < numElements; i++) {
				String temp = elements[i];
				elements[i] = prev;
				prev = temp;
			}
			numElements++;
			return true;
		}
	
	//	2. A method called set() that:
	//		a. Takes 2 parameters:
	//		i. The String to be stored in your list’s data array
	//		ii. The position (an int) the new element should replace
	//		b. Checks that the position is valid
	//		i. If the position is invalid, throws an IndexOutOfBoundsException
	//		c. Stores a copy of the element at the specified position in a temporary variable.
	//		d. Overwrites the element at the specified position with the new one
	//		e. Returns the original contents of that position (which you stored in the temporary variable)
		public String set(String str, int pos) {
			if (pos >= numElements || pos < 0) {
				throw new IndexOutOfBoundsException("Position is incorrect,please try again");
			}
			String oldVal = elements[pos];
			elements[pos] = str;
			return oldVal;
		}
	//	3. A method called remove() that:
	//		a. Takes 1 parameter, the position (an int) of the element to be removed
	//		b. Checks that the position is valid
	//		i. If the position is invalid, throws an IndexOutOfBoundsException
	//		c. Stores the element from the specified position in a temporary variable
	//		d. Shift-deletes the new element from the specified position
	//		e. Updates the number of elements currently stored
	//		f. Returns the deleted element (that you stored in the temporary variable at step c)
	
		public  boolean shiftDel(String[] str, int pos) {
			boolean isTrue = false;
			if (pos >= numElements|| pos < 0) {
				isTrue = false;
			} else {
				for (int i = pos; i < numElements - 1; i++) {
					str[i] = str[i + 1];
				}
				str[numElements - 1] = "null";
	
				isTrue = true;
			}
			return isTrue;
		}
	
		public String remove(int pos) {
			if (pos >= numElements || pos < 0) {
				throw new IndexOutOfBoundsException("Position out of bounds");
			}
			String oldVal = elements[pos];
			for (int i = pos; i < numElements - 1; i++) {
				elements[i] = elements[i + 1];
			}
			elements[elements.length - 1] = "null";
			numElements--;
			return oldVal;
		}
	
	//	1. A method called remove() that:
	//		a. Takes 1 parameter: the element to be removed (A String)
	//		b. Locates the element to be removed in the list.
	//		c. If the element can be found:
	//		i. Shift-deletes the element from that position (and ONLY that position)
	//		ii. Updates the number of elements currently stored
	//		iii. Returns true
	//		d. If the element cannot be found, returns false
	
		public boolean remove(String value) {
			boolean isdelete = false;
			for (int i = 0; i < numElements; i++) {
				if (elements[i].equals(value)) {
					isdelete = shiftDel(elements, i);
					numElements--;
					break;
				} else {
					isdelete = false;
				}
			}
			return isdelete;
		}
	
		public boolean removeAll(String value) {
			boolean isTrue = false;
	
			for (int i = 0; i < numElements; i++) {
				while (elements[i].equals(value)) {
					shiftDel(elements, i);
					numElements--;
					isTrue = true;
				}
	
			}
			return isTrue;
		}
	
	//	2. A method called contains() that:
	//		a. Takes 1 parameter: the element to be found (a String)
	//		b. Locates the element within the list (bonus points if you can see how to use a method you’ve already
	//		written to do this!)
	//		i. Returns true if the element can be found
	//		ii. Returns false if the element can’t be found
	
		public boolean contains(String value) {
	//		boolean appear = false;
			for (int i = 0; i < numElements; i++) {
				if (elements[i].equals(value)) {
					return true;
				}
	
			}
			return false;
		}
	
	//	3. A method called clear() that:
	//		a. Takes no parameters
	//		b. Deletes all elements in the list
	//		i. This can be done the slow way (deleting each element, one at a time) or the quick way – can
	//		you find the quick way?
	//		c. Resets the number of elements to 0
	//		d. Returns nothing
		public void clear() {
			elements = new String[0];
			numElements = 0;
	
		}
	//	4. A method called isEmpty() that:
	//		a. Takes no parameters
	//		b. Returns true if there are no elements in the list
	//		c. Returns false if there are 1 or more elements in the list
	
		public boolean isEmpty() {
			boolean isTrue = false;
			if (numElements == 0) {
				isTrue = true;
			} else {
				isTrue = false;
			}
			return isTrue;
		}
	
	}
