package DataStructures.LinkedLists;

import Nodes.LinkedListNode;

public class LinkedList <K extends Comparable<K>, V> {

    private LinkedListNode<K, V> head;
    private int size;

    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    // insertion operation
    public void insertion(K key, V value){

        LinkedListNode<K, V> newNode = new LinkedListNode<>(key, value);

        if(isEmpty()){
            head = newNode;
        } else {
            LinkedListNode<K, V> currentNode = head;
            LinkedListNode<K, V> previousNode = null;

            while(currentNode!=null && currentNode.getKey().compareTo(key) > 0) {
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            }

            if(previousNode == null) {
                newNode.setNextNode(head);
                head = newNode;
            } else {
                previousNode.setNextNode(newNode);
                newNode.setNextNode(currentNode);
            }
        }

        size ++;
    }

    // deletion operation
    public V deletion(){

        if(isEmpty())
            throw new IllegalStateException("Priority Queue is empty!");

        LinkedListNode<K, V> maxPriorityNode = head;
        head = head.getNextNode();
        maxPriorityNode.setNextNode(null);
        size --;

        return maxPriorityNode.getValue();
    }

    public V peek(){
        if(isEmpty())
            throw new IllegalStateException("Priority Queue is empty!");

        return head.getValue();
    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    public int getSize() {
        return this.size;
    }
}
