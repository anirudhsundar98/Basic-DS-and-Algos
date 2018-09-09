package Strings;

// https://discuss.leetcode.com/topic/97419/amazon-questions/2
public class ExprCompare {

    static String convert(String str) {
        String[] strArr = str.split("");
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("(") || strArr[i].equals(")"))
                continue;

            if (!strArr[i].equals("+") && !strArr[i].equals("-"))
                b.append(strArr[i]);

            if ( (strArr[i].equals("+") || strArr[i].equals("-"))  &&  !strArr[i+1].equals("(")) {
                b.append(strArr[i]);
            }

            if ( strArr[i].equals("+") &&  strArr[i+1].equals("(")) {
                if (strArr[i+2].equals("-"))
                    b.append("-");
                else b.append("+");
            }

            if ( strArr[i].equals("-") &&  strArr[i+1].equals("(")) {
                int temp = i+2, count = 0;
                if (!strArr[i+2].equals("+") || !strArr[i+2].equals("-")) {
                    b.append("-");
                    temp++;
                }
                while (true) {
                    if (strArr[temp].equals("("))
                        count++;
                    if (strArr[temp].equals(")") && count == 0)
                        break;
                    if (strArr[temp].equals(")") && count != 0)
                        count--;

                    if (count != 0) {
                        temp++;
                        continue;
                    }

                    if (strArr[temp].equals("+"))
                        strArr[temp] = "-";
                    else if (strArr[temp].equals("-"))
                        strArr[temp] = "+";

                    temp++;
                }
            }
        }

        return b.toString();
    }

    public static void main(String[] args) {
        String expr1 = "a-(b+c+(d-e)-f)";
        String expr2 = "a-b-c-d+e+f";

        expr1 = convert(expr1);
        expr2 = convert(expr2);

        System.out.println(expr1.equals(expr2));
    }
}
