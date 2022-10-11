import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 *
 */
public class AmplifireArrayDeque {

    static final int MAX = 10;
    int arrary[];
    int head;
    int tail;
    int size;

//    constructor for deque based on size
    public AmplifireArrayDeque(int size){
        arrary = new int[MAX];
        head = -1;
        tail = 0;
        this.size = size;
    }

//    checks the head and tail values to see if the deque is full

    /** isMaxCapacity determines if the
     * array deque has reached the maximum number of elements that
     *it can contain at the time. If all elements of the array are filled,
     *  this method returns true. Usually this method is called when attempting
     *  to add new elements to the deque */
    boolean isMaxCapacity(){
        if (head == 0 && tail == size -1){
            return true;
        }else if (head == tail + 1){
            return true;
        }else{
            return false;
        }
    }

    /** isEmpty, as the name implies, checks if the array deque is empty
     * and returns a Boolean. In this case if the first element of the array,
     * the head, is set to -1 which is an invalid array index, meaning that
     * the first element was never set and thus the array is empty */
    boolean isEmpty(){
        if (head ==-1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Addtofront element method to the of  array deque
     * ,by using if statement to check head and tail value
     * to check where we will add element value,
     *
     * if the head equal -1 we well make head and tail
     * are zero and add element in array[0]
     * if not we will check if head equal 0 if true make
     * head equal size -1  if not equal 0 make head  equal
     * head -1 and put the element in array[head -1].
     */
    void addToFront(int val){
        if(isMaxCapacity()){
            System.out.println("Overflow");
            return;
        }

        if (head == -1){
            head = 0;
            tail = 0;
        } else if (head == 0) {
            head = size - 1;
        }else{
            head = head - 1;
        }
        arrary[head] = val;

    }

    /**
     *addToEnd method adds an element to the rear of Deque. this function will
     * check if the array is full (if (isMaxCapacity())
     *
     * it will print overflow when it's full
     *
     * then if someone leaves the deque from the head (-1)
     * but head and rail will drop count
     *
     * so if someone is leaving from the front, the fuction allows entry from the tail(rear)
     *
     */
    void addToEnd(int val){
        if(isMaxCapacity()){
            System.out.println("Overflow");
            return;
        }

        if (head == -1){
            head = 0;
            tail = 0;
        } else if (tail == size -1) {
            tail = 0;
        }else{
            tail += 1;
        }
        arrary[tail] = val;

    }
//    pollFirst
    /**
     * Removes the front element of deque ({@link #arrary}). Will do nothing if the deque ({@link #arrary}) is empty.
     * <p>Does not actually delete value from memory, just moves {@link #head} to the position after. Will no longer be retrievable here. </p>
     * <p>That slot can eventually get overwritten behind the scenes.</p>
     */
    void delFront() {
        if(isEmpty()){
            System.out.println("Queue Underflow\n");
            return;
        }


    // only one element is present, reset head and tail
        if(head == tail){
            head = -1;
            tail = -1;
   // check if front will have to be wrapped around
        } else if (head == size -1) {
            head = 0;
    // else just delete normally
        }else{
            head +=1;
        }

    }


    /**
     * Removes the tail element of deque ({@link #arrary}). Will do nothing if the deque ({@link #arrary}) is empty.
     * <p>Does not actually delete value from memory, just moves {@link #tail} to the position before it.
     * Will no longer be retrievable here. </p> * <p>That slot can eventually get overwritten behind the scenes.</p> */
    void delEnd(){
        if (isEmpty()) {
            System.out.println(" Underflow");
            return;
        }

        if (head == tail) {
            head = -1;
            tail = -1;
        } else if (tail == 0)
            tail = size - 1;
        else
            tail = tail - 1;
    }

    /** the role of the getFirst() method returns the head of
     * the Deque and does not erase the element. It throws an
     * exception when the Deque is completely empty
     * */
    int getFirst() {
        if (isEmpty()) {
            System.out.println(" Underflow");
            return -1;
        }
        return arrary[head];
    }

    /** the role of the getLast() method returns the tail of
     * the Deque and does not erase the element.
     * Like the getFirst method, it throws an exception
     * */
    int getLast() {
        if (isEmpty() || tail < 0) {
            System.out.println(" Underflow\n");
            return -1;
        }
        return arrary[tail];
    }
    /**
     *
     *
     */
    void printInOrder() {
        int currHead = head;
        int []arr = new int[size];
        int currPosition = 0;
        if (isEmpty() || currHead == -1) return;
        System.out.print("[ ");
        while (currHead < size && currHead != -1 && currHead > tail) {
            System.out.print(", " + arrary[currHead]);
            arr[currPosition] = arrary[currHead];
            currHead++;
            currPosition++;
        }
        if (currHead >= size-1) {
            currHead = 0;
        }
        while (currHead <= tail) {
            System.out.print(", " + arrary[currHead]);
            arr[currPosition] = arrary[currHead];
            currHead++;
            currPosition++;
        }
        System.out.print("]\n");
    }

    @Override
    public String toString() {
        return "arrary=" + Arrays.toString(arrary) + "\n";
    }
}
