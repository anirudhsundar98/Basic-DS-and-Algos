package Strings;

import java.util.HashMap;

public class ParaCheck {
    public static void main (String[] args) throws java.lang.Exception {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("this",0);
        hm.put("a",0);
        hm.put("test",0);
        hm.put("programming",0);

        String input = "This is a test. This is a programming test. This is a programming test in any language.";
        String newStr = input.replaceAll("\\.","");
        String words[] = newStr.toLowerCase().split(" ");
        int start = 0;
        int count = 0;
        int window = 0;
        int min = window;

        for(int i = 0; i < words.length; i++) {
            System.out.println("Value of i is "+i);
            count = 0;
            if(hm.containsKey(words[i]))
                hm.put(words[i],hm.get(words[i])+1);
            else window++;

            for(String key : hm.keySet()) {
                if(hm.get(key) >= 1)
                    count++;
                else break;
            }

            if(count == 4) {
                if(min > window){
                    for(int j = start; j < i+1; j++){
                        System.out.print(words[j]+" ");
                    }
                    min = window;
                }
                if(window == 0)
                    break;

                System.out.println();

                for(String key : hm.keySet())
                    hm.put(key,0);

                start = start+window;
                System.out.println("Start is "+start+" and window is "+window);
                i = start-1;
                min = window;
                window = 0;
            }
        }
    }
}
