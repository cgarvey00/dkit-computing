package Queues;

import java.util.Scanner;

public class BoundedMusicQueue {
public static <E> void main(String args[]) {
//	1. Write a second copy of your MusicQueue program that does the same functionality, but using your
//	BoundedQueue. Your program should contain the following amendments:
//	a. Ask the user how many Songs your queue should be able to hold, and create your queue with that
//	capacity.
//	b. Instead of automatically adding 10 elements, request your user adds new items to their queue until
//	the structure is full.
//	Scanner sc = new Scanner(System.in);
	System.out.println("How many songs should a queue contain");
//	int size=sc.nextInt();
	BoundedQueue <E> list= new BoundedQueue<E>();
	
	creatingQueue(list);
	
//	System.out.println("Enter songs in the music queue");
//	for (int i = 0; i <list.size() ; i++) {
//		String item = sc.nextLine();
//		list.add(item);
//	}
//	
//	printList(list);
//	sc.close();
}

private static <E> void creatingQueue(BoundedQueue <E> list) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter songs in the music queue");
	for (int i = 0; i <list.size() ; i++) {
		String item = sc.nextLine();
		list.add(item);
	}
	sc.close();
}

private static void printList(BoundedQueue <String> list) {
	for (int i = 0; i <10; i++) {
		System.out.println(i+ " " +  list.get(i));
	}

}
}
