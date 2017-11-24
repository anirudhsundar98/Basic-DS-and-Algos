package List;

//import java.util.ArrayList;

public class LinkedListTest {


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.appendToTail(5);
        list.appendToTail(9);
        list.appendToTail(6);

        list.displayList();
    }
}
