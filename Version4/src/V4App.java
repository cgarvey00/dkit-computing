import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
//
///**
//* 
//* @author: Conor Garvey
//*
//*/
public class V4App {
	public static void main(String[] args) throws IOException {

		try {
			Scanner sc = new Scanner(System.in);
			Item i1 = new Item("Water Bottle 2L", 10000, 1.00);
			Item i2 = new Item("Bread", 10000, 5.40);
			Item i3 = new Item("Milk 3L", 5000, 3.40);
			Item i4 = new Item("Pancakes", 3400, 5.40);
			Item i5 = new Item("Avacado", 5000, 7.40);
			Item i6 = new Item("Mango", 4000, 2.40);
			Item i7 = new Item("Apple", 5000, 1.40);

			Private c1 = new Private("John Wick", "59 Dundalk Road", "jwick@hotmail.com");
			Business c2 = new Business(2003330.0, 10000.0, "Joe Bloggs", "12 Newry Road", "jbloggs@outlook.com");
			Private c3 = new Private("Mary McNulty", "23 Almond Grove", "mmcnulty@gmail.com");
			Business c4 = new Business(10.0, 10000.0, "Ben Quinn", "11 CastleTown Road", "bquinn@outlook.com");

			ClientBase customers = new ClientBase();
			customers.addClient(c1);
			customers.addClient(c2);
			customers.addClient(c3);
			customers.addClient(c4);

			// Writing c2 to badDebts.txt
			customers.createBadDebts();

			Order o1 = new Order(10, i1, c4);
			Order o7 = new Order(5, i5, c2);
			System.out.println(o1.toString());
			System.out.println("Order created= " + o1.toString());
			Order o2 = new Order(10, i3, c2);
			System.out.println("Order created= " + o2);
			Order o3 = new Order(52, i1, c3);
			System.out.println("Order created= " + o3);
			Order o6 = new Order(2, i2, c3);
			System.out.println("Order created= " + o6);
			Order o4 = new Order(3, i3, c1);
			System.out.println("Order created= " + o4);
			Order o5 = new Order(53, i7, c3);
			System.out.println("Order created= " + o5);

			Stock stock1 = new Stock();
			stock1.add(i1);
			stock1.add(i2);
			stock1.add(i3);
			stock1.add(i4);
			stock1.add(i5);
			stock1.add(i6);
			stock1.add(i7);

			// Adding Additional Items from file.txt
			stock1.popStock("../Versiond4/src/file.txt");

			// Create Order Book and add orders

			OrderBook obook = new OrderBook("CompanyA");
			obook.addOrder(o1);
			obook.addOrder(o2);
			obook.addOrder(o7);
			obook.addOrder(o3);
			obook.addOrder(o4);
			obook.addOrder(o5);
			obook.addOrder(o6);
			boolean exitMenu = false;
			while (!exitMenu) {

				System.out.println("What Option method do you wish to use?:");
				System.out.println(" Options:");
				System.out.println("1: Add a customer – Business Or Private");
				System.out.println("2: Delete a customer");
				System.out.println("3: Add an item ");
				System.out.println("4: Add an Order ");
				System.out.println("5: See Orders given the Customer Name");
				System.out.println("6: See the Balance of all Business Customers");
				System.out.println("7: See average Value of Loyalty Points");
				System.out.println("8: See a Customers Orders");
				System.out.println("9: Exit");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					addCustomer(customers);
					break;
				case 2:
					delCustomer(customers, obook);
					break;
				case 3:
					addItem(stock1);
					break;
				case 4:
					obook.addOrder(addOrder(stock1, customers));
					break;
				case 5:
					seeCustOrders(obook);
					break;
				case 6:
					getTotalBalanceBusCust(customers);
					break;
				case 7:
					avgLoyaltyPointBus(customers);
					break;
				case 8:
					seeCustOrder(obook);
					break;
				case 9:
					exitMenu = true;
					break;
				default:
					System.out.println("Invalid choice.");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Input is invalid " + e.getLocalizedMessage());
		}

	}

	/**
	 * addCustomer, uses customers of Object ClientBase as a parameter add a
	 * Customer object to ClientBase, either Private or Business
	 *
	 * @param customers, the ClientBase Object reference that will be used to add
	 *                   the customer to the map
	 *
	 * @return void, printing out whether or not the Customer has been added or not
	 */
	private static void addCustomer(ClientBase customers) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Customer Name");
		String name = sc.nextLine();

		System.out.println("Please enter the Customer Email");
		String email = sc.nextLine();

		System.out.println("Please enter the Customer Address");
		String address = sc.nextLine();

		System.out.println("Please Select which Customer you are Adding");
		System.out.println("Enter Business");
		System.out.println("Enter Private ");
		String option = sc.nextLine();
		if (option.equals("Business")) {
			Business b1 = new Business(name, address, email);
			customers.addClient(b1);
		} else if (option.equals("Private")) {
			Private p1 = new Private(name, address, email);
			customers.addClient(p1);
		}

	}

	/**
	 * This method displays the customers Orders through the use of an OrderBook
	 * using Customer email as the Key to search the list of Customer Orders
	 * 
	 * @param orders, a OrderBook reference constructed in the main method
	 * 
	 * @return void, printing out whether or not the Customer had been deleted or
	 *         not
	 */
	private static void delCustomer(ClientBase customers, OrderBook ob) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email of the Customer to be deleted");
		String email = sc.nextLine();

		boolean isDel = customers.deleteCust(email, ob);
		if (isDel) {
			System.out.println("Customer deleted");
		} else {
			System.out.println("Customer dosent exist");
		}

	}

	/**
	 * This method addItem, displays the customers Orders through the use of an
	 * OrderBook using Customer email as the Key to search the list of Customer
	 * Orders
	 * 
	 * @param stock, a Stock reference constructed in the main method
	 * 
	 * @return void, printing out a message when the Item is added or not to the
	 *         stock object
	 */
	private static void addItem(Stock stock) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Item Name");
		String name = sc.nextLine();
		System.out.println("Enter the Item Quantity");
		int quantityInStock = sc.nextInt();
		System.out.println("Enter the Item Unit Price");
		double unitPrice = sc.nextDouble();

//		if (stock.findItem(name).equals(null)) {
			System.out.println("Item Added to Stock");
			stock.add(new Item(name, quantityInStock, unitPrice));
		

	}

	/**
	 * createOrder, uses stock of Object Stocks as a parameter as well as c of
	 * ClientBase Object ArrayList, which uses three while loops with inside try
	 * catch functions as well as methods to create an order. Containing exceptions
	 * to ensure the program dosen't crash upon an incorrect entry
	 * 
	 * First. the nameValid while loop runs as well as its try catch block in order
	 * for the customer name and address to be given and is checked to ensure it is
	 * valid, if the customer object is null a NullPointer Exception is thrown the
	 * loop repeats until a correct Customer has been matched Second. the itemValid
	 * while loop runs as well as its try catch block in order for the item name to
	 * be given and is checked to ensure it is valid, if the item object is null a
	 * NullPointer Exception is thrown the loop repeats until a correct Item has
	 * been matched Third. the canOrder while loop runs as well as two try catch
	 * blocks in order for the correct quantity to be entered is checked to ensure
	 * it is valid and the correct data type, if the quantity variable is of an
	 * incorrect format a InputMismatchException is thrown and else if the
	 * quantityCheck method returns false a IllegalStateException is thrown. If all
	 * three Valid booleans are true then the Order is created with the
	 * balanceAndDisplay which displays the order information and decreaseQuantity
	 * methods being called returning the object
	 *
	 * @param stock,     the Stock Object reference that will be used to find the
	 *                   information about the item
	 * @param customers, the ClientBase Object reference that will be used to find
	 *                   the information about the customer
	 * 
	 * @throws NullPointerException,   this is thrown when a Customer or Item object
	 *                                 is returned as null
	 *
	 * @throws InputMismatchException, this is thrown when the orders quantity's
	 *                                 format is incorrect that of a string rather
	 *                                 than an integer
	 * 
	 * @throws IllegalStateException,  this is thrown if the orders quantity entered
	 *                                 is above the items quantity or equal to or
	 *                                 below 0
	 * 
	 *
	 * @return decreaseQuantity(order), the order object which is called by the
	 *         method decreaseQuantity in order to decrease the item quantity
	 *         following order creation
	 */
	public static Order addOrder(Stock stock, ClientBase customers) {
		// Get customer from client base
		Scanner sc = new Scanner(System.in);
		Order order = null;
		Customer customer = null;
		boolean nameValid = false;
		boolean itemValid = false;
		boolean canOrder = false;
		int quantity = 0;
		Item item = null;
		String itemName = "";

		// Get item from stock
		while (!itemValid) {
			try {
				item = searchItemName(stock);
				if (!item.equals(null)) {
					System.out.println("Valid Item");
					itemName = item.getName();
					itemValid = true;
				} else {
					sc.nextLine();
				}
			} catch (NullPointerException e) {
				System.out.println("The item being searched for dosent exist try again");
			}
		}
		while (!nameValid) {
			try {
				System.out.println("Enter a Customer email");
				String email = sc.nextLine();
				customer = customers.getClient(email);
				if (!customer.equals(null)) {
					System.out.println("Customer is valid");
					nameValid = true;
				} else {
					sc.nextLine();
				}
			} catch (NullPointerException e) {
				System.out.println("Customer dosent exist try again");

			}
		}
		while (!canOrder) {
			try {
				System.out.println("Enter the quantity to order");
				System.out.println("Quantity must not exceed item stock");
				quantity = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Incorrect format used " + e);
			}
			try {
				if (quantityCheck(item, quantity)) {
					System.out.println("Order successfully created");
					order = new Order(quantity, item, customer);
					canOrder = true;
				} else {
					System.out.println("Quantity Insufficent please try again");
					sc.nextLine();
				}
			} catch (IllegalQuantityException e) {
				System.out.println(
						e.getLocalizedMessage() + " Quantity must be above zero and Item must have sufficent stock");
			}
		}
		balanceAndDisplay(order);
		return decreaseQuantity(order, quantity);
	}

	/**
	 * quantityCheck, uses i1 of Object Item as a parameter as well as q of type int
	 * to check if the quantity entered is valid
	 *
	 * @param i1, the Item Object reference that will be used to find the
	 *            information about the Item object
	 * @param q,  the quantity reference used to decrease the items quantity using
	 *            the class set method
	 *
	 * @return qtyValid, the boolean returned whether the quantity can be updated or
	 *         not
	 */
	private static boolean quantityCheck(Item i1, int q) {
		boolean qtyValid = false;
		if (q <= 0) {
			System.out.println("Not enough quantity available in stock");
		} else {
			if (q < i1.getquantityInStock()) {
				System.out.println("Operation successfull, quantity vaiid");
				qtyValid = true;
			} else {
				System.out.println("Quantity Invalid try again");
			}
		}
		return qtyValid;

	}

	/**
	 * searchItemName, uses o of Object Order as a parameter as well as c of
	 * CustomerData Object ArrayList, which uses three while loops as well as
	 * methods to create an order. Containing exceptions ensuring the program
	 * dosen't crash upon an incorrect entry
	 *
	 * @param s, the Stock Object reference that will be used to find the
	 *           information about the Item
	 *
	 * @return item, the order object which is called by the method decreaseQuantity
	 *         in order to decrease the item quantity following order creation
	 */
	private static Item searchItemName(Stock s) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an item name");
		String iname = sc.nextLine();
		Item item = searchStock(s, iname);
		return item;

	}

	/**
	 * balanceAndDisplay, uses o of Object Order as a parameter to check whether the
	 * Customer who ordered is a business instance Customer or not
	 *
	 * The Order instance o is used to retrieve the customer reference and check if
	 * its a Business instance if so, Business is cast to the customer and the
	 * balance is updated to the sum of the final order cost and the previous
	 * customer balance which updates the order otherwise if the Customer object is
	 * not a Business instance balance remains the same. If customer is of a
	 * Private, The Loyalty Points is displayed and the final Cost is displayed for
	 * both
	 *
	 * @param o, the Order Object reference that will be used to find the customer
	 *           Object
	 *
	 */
	private static void balanceAndDisplay(Order o) {
		// This method increases Balance for Business Customers
		// Only if the Customer is of a Business object instance
		// otherwise it is unchanged
		Business bc;
		Private pc;
		double balance = 0;
		if (o.getCustomer() instanceof Business) {
			bc = (Business) o.getCustomer();
			balance = bc.getCustomerBalance();
			bc.setCustomerBalance(balance + finalCost(o));
			System.out.println("Customer Balance Updated");
			o.setCustomer(bc);
			System.out.println("Order Complete");
			System.out.println("Final Cost: " + finalCost(o));
			System.out.println("Customer Balance: " + bc.getCustomerBalance());

		} else if (o.getCustomer() instanceof Private) {
			pc = (Private) o.getCustomer();
			System.out.println("Customer Balance unchanged");
			System.out.println("Order Complete");
			System.out.println(o.toString());
			System.out.println("Final Cost:" + finalCost(o));
			System.out.println();
			System.out.println("Loyalty Points:" + pc.getLoyalityPoints());
		}

	}

	/**
	 * This constructs a finalCost with a specified Order Object by performing a
	 * series of calculations to get the new amended price
	 * 
	 * With the basicOrderCost of the order being subtracted from the discount price
	 * 
	 * @param order an object reference constructed in the main method
	 * 
	 * @return finalCost, the final cost of which has been calculated taking away
	 *         the percentage value from the order cost
	 */
	private static double finalCost(Order order) {
		return order.calculateBasicOrderCost() - (order.calculateBasicOrderCost() / 100 * order.calculateDiscount());
	}

	/**
	 * This method searches for the item using the Stock instance and the item name
	 * to see if they exist or not
	 * 
	 * @param stock, a Stock reference constructed in the main method
	 * @param name,  a variable used to search for item name
	 * 
	 * @return i, the Item Object which either contains the item or not
	 */
	private static Item searchStock(Stock stock, String name) {
		// This searchStock looks for the name of the item through the parameter stock
		// a stock reference and name to search the item through using the findItem
		// method
		Item i = stock.findItem(name);
		if (i.getName().equalsIgnoreCase(name)) {
			i = stock.findItem(name);
			System.out.println("Item exists");
		} else {
			System.out.println("Item dosent exist");
		}
		return i;

	}

	/**
	 * This method displays the customers Orders through the use of an OrderBook
	 * using Customer email as the Key to search the list of Customer Orders
	 * 
	 * @param orders, a OrderBook reference constructed in the main method
	 * 
	 * @return void, printing out whether or not the Orders have been printed out or
	 *         the email does not exist
	 */
	private static void seeCustOrders(OrderBook orders) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Customer Email");
		String email = sc.nextLine();

		if (!orders.getCustOrders(email).equals(null)) {
			System.out.println(orders.getCustOrders(email));
		} else {
			System.out.println("Orders do not exist or Email is Invalid");
		}

	}

	/**
	 * This method displays the total Balance between all Business Customers and is
	 * printed below
	 * 
	 * @param cb, a ClientBase reference constructed in the main method
	 * 
	 * @return void, printing out the total Balance for Business Customers
	 */
	private static void getTotalBalanceBusCust(ClientBase cb) {
		System.out.println("Total Balance is : " + cb.getTotalBalance());

	}

	/**
	 * This method displays the average Loyalty Points for Business Customers given
	 * their orders, by calling in the getAverageLoyaltyPoints() method for
	 * ClientBase
	 * 
	 * @param cb, a ClientBase reference constructed in the main method
	 * 
	 * @return void, but prints out the Average value for the Loyalty Points
	 */
	private static void avgLoyaltyPointBus(ClientBase cb) {
		System.out.println("Average Loyalty Points is : " + cb.getAverageLoyaltyPoints());
	}

	/**
	 * This method displays the customers Orders through the use of an OrderBook
	 * using Customer email as the Key to search the list of Customer Orders
	 * 
	 * @param ob, a OrderBook reference constructed in the main method, used to
	 *            print out Customer Orders
	 * 
	 * @return void, prints a HashMap of All Customers Orders
	 */
	private static void seeCustOrder(OrderBook ob) {
		System.out.println("Here is a Summary of Items the Customer Ordered");
		HashMap<Customer, HashMap<String, Integer>> custOrders = ob.getAllCustOrders();
		System.out.println(custOrders);

	}

	/**
	 * decreaseQuantity, uses o of Object Order as a parameter as well as q of type
	 * int to decrease the items quantity, using the Orders, getitemRef method
	 *
	 * @param o, the Order Object reference that will be used to find the
	 *           information about the object
	 * @param q, the quantity reference used to decrease the items quantity using
	 *           the class set method
	 *
	 * @return o, the order object which is called by the method decreaseQuantity in
	 *         order to decrease the item quantity following order creation
	 */
	private static Order decreaseQuantity(Order o, int q) {
		System.out.println("Quantity Updated");
		o.getitemRef().decreasequantityInStock(q);
		return o;

	}

}
