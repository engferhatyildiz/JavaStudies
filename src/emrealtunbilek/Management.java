package emrealtunbilek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Management {
    public static void main(String[] args) {
        String[] array = {"aaaaa", "bbbb", "ccc", "dd", "e"};

        ArrayList<String> names = new ArrayList();
        names.add("yildiz");names.add("ferhat");names.add("ozge");names.add("yoldas");

        //listenin Array'e dönüşümü
        String[] namesArray = names.toArray(new String[0]);
        System.out.println(namesArray[3]);

        //Method 1
        List<String> list = Arrays.asList(array);
        System.out.println(list);

        //Method 2
        ArrayList<String> listArrayList =new ArrayList<>(Arrays.asList(array));
        System.out.println(listArrayList);

        //Method 3
        List<String> list1 = new ArrayList<String>();
        Collections.addAll(list1, array);
        System.out.println(list1);

        //Method 4
        List<String> list2 = new ArrayList<String>();
        for (String text : array) {
            list2.add(text);
        }
        System.out.println(list2);

    }
}
