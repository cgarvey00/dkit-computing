package Queues;

public class BoundedQueue<E> extends Queue {

	private final int maxCapacity;
//	    Before you can extend your Queue class, you will need to modify it slightly:
//		1. Amend the count field in your Queue class from private to protected.
//		Create a class called BoundedQueue:
//		1. Extends your Queue class
//		2. Contains a final int called maxCapacity
//		3. Contains two constructors (in both cases, your Queue’s constructor should be called first, using super();):
//		a. A default constructor that sets your maxCapacity to 10
//		b. A parameterized constructor that takes 1 parameter – a value for the maxCapacity.
//		i. If the maximum capacity supplied is invalid (<= 0), throw an IllegalArgumentException
	public BoundedQueue() {
		super();
		maxCapacity = 10;
	}

	public BoundedQueue(int maxCapacity) {
		super();
		if (maxCapacity <= 0) {
			throw new IllegalArgumentException();
		} else {
			this.maxCapacity = maxCapacity;
		}
	}
	//	1. A method called add() that:
	//		a. Takes 1 parameter, the Song to be stored in your queue.
	//		b. Checks if there is sufficient space left in the Queue to add this element
	//		i. If the Queue is full, throws an IllegalStateException*
	//		c. If sufficient space exists, uses the add method from the super class to carry out the addition logic.
	public boolean add(String data) {
		if (numElements == maxCapacity) {
			throw new IllegalStateException();
		} else {
			return super.add(data);
		}
//		return false;
	}
	//	2. A method called isFull() that:
	//		a. Takes no parameters.
	//		b. Returns true if there is space remaining in the queue.
	//		c. Returns false if there is no space remaining in the queue.
	public boolean isFull() {
		boolean isTrue = false;
		if (numElements == maxCapacity) {
			isTrue = false;
		} else {
			isTrue = true;
		}
		return isTrue;
	}
	//	The following methods should be created within the BoundedQueue class:
	//	1. A method called offer() that:
	//	a. Takes 1 parameter, the Song to be stored in your queue.
	//	b. Checks if there is sufficient space to add this Song.
	//	i. If there is not enough space, return false
	//	ii. If there is enough space, use the add() method from your super class to carry out the
	//	addition and return its result
	public boolean offer(String data) {
		boolean isTrue = false;
		if (numElements == maxCapacity) {
			isTrue = false;
		} else {
			isTrue = add(data);
		}

		return isTrue;
	}

}