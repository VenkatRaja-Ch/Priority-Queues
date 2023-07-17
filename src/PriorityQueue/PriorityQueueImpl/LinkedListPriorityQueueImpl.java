package PriorityQueue.PriorityQueueImpl;



import DataStructures.LinkedLists.LinkedList;
import PriorityQueue.PriorityQueue;
public class LinkedListPriorityQueueImpl<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    private LinkedList<K, V> linkedList;

    public LinkedListPriorityQueueImpl(){
        this.linkedList = new LinkedList<>();
    }

    public void insert(K key, V value){
        linkedList.insertion(key, value);
    }

    public V deleteMax(){
        return linkedList.deletion();
    }
    public V peek(){
        return linkedList.peek();
    }
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
    public int size(){
        return linkedList.getSize();
    }
}
