import java.util.ArrayList;
import java.util.Collections;

public class PowerOfTwoMaxHeap {
    private ArrayList<Integer> heap;
    private int childrenExponent; // The value of 'x', renamed for clarity.
    private int numChildren; // Stores the number of children per node as 2^childrenExponent.

    // Constructor for the heap, takes x as a parameter.
    public PowerOfTwoMaxHeap(int childrenExponent) {
        if (childrenExponent < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative");
        }
        this.childrenExponent = childrenExponent;
        this.numChildren = (int) Math.pow(2, childrenExponent);
        this.heap = new ArrayList<>();
    }

    // Insert method to add a new element to the heap.
    public void insert(int value) {
        heap.add(value); // Add the new value at the end of the heap.
        heapifyUp(heap.size() - 1); // Restore the heap property.
    }

    // Method to pop the maximum value from the heap.
    public int popMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0); // Restore the heap property.
        }
        return max;
    }

    // Helper method to restore the heap property going up.
    private void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);
        while (index > 0 && heap.get(index) > heap.get(parentIndex)) {
            Collections.swap(heap, index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    // Helper method to restore the heap property going down.
    private void heapifyDown(int index) {
        int maxIndex = index;
        for (int i = 1; i <= numChildren; i++) {
            int childIndex = getChildIndex(index, i);
            if (childIndex < heap.size() && heap.get(childIndex) > heap.get(maxIndex)) {
                maxIndex = childIndex;
            }
        }
        if (index != maxIndex) {
            Collections.swap(heap, index, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    // Method to get the index of the parent node.
    private int getParentIndex(int index) {
        return (index - 1) / numChildren;
    }

    // Method to get the index of a specific child.
    private int getChildIndex(int parentIndex, int childNumber) {
        return parentIndex * numChildren + childNumber;
    }

    // Main method for testing.
    public static void main(String[] args) {
        // Test with a very small value of x (e.g., x = 1, binary heap)
        PowerOfTwoMaxHeap heap1 = new PowerOfTwoMaxHeap(1);
        heap1.insert(10);
        heap1.insert(20);
        heap1.insert(5);
        System.out.println(heap1.popMax()); // Should print 20
        
        // Test with a larger value of x (e.g., x = 3, 8-ary heap)
        PowerOfTwoMaxHeap heap8 = new PowerOfTwoMaxHeap(3);
        for (int i = 1; i <= 15; i++) {
            heap8.insert(i);
        }
        System.out.println(heap8.popMax()); // Should print 15
    }
}
