package um.edu.uy;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T>{
    private T[] elements;
    private int size;
    private int front;
    private int rear;
    public ArrayQueue(int Capacity){
        elements = (T[]) new Object[Capacity];
        front = 0;
        rear = -1;
    }
    @Override
    public void enqueue(T element) {
        if (size == elements.length){
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        T element = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return element;
    }

    @Override
    public T fris() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return elements[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
