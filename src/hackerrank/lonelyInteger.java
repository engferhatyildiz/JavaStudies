package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//this class returns unique element in a list
public class lonelyInteger {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);
        System.out.println(lonelyinteger(numbers));
        System.out.println(Collections.frequency(numbers,numbers.get(0)) == 4);


    }

    public static int lonelyinteger(List<Integer> a) {
        int result=0;
        for (int i = 0; i < a.size(); i++) {
            if(Collections.frequency(a,a.get(i)) == 1){ // ıt calculates frequency of any element in the list
                result=a.get(i);
                return result;
            }

        }
        return result;
    }

}
