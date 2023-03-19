//package LListutils;
//
//import LListbusiness.Song;
//
///**
// *
// * @author Conor Garvey
// * 
// */
//public class LinkedList {
//	private int numElements;
//	private Node first;
//
//	public LinkedList() {
//		first = null;
//	}
//
//	private static class Node {
//		private Song songs;
//		private Node next;
//
//		public Node(Song songs) {
//			this.songs = songs;
//			this.next = null;
//		}
//
//		public Song getSongs() {
//			return songs;
//		}
//
//		public Node getNext() {
//			return next;
//		}
//
//		public boolean hasNext() {
//			return next != null;
//		}
//	}
//
//	// 1 . A method called size() that takes no parameters & returns the number of
//	// Songs currently stored in your list
//	public int size() {
//		return numElements;
//	}
//
//	// 2. A method called size() that takes no parameters & returns the number of
//	// Songs currently stored in your list
//	public Song get(int pos) {
//		if (isEmpty() || pos >= numElements || pos < 0) {
//			throw new IndexOutOfBoundsException();
//		} else {
//			Node current = first;
//			for (int i = 0; i < pos; i++) {
//				current = current.next;
//			}
//			return current.songs;
//
//		}
//	}
//
//	// 3. A method called indexOf() that takes one parameter, a Song to be found in
//	// the list. The method should return
//	// an int indicating the position at which the Song could be found. If the Song
//	// could not be found, an appropriate
//	// value should be returned to indicate this.
//	public int indexOf(Song text) {
//		Node current = first;
//		int count = 0;
//		while (current != null) {
//			if (current.songs.equals(text)) {
//				return count;
//			} else {
//				current = current.next;
//				count++;
//			}
//
//		}
//		return -1;
//	}
//
//	// 4. A method called add() that takes a single parameter, a Song to be added to
//	// the end of the list.
//	// The method should return a boolean indicating that the Song was added.
//	public boolean add(Song str) {
//		boolean songAdded = false;
//		Node newNode = new Node(str);
//		if (isEmpty()) {
//			first = newNode;
//			songAdded = true;
//		} else {
//			Node current = first;
//			while (current.hasNext()) {
//				current = current.next;
//
//			}
//			current.next = newNode;
//			songAdded = true;
//		}
//		numElements++;
//		return songAdded;
//	}
//
//	public boolean add(Song song, int pos) {
//		if (size() == 0 || pos < 0 || pos > numElements) {
//			throw new IndexOutOfBoundsException("Position is out of bounds");
//		}
//		if (pos == 0) {
//			Node newNode = new Node(song);
//			newNode.next = first;
//			first = newNode;
//		}
//		Node current = first;
//		Node newNode = new Node(song);
//		for (int i = 0; i < pos - 1; i++) {
//			current = current.next;
//		}
//		newNode.next = current.next;
//		current.next = newNode;
//		numElements++;
//		return true;
//
//	}
//	
//	// 5. A method called set() that takes two parameters, a Song to be added and a
//	// position at which to insert the data.
//	// The position should be validated and invalid positions handling accordingly.
//	// If the position is valid, the data at that position should be replaced with
//	// the supplied Song, and the original
//	// content of that position (a Song) should be returned.
//	public Song set(int pos, Song str) {
//		Song temp = new Song();
//		int i = 0;
//		if (pos >= numElements || pos < 0) {
//			throw new IndexOutOfBoundsException();
//		}
//		Node current = first;
//		Node previous = first.next;
//		while (current != null) {
//			if (i == pos) {
//				temp = current.songs;
//				current.songs = str;
//				break;
//			}
//			previous = current;
//			current = current.next;
//			i++;
//		}
//
//		return temp;
//
//	}
//
//	// 6. A method called remove() that takes one parameter – the Song to be
//	// removed. Only the first instance of this
//	// Song should be removed from the list.
//	// The method should return a boolean indicating that the Song was removed.
//	public boolean remove(Song data) {
//		if (isEmpty()) {
//			return false;
//		}
//		if (first.songs.equals(data)) {
//			first = first.next;
//			numElements--;
//			return true;
//		}
//		Node current = first.next;
//		Node previous = first;
//
//		while (current != null) {
//			if (current.songs.equals(data)) {
//				previous.next = current.next;
//				numElements--;
//				return true;
//			}
//			previous = current;
//			current = current.next;
//
//		}
//		return false;
//	}
//
//	// 7. A method called isEmpty() that takes no parameters. This should return
//	// whether or not there is data currently
//	// stored in the list.
//	public boolean isEmpty() {
//		boolean isTrue = false;
//		if (numElements == 0) {
//			isTrue = true;
//		} else {
//			isTrue = false;
//		}
//		return isTrue;
//	}
//
//}
package LListutils;

import LListbusiness.Song;

/**
 *
 * @author michelle
 */
public class LinkedList {
	private int numElements;
	private Node first;
	private Node tail;

	public LinkedList() {
		first = null;
		tail = null;
	}

	private static class Node {
		private Song songs;
		private Node next;

		public Node(Song songs) {
			this.songs = songs;
			this.next = null;
		}
	}

	/**
	 * a method called size, which returns the lists capacity
	 *
	 * @return numElements, the number of elements stored in the list
	 */
	public int size() {
	// 1 . A method called size() that takes no parameters & returns the number of
	// Songs currently stored in your list
		return numElements;
	}

	/**
	 * get, uses pos of type int as a parameter to retrieve the element in the slot
	 * specified
	 *
	 * The position is validated and if it is beyond the lists capacity or below 0
	 * an IndexOutOfBoundsException is thrown otherwise the elements are looped
	 * through using a linear search and the song found at the specified position is
	 * returned
	 *
	 * @param pos, the position used to search the slots of the lists
	 * 
	 * @throws IndexOutOfBoundsException, thrown when the supplied position is below
	 *                                    0 or above the number of elements
	 * 
	 * @return current.songs the Song value returned from lists slot
	 *
	 */
	public Song get(int pos) {
	// 2. A method called get() that takes one parameter, an int representing the
	// position from which data should be
	// retrieved. The position should be validated and invalid positions handled
	// accordingly.
	// If the position is valid, the method should return the data (a Song) in the
	// position specified.
		if (size() == 0 || pos >= numElements || pos < 0) {
			throw new IndexOutOfBoundsException("Position must be between 0 and the arrays length");
		} else {
			Node current = first;
			for (int i = 0; i < pos; i++) {
				current = current.next;
			}
			return current.songs;
		}
	}

	/**
	 * indexOf, where which a linear search is used to find a match with the value
	 * and returns the position in the list if not found -1 is returned
	 *
	 * @param value, which is used to search the list for a match
	 *
	 * @return count, which is the number of where the song appears on the list
	 */
	public int indexOf(Song value) {
	// 3. A method called indexOf() that takes one parameter, a Song to be found in
	// the list. The method should return
	// an int indicating the position at which the Song could be found. If the Song
	// could not be found, an appropriate
	// value should be returned to indicate this.
		Node current = first;
		int count = 0;
		while (current != null) {
			if (current.songs.equals(value)) {
				return count;
			} else {
				current = current.next;
				count++;
			}

		}
		return -1;
	}

	/**
	 * add, uses a Song value to be inserted at the end of the List
	 *
	 * This method will add a Song to the LinkedList,an if statement checks whether
	 * or not the first Node is null or not and is added if it is null. Otherwise
	 * the LinkedList is iterated through by a while loop to the end of the List
	 * where the Song to be added and the boolean songAdded is set to true.
	 *
	 * @param: value, the Song to be added to the list
	 * 
	 * @return songAdded, whether or not the Song had been removed or not
	 *
	 */
	public boolean add(Song value) {
	// 4. A method called add() that takes a single parameter, a Song to be added to
	// the end of the list.
	// The method should return a boolean indicating that the Song was added.
		boolean songAdded = false;
		Node newNode = new Node(value);
		if (first == null) {
			first = newNode;
			songAdded = true;
		} else {
			Node current = first;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			songAdded = true;
		}
		numElements++;
		return songAdded;
	}

	/**
	 * add, this method checks if there is space in the list and whether to add a
	 * Song to the list at the specified position
	 * 
	 * This method initially validates the position whether or not it is within
	 * bounds and if no an IndexOutOfBoundsException is returned otherwise a new
	 * Node is created to facilitate the new Song being added to the list which is
	 * looped to and the current Node holds the Song inserted at the position it is
	 * set at and the number of elements update returning true
	 *
	 * @param song, an instance of the Song object that will be added
	 * @param pos,  the position where the song will be inserted to
	 * 
	 * @throws IndexOutOfBoundsException, thrown when the supplied position is below
	 *                                    0 or above the number of elements
	 *
	 * @return isTrue, the boolean which is returned whether the Song supplied has
	 *         been added to the list
	 */
	public boolean add(Song song, int pos) {
	// 5. A method called add() that takes in two parameters, a Song to be added to
	// the list and a position at which to
	// add it. The position should be validated, and invalid positions handled
	// accordingly. If the position is valid, the
	// Song should be added to the list at that position.
		boolean isTrue = false;
		if (size() == 0 || pos < 0 || pos > numElements) {
			throw new IndexOutOfBoundsException("Position must be between 0 and the arrays length");
		}
		if (pos == 0) {
			Node newNode = new Node(song);
			newNode.next = first;
			first = newNode;
			isTrue = true;
		} else {
			Node current = first;
			Node newNode = new Node(song);
			for (int i = 0; i < pos - 1; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
			numElements++;
			isTrue = true;
		}
		return isTrue;

	}

	/**
	 * toArray, this creates an array of Song objects from the LinkedList using a
	 * null Song object and a while loop iterating through the List and growing the
	 * arrays empty slots, the songArray is then returned
	 * 
	 * @return songArray, the boolean which is returned whether the string supplied
	 *         is a integer or not
	 */
	public Song[] toArray() {
	// 6. A method called toArray() that takes no parameters. The method should
	// return an array containing all Songs
	// in the list.
		Song songArray[] = new Song[numElements];
		Node current = first;
		int i = 0;
		Song s = null;
		while (current != null) {
			s = current.songs;
			songArray[i] = s;
			current = current.next;
			i++;
		}
		return songArray;
	}

	/**
	 * remove, this method checks if there is space in the list and whether to
	 * remove a Song to the list at the specified position
	 * 
	 * Initially the method . checks if the first Node contains the Song and if so
	 * it is deleted, numElements is then updated. If not the a while loop iterates
	 * through the List using a current and a previous Node once it matches the Song
	 * specified it is then deleted and the numElements is updated and isRemoved is
	 * set to true
	 * 
	 * @param data, an instance of the Song object to be removed
	 *
	 * @return isRemoved, the boolean which is returned whether the Song supplied is
	 *         a removed or not
	 */
	public boolean remove(Song data) {
	// 7. A method called remove() that takes one parameter – the Song to be
	// removed. Only the first instance of this
	// Song should be removed from the list.
	// The method should return a boolean indicating that the Song was removed
		boolean isRemoved = false;
		if (first.songs.equals(data)) {
			first = first.next;
			numElements--;
			isRemoved = true;
		}
		Node current = first.next;
		Node previous = first;

		while (current != null) {
			if (current.songs.equals(data)) {
				previous.next = current.next;
				numElements--;
				isRemoved = true;
			}
			previous = current;
			current = current.next;
		}
		return isRemoved;
	}

	/**
	 * isEmpty, uses a boolean to see whether or not the list is empty or not
	 *
	 * @return first==null, a boolean checking whether or not the first value is
	 *         null or not which
	 */
	public boolean isEmpty() {
	// 8. A method called isEmpty() that takes no parameters. This should return a
	// boolean indicating if there is data
	// currently stored in the list.
		return first == null;
	}

	/**
	 * tail, this method iterates throughout the list until it reaches its end and
	 * returning the last Song of the LinkedList
	 *
	 * @return tail.songs, the boolean which is returned whether the string supplied
	 *         is a integer or not
	 */
	public Song tail() {
	// 9. A method called tail() that takes no parameters. This should return the
	// last element in the list
		tail = first;
		Node current = first.next;
		while (current != null) {
			tail = current;
			current = current.next;
		}
		return tail.songs;
	}
}
