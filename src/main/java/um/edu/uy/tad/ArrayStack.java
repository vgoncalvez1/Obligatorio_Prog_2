package um.edu.uy.tad;

import um.edu.uy.tad.Stack;

import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {
    private T[] array;
    private int top;

    public ArrayStack(int capacity){
        array = (T[]) new Object[capacity];
        top = -1;
    }

    @Override
    public void push(T element) {
        if (top == array.length - 1){
            throw new NoSuchElementException("Stack esta lleno");
        }
    }

    @Override
    public T pop() {
        if (top == -1){
            throw new NoSuchElementException("Stack esta vacia");
        }
        return array[top--];
    }

    @Override
    public T peek() {
        if (top == -1){
            throw new NoSuchElementException("Stack esta vacia");
        }
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top;
    }
}