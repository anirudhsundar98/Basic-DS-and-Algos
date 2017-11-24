package DynamicProgramming;

import java.util.Arrays;

//Longest Unique Substring
public class LUS {

    static int[] index = new int[128];

    static void refill() {
        Arrays.fill(index, -1);
    }

    public static void main(String[] args) {
        refill();
        String str = "abfsbderamegfgr";
        char[] charArray = str.toCharArray();
        int length = 0;

        int max = -1;
        for (int i = 0; i < charArray.length; i++) {
            int code = charArray[i];

            if (index[code] == -1) {
                index[code] = i;
                length ++;
            } else {
                if (max < length)
                    max = length;
                i = index[code];
                length = 0;
                refill();
            }
        }
        if (max < length)
            max = length;

        System.out.println(max);
    }
}
