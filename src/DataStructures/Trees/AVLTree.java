package DataStructures.Trees;

import Nodes.AVLTreeNode;

public class AVLTree<K extends Comparable<K>, V> {

    private AVLTreeNode<K, V> root;

    public AVLTree() {
        this.root = null;
    }

    // get the height of the node
    private int getHeight(AVLTreeNode<K, V> node) {
        return (null == node) ? -1 : node.height;
    }

    // update height of the AVL Tree
    private void updateHeight(AVLTreeNode<K, V> node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    // right rotation
    private AVLTreeNode<K, V> rotateRight(AVLTreeNode<K, V> y) {
        AVLTreeNode<K, V> x = y.left;
        AVLTreeNode<K, V> z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // left rotation
    private AVLTreeNode<K, V> rotateLeft(AVLTreeNode<K, V> y) {
        AVLTreeNode<K, V> x = y.right;
        AVLTreeNode<K, V> z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // rebalanced of the tree
    private AVLTreeNode<K, V> rebalance(AVLTreeNode<K, V> node) {

        updateHeight(node);
        int balanceFactor = getHeight(node.left) - getHeight(node.right);

        if (balanceFactor > 1) {
            if (getHeight(node.left.left) >= getHeight(node.left.right))
                node = rotateRight(node);
            else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (balanceFactor < -1) {
            if (getHeight(node.right.right) > getHeight(node.right.left))
                node = rotateLeft(node);
            else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        return node;
    }

    // insertion operation
    private AVLTreeNode<K, V> insertNode(AVLTreeNode<K, V> node, K key, V value) {

        if (null == node)
            return new AVLTreeNode<>(key, value);

        int compare = key.compareTo(node.key);
        if (compare < 0)
            node.left = insertNode(node.left, key, value);
        else if (compare > 0)
            node.right = insertNode(node.right, key, value);
        else
            throw new IllegalArgumentException("Duplicate key found: " + key);

        return rebalance(node);
    }

    public void insert(K key, V value) {
        root = insertNode(root, key, value);
    }

    // find the node with minimum priority
    private AVLTreeNode<K, V> findMinNode(AVLTreeNode<K, V> node) {
        if (node == null)
            return null;

        while (node.left != null)
            node = node.left;

        return node;
    }

    // deletion operation for minimum priority node
    private AVLTreeNode<K, V> deleteMinNode(AVLTreeNode<K, V> node) {
        if (node == null)
            return null;

        if (node.left == null)
            return node.right;

        node.left = deleteMinNode(node.left);
        updateHeight(node);
        node = rebalance(node);
        return node;
    }

    // find the node with maximum priority
    private AVLTreeNode<K, V> findMaxNode(AVLTreeNode<K, V> node) {
        if (node == null)
            return null;

        while (node.right != null)
            node = node.right;

        return node;
    }

    public AVLTreeNode<K, V> getMaxNode(AVLTreeNode<K, V> node) {
        return this.findMaxNode(node);
    }

    // deletion operation for maximum priority node
    private AVLTreeNode<K, V> deleteMaxNode(AVLTreeNode<K, V> node) {
        if (node == null)
            return null;

        if (node.right == null)
            return node.left;

        node.right = deleteMaxNode(node.right);
        updateHeight(node);
        node = rebalance(node);
        return node;
    }

    // Delete a node from AVL Tree
    private AVLTreeNode<K, V> deleteNode(AVLTreeNode<K, V> node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = deleteNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                AVLTreeNode<K, V> successor = findMinNode(node.right);
                node.key = successor.key;
                node.value = successor.value;
                node.right = deleteMinNode(node.right);
            }
        }

        updateHeight(node);
        node = rebalance(node);
        return node;
    }

    // Delete a key-value pair from the AVL Tree
    public void delete(K key) {
        root = deleteNode(root, key);
    }

    // search operation
    private AVLTreeNode<K, V> searchNode(AVLTreeNode<K, V> node, K key) {
        if (node == null || key.equals(node.key))
            return node;

        if (key.compareTo(node.key) < 0)
            return searchNode(node.left, key);
        else
            return searchNode(node.right, key);
    }

    // search in AVL Tree using Key
    public AVLTreeNode<K, V> search(K key) {
        return searchNode(root, key);
    }

    // check whether AVL Tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // get the size of the AVL Tree
    public int size() {
        return getSize(root);
    }

    // get the size of a subtree rooted at the given node
    private int getSize(AVLTreeNode<K, V> node) {
        if (node == null)
            return 0;

        return (1 + getSize(node.left) + getSize(node.right));
    }

    public AVLTreeNode<K, V> getRoot() {
        return this.root;
    }


}
