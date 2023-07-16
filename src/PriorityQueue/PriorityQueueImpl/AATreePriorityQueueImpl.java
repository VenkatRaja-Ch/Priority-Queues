package PriorityQueue.PriorityQueueImpl;

import Nodes.AATreeNode;
import PriorityQueue.PriorityQueue;
import DataStructures.Trees.AATree;

public class AATreePriorityQueueImpl<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    private final AATree<K, V> aaTree;

    public AATreePriorityQueueImpl() {
        aaTree = new AATree<>();
    }

    @Override
    public void insert(K key, V value) {
        aaTree.insert(key, value);
    }

    @Override
    public V deleteMax() {
        if(isEmpty()) {
            throw new IllegalStateException("The priority queue is empty");
        }

        // find the highest priority element
        AATreeNode<K, V> maxNode = aaTree.getRoot();
        while(maxNode.right != null) {
            maxNode = maxNode.right;
        }

        //Delete the node with the highest priority
        aaTree.delete(maxNode.key);
        return maxNode.value;
    }

    @Override
    public V peek() {
        if(isEmpty()) {
            throw new IllegalStateException("The priority queue is empty");
        }

        // find the node with the highest priority
        AATreeNode<K, V> maxNode = aaTree.getRoot();
        while(maxNode.right != null) {
            maxNode = maxNode.right;
        }

        return maxNode.value;
    }

    @Override
    public boolean isEmpty() {
        return (aaTree.getRoot() == null);
    }

    @Override
    public int size() {
        return calculateSize(aaTree.getRoot());
    }

    // calculate the size of the tree
    private int calculateSize(AATreeNode<K,V> node) {
        if (node == null)
            return 0;

        return (1 + calculateSize(node.left) + calculateSize(node.right));
    }
}
