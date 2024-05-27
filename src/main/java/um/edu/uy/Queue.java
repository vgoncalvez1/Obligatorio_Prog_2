package um.edu.uy;

public interface Queue<T>{
    void enqueue(T element);
    T dequeue();
    T fris();
    boolean isEmpty();
    int size();
}
