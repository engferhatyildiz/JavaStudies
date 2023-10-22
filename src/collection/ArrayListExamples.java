package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExamples {
    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        List<Integer>arr=new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(4);
        arr.add(5);
        arr.add(3);
        Collections.sort(arr);
        System.out.println(arr);


    }
}
