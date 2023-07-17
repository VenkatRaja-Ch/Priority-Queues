package Nodes;

public class AVLTreeNode<K extends Comparable<K>, V> {

    public K key;
    public V value;
    public int height;
    public AVLTreeNode<K, V> left;
    public AVLTreeNode<K, V> right;

    // constructor
    public AVLTreeNode(K key, V value) {

        this.key = key;
        this.value = value;
        this.height = -1;
        this.left = null;
        this.right = null;
    }
}
