package DataStructures.Heap;

import Nodes.HeapNode;

public class Heap <K extends Comparable<K>, V> {

    private static final int DEFAULT_MAX_SIZE = 10;
    private HeapNode<K, V>[] heapArray;
    private int capacity;
    private int size;

    // default constructor
    public Heap() {
        this.capacity = 0;
        this.size = 0;
        this.heapArray = new HeapNode[capacity];
    }
    // parameterized constructor
    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heapArray = new HeapNode[capacity];
    }


    public void insert(K key, V value) {
        if(size >= capacity)
            throw new IllegalStateException("DataStructures.Heap is Full!");

        HeapNode<K, V> newNode = new HeapNode<>(key, value);
        heapArray[size] = newNode;

        // percolate up
        int currentIndex = size;
        int parentIndex = getParentIndex(currentIndex);

        while(parentIndex >= 0 && heapArray[currentIndex].key.compareTo(heapArray[parentIndex].key) > 0){
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = getParentIndex(currentIndex);
        }

        size ++;
    }

    public V deleteMax() {
        if(isEmpty())
            throw new IllegalStateException("DataStructures.Heap is empty!");

        HeapNode<K, V> maxNode = heapArray[0];
        heapArray[0] = heapArray[size - 1];
        size --;

        // percolate down
        int currentIndex = 0;

        while(true) {
            int maxIndex = currentIndex;
            int leftChildIndex = getLeftChildIndex(currentIndex);
            int rightChildIndex = getRightChildIndex(currentIndex);

            if(leftChildIndex < size && heapArray[leftChildIndex].key.compareTo(heapArray[maxIndex].key) > 0)
                maxIndex = leftChildIndex;

            if(rightChildIndex < size && heapArray[rightChildIndex].key.compareTo(heapArray[maxIndex].key) > 0)
                maxIndex = rightChildIndex;

            if(maxIndex == currentIndex)
                break;

            swap(currentIndex, maxIndex);
            currentIndex = maxIndex;
        }

        return maxNode.value;
    }

    public V peek() {
        if(isEmpty())
            throw new IllegalStateException("DataStructures.Heap is empty!");

        return heapArray[0].value;
    }

    private int getParentIndex(int index){
        return (index - 1)/2;
    }

    private void swap(int index1, int index2){
        HeapNode<K, V> temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }

    private boolean isEmpty(){
        return (size == 0);
    }

    private int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    public boolean getIsEmpty() {
        return this.isEmpty();
    }

    public int getSize(){
        return this.size;
    }
}
