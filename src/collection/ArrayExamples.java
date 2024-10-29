package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ArrayExamples {
    public static void main(String[] args) {
        List<Integer> numbersArrayList = new ArrayList<>();
        List<Integer> numbersLinkedList = new LinkedList<>();


        Collections.addAll(numbersArrayList, 101, 102, 103, 500);

        for (int i = 1; i < 10; i++) {
            numbersArrayList.add(i);
            numbersLinkedList.add(i);
        }

        Collections.copy(numbersArrayList, numbersLinkedList);
        System.out.println(numbersLinkedList);

        System.out.println("--------------------------------------------");
        System.out.println(numbersArrayList);

        Collections.shuffle(numbersArrayList);

        System.out.println(numbersArrayList);

    }
}