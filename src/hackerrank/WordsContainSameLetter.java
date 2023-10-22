package hackerrank;

import java.util.*;

public class WordsContainSameLetter {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        int result=0;
        words.add("abaa");
        words.add("abaca");
        words.add("baab");
        words.add("cba");

        String[] array = new String[words.size()];

        for (int i = 0; i < words.size(); i++) {
            String str = "";
            String element = words.get(i);
            for (int j = 0; j < element.length(); j++) {
                if (!str.contains(element.substring(j, j + 1))) {
                    str += element.substring(j, j + 1);
                }
            }
            array[i] = str;
        }

        for (int i = 0; i < array.length; i++) {
            char [] letter = array[i].toCharArray();
            Arrays.sort(letter);
            for (int j = i+1; j < array.length; j++) {
                char [] checkWord = array[j].toCharArray();
                Arrays.sort(checkWord);

                if(Arrays.equals(letter,checkWord))
                    result+=1;
            }

        }
        System.out.println(result);


    }


}

