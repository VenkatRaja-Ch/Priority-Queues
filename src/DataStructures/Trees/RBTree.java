package DataStructures.Trees;

import Nodes.RBTreeNode;

public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private RBTreeNode<K, V> root;

    // constructor
    public RBTree() {
        root = null;
    }

    public RBTreeNode<K, V> getRoot() {
        return this.root;
    }

    // insert operation
    public void insert(K key, V value) {
        RBTreeNode<K, V> z = new RBTreeNode<>(key, value);
        RBTreeNode<K, V> y = null;
        RBTreeNode<K, V> x = root;

        while(x != null) {
            y = x;
            if(z.key.compareTo(x.key) < 0)
                x = x.left;
            else
                x = x.right;
        }

        z.parent = y;
        if(y == null)
            root = z;
        else if(z.key.compareTo(y.key) < 0)
            y.left = z;
        else
            y.right = z;
        z.left = null;
        z.right = null;
        z.color = RED;
        insertFixup(z);
    }

    // fixup for insert operation
    private void insertFixup(RBTreeNode<K, V> z) {

        while(z.parent != null && z.parent.color == RED){

            if(z.parent == z.parent.parent.left) {

                RBTreeNode<K, V> y = z.parent.parent.right;
                if(y != null && y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if(z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    rightRotate(z.parent.parent);
                }
            } else {

                RBTreeNode<K, V> y = z.parent.parent.left;
                if(y != null && y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if(z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    leftRotate(z.parent.parent);
                }
            }
        }

        root.color = BLACK;
    }

    // deletion operation
    public void delete(K key) {

        RBTreeNode<K, V> z = search(key);
        if(z == null)
            return;

        RBTreeNode<K, V> y = z;
        RBTreeNode<K, V> x;
        boolean yOriginalColor = y.color;

        if(z.left == null) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == null){
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if(y.parent == z)
                x.parent = y;
            else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if(yOriginalColor == BLACK)
            deleteFixup(x);
    }

    // transplant function
    private void transplant(RBTreeNode<K, V> u, RBTreeNode<K, V> v) {

        if(u.parent == null)
            root = v;
        else if (u == u.parent.left)
            u.parent.left = v;
        else
            u.parent.right = v;
        if(v != null)
            v.parent = u.parent;
    }

    // delete fixup function
    private void deleteFixup(RBTreeNode<K, V> x) {

        while(x != root && x != null && x.color == BLACK) {
            if(x == x.parent.left) {
                RBTreeNode<K, V> w = x.parent.right;
                if(w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    leftRotate(x.parent);
                }
                if(w.left.color == BLACK && w.right.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                } else {
                    if(w.right.color == BLACK) {
                        w.left.color = BLACK;
                        w.color = RED;
                        rightRotate(w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.right.color = BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                RBTreeNode<K, V> w = x.parent.left;
                if(w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if(w.right.color == BLACK && w.left.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                } else {
                    if(w.left.color == BLACK) {
                        w.right.color = BLACK;
                        w.color = RED;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.left.color = BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }

        if(x != null)
            x.color = BLACK;
    }

    // search operation
    public RBTreeNode<K, V> search(K key) {
        RBTreeNode<K, V> x = root;
        while(x != null && !key.equals(x.key)) {
            if(key.compareTo(x.key) < 0)
                x = x.left;
            else
                x = x.right;
        }

        return x;
    }

    // minimum
    public RBTreeNode<K, V> minimum(RBTreeNode<K, V> x) {
        while(x.left != null)
            x = x.left;

        return x;
    }

    // maximum
    public RBTreeNode<K, V> maximum(RBTreeNode<K, V> x) {
        while(x.right != null)
            x = x.right;

        return x;
    }

    // left Rotation
    private void leftRotate(RBTreeNode<K, V> x) {

        RBTreeNode<K, V> y = x.right;
        x.right = y.left;
        if(y.left != null)
            y.left.parent = x;
        y.parent = x.parent;
        if(x.parent == null)
            root = y;
        else if(x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.left = x;
        y.parent = y;
    }

    // right rotation
    private void rightRotate(RBTreeNode<K, V> x) {

        RBTreeNode<K, V> y = x.left;
        x.left = y.right;
        if(y.right != null)
            y.right.parent = x;
        y.parent = x.parent;
        if(x.parent == null)
            root = y;
        else if(x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.right = x;
        x.parent = y;
    }
}
