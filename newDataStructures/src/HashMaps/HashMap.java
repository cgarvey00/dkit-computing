package HashMaps;

public class HashMap {
//	1. Create a class called HashMap. It should contain:
//		a. A class called Entry. This should:
//		i. Be created within the same file as the HashMap class.
//		ii. Be created as a private static class.
//		iii. Contain:
//		1. A final String called key – The key based on which you will search.
//		2. An Integer called value – The value (or data) associated with that particular key.
//		3. A constructor that takes two parameters, a String representing the key to be stored
//		and an Integer representing the phone number/value to be stored.
//		b. An int called count– this will track how many pairings/mappings are stored in the map.
//		c. An array of Entry objects called data – this will store all of the key-value pairs in the map.
//		2. Create one constructor:
//		a. A default constructor that initialises the array to a fixed size (100).
	private static class Entry<String, Integer> {
		private final String key;
		private Integer value;

		public Entry(String key, Integer value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * @return the value
		 */
		public Integer getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(Integer value) {
			this.value = value;
		}

	}

	private int count;
	private Entry<String, Integer> data[];

	public HashMap() {
		data = (Entry<String, Integer>[]) new Entry[100];
		count = 0;
	}

//	The following methods should be created within the HashMap class:
//		1. A method called size() that:
//		a. Takes no parameters.
//		b. Returns the number of pairings currently in the map.
	public int size() {
		return count;
	}

//	2. A method called hashFunction() that:
//		a. Takes a single parameter: A String (key) to use in its calculation.
//		b. Calls hashCode on the key to calculate its numeric value.
//		c. Gets the absolute value of the calculated hashCode (using Math.abs) and stores it in an int called
//		result.
//		d. Gets the remainder of dividing result by the size of the array holding the map and returns it. This can
//		be done using the % function (e.g. 5 % 3 would return 2, as 2 is the remainder of dividing 5 by 3).
	public int hashFunction(String key) {
		int hash = Math.abs(key.hashCode());
		return hash % data.length;
	}

//	3. A method called put() that:
//		a. Takes 2 parameters, the key and value of the new element to be stored in your map.
//		b. Calls hashFunction (based on the key supplied to this method as a parameter) to calculate the
//		appropriate slot for this new entry
//		c. Checks if the specified slot is empty (i.e. null)
//		d. If it is null:
//		i. Creates a new Entry (newEntry) containing the data to be added.
//		ii. Adds newEntry to the specified slot in your data array.
//		iii. Updates the number of elements currently stored.
//		iv. Returns null (indicating nothing was replaced).
//		e. If it’s not null:
//		i. Saves the original value currently in the specified slot as a temp variable.
//		ii. Replaced the value with the new value (supplied as a parameter in this method).
//		iii. Returns the temp variable (containing the original value that was just replaced).
	public Integer put(String key, Integer value) {
		int slot = hashFunction(key);
		if (data[slot] == null) {
			Entry<String, Integer> newEntry = new Entry(key, value);
			data[slot] = newEntry;
			count++;
			return null;
		} else {
			Integer oldVal = data[slot].getValue();
			data[slot].setValue(value);
			return oldVal;
		}
	}

//	4. A method called get() that:
//	a. Takes 1 parameter: The key of the element to be located in the map.
//	b. Calls hashFunction (based on the key supplied as a parameter to this method) to calculate the slot in
//	which the corresponding value should be located.
//	c. Checks if the slot contains anything
//	i. If the slot contains null, return null
//	ii. If the slot does not contain null, return the value (an Integer) stored within the slot’s Entry
//	object.
	public Integer get(String key) {
		int slot = hashFunction(key);
		if (data[slot] == null) {
			return null;
		} else {
			return data[slot].getValue();
		}
	}

}
