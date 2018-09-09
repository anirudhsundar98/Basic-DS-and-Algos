package Arrays;

// https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {

    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        return commonPrefixTemp(strs, strs[0], 1);
    }

    static String commonPrefixTemp(String[] strs, String prefix, int index) {
        if (index >= strs.length)
            return prefix;

        StringBuffer s = new StringBuffer();
        for (int i = 0; i < prefix.length() && i < strs[index].length(); i++) {
            if (prefix.charAt(i) == strs[index].charAt(i)) {
                s.append(prefix.charAt(i));
            } else break;
        }

        if (s.length() == 0)
            return "";

        return commonPrefixTemp(strs, s.toString(), index+1);
    }

    public static void main(String[] args) {
        String[] strs = {"leetcode", "leetc", "leetdisuhfaj"};
        System.out.println(longestCommonPrefix(strs));
    }
}
