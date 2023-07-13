//
//import java.util.ArrayList;
//
///**
// * 
// * @author Conor Garvey
// *
// */
//public class CustomerData {
//	private ArrayList<Customer> customers;
//
//	/**
//	 *
//	 * It is a constructor.
//	 *
//	 */
//	public CustomerData() {
//
//		customers = new ArrayList<>();
//	}
//
//	/**
//	 *
//	 * getCustomers, used return the CustomerData's contents via ArrayList of
//	 * Customer Objects
//	 *
//	 * @return customers, an ArrayList of customers
//	 */
//	public ArrayList<Customer> getCustomers() {
//
//		return customers;
//	}
//
//	/**
//	 *
//	 * addCustomer, used to add the Customer to the ArrayList
//	 *
//	 * @param c, the Customer Object that is being added
//	 * 
//	 * @return customers.add(c), whether or not the Customer has been added or not
//	 */
//	public boolean addCustomer(Customer c) {
//
//		return customers.add(c);
//	}
//
//	/**
//	 *
//	 * findAllOCustomers, this is used to tabulate a String ArrayList of the regular
//	 * Customer Objects that is not of a Business instance, each slot of the
//	 * ArrayList contains the Customer email and name. This is done through the use
//	 * of a for loop and if statements
//	 *
//	 * @return oCustomer, the ArrayList containing each of the non Business
//	 *         Customers name and email
//	 */
//	public Object findAllOCustomers() {
//    // 2) findAllOCustomers() that returns the name and email of all non business
//	// customers.
//	
//		String name;
//		ArrayList<String> oCustomer = new ArrayList<>();
//		String email;
//		String store = "";
//		for (int i = 0; i < customers.size(); i++) {
//			if (!(customers.get(i) instanceof Business)) {
//				name = customers.get(i).getName();
//				email = customers.get(i).getEmail();
//				store = "Name= " + name + " Email= " + email;
//				oCustomer.add(store);
//			}
//
//		}
//		return oCustomer;
//
//	}
//
//	/**
//	 * getAvgBalance, used to get each Business Customer Objects balance tabulated
//	 * to a variable called total which a count variable is increased among each
//	 * iteration, using a for loop to iterate through the CustomerData ArrayList
//	 * 
//	 * 
//	 * @return total/count, which gives the average balance among Customer objects
//	 *         in the CustomerData ArrayList
//	 */
//	public double getAvgBalance() {
//	// 3) getAvgBalance() that returns the average balance of Business customers.
//		int count = 0;
//		double total = 0;
//		Business bc;
//		for (int i = 0; i < customers.size(); i++) {
//			if (customers.get(i) instanceof Business) {
//				bc = (Business) customers.get(i);
//				count++;
//				total = total + bc.getCustomerBalance();
//			}
//
//		}
//		return total / count;
//	}
//
//	/**
//	 *
//	 * countCustType, this used to count the Objects using fType as a parameter
//	 * whether it is Business or Customer class
//	 *
//	 * @param fType, the class used to match the customers ArrayLists class
//	 * 
//	 * @return count, the count of the supplied class fType
//	 */
//	public int countCustType(Class<?> fType) {
//	// 4) countCustType() returns the number of customers of a
//	// particular type, the type is passed as a parameter.
//		int count = 0;
//		for (int i = 0; i < customers.size(); i++) {
//			if (customers.get(i).getClass() == fType) {
//				count++;
//			}
//
//		}
//		return count;
//	}
//
//}
