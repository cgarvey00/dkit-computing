package DynamicArray;

public class testnums {
public static void main(String args[]) {
numberUtilities list = new numberUtilities();

list.add(1);
list.add(2);
list.add(3);
list.add(4);
list.add(5);
list.add(6);
list.add(7);
list.add(8);
list.add(9);
list.add(10);

for(int i = 0; i < list.size(); i++){
    System.out.println("Entry: " + list.get(i));
}

if(list.contains(5)){
    System.out.println("My list contains the number 5");
}else{
    System.out.println("My list has no 5s, go fish");
}


System.out.println(list.remove(0));

for(int i = 0; i < list.size(); i++){
    System.out.println("Entry: " + list.get(i));
}

list.add(3, 7);

for(int i = 0; i < list.size(); i++){
    System.out.println("Entry: " + list.get(i));
}

}




}
