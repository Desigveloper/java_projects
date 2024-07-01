package mini_projects.linkedListImplementation;

/**
 * Represents a node in a singly linked list.
 * Each node contains an integer data value and a reference to the next node in the list.
 */
public class Node {
    int data;
    Node next;

    public  Node(int data) {
        this.data = data;
        this.next = null;
    }
}
