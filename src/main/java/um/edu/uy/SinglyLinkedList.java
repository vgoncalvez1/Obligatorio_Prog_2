package um.edu.uy;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements LinkedList<T> {
    private class Node{
        T element;
        Node next;

        Node(T element){
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private  int size;
    @Override
    public void addfrist(T element) {
        Node newNode = new Node(element);
        if (isEmpty()){
            head = tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }

    }

    @Override
    public void addLast(T element) {
        Node newNode = new Node(element);
        if (isEmpty()){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size ++;
    }

    @Override
    public T removeFrist() {
        if (isEmpty()){
            throw  new NoSuchElementException();
        }
        T element = head.element;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size ++;
        return element;
    }

    @Override
    public T removeLast() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        T element = tail.element;
        if (head == null){
            head = tail = null;
        }else {
            Node current = head;
            while (current.next != tail){
                current = current.next
            }
            tail = current;
            tail.next = null;
        }
        size--;
        return element;
    }

    @Override
    public T getFrist() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return head.element;
    }

    @Override
    public T getLast() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return tail.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


}
