package um.edu.uy.tad;

import um.edu.uy.tad.Stack;

import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {
    private T[] elements;
    private int size;
    public ArrayStack(int capacity){
        elements = (T[]) new Object[capacity];
    }

    @Override
    public void push(T element) {
        if (size == elements.length){
            throw new IllegalStateException("Stack esta lleno");
        }
        elements[size++] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        T element = elements[--size];
        elements[size] = null;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return elements[size - 1];
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
