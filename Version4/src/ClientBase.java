import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

//
///**
//* 
//* @author: Conor Garvey
//*
//*/
public class ClientBase {
	private Map<String, Customer> customers;

	public ClientBase() {
		customers = new HashMap<>();
	}

	public Customer addClient(Customer c) {
		// addClient() – add the Customer passed as parameter to the map.
		return customers.put(c.getEmail(), c);
	}

	public Customer getClient(String email) {

		return customers.get(email);
	}

	/**
	 * createBadDebts, this method writes Business Customers whos Credit Limit is
	 * surpassed by their balance from ClientBase
	 *
	 * @throws FileNotFoundException, the exception thrown if an incorrect file
	 *                                pathway has been supplied or a type mistake
	 * 
	 * @throws IOException,           the exception thrown if an incorrect file
	 *                                pathway has been supplied or a type mistake
	 * 
	 * @return void, indicating if the file had been created or not or an Exception
	 *         is thrown
	 */
	public void createBadDebts() throws IOException {
		// createBadDebts() - Write the details of all customers whose balance exceeds
		// their credit limit to a file badDebts.txt.
		// (ClientBase)
		File file = new File("../Version4/src/badDebts.txt");
		BufferedWriter bf = null;
		Business bc = null;
		try {
			bf = new BufferedWriter(new FileWriter(file));
			for (Entry<String, Customer> entry : customers.entrySet()) {
				if ((entry.getValue() instanceof Business)) {
					bc = (Business) entry.getValue();
					if (bc.getCustomerBalance() > bc.getCreditLimit()) {
						bf.write(bc.toString());
						bf.newLine();
					}
				}
			}
			System.out.println("File created");
			bf.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * deleteCust, this method removes the Customer through the OrderBook and the
	 * ClientBase through two for loops removing the Customer from each and setting
	 * isDeleted to true
	 *
	 * @param email, the String used to delete the Customer
	 * @param ob,    the OrderBook used to search the Map for the customer
	 * 
	 * @return isDeleted, a boolean whether or not the Customer is deleted or not
	 */
	public boolean deleteCust(String email, OrderBook ob) {
		// deleteCust() - Delete a customer given their email address all orders for
		// this customer should also be deleted.
		// (ClientBase)
		boolean isDeleted = false;
		Customer customer = null;
		if (customers.containsKey(email)) {
			customer = customers.get(email);
			customers.remove(email);

		}
		if (customer != null) {
			if (ob != null) {
				ArrayList<Order> custOrders = ob.getCustOrders(email);
				for (int i = 0; i < custOrders.size(); i++) {
					ob.getOnOrder().remove(custOrders.get(i));
				}
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	/**
	 *
	 * getPCustEmail, gets a Random Private Customer Email as the method is called
	 * Using a List to generate an index of which to be used to return
	 *
	 * @return keyList.get(randomEmail), the random email returned containing a
	 *         private Customer
	 */
//	public String getPCustEmail() {
//		// 8) getPCustEmail() – Return the email of a random private customer.
//		// (ClientBase)
//		Set<String> keySet = customers.keySet();
//		List<String> keyList = new ArrayList<>(keySet);
//
//		int size = keyList.size();
//		int randomEmail = new Random().nextInt(size);
//
//		
//		
//		return keyList.get(randomEmail);
//
//	}
	public String getPCustEmail() {
		// 8) getPCustEmail() – Return the email of a random private customer.
		// (ClientBase)
		List<Customer> cust = new ArrayList<Customer>(customers.values());
		int size = customers.size();
		int randomEmail = new Random().nextInt(size);
		Private pc = null;

		if (cust.get(randomEmail) instanceof Private) {
			pc = (Private) cust.get(randomEmail);
		}
		return pc.getEmail();
	}

	/**
	 *
	 * getTotalBalance, gets the total balance of all Business Customers during an
	 * entrySet being iterated through
	 *
	 * @return balance, double containing the balance of Business Customers
	 */
	public double getTotalBalance() {
		// getTotalBalance() - Return the total balance of all business
		// customers.(ClientBase)
		double balance = 0;
		Business bc = null;
		for (Map.Entry<String, Customer> entry : customers.entrySet()) {
			if (entry.getValue() instanceof Business) {
				bc = (Business) entry.getValue();
				balance = balance + bc.getCustomerBalance();
			}
		}
		return balance;
	}

	/**
	 *
	 * getAverageLoyaltyPoints, gets the average loyalty points from private
	 * Customers, where a count variable is incremented during each Private Customer
	 * in the entrySet
	 * 
	 * @return avgPoints / count, the average points for the customers
	 */
	public double getAverageLoyaltyPoints() {
		// getAverageLoyaltyPoints() – returns the average value of
		// loyalty points held by business customers.
		int avgPoints = 0;
		Private pc = null;
		int count = 0;
		for (Map.Entry<String, Customer> entry : customers.entrySet()) {
			if (!(entry.getValue() instanceof Business)) {
				pc = (Private) entry.getValue();
				avgPoints = avgPoints + pc.getLoyalityPoints();
				count++;
			}
		}
		return avgPoints / count;
	}
}
