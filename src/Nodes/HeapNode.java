package Nodes;

public class HeapNode<K extends Comparable<K>, V> {

    public K key;
    public V value;

    public HeapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
