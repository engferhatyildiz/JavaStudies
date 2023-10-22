package collection;

import java.util.Iterator;
import java.util.Vector;

public class StackExamples {
    public static void main(String[] args) {
        Vector<Integer> numbers = new Vector<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(5);

        Iterator<Integer> iterator = numbers.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next() +" ,");
        }

    }
}
