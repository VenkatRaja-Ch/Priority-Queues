package PriorityQueue.PriorityQueueImpl;

import PriorityQueue.PriorityQueue;
import DataStructures.Heap.Heap;

public class HeapPriorityQueueImpl<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    private Heap<K, V> heap;

    public HeapPriorityQueueImpl(int capacity){
        this.heap = new Heap<K, V>(capacity);
    }

    @Override
    public void insert(K key, V value) {
        heap.insert(key, value);
    }

    @Override
    public V deleteMax() {
        return heap.deleteMax();
    }

    @Override
    public V peek() {
        return heap.peek();
    }

    @Override
    public boolean isEmpty() {
        return heap.getIsEmpty();
    }

    @Override
    public int size() {
        return heap.getSize();
    }
}