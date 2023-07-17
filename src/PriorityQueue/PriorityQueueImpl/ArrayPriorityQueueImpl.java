package PriorityQueue.PriorityQueueImpl;

import DataStructures.Array.Array;
import PriorityQueue.PriorityQueue;

public class ArrayPriorityQueueImpl<K extends Comparable<K>, V> implements PriorityQueue<K, V>{

    private final Array<K, V> array;

    public ArrayPriorityQueueImpl() {
        this.array = new Array<>();
    }

    public ArrayPriorityQueueImpl(int capacity) {
        this.array = new Array<>(capacity);
    }

    @Override
    public void insert(K key, V value) {
        array.insert(key, value);
    }

    @Override
    public V deleteMax() {
        return array.deletion();
    }

    @Override
    public V peek() {
        return array.peek();
    }

    @Override
    public boolean isEmpty() {
        return array.getIsEmpty();
    }

    @Override
    public int size() {
        return array.size();
    }
}