package um.edu.uy.tad;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements LinkedList<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    private Node tail;
    private int size;

    @Override
    public void addfrist(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void addLast(T data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }

    }

    @Override
    public T removeFrist() {
        if (head == null) {
            throw new NoSuchElementException("Lista esta vacia.");
        }
        T data = head.data;
        head = head.next;
        return data;
    }

    @Override
    public T removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T element = tail.data;
        if (head == null) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        size--;
        return element;
    }

    @Override
    public T getFrist() {
        if (head == null) {
            throw new NoSuchElementException("Lista esta vacia");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
