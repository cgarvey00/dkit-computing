
/**
 * 
 * @author Conor Garvey
 *
 */
public class Business extends Customer {
	private double customerBalance;
	private double creditLimit;

	public Business() {
		super();
		
	}

	public Business(double customerBalance, double creditLimit, String name, String address, String email) {
		super(name, address, email);
		this.customerBalance = customerBalance;
		this.creditLimit = creditLimit;
		
	}
	//Alternate Constructor for V4App
	public Business(String name, String address, String email) {
		super(name, address, email);
		this.customerBalance = 0;
		this.creditLimit = 1200;
		
	}
	
	//Constructor for Business Customer With Equal Limit and Balance
	public Business(double customerBalance,String name, String address, String email) {
		super(name, address, email);
		this.customerBalance = customerBalance;
		this.creditLimit = customerBalance;
		
	}

	// Accessor Methods

	public double getCustomerBalance() {
		return customerBalance;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	// Mutator Methods
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public void setCustomerBalance(double customerBalance) {
		this.customerBalance = customerBalance;
	}
	
	public void updateCusBal(double value) {
		this.customerBalance = customerBalance+value;
	}

	/**
	 * Overwrite method toString() uses the variables and prints them in order for
	 * the version3App
	 * 
	 * @return the Business details with the instance variables above in a formatted
	 *         manner as well as the inherited Customer superclass
	 */
	@Override
	public String toString() {
		return "Business{ " + " Balance= " + this.customerBalance + " Credit Limit= " + this.creditLimit
				+ super.toString() + '}';
	}
}
