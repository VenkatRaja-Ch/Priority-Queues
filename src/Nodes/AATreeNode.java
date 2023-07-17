package Nodes;

public class AATreeNode<K extends Comparable<K>, V> {

    // properties of AA Tree Node
    public K key;
    public V value;
    public int level;
    public AATreeNode<K, V> left;
    public AATreeNode<K, V> right;

    // constructors
    public AATreeNode(K key, V value) {

        this.key = key;
        this.value = value;
        level = 1;
        this.left = null;
        this.right = null;
    }

}
