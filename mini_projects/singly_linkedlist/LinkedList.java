package singly_linkedlist;
/**
 * Represents a singly linked list.
 */
class LinkedList {
    /**
 * Represents a node in a singly linked list.
 * Each node contains an integer data value and a reference to the next node in the list.
 */
public class Node {
    private int data;
    private Node next;

    private  Node(int data) {
        this.data = data;
    }
}
    Node head;
    Node tail;

    /**
     * Creates a new LinkedList with an empty head.
     */
    private boolean isEmpty() {
        return head == null;
    }

    /**
     * Appends a new node with the given data to the linked list.
     *
     * @param  data the data to be stored in the new node
     */
    public void addHead(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        
    } 

    public void addTail(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int indexOf(int data) {
        int index = 0;
        Node current = head;

        while (current != null) {
            if (current.data == data)
                return index;
            index++;
            current = current.next;
        }
        return -1;
    }

    /* 
     * 
     */
    public boolean contains(int data) {
        return indexOf(data) != -1;
    }

    /**
     * Prints the elements of the linked list in order, separated by " -> ".
     *
     * @return void
     */
    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " ->");
            currNode = currNode.next;
        }
        System.out.println("");
    }
}

