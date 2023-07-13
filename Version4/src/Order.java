
/**
 * 
 * @author Conor Garvey
 *
 */

// instance variables
public class Order {
	private int uniqueID;
	private int orderQuantity;
	private Item itemRef;
	private Customer customer;

	/*
	 * Static field id will set the value of the uniqueID increasing by one when an
	 * Item object is created
	 */
	private static int id = 0;

	/**
	 * This constructs an Order with a specified uniqueID, orderQuantity and itemRef
	 * of type Object Item
	 * 
	 * This checks the itemRef, ensuring the orderQuantity does not exceed the
	 * quantity of the item if so an IndexOutOfBoundsException error is thrown but
	 * if its within bounds the Order is created with the orderQuantity decreasing
	 * the item quantity by calling the decreasequantityInStock() method
	 * 
	 * @param uniqueID      unique id of the order
	 * @param orderQuantity the quantity of the item ordered
	 * @param itemRef       the Item details of which is being ordered
	 * @param cust          the Customer details of which is being purchased
	 * 
	 * 
	 */
	public Order(int orderQuantity, Item itemRef, Customer cust) {

		if (cust instanceof Business) {
			if (((Business) cust).getCreditLimit() < ((Business) cust).getCustomerBalance()) {
				System.out.println("Balance exceeds your limit please try again");
				System.out.println("Reduce balance");
			}
		} else if (cust instanceof Private) {
				System.out.println("Loyalty Points updated");
				((Private) cust).updateLoyaltyPoints(orderQuantity * itemRef.getunitPrice());
			}
		id++;
		uniqueID = id;
		this.orderQuantity = orderQuantity;
		this.itemRef = itemRef;
		this.customer = cust;

	}

	/*
	 * Accessor/Getter Methods
	 */

	public int getuniqueID() {
		return this.uniqueID;
	}

	public int getorderQuantity() {
		return this.orderQuantity;
	}

	public Item getitemRef() {
		return this.itemRef;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	/*
	 * Mutator Methods
	 */

	public boolean setuniqueID(int uniqueID) {
		boolean isTrue = false;
		if (uniqueID > 0 && uniqueID < 100) {
			this.uniqueID = uniqueID;
			isTrue = true;
		}

		return isTrue;
	}

	public boolean setorderQuantity(int orderQuantity) {
		boolean isTrue = false;
		if (orderQuantity >= 0 && orderQuantity <= 100) {
			this.orderQuantity = orderQuantity;
			isTrue = true;
		}

		return isTrue;
	}

	public boolean setitemRef(Item itemRef) {
		boolean isTrue = false;
		if (itemRef != null) {
			this.itemRef = itemRef;
			isTrue = true;
		}
		return isTrue;
	}

	public boolean setCustomer(Customer customer) {
		boolean isTrue = false;
		if (customer != null) {
			this.customer = customer;
			isTrue = true;
		}
		return isTrue;
	}

	/**
	 * This constructs an Order with a specified uniqueID, orderQuantity and itemRef
	 * of object type Item
	 * 
	 * orderQuantity is multiplied with the unitPrice of the Item object by the
	 * getunitPrice accessor method
	 * 
	 * @return the basic order cost, formed by multiplying the orderQuantity by the
	 *         unitPrice of the item
	 */
	public double calculateBasicOrderCost() {
		return orderQuantity * itemRef.getunitPrice();
	}

	/**
	 * This constructs a discount amount per Order Instance, based on orderQuantity
	 * 
	 * orderQuantity goes through a series of if, else if statements based on the
	 * orderValue, if being over 5000 the discounts 4, else if it was between 1000
	 * and 5000 its set at 3 or if below 1000 there is no discount
	 * 
	 * @return discount, the percentage rate of which the discount will be
	 */
	public double calculateDiscount() {
		double discount = 0;
		if (calculateBasicOrderCost() >= 5000) {
			discount = 4.0;
		} else if (calculateBasicOrderCost() >= 1000 && calculateBasicOrderCost() < 5000) {
			discount = 3.0;
		} else if (calculateBasicOrderCost() < 1000) {
			discount = 0;
		}
		return discount;
	}

	/**
	 * Overwrite method toString() uses the variables and prints them in Order for
	 * the version1App
	 * 
	 * @return the Order details with the instance variables above in a formatted
	 *         manner
	 * 
	 */

	@Override
	public String toString() {

		return "\n" + "--Order Details--" + "\n" + "Unique ID: " + this.uniqueID + "\n" + "Customer ID: "
				+ this.customer.getuniqueID() + "\n" + "Order Quantity: " + this.orderQuantity + "\n"
				+ "Item Reference: " + this.itemRef + "\n" + "Customer Reference: " + this.customer;
	}

}