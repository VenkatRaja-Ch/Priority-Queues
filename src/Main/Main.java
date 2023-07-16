package Main;

import PriorityQueue.PriorityQueueImpl.AATreePriorityQueueImpl;
import PriorityQueue.PriorityQueueImpl.AVLTreePriorityQueueImpl;
import PriorityQueue.PriorityQueueImpl.HeapPriorityQueueImpl;
import PriorityQueue.PriorityQueueImpl.RBTreePriorityQueueImpl;


// The code snippet tests three different implementations of priority queues: AA Tree, Red-Black Tree, and AVL Tree. It inserts elements into each priority queue, checks if they are empty, retrieves the size, peeks at the highest priority element, deletes
public class Main {

    static int MAX_SIZE = 10;

// The code snippet tests the functionality of three different priority queue implementations: AA Tree, Red-Black Tree, and AVL Tree. It inserts elements into each priority queue, checks if the queue is empty, checks the size of the queue, performs peek and
    public static void main(String[] args) {

        AATreePriorityQueueImpl<Integer, String> aaTreePriorityQueue = new AATreePriorityQueueImpl<>();
        RBTreePriorityQueueImpl<Integer, String> rbTreePriorityQueue = new RBTreePriorityQueueImpl<>();
        AVLTreePriorityQueueImpl<Integer, String> avlTreePriorityQueue = new AVLTreePriorityQueueImpl<>();
        HeapPriorityQueueImpl<Integer, String> heapPriorityQueue = new HeapPriorityQueueImpl<>(MAX_SIZE);

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
        System.out.println("\n\n\n\n\n\n");
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
        System.out.println("\n\n\n\n\n\n");
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


        // <-------------------------------- DataStructures.Heap Testing starts ------------------------------->
        System.out.println("DataStructures.Heap Testing!");
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
        // <-------------------------------- DataStructures.Heap Testing ends -------------------------------->
    }
}
