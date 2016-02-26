import java.lang.NullPointerException;
import java.lang.ClassCastException;
import java.lang.StringBuilder;

public class SinglyLinkedList<T> implements List<T> {

    private class Node {
        T element;
        Node next;
        Node(T element) {
            if (element == null)
                throw new NullPointerException("Null element");
            this.element = element;
        }
        @Override
        public boolean equals(Object o) {
            try {
                // if unable to cast, an exception will be thrown
                @SuppressWarnings("unchecked")
                Node other = (Node) o;
                return element.equals(other.element);
            } catch(ClassCastException e) {
                // do nothing
            }
            return false;
        }
        @Override
        public String toString() {
            return element.toString();
        }
    }
    private Node head;
    private int nodeCounter;

    // INSERTS AS THE FIRST ELEMENT - o(1)
    //
    // Tests: add in an empty list, check if the element exists, nodeCounter
    //        add in a non-empty list, check if the element exists, nodeCounter
    //        test for multiple inserts
    //
    @Override
    public void add(T element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node oldHead = head;
            head = newNode;
            head.next = oldHead;
        }
        nodeCounter++;
    }

    // WORST CASE - LINEAR SEARCH, THEREFORE, O(n)
    //
    // Tests:   remove from empty list
    //          remove from an 1-element list
    //          same as before but the removed element doesn't exist
    //          remove from a regular list (more than 1 elements), element exists
    //          remove from a regular list (more than 1 elements), element doesn't exist
    //
    //          Checking if the removed element exists wouldn't give useful
    //          information if we test on a list with duplicated nodes.
    //
    /** removes the first occurrence of element */
    @Override
    public void remove(T element) {
        Node toRemove = new Node(element);

        Node previousNode = null;
        Node currentNode = head;
        while ((currentNode != null) && !currentNode.equals(toRemove)) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNode != null && currentNode.equals(toRemove)) {
            if (previousNode == null) {
                head = null;

            } else {
                previousNode.next = currentNode.next;
            }
            currentNode = null;
            nodeCounter--;
        }
    }

    /** removes the ith occurrence of element. If there's no ith
    occurrence, nothing happens. */
    @Override
    public void remove(T element, int ith) { }

    /** returns the length of this list */
    @Override
    public int length() { return nodeCounter; }

    /** gets the ith element of this list */
    @Override
    public T get(int ith) { return null; }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node currentNode = head;
        while (currentNode != null) {
            str.append(" ");
            str.append(currentNode.toString());
            currentNode = currentNode.next;
        }
        str.append(" ]");
        return str.toString();
    }
}
