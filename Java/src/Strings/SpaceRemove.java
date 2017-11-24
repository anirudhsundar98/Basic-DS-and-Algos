package Strings;

public class SpaceRemove {

    public static void main(String[] args) {
        String s = "abc sdf dfdsef sf";
        String[] a = s.split("");

        for (int i = 0; i < a.length; i++) {
            if (a[i] == " ") {
                a[i] = "%20";
            }
        }

        String res = "";
        for (String x : a) {
            if (x.equals(" "))
                res += "%20";
            else res += x;
        }

        System.out.println(res);
    }
}
