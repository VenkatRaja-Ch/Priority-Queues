package Main;

import PriorityQueue.PriorityQueueImpl.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// The code snippet tests three different implementations of priority queues: AA Tree, Red-Black Tree, and AVL Tree. It inserts elements into each priority queue, checks if they are empty, retrieves the size, peeks at the highest priority element, deletes
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


    // The code snippet tests the functionality of three different priority queue implementations: AA Tree, Red-Black Tree, and AVL Tree. It inserts elements into each priority queue, checks if the queue is empty, checks the size of the queue, performs peek and
        public static void main(String[] args) throws IOException {

        AATreePriorityQueueImpl<Integer, String> aaTreePriorityQueue = new AATreePriorityQueueImpl<>();
        RBTreePriorityQueueImpl<Integer, String> rbTreePriorityQueue = new RBTreePriorityQueueImpl<>();
        AVLTreePriorityQueueImpl<Integer, String> avlTreePriorityQueue = new AVLTreePriorityQueueImpl<>();
        HeapPriorityQueueImpl<Integer, String> heapPriorityQueue = new HeapPriorityQueueImpl<>(MAX_SIZE);
        ArrayPriorityQueueImpl<Integer, String> arrayPriorityQueue = new ArrayPriorityQueueImpl<>(MAX_SIZE);
        LinkedListPriorityQueueImpl<Integer, String> linkedListPriorityQueue = new LinkedListPriorityQueueImpl<>();


        List<String> test = extractValuesFromFile(PATH_TO_MANUAL_DATASET);
        test.forEach(System.out::println);

        // <-------------------------------- AA Tree Testing starts ------------------------------->
        System.out.println("AA Tree Testing");
        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + aaTreePriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + aaTreePriorityQueue.size());

        // insert elements into the queue
        aaTreePriorityQueue.insert(4, "Home Assignment");
        aaTreePriorityQueue.insert(5, "Driving Lessons");
        aaTreePriorityQueue.insert(1, "Personal Life");
        aaTreePriorityQueue.insert(2, "Health and Care");

        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + aaTreePriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + aaTreePriorityQueue.size());

        // Test for peek and Delete max
        System.out.println("Peek: " + aaTreePriorityQueue.peek());
        System.out.println("DeleteMax: " + aaTreePriorityQueue.deleteMax());
        System.out.println("Peek after Deleting element with highest priority: " + aaTreePriorityQueue.peek());

        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + aaTreePriorityQueue.size());
        printSpace();
        // <-------------------------------- AA Tree Testing ends -------------------------------->


        // <-------------------------------- Red-Black Tree Testing starts ------------------------------->
        System.out.println("Red-Black Tree Testing!");
        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + rbTreePriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + rbTreePriorityQueue.size());

        // insert elements into the queue
        rbTreePriorityQueue.insert(4, "Home Assignment");
        rbTreePriorityQueue.insert(5, "Driving Lessons");
        rbTreePriorityQueue.insert(1, "Personal Life");
        rbTreePriorityQueue.insert(2, "Health and Care");

        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + rbTreePriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + rbTreePriorityQueue.size());

        // Test for peek and Delete max
        System.out.println("Peek: " + rbTreePriorityQueue.peek());
        System.out.println("DeleteMax: " + rbTreePriorityQueue.deleteMax());
        System.out.println("Peek after Deleting element with highest priority: " + rbTreePriorityQueue.peek());

        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + rbTreePriorityQueue.size());
        printSpace();
        // <-------------------------------- Red-Black Tree Testing ends -------------------------------->


        // <--------------------------------AVL Tree Testing starts ------------------------------->
        System.out.println("AVL TreeTesting!");
        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + avlTreePriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + avlTreePriorityQueue.size());

        // insert elements into the queue
        avlTreePriorityQueue.insert(4, "Home Assignment");
        avlTreePriorityQueue.insert(5, "Driving Lessons");
        avlTreePriorityQueue.insert(1, "Personal Life");
        avlTreePriorityQueue.insert(2, "Health and Care");

        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + avlTreePriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + avlTreePriorityQueue.size());

        // Test for peek and Delete max
        System.out.println("Peek: " + avlTreePriorityQueue.peek());
        System.out.println("DeleteMax: " + avlTreePriorityQueue.deleteMax());
        System.out.println("Peek after Deleting element with highest priority: " + avlTreePriorityQueue.peek());

        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + avlTreePriorityQueue.size());
        System.out.println("\n\n\n\n\n\n");
        // <-------------------------------- AVL Tree Testing ends -------------------------------->


        // <-------------------------------- Heap Testing starts ------------------------------->
        System.out.println("Heap Testing!");
        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + heapPriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + heapPriorityQueue.size());

        // insert elements into the queue
        heapPriorityQueue.insert(4, "Home Assignment");
        heapPriorityQueue.insert(5, "Driving Lessons");
        heapPriorityQueue.insert(1, "Personal Life");
        heapPriorityQueue.insert(2, "Health and Care");

        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + heapPriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + heapPriorityQueue.size());

        // Test for peek and Delete max
        System.out.println("Peek: " + heapPriorityQueue.peek());
        System.out.println("DeleteMax: " + heapPriorityQueue.deleteMax());
        System.out.println("Peek after Deleting element with highest priority: " + heapPriorityQueue.peek());

        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + heapPriorityQueue.size());
        System.out.println("\n\n\n\n\n\n");
        // <-------------------------------- Heap Testing ends -------------------------------->


        // <-------------------------------- Array Testing starts ------------------------------->
        System.out.println("Array Testing!");
        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + arrayPriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + arrayPriorityQueue.size());

        // insert elements into the queue
        arrayPriorityQueue.insert(4, "Home Assignment");
        arrayPriorityQueue.insert(5, "Driving Lessons");
        arrayPriorityQueue.insert(1, "Personal Life");
        arrayPriorityQueue.insert(2, "Health and Care");

        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + arrayPriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + arrayPriorityQueue.size());

        // Test for peek and Delete max
        System.out.println("Peek: " + arrayPriorityQueue.peek());
        System.out.println("DeleteMax: " + arrayPriorityQueue.deleteMax());
        System.out.println("Peek after Deleting element with highest priority: " + arrayPriorityQueue.peek());

        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + arrayPriorityQueue.size());
        System.out.println("\n\n\n\n\n\n");
        // <-------------------------------- Array Testing ends -------------------------------->


        // <-------------------------------- LinkedList Testing starts ------------------------------->
        System.out.println("LinkedList Testing!");
        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + linkedListPriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + linkedListPriorityQueue.size());

        // insert elements into the queue
        linkedListPriorityQueue.insert(4, "Home Assignment");
        linkedListPriorityQueue.insert(5, "Driving Lessons");
        linkedListPriorityQueue.insert(1, "Personal Life");
        linkedListPriorityQueue.insert(2, "Health and Care");

        // Check is priority queue is empty
        System.out.println("Is priority Queue empty: " + linkedListPriorityQueue.isEmpty());
        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + linkedListPriorityQueue.size());

        // Test for peek and Delete max
        System.out.println("Peek: " + linkedListPriorityQueue.peek());
        System.out.println("DeleteMax: " + linkedListPriorityQueue.deleteMax());
        System.out.println("Peek after Deleting element with highest priority: " + linkedListPriorityQueue.peek());

        // Check the size of the priority queue
        System.out.println("Size of the priority queue: " + linkedListPriorityQueue.size());
        System.out.println("\n\n\n\n\n\n");
        // <-------------------------------- LinkedList Testing ends -------------------------------->
    }
}
