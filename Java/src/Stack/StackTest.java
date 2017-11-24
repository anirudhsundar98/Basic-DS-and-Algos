package Stack;

/**
 * Created by anirudh on 8/3/17.
 */
public class StackTest {

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(5).push(3).push(2);
        s.display();

        s.pop();
        s.display();
        s.push(100).push(200).push(-57).push(8).push(2);
        System.out.println(s.top.data);
        System.out.println(s.getMinimum());
    }
}
