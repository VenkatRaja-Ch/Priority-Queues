package Nodes;

public class SplayTreeNode<K extends Comparable<K>, V> {

    public K key;
    public V value;
    public SplayTreeNode<K, V> left;
    public SplayTreeNode<K, V> right;
    public SplayTreeNode<K, V> parent;

    public SplayTreeNode(K key, V value){

        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
