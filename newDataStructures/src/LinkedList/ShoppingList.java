package LinkedList;

public class ShoppingList {
	public static void main(String args[]) {
		// 1. Write a program (ShoppingList.java) that:
		// a. Creates an instance of your LinkedList class.
		// b. Fills the instance with 10 hard-coded pieces of text using your add()
		// method
		// c. Loops through the LinkedList and displays the content. The loop should be
		// based on your size()
		// method, and you should retrieve each entry in the list using your get()
		// method.
		// i. Make sure that ALL of the data that should be in your list appears
		// ii. Make sure that the data appears in the right order!
		// iii. Make sure that you don’t end up seeing blanks!
		// d. Adds the word “Chocolate” to the start of the list using your addFirst()
		// method.

		LinkedList list = new LinkedList();
		list.add("Banana");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		list.add("i");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("------------------------------");
		list.remove2(0);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("------------------------------");
		list.addFirst("Chocolate");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// 1. Amend your ShoppingList program to add the following to the end of your
		// program:
		// a. Use your 2 parameter add() method to add “Apples” to your LinkedList in
		// position 5.
		// b. Loop through the LinkedList and display the content. Confirm that “Apples”
		// appears in position 5,
		// and that the rest of your list is still present.
		// c. Use your remove() method to delete the element in position 8 and display
		// it (it should be returned
		// by your remove() method)
		// d. Loop through the LinkedList and display the content. Confirm that the
		// element that WAS in position
		// 8 is no longer in your list, and that the elements from after that position
		// are still in the list.

		System.out.println("------------------------------------");
		list.add("Apples", 0);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		list.remove(8);
		System.out.println("After Removal");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		list.remove("Chocolate");
		// 1. Amend your ShoppingList program to add the following to the end of your
		// program:
		// a. Use your set() method to set the element in position 3 to be “Pears”.
		// b. Loop through the LinkedList and display the content. Confirm that “Pears”
		// appears in position 3, and
		// that the element that WAS in position 3 is no longer in your list.
		// c. Use your isEmpty() method to display whether or not there is anything in
		// your list.
		// d. Use your remove() method to try and delete “Apples” from the list. Display
		// whether or not the
		// element could be removed.
		// e. Loop through the LinkedList & display the content. Confirm that all
		// elements are in the correct place.
		// f. Use your contains() method to confirm that “Pears” is present in the list.
		// g. Use your clear() method to wipe the content of the list.
		// h. Loop through the LinkedList and confirm that there is nothing to be
		// displayed.
		// i. Use your isEmpty() method to display whether or not there is anything in
		// your list

		System.out.println("---------------------------------");
		list.set("Pears", 3);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("---------------------------------");
		System.out.println("List Empty:");
		System.out.println(list.isEmpty());
		System.out.println("---------------------------------");
		System.out.println(list.contains("Pears"));
		System.out.println("---------------------------------");
		list.clear();

		if (list.isEmpty()) {
			System.out.println("List is empty");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}

//	private static void printList(LinkedList list) {
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//	}

//	private static boolean tabulateList(DynamicArrayList list) {
//	Scanner sc=new Scanner(System.in);
//	System.out.println("Enter your List item");
//	String item=sc.nextLine();
//	return list.add(item);
//	}
//	

}
