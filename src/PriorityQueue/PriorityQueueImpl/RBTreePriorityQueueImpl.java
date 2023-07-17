package PriorityQueue.PriorityQueueImpl;

import Nodes.RBTreeNode;
import PriorityQueue.PriorityQueue;
import DataStructures.Trees.RBTree;

public class RBTreePriorityQueueImpl<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    private final RBTree<K, V> rbTree;

    public RBTreePriorityQueueImpl(){
        rbTree = new RBTree<>();
    }

    @Override
    public void insert(K key, V value) {
        rbTree.insert(key, value);
    }

    @Override
    public V deleteMax() {
        if(isEmpty())
            throw new IllegalStateException("The priority queue is empty");

        // find the node with the highest priority
        RBTreeNode<K, V> maxPriorityNode = rbTree.maximum(rbTree.getRoot());
        rbTree.delete(maxPriorityNode.key);
        return maxPriorityNode.value;
    }

    @Override
    public V peek() {
        if(isEmpty())
            throw new IllegalStateException("The priority queue is empty");

        RBTreeNode<K, V> maxPriorityNode = rbTree.maximum(rbTree.getRoot());
        return maxPriorityNode.value;
    }

    @Override
    public boolean isEmpty() {
        return (rbTree.getRoot() == null);
    }

    @Override
    public int size() {
        return calculateSize(rbTree.getRoot());
    }

    private int calculateSize(RBTreeNode<K, V> node) {
        if(node == null)
            return 0;

        return 1 + calculateSize(node.left) + calculateSize(node.right);
    }
}
