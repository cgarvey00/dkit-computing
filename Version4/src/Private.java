
//
// /**
// * 
// * @author Conor Garvey
// *
// */
public class Private extends Customer {
	private int loyaltyPoints;

	public Private() {

		super();
		name = "matt";
		loyaltyPoints = 0;
	}

	// this constructor inherits superclass Customer
	public Private(String name, String address, String email) {

		super(name, address, email);
		loyaltyPoints = 0;
	}

	/**
	 * @return the loyalityPoints
	 */
	public int getLoyalityPoints() {
		return loyaltyPoints;
	}

	/**
	 * @param loyalityPoints the loyalityPoints to set
	 */
	public void setLoyalityPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	/**
	 * Updates the Loyalty Points if an Order value is 100
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
	public boolean updateLoyaltyPoints(double value) {
		// updateLoyaltyPoints() - Update the loyalty points given the order value. 1
		// loyalty point is assigned
		// for every €100 spent. (Private Customer)
		boolean isTrue = false;
		if (value >= 100.00) {
			this.loyaltyPoints = loyaltyPoints + 1;
			isTrue = true;
		}
		return isTrue;
	}

	// This method uses the superclass Customer to print the variables
	@Override
	public String toString() {

		return "Private{ " + super.toString() + "Loyality Points : " + this.loyaltyPoints + '}';
	}

}
