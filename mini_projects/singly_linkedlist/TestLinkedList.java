package singly_linkedlist;



/**
 * The TestLinkedList class is used to demonstrate the functionality 
 * of a custom LinkedList implementation.
 * It contains a main method that creates a LinkedList object, 
 * appends elements to it, and prints the list.
 */
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addHead(2);
        list.addHead(7);
        list.printList();
        
        list.addHead(6);
        list.addTail(10);
        list.addHead(5);
        list.addTail(15);
        list.addTail(20);
        list.addTail(25);
        list.printList();

        System.out.println(list.indexOf(10));
        System.out.println(list.indexOf(50));

        System.out.println(list.contains(10));
        System.out.println(list.contains(50));


    }
}