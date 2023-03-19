package DynamicArray;

//CORRECTIONS
public class dyanamicarraylistca {

	private int numElements;
	private String[] elements;

	/**
	 *
	 * It is a default no argument constructor. Which sets the array length at 10
	 * for default elements length
	 *
	 */
	public dyanamicarraylistca() {
		// Implement a list to store Strings. This list should be implemented as a
		// dynamic array class named DynamicArrayList, and
		// should have a standard initial capacity of 10. The following functionality
		// should be provided:
		elements = new String[10];
		numElements = 0;
	}

	/**
	 *
	 * A parameterised constructor. Of which int size is used as a parameter,
	 * undergoing a validation check if below 0 IllegalArgumentException is thrown
	 * otherwise the arrays size is selected
	 *
	 * @param size the capacity of which the list will hold
	 */
	public dyanamicarraylistca(int size) {

		if (size <= 0) {
			throw new IllegalArgumentException("Value must be above zero");
		} else {
			elements = new String[size];
			numElements = 0;
		}
	}

	/**
	 * a method called size, which returns the lists capacity
	 *
	 * @return numElements, the number of elements stored in the list
	 */
	public int size() {
		// 1. A method called size() that takes no parameters & returns the number of
		// elements currently stored in your list.
		return numElements;
	}

	/**
	 *
	 * Method: get, uses pos of type int as a parameter to retrieve the element in
	 * the slot specified
	 *
	 * The position is validated and if it is beyond the lists capacity or below 0
	 * an IndexOutOfBoundsException is thrown otherwise the element in the slot is
	 * returned
	 *
	 * @param pos, the position used to search the slots of the lists
	 *
	 * @return elements[pos], the String value returned from lists slot
	 */
	public String get(int pos) {
		// 2. A method called get() that takes one parameter, an int representing the
		// position from which data should be
		// retrieved. The position should be validated and invalid positions handled
		// accordingly.
		// If the position is valid, the method should return the data (a String) in the
		// position specified.
		if (pos < 0 || pos >= numElements) {
			throw new IndexOutOfBoundsException("Position must be between zero and the arrays length");
		} else {
			return elements[pos];
		}
	}

	/**
	 *
	 * Method: indexOf, where which a linear search is used to find a match with the
	 * value and returns the position in the list if not found -1 is returned
	 *
	 * @param value, which is used to search the list for a match
	 * @return pos, which is the number of where the value is on the list
	 */
	public int indexOf(String value) {
		// 3. A method called indexOf() that takes one parameter, a String to be found
		// in the list. The method should return
		// an int indicating the position at which the String could be found. If the
		// String could not be found, an appropriate
		// value should be returned to indicate this.
//        int pos = -1;
		for (int i = 0; i < numElements; i++) {
			if (elements[i].equals(value)) {
				return i;

			}
		}
		return -1;
	}

	/**
	 * Method: grow, which is used to grow the array by creating a new one and
	 * copying all the values from the original to the newArray
	 *
	 * @return newArray[], the newArray created with an array length plus one
	 */
	private String[] grow() {

		int slot = 0;
		String[] newArray = new String[elements.length + 10];
		for (String element : elements) {
			newArray[slot] = element;
			slot++;
		}
		return newArray;
	}

	/**
	 * Method: add, uses a String value to add to the list
	 *
	 * This method checks if there is capacity to add the value if the capacity is
	 * equal to the array length, the array length is increased with the grow
	 * method, making a slot free to add the value to and increasing the capacity
	 *
	 * @param: value, the value to be added to the list
	 *
	 * @return true, indicating the value has been added to the last at the last
	 *         slot
	 *
	 */
	public boolean add(String value) {
		// 4. A method called add() that takes a single parameter, a String to be added.
		// This String should be added to the
		// end of the list. If there is insufficient space in the list, the internal
		// array should be grown (using the arraycopy
		// method from JavaÂ?s API OR your own growArray algorithm) and the String added
		// then.
		// The method should return a boolean indicating that the String was added.

		if (numElements == elements.length) {
			elements = grow();
		}
		elements[numElements] = value;
		numElements++;
		return true;
	}

	/**
	 * Set, uses pos of type int as a parameter to retrieve the element in
	 * the slot specified and value to replace the element
	 *
	 * The position is validated and if it is beyond the lists capacity or below 0
	 * an IndexOutOfBoundsException is thrown otherwise the element in the slot will
	 * be copied to a variable oldVal and the blank slot in the list overwritten
	 * with the value
	 *
	 * @param pos,   the position that will be used to find the slot
	 * @param value, the String that will replace the value in the slot
	 *
	 * @return oldVal, the former value that was replaced by the new value
	 */
	public String set(int pos, String value) {
		// 5. A method called set() that takes two parameters, a String to be added and
		// a position at which to insert the data.
		// The position should be validated and invalid positions handling accordingly.
		// If the position is valid, the data at that position should be replaced with
		// the supplied String, and the original
		// content of that position should be returned.
		if (pos >= numElements || pos < 0) {
			throw new IndexOutOfBoundsException("Position must be between zero and below the arrays length");
		}
		String oldVal = elements[pos];
		elements[pos] = value;
		return oldVal;
	}

//	/**
//	 *
//	 * Method: shiftDel, uses parameters array and the position of which to delete
//	 * from, this method is used in removeAll
//	 *
//	 * @param: arr  [], the array used to search for the position
//	 * @param: pos, the position to be found and replace the value at the position
//	 *              found
//	 *
//	 * @return: isTrue, a boolean indicating whether the value was deleted
//	 *
//	 */
//	public boolean shiftDel(String[] arr, int pos) {
//
//		boolean isTrue;
//		if (pos > numElements || pos < 0) {
//			isTrue = false;
//		} else {
//			for (int i = pos; i < numElements - 1; i++) {
//				arr[i] = arr[i + 1];
//			}
//			arr[arr.length - 1] = "null";
//
//			isTrue = true;
//		}
//		return isTrue;
//	}
//
//	/**
//	 *
//	 * Method: remove, the value is used to search the list if the value exists and
//	 * the shiftDel method is performed to delete the value and the list's capacity
//	 * is decreased. This method is used in removeAll
//	 *
//	 * @param value the String value which is used to search the element in the
//	 *              DynamicArraylist in order to delete
//	 *
//	 * @return isDelete, boolean returned if the value had been deleted
//	 */
//	public boolean remove(String value) {
//
//		boolean isDelete = false;
//		for (int i = 0; i < numElements; i++) {
//			if (elements[i].equals(value)) {
//				isDelete = shiftDel(elements, i);
//				numElements--;
//			} else {
//				isDelete = false;
//			}
//		}
//		return isDelete;
//	}
//
//	/**
//	 *
//	 * Method: removeAll uses a parameter value type String to search for the slots
//	 * and removes all instances from the list, using contains and remove methods
//	 * shiftDel methods to delete each value
//	 *
//	 * @param value a String variable for the value to be deleted
//	 *
//	 * @return isTrue, indicating all values were deleted
//	 */
//	public boolean removeAll(String value) {
//		// 6. A method called removeAll() that takes one parameter Â? the String to be
//		// removed. All instances of this String
//		// should be removed from the list.
//		// The method should return a boolean indicating that the String was removed.
//		boolean isTrue = false;
//
//		for (int i = 0; i < numElements; i++) {
//			if (contains(value)) {
//				remove(value);
//				isTrue = true;
//			}
//
//		}
//		return isTrue;
//	}

	/**
	 *
	 * Method: removeAll uses a parameter value type String to search for the slots
	 * and removes all instances from the list, using contains and remove methods
	 * shiftDel methods to delete each value
	 *
	 * @param value a String variable for the value to be deleted
	 *
	 * @return isTrue, indicating all values were deleted
	 */
	public boolean removeAll(String value) {
		// 6. A method called removeAll() that takes one parameter Â? the String to be
		// removed. All instances of this String
		// should be removed from the list.
		// The method should return a boolean indicating that the String was removed.
		boolean isTrue = false;
		int newSize = 0;
		for (int i = 0; i < numElements; i++) {
			if (!elements[i].contains(value)) {
				elements[newSize] = elements[i];
				newSize++;
			} else {
				isTrue = true;
			}
		}
		numElements = newSize;
		return isTrue;
	}

	/**
	 *
	 * Method: contains, which linear searches the array to find the slot containing
	 * the value and returning a boolean isTrue if the value exists
	 *
	 * @param value, the value which is used to search the array
	 *
	 * @return isTrue, indicating whether the value exists in the array
	 */
	public boolean contains(String value) {

		boolean isTrue = false;
		for (int i = 0; i < numElements; i++) {
			if (elements[i].equals(value)) {
				isTrue = true;
			}

		}
		return isTrue;
	}

	/**
	 *
	 * Method: isEmpty, checks if the list is empty or not through ensuring if the
	 * capacity is equal to zero if so isTrue is true else it is false
	 *
	 * @return isTrue, if there is any capacity within the list
	 */
	public boolean isEmpty() {
		// 7. A method called isEmpty() that takes no parameters. This should return
		// whether or not there is data currently
		// stored in the list.
		return numElements == 0;
	}
}
