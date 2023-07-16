package PriorityQueue.PriorityQueueImpl;

import Nodes.AVLTreeNode;
import PriorityQueue.PriorityQueue;
import DataStructures.Trees.AVLTree;

public class AVLTreePriorityQueueImpl<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    private final AVLTree<K, V> avlTree;

    public AVLTreePriorityQueueImpl() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void insert(K key, V value) {
        avlTree.insert(key, value);
    }

    @Override
    public V deleteMax() {
        if(isEmpty())
            throw new IllegalStateException("The priority queue is empty");

        // find the node with the highest priority
        AVLTreeNode<K, V> maxPriorityNode = avlTree.getMaxNode(avlTree.getRoot());
        avlTree.delete(maxPriorityNode.key);
        return maxPriorityNode.value;
    }

    @Override
    public V peek() {
        if(isEmpty())
            throw new IllegalStateException("The priority queue is empty");

        AVLTreeNode<K, V> maxPriorityNode = avlTree.getMaxNode(avlTree.getRoot());
        return maxPriorityNode.value;
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }

    @Override
    public int size() {
        return avlTree.size();
    }
}
