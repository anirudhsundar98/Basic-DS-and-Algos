package DynamicProgramming;

//Count number of binary strings without consecutive 1’s
public class BinaryString {

    static int n = 5;
    static int[] total = new int[n+1];

    static int getValue (int i) {
        if (i == 0)
            return 1;
        if (i == 1)
            return 2;

        return total[i-1] + total[i-2];

    }

    public static void main(String[] args) {

        for (int i = 0; i <= n; i++) {
            total[i] = getValue(i);
        }

        System.out.println(total[n]);
    }
}
