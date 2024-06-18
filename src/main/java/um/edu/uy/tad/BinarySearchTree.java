package um.edu.uy.tad;

public interface BinarySearchTree<T extends Comparable<T>>{
    void insert(T element);
    boolean search(T element);
    void delete(T element);
    int size();
    boolean isEmpty();
}
