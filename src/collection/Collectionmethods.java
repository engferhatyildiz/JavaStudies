package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Collectionmethods {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        tempList.add(11); tempList.add(13);


        /// "addAll" Method
        Collections.addAll(numbers,1,1,3,4,5,6,7,8,9);
        System.out.println(numbers);
        // "frequency" method
        System.out.println(Collections.frequency(numbers,1));

        // "shuffle"
        Collections.shuffle(numbers);
        System.out.println(numbers);

        // "sort" -- "reverseOrder"
        Collections.sort(numbers);
        System.out.println(numbers);

        //Collections.reverse(numbers);
        System.out.println(numbers);

        // "binarySearch"
        System.out.println(Collections.binarySearch(numbers,1));

    }

}
