package Nodes;

public class LinkedListNode <K extends Comparable<K>, V>{

    private final K key;
    private final V value;
    private LinkedListNode<K, V> nextNode;

    public LinkedListNode(K key, V value){
        this.key = key;
        this.value = value;
        this.nextNode = null;
    }

    public LinkedListNode(K key, V value, LinkedListNode<K, V> node){
        this.key = key;
        this.value = value;
        this.nextNode = node;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public LinkedListNode<K, V> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedListNode<K, V> nextNode) {
        this.nextNode = nextNode;
    }
}
