package Queues;

public class MusicQueue {
	public static <E> void main(String args[]) {
	
	Queue queue = new Queue();

	queue.add("Chocolate s");
	queue.add("Cr");
	queue.add("Milk");
	queue.add("Chocolate Milk");
	queue.add("Chocolate Milk");
	queue.add("Chocolate Milk");
	queue.add("Chocolate Milk");
	queue.add("Chocolate");
	queue.add("Milk");
	queue.add("Chocolate 22");
	
	System.out.println(queue.peek());
	System.out.println("###########################################");
	System.out.println(queue.isEmpty());
//	for(int i=0; i<queue.size() ;i++){
//	System.out.println(queue.remove());
//	}
	System.out.println("---------------------------");
	for(int i=0; i<10;i++){
		System.out.println(queue.remove());
	}
	
	
		
	
	}
}