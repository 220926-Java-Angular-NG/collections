import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {



        AmplifireArrayDeque arrayDeque = new AmplifireArrayDeque(10);
        arrayDeque.printInOrder();
        arrayDeque.addToFront(10);
        arrayDeque.printInOrder();
        arrayDeque.addToFront(8);
        arrayDeque.printInOrder();
        arrayDeque.addToEnd(6);
        arrayDeque.printInOrder();
        arrayDeque.addToEnd(4);
        arrayDeque.printInOrder();
        arrayDeque.delFront();
        arrayDeque.printInOrder();
        arrayDeque.delEnd();
        arrayDeque.printInOrder();
        System.out.println(arrayDeque.getFirst());
        System.out.println(arrayDeque.getLast());







    }
}
