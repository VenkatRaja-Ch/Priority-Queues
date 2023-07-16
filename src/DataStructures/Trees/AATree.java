package DataStructures.Trees;

import Nodes.AATreeNode;

public class AATree <K extends Comparable<K>, V> {

    private AATreeNode<K, V> root;

    public AATree() {
        this.root = null;
    }

    // skew operation
    private AATreeNode<K, V> skew(AATreeNode<K, V> node) {
        if(node == null)
            return null;
        else if(node.left == null)
            return node;
        else if(node.left.level == node.level) {

            // swap the pointers of horizontal left link
            AATreeNode<K, V> leftChild = node.left;
            node.left = leftChild.right;
            leftChild.right = node;
            return leftChild;
        }
        else
            return node;
    }

    // split operation
    private AATreeNode<K, V> split(AATreeNode<K, V> node) {
        if(node == null)
            return null;
        else if(node.right == null || node.right.right == null)
            return node;
        else if(node.level == node.right.right.level) {

            // Two horizontal right links, elevate the middle node
            AATreeNode<K, V> rightChild = node.right;
            node.right = rightChild.left;
            rightChild.left = node;
            rightChild.level = rightChild.level + 1;
            return rightChild;
        }
        else
            return node;
    }

    // Insertion Operation
    private AATreeNode<K, V> insert(AATreeNode<K, V> node, K key, V value) {
        if(node == null)
            return new AATreeNode<>(key, value);
        else if(key.compareTo(node.key) < 0)
            node.left = insert(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = insert(node.right, key, value);

        node = skew(node);
        node = split(node);
        return node;
    }

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    // Deletion Operation
    private AATreeNode<K, V> delete(AATreeNode<K, V> node, K key) {
        if(node == null)
            return null;
        else if(key.compareTo(node.key) > 0)
            node.right = delete(node.right, key);
        else if(key.compareTo(node.key) < 0)
            node.left = delete(node.left, key);
        else {
            if(node.left == null && node.right == null)
                return null;
            else if(node.left == null) {
                AATreeNode<K, V> successor = findSuccessor(node);
                node.key = successor.key;
                node.value = successor.value;
                node.right = delete(node.right, successor.key);
            }
            else {
                AATreeNode<K, V> predecessor = findPredecessor(node);
                node.key = predecessor.key;
                node.value = predecessor.value;
                node.left = delete(node.left, predecessor.key);
            }
        }

        node = decreaseLevel(node);
        node = skew(node);
        if(node.right != null) {
            node.right = skew(node.right);
            node.right.right = skew(node.right.right);
        }
        node = split(node);
        if(node.right != null)
            node.right = split(node.right);

        return node;
    }

    public void delete(K key){
        root = delete(root, key);
    }

    private AATreeNode<K, V> decreaseLevel(AATreeNode<K, V> node) {

        int shouldBe = Math.min(getLevel(node.left), getLevel(node.right)) + 1;
        if(shouldBe < node.level) {
            node.level = shouldBe;
            if(shouldBe < getLevel(node.right))
                node.right.level = shouldBe;
        }
        return node;
    }

    private int getLevel(AATreeNode<K, V> node) {
        return (node == null) ? 0 : node.level;
    }

    private AATreeNode<K, V> findSuccessor(AATreeNode<K, V> node) {
        if(node == null)
            return null;
        node = node.right;
        while(node != null && node.left != null)
            node = node.left;

        return node;
    }

    private AATreeNode<K, V> findPredecessor(AATreeNode<K, V> node) {

        if(node == null)
            return null;
        node = node.left;
        while(node.right != null)
            node = node.right;

        return node;
    }

    public AATreeNode<K, V> getRoot() {
        return this.root;
    }
}
