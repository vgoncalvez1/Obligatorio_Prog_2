package um.edu.uy;

public interface ClosedHash<K, V>{
    void put(K key, V value);
    V get(K key);
    boolean containsKey(K key);
    V remove(K key);
    int size();
    boolean isEmpty();
}
