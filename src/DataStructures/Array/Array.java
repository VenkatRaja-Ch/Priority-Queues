package DataStructures.Array;

import Nodes.ArrayElement;

public class Array <K extends Comparable<K>, V> {

    private static final int MAX_CAPACITY = 10;
    private final int capacity;
    private final ArrayElement<K, V>[] array;
    private int size;

    // default constructor
    public Array() {
        this.capacity = MAX_CAPACITY;
        this.array = new ArrayElement[capacity];
        this.size = 0;
    }

    // parameterized constructor
    public Array(int capacity) {
        this.capacity = capacity;
        this.array = new ArrayElement[capacity];
        this.size = 0;
    }

    // insertion operation
    public void insert(K key, V value) {

        if(size == capacity){
            throw new IllegalStateException("Priority Queue is Full");
        }

        // creating a new element
        ArrayElement<K, V> element = new ArrayElement<>(key, value);
        int insertionIndex = size;

        // shifting the elements to the right to make the insertion
        while(insertionIndex > 0 && array[insertionIndex-1].getKey().compareTo(key) < 0){
            array[insertionIndex] = array[insertionIndex - 1];
            insertionIndex --;
        }

        array[insertionIndex] = element;
        size ++;
    }

    // deletion operation
    public V deletion() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty!");
        }

        ArrayElement<K, V> maxPriorityElement = array[0];
        array[0] = null;
        size--;

        // Shifting the elements to the left to fill the gap
        int currentIndex = 0;
        while (currentIndex < size && array[currentIndex + 1] != null) {
            array[currentIndex] = array[currentIndex + 1];
            currentIndex++;
        }

        return maxPriorityElement.getValue();
    }


    // peek operation
    public V peek() {
        if(isEmpty())
            throw new IllegalStateException("Priority Queue is empty!");

        return array[0].getValue();
    }

    private boolean isEmpty(){
        return (size == 0);
    }

    public int size(){
        return size;
    }

    public boolean getIsEmpty(){
        return this.isEmpty();
    }
}