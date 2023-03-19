package Queues;

import java.util.Scanner;

public class App2 {
public static <E> void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	Queue list= new Queue();
	
	System.out.println("Enter songs in the music queue");
	for (int i = 0; i <list.size(); i++) {
		String item = sc.next();
		list.add(item);
	}
	
sc.close();	
}

private static <E> void creatingQueue(BoundedQueue <E> list) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter songs in the music queue");
	for (int i = 0; i <list.size() ; i++) {
		String item = sc.next();
		list.add(item);
	}
	sc.close();
}

private static <E> void printList(BoundedQueue <E> list) {
	for (int i = 0; i <10; i++) {
		System.out.println(i+ " " +  list.get(i));
	}

}

}
