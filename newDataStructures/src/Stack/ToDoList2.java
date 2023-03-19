package Stack;

import java.util.Scanner;

public class ToDoList2 {
public static void main(String args[]) {
//	1. Write a second copy of your ToDoList program that does the same functionality, but using your
//	BoundedStack. Your program should contain the following amendments:
//	a. Ask the user how many ToDo items your Stack should be able to hold, and create your Stack with
//	that capacity.
//	b. Instead of automatically adding 10 elements, request your user adds new items to their list until the
//	stack is full.
	

	Scanner sc = new Scanner(System.in);
	
	System.out.println("how many todo items stack should hold");
	int size=sc.nextInt();
	
	BoundedStack toDo = creatingList(size);
	Stack toDo2 = new Stack();
	for (int i = 0; i < size; i++) {
		System.out.println(i+ " " +  toDo.pop());
	}
	System.out.println("---------------------");

	System.out.println("---------------------");
	System.out.println(toDo.isFull());
}

private static BoundedStack creatingList(int size) {
	Scanner sc = new Scanner(System.in);
	BoundedStack toDo = new BoundedStack(size);
	System.out.println("Enter The tasks");
	for (int i = 0; i < size; i++) {
		String item = sc.nextLine();
		toDo.push(item);
	}
	sc.close();
	return toDo;
}

//private static void printList(BoundedStack list , int size) {
//	for (int i = 0; i < size; i++) {
//		System.out.println(i+ " " +  list.pop());
//	}
//}
}

