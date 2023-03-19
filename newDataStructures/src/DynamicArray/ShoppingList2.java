package DynamicArray;

import java.util.Scanner;

public class ShoppingList2 {
	public static void main(String args[]) {
		   Scanner sc = new Scanner(System.in);
	        //	1. Write a program (ShoppingList.java) that:
	        //	a. Creates an instance of your DynamicArrayList class.
	        //	b. Asks the user how many entries they’d like to add to their shopping list.
	        //	c. Prompts the user to enter the specified number of entries for their shopping list and adds each to the
	        //	list (each line can contain one or more words each)
	        //	d. Loops through the shopping list and displays the content.
	        //	e. Asks the user to enter an item and searches for that item in the list.
	        //	f. Sets every odd-numbered position in the list to contain “Milk chocolate”.
	        //	g. Loops through the shopping list and displays the content.
	        //	h. Removes all instances of “Milk chocolate” from the list.
	        //	i. Checks whether or not the list is empty (using your isEmpty() method).
	        //	i. If it’s not empty, then the program should print a final count before terminating
	        //	ii. If it is empty, the program should display a message indicating there is nothing in the list, then
	        //	terminate.

	        System.out.println("How many slots do you want in your shopping cart?");
	        int size = sc.nextInt();

	        dyanamicarraylistca cart = creatingList(size);
	        System.out.println("Place items into your Cart");
	        System.out.println("---------------------------------------");
	        for (int i = 0; i < cart.size(); i++) {
	            System.out.println(i + " " + cart.get(i));
	        }
	        System.out.println("---------------------------------------");
	        int pos = indexOfList(cart);
	        System.out.println(pos);

	        chocolateMilkChange(cart);
	        System.out.println("---------------------------------------");
	        for (int i = 0; i < cart.size(); i++) {
	            System.out.println(cart.get(i));
	        }

	        cart.removeAll("Chocolate Milk");
	        System.out.println("---------------------------------------");
	        for (int i = 0; i < cart.size(); i++) {
	            System.out.println(i + " " + cart.get(i));
	        }
	        checkIsEmpty(cart);
	    }

	    public static dyanamicarraylistca creatingList(int size) {
	        Scanner sc = new Scanner(System.in);
	        dyanamicarraylistca list = new dyanamicarraylistca(size);
	        System.out.println("Place items into your Cart");
	        for (int i = 0; i < size; i++) {
	            String item = sc.nextLine();
	            list.add(item);
	        }
	        return list;
	    }

	    public static int indexOfList(dyanamicarraylistca list) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Please search for an Item");
	        String str = sc.nextLine();
	        int index = list.indexOf(str);

	        return index;
	    }

	    public static void chocolateMilkChange(dyanamicarraylistca list) {
	        for (int i = 1; i < list.size(); i = i + 2) {
	            list.set(i, "Chocolate Milk");
	        }
	    }

	    public static void checkIsEmpty(dyanamicarraylistca list) {
	        if (list.isEmpty()) {
	            System.out.println("Cart is Empty ");

	        } else {
	            System.out.println("Cart is not empty ");
	            System.out.println("Final Size: " + list.size());
	        }
	    }

	}
