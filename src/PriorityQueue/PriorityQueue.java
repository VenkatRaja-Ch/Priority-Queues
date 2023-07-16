package PriorityQueue;

public interface PriorityQueue <K extends Comparable<K>, V> {

    // functions of this Priority Queue
    void insert(K key, V value);
    V deleteMax();
    V peek();
    boolean isEmpty();
    int size();

}
