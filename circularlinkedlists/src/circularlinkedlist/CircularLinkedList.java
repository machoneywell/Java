package circularlinkedlist;

import java.util.Scanner;

import java.util.Scanner;

public class CircularLinkedList <E> {
    // Instance variables. You cannot add or remove these starting variables
    private Node<E> tail;
    private int size;

    // Default Constructor sets the tail-->null and size-->0
    public CircularLinkedList() {
    }


    /** Access Methods */
    // returns current size
    public int getSize() {
        return size;
    }

    // return true if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the value of first element (head) of the list
    public E getFirst() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    // Returns the value of last element (tail) of the list
    public E getLast() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // list = [1,2,3,4,5]
    // list.delete(4) => [1,2,3,5,6]
    // Some cases to consider:
    //The circular linked list has only one element, and we want to remove the element
    //The element to delete is the head node
    //The element to delete is the tail node
    public void deleteNode(E e) {
        if (isEmpty()) return;
        if (tail.getNext() == tail) {
            tail = null;
            size--;
        } else if (tail.getNext().getElement() == e) {
            tail.setNext(null);
            size--;
        } else if (tail.getElement() == e) {
            tail = null;
            size--;
        } else {
            if (containsValue(e)) {
                Node<E> currNode = tail.getNext();
                for (int i = 0; i < size; i++) {
                    if (currNode.getElement() == e) {
                        currNode.setElement(null);
                        size--;
                    }
                    currNode = currNode.getNext();
                }
            }
        }
    }

    /** Update methods */
    // Left Rotate the elements in the list. (Hint: Tail becomes tail.getNext())
    // list                 --> [1,2,3,4,5]
    // list_after_rotate_1  --> [2,3,4,5,1]
    // list_after_rotate_2  --> [3,4,5,1,2]
    public void rotate(){
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    // Add an element at the start of the list. (Hint: The first element of a circular linked list is tail.getNext())
    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newItem = new Node<>(e, tail.getNext());
            tail.setNext(newItem);
        }
        size++;
    }

    // Adding the element at the tail. Question: Can you implement this function using addFirst and rotate?
    // list = [1,2,3,4,5]
    // list.addLast(6) => [1,2,3,4,5,6]
    public void addLast(E e) {
        addFirst(e);
        rotate();
    }

    // Remove the first element of the list and return the removed element.
    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> head = tail.getNext();
        if (tail.getNext() == tail) {
            E remElem = tail.getElement();
            tail = null;
            size--;
            return remElem;
        } else {
            size--;
            tail.setNext(head.getNext());
            return head.getElement();
        }
    }

    // Prints out the list elements.
    // IF these are the elements of the linked list, then they will be matched with the corresponding output
    // 1)--> "prius", "rav4", "subaru", "crv", "pilot"
    // 2)--> 1,2,3,4,5
    // 3)--> []
    // Outputs
    // 1)-->[prius, rav4, subaru, crv, pilot, prius, rav4, subaru, crv, pilot]
    // 2)-->[1, 2, 3, 4, 5, 1, 2, 3, 4, 5]
    // 3)-->[empty list]
    public String toString(){
        String s;
        Node<E> n;
        if (tail == null) return "[empty list]";
        s = "[";
        n = tail.getNext();
        int iteration = 0;
        while (n != null && iteration < size * 2) {
            iteration++;
            s = s + n.getElement();
            if (iteration < size * 2) s = s + ", ";
            n = n.getNext();
        }
        return s + "]";
    }

    // Checks the list to see if the given value is contained within it
    public boolean containsValue(E searchValue) {
        Node<E> currNode = tail.getNext();
        while (currNode != null) {
            if (currNode.getElement() == searchValue) return true;
            currNode = currNode.getNext();
        }
        return false;
    }

    public static void main(String args[]){
        String[] cars = { "prius", "rav4", "subaru", "crv", "pilot"};

        CircularLinkedList<String> carsList = new CircularLinkedList<String>();
        for (String i: cars)
            carsList.addLast(i);

        System.out.println("linkedList:"+ carsList.toString());
        // Output for this should be --> linkedList:[prius, rav4, subaru, crv, pilot, prius, rav4, subaru, crv, pilot]
    }
}

