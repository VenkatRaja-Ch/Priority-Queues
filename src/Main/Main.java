package Main;

import PriorityQueue.PriorityQueue;
import PriorityQueue.PriorityQueueImpl.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int MAX_SIZE = 10;
    static String PATH_TO_MANUAL_DATASET = "src/TestingDataFiles/ManualDataFile";
    static String LINE = "";
    static String CSV_SPLIT_BY = ",";

    public static List<String> extractValuesFromFile(String path) throws IOException{

        List<String> valuesExtracted = new ArrayList<>();
        String[] currentExtractedValue;
        BufferedReader br = new BufferedReader(new FileReader(path));

        while((LINE = br.readLine()) != null){

            currentExtractedValue = LINE.split(CSV_SPLIT_BY);
            valuesExtracted.addAll(Arrays.asList(currentExtractedValue));
        }

        return valuesExtracted;
    }

    public static void printSpace(){
        System.out.println("\n\n\n\n\n\n");
    }

    public static void insertDataToPriorityQueue(List<String> passedData, PriorityQueue<Integer, String> passedPriorityQueue){

        int length = passedData.size();

        for(int i=0; i < length-1; i += 2 ){
            int priorityValue = Integer.parseInt(passedData.get(i));
            String value = passedData.get(i+1);
            passedPriorityQueue.insert(priorityValue, value);
        }
    }

    public static void removeAllDataToPriorityQueue(PriorityQueue<Integer, String> passedPriorityQueue){

        int length = passedPriorityQueue.size();

        for(int i = 0; i < length; i ++){
            passedPriorityQueue.deleteMax();
        }
    }

    public static void test(PriorityQueue<Integer, String> passedPriorityQueue, String priorityQueueName){

        System.out.println(priorityQueueName);
        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + passedPriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + passedPriorityQueue.size());


        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + passedPriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + passedPriorityQueue.size());

        // Test for peek and Delete max
        System.out.println("Peek: " + passedPriorityQueue.peek());
        System.out.println("DeleteMax: " + passedPriorityQueue.deleteMax());
        System.out.println("Peek after Deleting element with highest priority: " + passedPriorityQueue.peek());

        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + passedPriorityQueue.size());
        printSpace();

    }

    public static void main(String[] args) throws IOException {

        AATreePriorityQueueImpl<Integer, String> aaTreePriorityQueue = new AATreePriorityQueueImpl<>();
        RBTreePriorityQueueImpl<Integer, String> rbTreePriorityQueue = new RBTreePriorityQueueImpl<>();
        AVLTreePriorityQueueImpl<Integer, String> avlTreePriorityQueue = new AVLTreePriorityQueueImpl<>();
        HeapPriorityQueueImpl<Integer, String> heapPriorityQueue = new HeapPriorityQueueImpl<>(MAX_SIZE);
        ArrayPriorityQueueImpl<Integer, String> arrayPriorityQueue = new ArrayPriorityQueueImpl<>(MAX_SIZE);
        LinkedListPriorityQueueImpl<Integer, String> linkedListPriorityQueue = new LinkedListPriorityQueueImpl<>();


        List<String> test = extractValuesFromFile(PATH_TO_MANUAL_DATASET);
        insertDataToPriorityQueue(test, aaTreePriorityQueue);
        insertDataToPriorityQueue(test, rbTreePriorityQueue);
        insertDataToPriorityQueue(test, avlTreePriorityQueue);
        insertDataToPriorityQueue(test, heapPriorityQueue);
        insertDataToPriorityQueue(test, arrayPriorityQueue);
        insertDataToPriorityQueue(test, linkedListPriorityQueue);

        // Testing Priority Queue implemented using AA Tree Data Structure
        test(aaTreePriorityQueue, "Priority Queue implemented using AA Tree Testing");

        // Testing Priority Queue implemented using RedBlack Tree Data Structure
        test(rbTreePriorityQueue, "Priority Queue implemented using Red-Black Tree Testing!");

        // Testing Priority Queue implemented using AVL Tree Data Structure
        test(avlTreePriorityQueue, "Priority Queue implemented using AVL Tres Testing!");

        // Testing Priority Queue implemented using Heap Data Structure
        test(heapPriorityQueue, "Priority Queue implemented using Heap Testing!");

        // Testing Priority Queue implemented using Array Data Structure
        test(arrayPriorityQueue, "Priority Queue implemented using Array Testing!");

        // Testing Priority Queue implemented using LinkedList Data Structure
        test(linkedListPriorityQueue, "Priority Queue implemented using LinkedList Testing!");

        removeAllDataToPriorityQueue(aaTreePriorityQueue);
        removeAllDataToPriorityQueue(rbTreePriorityQueue);
        removeAllDataToPriorityQueue(avlTreePriorityQueue);
        removeAllDataToPriorityQueue(heapPriorityQueue);
        removeAllDataToPriorityQueue(arrayPriorityQueue);
        removeAllDataToPriorityQueue(linkedListPriorityQueue);
    }
}
