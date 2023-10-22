package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlippingTheMatrix {
    public static void main(String[] args) {
        int[][] numbers = {{0, 1, 2, 3}, {1, 2, 3, 4}, {0, 1, 5, 6}, {1, 2, 7, 8}};
        List<List<Integer>> matrix = new ArrayList<>();

        System.out.println(numbers.length);


    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int size = matrix.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = sum + Collections.max(Arrays.asList(matrix.get(i).get(j), matrix.get(i).get(size - 1 - j), matrix.get(size - 1 - i).get(j), matrix.get(size - 1 - i).get(size - 1 - j)));
            }

        }
        return sum;

    }
}
