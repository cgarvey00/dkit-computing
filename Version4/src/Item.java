

import java.io.Serializable;

/**
 * 
 * @author Conor Garvey
 *
 */

// Class Item implements Serialised as a binary files
// contents are used to create item objects and a Comparable Interface
public class Item implements Serializable, Comparable<Item> {
	/*
	 * Instance variables
	 */
	private String name;
	private int uniqueID;
	private int quantityInStock;
	private double unitPrice;

	/*
	 * Static field id will set the value of the uniqueID increasing by one when an
	 * Item object is created
	 */
	private static int id = 0;

	/*
	 * No argument constructor containing a default quantityInStock and a standard
	 * uniqueID if the object reference is blank. This ensures every time a blank
	 * Item object is created the uniqueID is increased and contains a set
	 * quantityInStock
	 */
	public Item() {
		quantityInStock = 60000;
		id++;
		uniqueID = id;
	}

	/**
	 * This amends and constructs an Item with a specified uniqueID, name, quantity
	 * in stock and unit price
	 * 
	 * This constructor sets all values entered by the user to their parameters
	 * 
	 * @param name            the name of the Item
	 * @param quantityInStock the quantity of the item ordered
	 * @param unitPrice       the Item details of which is being ordered
	 * 
	 *                        the variable id increases by one as an item is created
	 * 
	 */
	public Item(String name, int quantityInStock, double unitPrice) {
		this.name = name;
		this.quantityInStock = quantityInStock;
		this.unitPrice = unitPrice;

		id++;
		uniqueID = id;
	}

	/*
	 * Getter Methods
	 */

	public String getName() {
		return this.name;
	}

	public int getuniqueID() {
		return this.uniqueID;
	}

	public int getquantityInStock() {
		return this.quantityInStock;
	}

	public double getunitPrice() {
		return this.unitPrice;
	}

	/*
	 * Mutator Methods
	 */

	public boolean setName(String name) {
		boolean isTrue = false;
		if (name.equals(null) || name.length() == 0) {
			isTrue = false;
		} else {
			isTrue = true;
			this.name = name;
		}
		return isTrue;
	}

	public boolean setuniqueID(int uniqueID) {
		boolean isTrue = false;
		if (uniqueID > 0 && uniqueID < 100) {
			this.uniqueID = uniqueID;
			isTrue = true;
		}

		return isTrue;
	}

	public boolean setquantityInStock(int quantityInStock) {
		boolean isTrue = false;
		if (quantityInStock >= 0 && quantityInStock <= 100) {
			this.quantityInStock = quantityInStock;
			isTrue = true;
		}

		return isTrue;
	}

	public boolean setunitPrice(double unitPrice) {
		boolean isTrue = false;
		if (unitPrice > 0.00) {
			this.unitPrice = unitPrice;
			isTrue = true;
		}
		return isTrue;
	}

	/**
	 * Updates the quantityInStock so that it increases with a supplied value
	 * 
	 * Ensures the quantityInStock per item is above a threshold before a change is
	 * made increasing the quantityInStock Instance variable
	 * 
	 * @param value, the quantity of which to decrease from
	 * 
	 * @return the boolean isTrue will be returned true or false whether the
	 *         quantity increase was successful or not
	 * 
	 */
	public boolean increasequantityInStock(int value) {
		boolean isTrue = false;
		if (value > 0) {
			this.quantityInStock = getquantityInStock() + value;
			isTrue = true;
		}
		return isTrue;
	}

	/**
	 * Updates the quantityInStock so that it decreases with a supplied value
	 * 
	 * Ensures the quantityInStock per Item is above a threshold before a change is
	 * made decreasing the quantityInStock instance variable
	 * 
	 * @param value, the quantity of which to decrease from
	 * 
	 * @return the boolean isTrue will be returned true or false whether the
	 *         quantity decrease was successful or not
	 * 
	 */
	public boolean decreasequantityInStock(int value) {
		boolean isTrue = false;
		if (value > 0) {
			this.quantityInStock = getquantityInStock() - value;
			isTrue = true;
		}
		return isTrue;
	}

	/**
	 * Overwrite method toString() uses the variables and prints them in order for
	 * the version1App
	 * 
	 * @return the Item details with the instance variables above in a formatted
	 *         manner
	 */
	@Override
	public String toString() {
		return "\n" + "--Item Details--" + "\n" + "Unique ID: " + this.uniqueID + "\n" + "Item Name: " + this.name
				+ "\n" + "Quantity in Stock: " + this.quantityInStock + "\n" + "Unit Price: " + this.unitPrice;
	}

	/**
	 * compareTo, implements the Comparable Interface in order to compare quantity in stocks
	 * per Item Object

	 * @param Item o1, the Item object of which is used to compare getquantityInStock() method
	 * 
	 * @return qty, whether the quantity is either 0, -1 and 1
	 * 
	 */
	@Override
	public int compareTo(Item o1) {
		int qty = 0;

		if (this.getquantityInStock() < o1.getquantityInStock()) {
			qty = -1;
		}
		else if (this.getquantityInStock() > o1.quantityInStock) {
			qty = 1;
		} else {
			return 0;
		}
		return qty;

	}
}