package um.edu.uy.tad;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
    private T[] array;
    private int size;
    private int front;
    private int rear;
    public ArrayQueue(int Capacity){
        array = (T[]) new Object[Capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    @Override
    public void enqueue(T data) {
        if (size == array.length){
            throw new NoSuchElementException("Queue esta lleno");
        }
        rear = (rear + 1) % array.length;
        array[rear] = data;
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0){
            throw new NoSuchElementException("Queue esta vacio");
        }
        T data = array[front];
        front = (front + 1) % array.length;
        size --;
        return data;
    }

    @Override
    public T fris() {
        if (size == 0){
            throw new NoSuchElementException();
        }
        return array[front];
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
