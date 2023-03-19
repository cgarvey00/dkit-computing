package DynamicArray;

import java.util.Scanner;

public class ShoppingList {
	public static void main(String args[]) {
//	1. Write a program (ShoppingList.java) that:
//		a. Creates an instance of your DynamicArrayList class.
//		b. Fills the instance with 10 hard-coded pieces of text using your add() method
//		c. Loops through the DynamicArrayList and displays the content. The loop should be based on your
//		size() method, and you should retrieve each entry in the list using your get() method.
//		i. Make sure that ALL of the data that should be in your list appears
//		ii. Make sure that the data appears in the right order!
//		iii. Make sure that you don’t end up seeing blanks!
//		d. Prints out the position of the word “Chocolate” (note: it might not be there!)
//		Scanner sc = new Scanner(System.in);
		DynamicArrayList cart = new DynamicArrayList();
		for(int i=0; i<cart.size() ;i++){
		tabulateList(cart);
		}
	
//		cart.add("Milk");
//		cart.add("Bar");
//		cart.add("Chocolate");
//		cart.add("Caple");
//		cart.add("Codeine");
//		cart.add("Crisps");
//		cart.add("Cheese");
//		cart.add("Yougart");
//		cart.add("Chocolate");
//		cart.add("Chocolate");

//		printList(cart);
//		System.out.println("#########################");
//		System.out.println("Removed product= " + cart.remove(0));
//		System.out.println("--------------------------------------------------");
//		printList(cart);
//		System.out.println(cart.size());
//		cart.add2("sss", 8);
//		cart.add2("ddd", 8);
//
//		printList(cart);
//
//		System.out.println(cart.size());
//
//		System.out.println("Please search for a cart item");
//		String item = sc.nextLine();
//
//		System.out.println(cart.remove(item));
//
//		printList(cart);
//		System.out.println(cart.size());
//
//		System.out.println(cart.indexOf("Milk"));
//
//		cart.removeAll("Chocolate");
//		printList(cart);
//		System.out.println("Cart size is: ");
//		System.out.println(cart.size());

//	Using your new functionality from the DynamicArrayList
//	1. Amend your ShoppingList program to add the following to the end of your program:
//	a. Use your 2 parameter add() method to add “Apples” to your DynamicArrayList in position 5.
//	b. Loop through the DynamicArrayList and display the content. Confirm that “Apples” appears in
//	position 5, and that the rest of your list is still present.
//	c. Use your set() method to set the element in position 3 to be “Pears”.
//	It’s ok to have more than one
//	method in the same class with the
//	same name, as long as they have
//	different parameter lists.
//	Data Structures Dynamic Arrays
//	d. Loop through the DynamicArrayList and display the content. Confirm that “Pears” appears in position
//	3, and that the element that WAS in position 3 is no longer in your list.
//	e. Use your remove() method to delete the element in position 8 and display it (it should be returned
//	by your remove() method)
//	f. Loop through the DynamicArrayList and display the content. Confirm that the element that WAS in
//	position 8 is no longer in your list, and that the elements from after that position are still in the list.

//	System.out.println("--------------------------");
//	
//	cart.add("Apples2",5);
//	
//	for(int i=0; i<cart.size() ;i++){
//		System.out.println(cart.get(i));
//	}
//	
//	cart.set("Pears", 3);
//	
//	System.out.println("--------------------------");
//
//	for(int i=0; i<cart.size() ;i++){
//		System.out.println(cart.get(i));
//	}
//	System.out.println("-----------------------");
//	String remove=cart.remove(8);
//	System.out.println(remove);
//	System.out.println("--------------------------");
//
//	for(int i=0; i<cart.size() ;i++){
//		System.out.println(cart.get(i));
//	}
//	1. Amend your ShoppingList program to add the following to the end of your program:
//		a. Use your isEmpty() method to display whether or not there is anything in your list.
//		b. Use your remove() method to try and delete “Apples” from the list. Display whether or not the
//		element could be removed.
//		c. Loop through the DynamicArrayList and display the content. Confirm that all elements are in the
//		correct place.
//		d. Use your contains() method to confirm that “Pears” is present in the list.
//		e. Use your clear() method to wipe the content of the list.
//		f. Loop through the DynamicArrayList and confirm that there is nothing to be displayed.
//		g. Use your isEmpty() method to display whether or not there is anything in your list.

//	System.out.println("--------------------------");
//	
//	System.out.println(cart.isEmpty());
//	
//	System.out.println("--------------------------");
//	
//	System.out.println(cart.remove("Codeine"));
//	for(int i=0; i<cart.size() ;i++){
//		System.out.println(cart.get(i));
//	}
//	
//	System.out.println("--------------------------");
//	
//	System.out.println(cart.contains("Apples2"));
//	
//	System.out.println("--------------------------");
//	System.out.println("###########################");
//	cart.clear();
//	
//	for(int i=0; i<cart.size() ;i++){
//		System.out.println(cart.get(i));
//	}
//
//	System.out.println("--------------------------");
//	
//	System.out.println(cart.isEmpty());
//	
	}
	
	private static void printList(DynamicArrayList list) {
for(int i=0; i<list.size() ;i++){
	System.out.println(list.get(i));
}
	}
	
	
	private static boolean tabulateList(DynamicArrayList list) {
Scanner sc=new Scanner(System.in);
System.out.println("Enter your List item");
String item=sc.nextLine();
return list.add(item);

	}
	
	
}
