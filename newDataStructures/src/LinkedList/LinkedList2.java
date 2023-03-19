package LinkedList;

public class LinkedList2 {
	public static void main(String args[]) {
		LinkedList testList = new LinkedList();
		testList.add("a");
		testList.add("b");
		testList.add("c");
		testList.add("d");
		testList.add("e");
		testList.add("f");
		testList.add("g");

		printList(testList);

		// test one works position=0
		testList.add2("out of place1", 0);
		// test two works position=list.size()
		testList.add("out of place2", testList.size());

		testList.add("out of place3", testList.size() / 2);
		System.out.println("---------------------");

		printList(testList);
		System.out.println("Testing remove String Position");
		testList.remove(0);
		testList.remove(testList.size()-1);
		testList.remove(testList.size()-5);
		System.out.println("---------------------");
		printList(testList);
		System.out.println("---------------------");
		System.out.println("Testing remove String method");
		System.out.println("---------------------");
		testList.remove("a");
		printList(testList);
		System.out.println("---------------------");
		System.out.println("Testing add first");
		System.out.println("---------------------");
		testList.addFirst("a");
		printList(testList);
		
		System.out.println("---------------------");
		System.out.println("Testing set Method");
		System.out.println("---------------------");
		testList.set("change",0);
		printList(testList);
		
		System.out.println("---------------------");
		System.out.println("Testing clear Method");
		System.out.println("---------------------");
		testList.clear();
		printList(testList);
	}

	private static void printList(LinkedList list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
