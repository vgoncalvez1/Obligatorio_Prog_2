package um.edu.uy.tad;

import java.util.NoSuchElementException;

public class ClosedHashTable<K, V> implements ClosedHash<K, V> {
    private static final int INITIAL_CAPACITY = 16;

    private static class Entry<K, V>{
        K key;
        V value;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    private Entry<K, V>[] table;
    private int size;

    @SuppressWarnings("Inchequable")
    public ClosedHashTable(int capacidad){
        table = (Entry<K, V>[]) new Entry[capacidad];
        size = 0;
    }
    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        for (int i = 0; i < table.length; i++){
            int probeIndex = (index + 1) % table.length;
            if (table[probeIndex] == null || table[probeIndex].key.equals(key)){
                table[probeIndex] = new Entry<>(key, value);
                if (table[probeIndex] == null){
                    size++;
                }
                return;
            }
        }
        throw new NoSuchElementException("Table esta llena");
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        for (int i = 0; i < table.length; i++){
            int probeIndex = (index + i) % table.length;
            if (table[probeIndex] == null){
                return null;
            }
            if (table[probeIndex].key.equals(key)){
                return table[probeIndex].value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V remove(K key) {
        int index = getIndex(key);
        for (int i = 0; i < table.length; i++){
            int probeIndex = (index + 1) % table.length;
            if (table[probeIndex] == null){
                return null;
            }
            if (table[probeIndex].key.equals(key)){
                V value = table[probeIndex].value;
                table[probeIndex] = null;
                size--;
                rehash();
                return value;

            }
        }
        return null;
    }

    private  void rehash(){
        Entry<K, V>[] oldtable = table;
        table = new Entry[oldtable.length];
        size = 0;
        for (Entry<K, V> entry : oldtable){
            if (entry != null){
                put(entry.key, entry.value);
            }
        }
    }

    private int getIndex(K key){
        return key.hashCode() % table.length;
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
