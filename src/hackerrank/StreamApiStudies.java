package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiStudies {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);
        numbers.add(8);
        numbers.add(7);
        Collections.sort(numbers);
        int[] arrayNumbers ={1,2,3,4,5,6,7,8,9};

        //arrayNumbers.toString();



        numbers.stream().forEach(number -> System.out.println(number.toString()));
        System.out.println(numbers.toString());

       List<Integer> tempList = numbers.stream().filter(number ->number.intValue()>4).collect(Collectors.toList());
        System.out.println(tempList.toString());
    }
}
