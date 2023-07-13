
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Conor Garvey
 *
 */
public class OrderBook {

	// Has 2 instance variables, an arrayList
	// called onOrder of orders and the branch name.
	private ArrayList<Order> onOrder;
	private String branchName;

	/**
	 *
	 * It is a non argument constructor.
	 *
	 */
	public OrderBook() {

		onOrder = new ArrayList<>();

	}

	/**
	 *
	 * It is a parameter constructor.
	 *
	 * @param branchName the branch name of which the OrderBook is named after
	 */
	public OrderBook(String branchName) {

		onOrder = new ArrayList<>();
		this.branchName = branchName;
	}

	public ArrayList<Order> getOnOrder() {

		return onOrder;
	}

	public void setOnOrder(ArrayList<Order> onOrder) {

		this.onOrder = onOrder;
	}

	public String getBranchName() {

		return branchName;
	}

	public void setBranchName(String branchName) {

		this.branchName = branchName;
	}

	/**
	 *
	 * addOrder, used to add the order to the ArrayList
	 *
	 * @param o, the Order Object that is being added
	 * 
	 * @return onOrder.add(o), whether or not the order has been added or not
	 */
	public boolean addOrder(Order o) {
		// addOrder() - adds order to onOrder
		return onOrder.add(o);
	}

	/**
	 *
	 * findAllOrders, used to get an ArrayList of Orders given the Item name which
	 * returns the Orders containing said item
	 *
	 * @param itemName, the item name that is used in the search 
	 * 
	 * @return allOrders, an ArrayList of orders that has been returned given the
	 *         item name
	 */
	public ArrayList<Order> findAllOrders(String itemName) {
		// findAllOrders() that returns all orders for a
		// particular item given the item name. public boolean addOrder(Order o) {
		ArrayList<Order> allOrders = new ArrayList<>();
		for (int i = 0; i < onOrder.size(); i++) {
			if (onOrder.get(i).getitemRef().getName().equals(itemName)) {
				allOrders.add(onOrder.get(i));
			}
		}
		return allOrders;
	}

	/**
	 *
	 * getCusBus, gets the total value orders placed by the Customer who is a
	 * Business Customer. using the equals Comparable operator to find the name and
	 * address
	 *
	 * @param c, the Customer Object used to find Business Customers orders
	 * 
	 * @return total, the total value of the Business Customer Orders
	 */
	public double getCusBus(Customer c) {
		// getCusBus() that returns the value of all orders placed by a particular
		// Customer, when the Customer
		// is passed as a parameter. Note that two customers are considered equal
		// if they have the same name and address.
		double total = 0;
		for (int i = 0; i < onOrder.size(); i++) {
			if (onOrder.get(i).getCustomer().equals(c)) {
				total = total + onOrder.get(i).calculateBasicOrderCost();
			}
		}
		return total;
	}

	/**
	 *
	 * getCustOrders, returns the Orders in an ArrayList from which the Customer
	 * has given the email to.
	 *
	 * @param custEmail, the Customer Object used to find Orders given the email
	 * 
	 * @return orders, a ArrayList containing the orders by a particular Customer
	 */
	public ArrayList<Order> getCustOrders(String custEmail) {
		// getCustOrders() - Return an arrrayList of orders given
		// the customer email. (OrderBook)
		ArrayList<Order> orders = new ArrayList<Order>();
		Order o = null;
		for (int i = 0; i < onOrder.size(); i++) {
			if (onOrder.get(i).getCustomer().getEmail().equals(custEmail)) {
				o = onOrder.get(i);
				orders.add(o);
			}
		}
		return orders;
	}

	/**
	 * getAllCustOrders, where all Customer's and the items they have ordered are Mapped
	 * in a HashMap containing a Customer as  Key and another HashMap containing a String and Integer
	 * the String being the Item name and the Integer being the quantity of the Item Ordered
	 * 
	 * @return custOrders, the set containing Strings of Customer names
	 */
	public HashMap<Customer, HashMap<String, Integer>> getAllCustOrders() {
		// getAllCustOrders() - Returns a map that maps the customers to the items they
		// have ordered. The values should be the item name and the total quantity of
		// that item ever ordered by that customer. (OrderBook)
		HashMap<Customer, HashMap<String, Integer>> custOrders = new HashMap<Customer, HashMap<String, Integer>>();
		HashMap<String, Integer> itemDet = null;
		Customer c = null;
		int qty = 0;
		String iName = "";
		for (int i = 0; i < onOrder.size(); i++) {
			c = onOrder.get(i).getCustomer();
			qty = onOrder.get(i).getorderQuantity();
			iName = onOrder.get(i).getitemRef().getName();
			if (!custOrders.containsKey(c)) {
				custOrders.put(c, new HashMap<>());
			}
			itemDet = custOrders.get(c);

			if (!itemDet.containsKey(onOrder.get(i).getitemRef().getName())) {
				itemDet.put(iName, qty);
			} else {
				int oldQuantity = itemDet.get(iName);
				itemDet.put(iName, oldQuantity + qty);
			}
		}

		return custOrders;
	}

	/**
	 *
	 * getCustItem, this gets the names of the Customers who orders an item but
	 * these are in descending order using a TreeSet and uses a Collections reverse
	 * Order.
	 *
	 * @param itemName, the String (itemName) used to find the Customers who ordered
	 *                  a particular item
	 * 
	 * @return customers, the set containing Strings of Customer names
	 */
	public Set<String> getCustItem(String itemName) {
		// getCustItem() – returns the names of all Customers that have ordered a
		// particular item (passed as a parameter). The customer names should be sorted
		// in descending alphabetical order – i.e. Z- A and each name should appear only
		// once.
		Set<String> customers = new TreeSet<>(Collections.reverseOrder());
		for (int i = 0; i < onOrder.size(); i++) {
			if (onOrder.get(i).getitemRef().getName().equalsIgnoreCase(itemName)) {
				customers.add(onOrder.get(i).getCustomer().getName());
			}
		}
		return customers;

	}

}
