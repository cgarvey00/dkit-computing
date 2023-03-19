package Stack;

import java.util.Scanner;

public class ToDoList {

public static void main(String args[]) {
	
	//	1. Write a program (ToDoList.java) that:
	//	a. Creates an instance of your Stack class.
	//	b. Fills the stack with 10 user-specified tasks (Strings) using your push() method.
	//	c. Displays how many tasks are in the stack using your size() method.
	//	Data Structures Stacks
	//	d. Displays the first element in the stack using your peek() method.
	Stack tasks = creatingList(10);
	System.out.println("---------------------");
	System.out.println("They are : "+tasks.size()+" Tasks");
	System.out.println("---------------------");
	System.out.println(tasks.peek());
	//	1. Amend your ToDoList program to add the following to the end of your program:
	//		a. Loop through the Stack and display the content.
	//		i. Your loop should be based on the isEmpty() method.
	//		ii. You should retrieve each element from the stack using your pop() method.
	
	if (tasks.isEmpty()) {
		System.out.println("List is empty");
	}else {
		printList(tasks);
	}
}

private static Stack creatingList(int size) {
	Scanner sc = new Scanner(System.in);
	Stack list = new Stack();
	System.out.println("Enter 10 tasks");
	for (int i = 0; i < size; i++) {
		String item = sc.nextLine();
		list.push(item);
	}
	sc.close();
	return list;
}

private static void printList(Stack list) {
	for (int i = 0; i <10; i++) {
		System.out.println(i+ " " +  list.pop());
	}
}


}
