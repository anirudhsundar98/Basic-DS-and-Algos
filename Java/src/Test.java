import java.util.PriorityQueue;
import java.util.Queue;

class Lel {
    int data = 0;

    public Lel(int d) {
        data = d;
    }

    void print() {
        System.out.println("lulz");
    }
}

public class Test {

    public static void main(String[] args) {
        int a = 19;
        int b = Integer.parseInt("11111", 2) - 2;
        System.out.println(a);
        System.out.println(b);
        a = a & b;
        System.out.println(a);

        Queue<Character> q = new PriorityQueue<>();
        q.add('b');
        q.add('w');
        q.add('s');
        q.add('a');
        q.add('6');
        System.out.println(q);

        Lel y = new Lel(5);
        y.print();

//        System.out.println(true ^ false);
    }
}
