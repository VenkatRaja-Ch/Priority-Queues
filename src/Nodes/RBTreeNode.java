package Nodes;

public class RBTreeNode<K extends Comparable<K>, V> {

    // properties of Red-Black Tree Node
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    public V value;
    public K key;
    public boolean color;
    public RBTreeNode<K, V> left;
    public RBTreeNode<K, V> right;
    public RBTreeNode<K, V> parent;


    // constructors
    public RBTreeNode(K key, V value) {

        this.key = key;
        this.value = value;
        this.color = RED;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
