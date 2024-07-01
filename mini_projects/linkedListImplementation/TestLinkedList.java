package mini_projects.linkedListImplementation;


/**
 * The TestLinkedList class is used to demonstrate the functionality 
 * of a custom LinkedList implementation.
 * It contains a main method that creates a LinkedList object, 
 * appends elements to it, and prints the list.
 */
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(2);
        list.append(7);
        list.printList();
        
        list.append(6);
        list.append(5);
        list.printList();
    }
}