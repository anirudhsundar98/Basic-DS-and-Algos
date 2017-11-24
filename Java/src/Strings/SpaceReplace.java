package Strings;

// Cracking the coding interview 1.5
public class SpaceReplace {

    static String replace(String s) {
        StringBuffer b = new StringBuffer();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                b.append("%20");
            } else {
                b.append(arr[i]);
            }
        }

        return new String(b);
    }

    public static void main(String[] args) {
        String s = "This is a test string";
        System.out.println(replace(s));
    }
}
