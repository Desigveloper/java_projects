package mini_projects.linkedListImplementation;

/**
 * Represents a singly linked list.
 */
class LinkedList {
    Node head;

    /**
     * Creates a new LinkedList with an empty head.
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * Appends a new node with the given data to the linked list.
     *
     * @param  data the data to be stored in the new node
     */
    public void append(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
            current = current.next;
            }
            current.next = newNode;
        }
        
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

