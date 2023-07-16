package DataStructures.Trees;

import Nodes.SplayTreeNode;

public class SplayTree<K extends Comparable<K>, V>{

    private SplayTreeNode<K, V> root;

    public SplayTree(){
        this.root = null;
    }

    // left rotation
    private void leftRotate(SplayTreeNode<K, V> node) {
        SplayTreeNode<K, V> parent = node.parent;
        SplayTreeNode<K, V> left = node.left;
        node.left = parent;
        parent.right = left;

        if(left != null)
            left.parent = parent;

        SplayTreeNode<K, V> grandParent = node.parent.parent;
        parent.parent = node;
        node.parent = grandParent;

        if(grandParent == null)
            root = node;
        else
            if(grandParent.left == parent)
                grandParent.left = node;
            else
                grandParent.right = node;
    }

    // right rotation
    private void rightRotate(SplayTreeNode<K, V> node) {
        SplayTreeNode<K, V> parent = node.parent;
        SplayTreeNode<K, V> right = node.right;
        node.right = parent;
        parent.left = right;

        if(right != null)
            right.parent = parent;

        SplayTreeNode<K, V> grandParent = parent.parent;
        node.parent = grandParent;
        parent.parent = node;

        if(grandParent == null)
            root = node;
        else{
            if(grandParent.left == parent)
                grandParent.left = node;
            else
                grandParent.right = node;
        }
    }

    // splay operation
    private void splay(SplayTreeNode<K, V> node) {
        if(node.parent == null) {
            root = node;
            return;
        }

        // zig rotation
        if(node.parent.parent == null) {
            if (node.parent.right == node) {
                leftRotate(node);
                root = node;
            } else {
                rightRotate(node);
                root = node;
            }

            return;
        }

        // zig-zag rotation [left rotation then right rotation]
        if(node.parent.right == node && node.parent.parent.left == node.parent) {
            leftRotate(node);
            rightRotate(node);
            splay(node);
            return;
        }

        // zig-zag rotation [right rotation then left rotation]
        if(node.parent.left == node && node.parent.parent.right == node.parent) {
            rightRotate(node);
            leftRotate(node);
            splay(node);
            return;
        }

        // zig-zig rotation [left rotation then left rotation]
        if (node.parent.right == node && node.parent.parent.right == node.parent) {
            leftRotate(node.parent);
            leftRotate(node);
            splay(node);
            return;
        }

        // zig-zig rotation [right rotation then right rotation]
        if (node.parent.left == node && node.parent.parent.left == node.parent) {
            rightRotate(node.parent);
            rightRotate(node);
            splay(node);
            return;
        }
    }

    // insert
    public void insert(K key, V value) {
        root = insertNode(root, key, value);
    }

    // insertion operation
    private SplayTreeNode<K, V> insertNode(SplayTreeNode<K, V> node, K key, V value) {
        SplayTreeNode<K, V> newNode = new SplayTreeNode<>(key, value);

        if(root == null)
            return newNode;

        SplayTreeNode<K, V> temp = root;
        SplayTreeNode<K, V> parent = null;

        while(temp != null){
            parent = temp;

            if(temp.key.compareTo(key) < 0)
                temp = temp.left;
            else if(temp.key.compareTo(key) > 0)
                temp = temp.right;
            else {
                throw new IllegalStateException("Duplicate key not allowed:" + key);
            }
        }

        // set the parent to the new node
        newNode.parent = parent;

        // insert parent
        if(key.compareTo(parent.key) < 0)
            parent.left = newNode;
        else
            parent.right = newNode;

        // splay operation
        splay(newNode);

        return temp;
    }

    public SplayTreeNode<K, V> getRoot() {
        return root;
    }
}
