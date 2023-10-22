package hackerrank;

import java.util.Arrays;

public class ClosestNumbers {
    public static void main(String[] args) {
        int [] numbers = {4,2,3,1};
        Arrays.sort(numbers);
        int minumumDifference=Math.abs(numbers[0]-numbers[1]);

        //find the minimum differences
        for (int i = 0; i < numbers.length-1; i++) { // last index
            if(Math.abs(numbers[i]-numbers[i+1])<minumumDifference)
                minumumDifference=Math.abs(numbers[i]-numbers[i+1]);
        }
        //print whose elements have the minimum difference
        for (int i = 0; i < numbers.length-1; i++) {
            if(Math.abs(numbers[i]-numbers[i+1])==minumumDifference)
                System.out.print(numbers[i] + " " + numbers[i+1] + "\n");

        }

    }
}
