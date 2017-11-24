package Sort;

/**
 * Created by anirudh on 8/3/17.
 */
public class SortTest {

    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.push(11).push(55).push(33).push(5).push(-5).push(-35).push(-10).push(434);
        s1.display();
        s1 = s1.sort();
        s1.display();
    }
}
