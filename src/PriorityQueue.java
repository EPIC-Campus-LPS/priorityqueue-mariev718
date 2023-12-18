import java.util.ArrayList;


/**
 * This class represents a Priority Queue (heap) based on the ordering
 * defined by the compareTo method for the element. "Lower" value will
 * mean "higher" priority.
 *
 * @param <E> the type of elements in the queue
 * @author
 */
public class PriorityQueue<E extends Comparable<E>> {


    private ArrayList<E> myHeap; //array representation of the heap
    private int size = 0;


    /**
     * Creates an empty Priority Queue
     */
    public PriorityQueue() {
        myHeap = new ArrayList<E>();
    }


    /**
     * Adds the element to the priority queue
     *
     * @param element the element to be added
     */
    public void add(E element) {


        if (size == 0) {


            myHeap.set(0, element);


        } else {


            size++;


            int index = size;


            myHeap.set(index, element);


            for (int i = index; i > 0; i -= (i / 2 + 1)) {


                int temp = i - (i / 2 + 1);


                if (temp < 0) temp = 0;


                if (myHeap.get(i).compareTo(myHeap.get(temp)) < 0) {


                    swap(i, temp);


                }


            }


        }


    }


    /**
     * Swaps two elements in the queue.
     * Pre-condition: 0 <= posOne, posTwo < size of queue
     *
     * @param posOne the first element's position in the queue
     * @param posTwo the second element's position in the queue
     */
    private void swap(int posOne, int posTwo) {


        E temp1 = myHeap.get(posOne);
        E temp2 = myHeap.get(posTwo);
        myHeap.set(posOne, temp2);
        myHeap.set(posTwo, temp1);


    }


    /**
     * Returns whether or not the element is in the heap
     *
     * @param element the element to be searched for
     * @return true if the element is in the queue, false otherwise
     */
    public boolean contains(E element) {


        for (int i = 0; i < myHeap.size(); i++) {


            if (myHeap.get(i).equals(element)) {


                return true;


            }


        }


        return false;


    }


    /**
     * Returns the element of highest priority, null if queue is empty.
     * Post-condition: the queue is not changed
     *
     * @return the element of highest priority queue
     */
    public E peek() {


        if (myHeap.size() != 0) return myHeap.get(0);
        return null;


    }


    /**
     * Removes and returns the element of highest priority,
     * returns null if queue is empty.
     *
     * @return the element of highest priority
     */
    public E poll() {


        if (size == 0) {


            return null;


        }


        E temp = myHeap.get(0);


        myHeap.set(0, null);


        if (size == 1) {


            size--;
            return temp;


        }


        swap(0, size);
        size--;


        heapify(0);


        return temp;


    }


    /**
     * Will "sift down" the element at the given position
     * down to restore the heap property
     *
     * @param pos the starting position for heapify
     */
    private void heapify(int pos) {


        int index = pos;


        if (size == index) return;


        while (size > (index * 2 + 1)) {


            E parent = myHeap.get(index);
            E child1 = myHeap.get(index * 2 + 1);


            if (size > (index * 2 + 2)) {


                E child2 = myHeap.get(index * 2 + 2);


                if (parent.compareTo(child1) > 0) {


                    if (child1.compareTo(child2) < 0) {


                        swap(index, index * 2 + 1);


                        index = index * 2 + 1;


                    }


                } else if (parent.compareTo(child2) > 0) {


                    swap(index, index * 2 + 2);


                    index = index * 2 + 2;


                } else {


                    index = size;


                }


            } else {


                if (parent.compareTo(child1) > 0) {


                    swap(index, index * 2 + 1);


                    index = index * 2 + 1;


                } else {


                    index = size;


                }


            }


        }


    }


    /**
     * Finds and removes the given element from the queue.
     * Returns true if an element was deleted from the queue,
     * false otherwise.
     *
     * @param element the element to be removed from the queue
     * @return true if an element was removed from the queue, false otherwise
     */
    public boolean remove(E element) {


        if (size == 0) return false;


        if (size == 1) {


            if (myHeap.get(0).equals(element)) {


                myHeap.set(0, null);
                size--;
                return true;


            }


            return false;


        }


        for (int i = 0; i < size; i++) {


            if (myHeap.get(i).equals(element)) {


                myHeap.set(i, null);
                swap(i, size - 1);
                size--;
                heapify(i);
                return true;


            }


        }


        return false;


    }


    /**
     * Returns the number of elements in the queue
     *
     * @return the number of elements in the queue
     */
    public int size() {


        return size;


    }


    /**
     * Returns the String representation of the heap
     * (by the order of list, each element separated
     * with a single space)
     *
     * @return the String representation of the heap
     */
    public String toString() {


        String temp = "";


        for (int i = 0; i < size; i++) {


            temp += myHeap.get(i);
            temp += " ";


        }


        return temp;

    }


    /**
     * Main method - contains console program used
     * for testing of the PriorityQueue class.
     *
     * @param args
     */
    public static void main(String[] args) {

    }


}