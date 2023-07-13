
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//
// /**
// * 
// * @author: Conor Garvey
// *
// */

public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Has an instance variable called products that is an arrayList of items,
	// a no argument constructor and the following methods:
	private ArrayList<Item> products;
	private static final String FILENAME = "items.bin";

	/**
	 *
	 * It is a non argument constructor.
	 *
	 */
	public Stock() {
		products = new ArrayList<>();

	}

	public ArrayList<Item> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Item> products) {
		this.products = products;
	}

	/**
	 *
	 * addOrder, used to add the Item to the ArrayList
	 *
	 * @param i, the Item Object that is being added
	 * 
	 * @return products.add(i), whether or not the Item has been added or not
	 */
	public boolean add(Item i) {
		// add() - adds an item to products. The Item is passed as a parameter.
		return products.add(i);
	}

	/**
	 *
	 * findItem, used to search for the item from the parameter iName which searches
	 * through the products ArrayList via a while loop and returning the Item. and
	 * setting done to true once its found terminating the loop and when a tracker
	 * variable i has reached the ArrayLists size, if not present a Null Item is
	 * returned
	 * 
	 * @param iName, the item name that is used in the search
	 * 
	 * @return item, an Item Object of which is returned after it has been found
	 */
	public Item findItem(String iName) {
		// findItem() - given the name of an item, finds and returns the item.
		boolean done = false;
		int i = 0;
		Item item = null;

		while (done == false && i < products.size()) {
			if (products.get(i).getName().equalsIgnoreCase(iName)) {
				item = products.get(i);
				done = true;
			}

			i++;
		}
		return item;
	}

	/**
	 *
	 * calculateTotStockVal, used to calculate the total stock price per item in
	 * products, using a for loop and a total variable to get the total stock price
	 * per Item and add to totalStock per iteration of the for loop, then totalStock
	 * is returned
	 * 
	 * @return totalStock, the collective price of all item stock added together
	 */
	public double calculateTotStockVal() {
		// calculateTotStockVal() - Calculates and returns the total stock value (total
		// of price*quantity for all items).
		double total = products.get(0).getunitPrice() * products.get(0).getquantityInStock();
		double totalStock = 0.0;
		for (int i = 0; i < products.size(); i++) {
			total = products.get(i).getunitPrice() * products.get(i).getquantityInStock();
			totalStock = totalStock + total;
		}

		return totalStock;
	}

	/**
	 *
	 * findDearest, used to search for the dearest item in the products ArrayList,
	 * using a variable dearest which is used to compare to the products and if a
	 * product slots units price is greater then dearest, it is replaced with the
	 * slots price, iName a string then stores the dearest's unitPrices Item Name
	 * and returns it
	 * 
	 * 
	 * @return iName, an Item Object of which is returned after the cheapest
	 *         unitPrice has been found
	 */
	public String findDearest() {
		// findDearest() - Finds and returns the name of the dearest item
		double dearest = products.get(0).getunitPrice();
		String iName = products.get(0).getName();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getunitPrice() > dearest) {
				dearest = products.get(i).getunitPrice();
				iName = products.get(i).getName();
			}
		}
		return iName;
	}

	/**
	 *
	 * findCheapest, used to search for the cheapest item in the products ArrayList,
	 * using a variable cheapest which is used to compare to the products and if a
	 * product slots units price is less then cheapest is replaced with the slots
	 * price
	 * 
	 * 
	 * @return i1, an Item Object of which is returned after the cheapest unitPrice
	 *         has been found
	 */
	public Item findCheapest() {
		// findCheapest()- Finds and returns the cheapest item.
		Item i1 = null;
		double cheapest = products.get(0).getunitPrice();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getunitPrice() < cheapest) {
				i1 = products.get(i);
			}
		}
		return i1;
	}

	/**
	 *
	 * displaySorted,this is used to create a new ArrayList containing Items being
	 * sorted by name using the Comparator Interface of an Item, using a new
	 * ArrayList sorted to contain the products, this is then sorted using item name
	 * in ascending order
	 * 
	 * 
	 * @return sorted, the ArrayList of Items after being sorted by Collections
	 *         methods
	 */
	public ArrayList<Item> displaySorted() {
		// 6) displaySorted() – displays all items sorted by name
		ArrayList<Item> sorted = new ArrayList<>();
		sorted.addAll(products);
		Collections.sort(sorted, new Comparator<Item>() {

			@Override
			public int compare(Item i1, Item i2) {
				return i1.getName().compareTo(i2.getName());
			}

		});
		return sorted;
	}

	/**
	 * popStock, uses file to create a scanner which prints out the contents line by
	 * line using a try catch exception if the validation methods return true, the
	 * files contents are parsed into an item object and added to the stock
	 * ArrayList, and is sorted using the ItemComparator method which sorts the
	 * stock via the uniqueID of the Item. Otherwise if validation fails the files
	 * corrupt contents are parsed into an invalidFile.txt created. Otherwise if the
	 * files not found a FileNotFoundException is thrown
	 *
	 * @param file, the String file pathway that will read in the file
	 *
	 * @throws FileNotFoundException, the exception thrown if an incorrect file
	 *                                pathway has been supplied or a type mistake
	 */
	public void popStock(String file) {
		// a) Add a method, popStock() that accepts the name of a text file as a
		// parameter and uses the data in the file to add items to stock.
		String text = "";
		String[] line = null;
		try {
			PrintStream invalidFile = new PrintStream(new File("invalidStock.txt"));
			Scanner s = new Scanner(new File(file));
			while (s.hasNext()) {
				Item item = null;
				text = s.nextLine();
				line = text.split(",");
				if (itemCheck(line[0]) && intCheck(line[1]) && doubleCheck(line[2])) {
					System.out.println("Line read successful, Item is created");
					if (findItem(line[0]) == null) {
						item = new Item(line[0], Integer.parseInt(line[1]), Double.parseDouble(line[2]));
						products.add(item);
						Collections.sort(products, new ItemComparator());
					} else {
						System.out.println("Item Already Exists");
					}
				} else {
					System.out.println("File is corrupt, file contents being parsed to invalidStock.txt");
					invalidFile.println(text);
					invalidFile.close();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error,File not found");
		}

	}
	
	 
	

	/**
	 * doubleCheck, uses a pattern of variable String to check and validate using a
	 * try catch block to parse the pattern into double, if so isTrue is set to true
	 * else the exception is caught and a message is printed
	 *
	 * @param pattern, a string from the file supplied to validate if it is a double
	 *                 or not
	 * @throws Exception, thrown when the string supplied isn't a double
	 *
	 * @return isTrue, the boolean which is returned whether the string supplied is
	 *         a double or not
	 */
	public static boolean doubleCheck(String pattern) {
		boolean isTrue = false;
		try {
			Double.valueOf(pattern);
			System.out.println("Correct");
			isTrue = true;
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			System.out.println("Not a valid double value ");
			isTrue = false;
		}
		return isTrue;
	}

	/**
	 * intCheck, uses a pattern of variable String to check and validate using a try
	 * catch block to parse the pattern into integer, if so isTrue is set to true
	 * else the exception is caught and a message is printed
	 *
	 * @param pattern, a string from the file supplied to validate if it is a
	 *                 integer or not
	 * @throws Exception, thrown when the string supplied isn't a integer
	 *
	 * @return isTrue, the boolean which is returned whether the string supplied is
	 *         a integer or not
	 */
	public static boolean intCheck(String pattern) {
		boolean isTrue = false;
		try {
			Integer.valueOf(pattern);
			System.out.println("Correct");
			isTrue = true;
		} catch (Exception ex) {
			System.out.println("Not a valid Integer value");
			isTrue = false;
		}
		return isTrue;

	}

	/**
	 * itemCheck, uses a pattern of variable String to check and validate using a
	 * try catch block to parse the pattern into a String, if so isTrue is set to
	 * true else the exception is caught and a message is printed
	 *
	 * @param pattern, a string from the file supplied to validate if it is a string
	 *                 or not
	 * @throws Exception, thrown when the string supplied isn't a String
	 *
	 * @return isTrue, the boolean which is returned whether the string supplied is
	 *         a string or not
	 */
	public static boolean itemCheck(String pattern) {
		boolean isTrue = false;
		try {
			String.valueOf(pattern);
			System.out.println("Correct");
			isTrue = true;
		} catch (Exception ex) {
			System.out.println("Not a valid Item value");
			isTrue = false;
		}
		return isTrue;

	}

	/**
	 * saveData, uses a FileOutputStream and ObjectOutputStream to write to a file
	 * of the ArrayLists contents to a file called items.bin
	 *
	 *
	 * @throws FileNotFoundException, the exception thrown if an incorrect file
	 *                                pathway has been supplied or a type mistake
	 * 
	 * @throws IOException,           the exception thrown if there is an incorrect
	 *                                input type
	 * 
	 */
	public void saveData() {
		// b) Write a method saveData() that writes the arrayList in the Stock class to
		// a binary file items.bin.
		try {
			FileOutputStream outFile = new FileOutputStream(FILENAME);
			ObjectOutputStream objOutput = new ObjectOutputStream(outFile);
			objOutput.writeObject(products);
			objOutput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stock, an alternate constructor used to create a Stock ArrayList class using
	 * a String binFIle in order to read the file pathway using Stream Classes to
	 * read the file pathway in order to read the object. products the ArrayList is
	 * written to the file using the ObjectInputStream instance ois, this is
	 * surrounded by a try catch block
	 * 
	 * @param binFile, the String used to specify the file pathway to input the
	 *                 products contents from
	 * 
	 * @throws FileNotFoundException,  the exception thrown if an incorrect file
	 *                                 pathway has been supplied or a type mistake
	 * 
	 * @throws IOException,            the exception thrown if there is an incorrect
	 *                                 input type
	 *
	 * @throws ClassNotFoundException, the exception thrown if the Stock Class is
	 *                                 not found
	 */
	public Stock(String binFile) {
		// c) Add another constructor that accepts a binary file as a parameter and uses
		// the file to initialise the ArrayList.
		try {
			FileInputStream fis = new FileInputStream(binFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			ArrayList<Item> arrayList = (ArrayList<Item>) obj;
			products = arrayList;
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}
