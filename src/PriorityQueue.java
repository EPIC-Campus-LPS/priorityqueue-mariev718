import java.util.*;

/**
 * This class represents a Priority Queue (heap) based on the ordering
 * defined by the compareTo method for the element. "Lower" value will
 * mean "higher" priority.
 *
 * @param <E> the type of elements in the queue
 * @author Marie Viita
 */
public class PriorityQueue<E extends Comparable<E>> {

    private ArrayList<E> myHeap; //array representation of the heap
    private int size = 0;

    /**
     * Creates an empty Priority Queue
     */
    public PriorityQueue() {
        myHeap = new ArrayList<>();
    }

    /**
     * Adds the element to the priority queue
     *
     * @param element the element to be added
     */
    public void add(E element) {

        if (size == 0) {

            myHeap.add(element);
            size++;

        } else {

            size++;

            int index = size - 1;

            myHeap.add(element);

            while (index >= 0) {

                int temp = index - (index / 2 + 1);

                if (temp < 0) temp = 0;

                if (myHeap.get(index).compareTo(myHeap.get(temp)) < 0) {

                    swap(index, temp);

                    index = temp;

                } else {

                    index = -1;

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
     * Returns whether the element is in the heap
     *
     * @param element the element to be searched for
     * @return true if the element is in the queue, false otherwise
     */
    public boolean contains(E element) {

        for (int i = 0; i < size; i++) {

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

        if (!myHeap.isEmpty()) return myHeap.get(0);
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

        size--;

        swap(0, size);

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

        for (int i = 0; i < size; i++) {

            System.out.print(myHeap.get(i) + " ");
        }

        return "";

    }

    /**
     * Main method - contains console program used
     * for testing of the PriorityQueue class.
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PriorityQueue<String> pQ = new PriorityQueue<>();

        boolean loop = true;

        while (loop) {

            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("[1] End program");
            System.out.println("[2] Add to queue");
            System.out.println("[3] Check if queue contains value");
            System.out.println("[4] Peek at queue");
            System.out.println("[5] Remove first in queue");
            System.out.println("[6] Remove a specific element");
            System.out.println("[7] Get length of queue");
            System.out.println("[8] See queue");
            System.out.println();

            int num = Integer.valueOf(scanner.next());

            switch (num) {

                case 1:
                    loop = false;
                    break;

                case 2:
                    System.out.println();
                    System.out.println("What value are you adding?");
                    System.out.println();
                    String add = String.valueOf(scanner.next());
                    pQ.add(add);
                    System.out.println();
                    System.out.println("Added " + add);
                    break;

                case 3:
                    System.out.println();
                    System.out.println("What value?");
                    System.out.println();
                    String value = String.valueOf(scanner.next());
                    System.out.println();
                    System.out.println(pQ.contains(value));
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Next in queue is " + pQ.peek());
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Removed " + pQ.poll());
                    break;

                case 6:
                    System.out.println();
                    System.out.println("What element?");
                    System.out.println();
                    String element = String.valueOf(scanner.next());
                    System.out.println();
                    if (pQ.remove(element)) {
                        System.out.println("Removed " + element);
                    } else {

                        System.out.println(element + " is not in queue");

                    }
                    break;

                case 7:
                    System.out.println();
                    System.out.println(pQ.size());
                    break;

                case 8:
                    System.out.println();
                    System.out.println(pQ);
                    break;

                default:
                    System.out.println();
                    System.out.println("Try again");

            }

        }

    }

}