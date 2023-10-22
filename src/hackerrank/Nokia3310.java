package hackerrank;

import java.util.*;

public class Nokia3310 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        HashMap<Integer, String> nokia = new HashMap<>();
        {nokia.put(2, "abc");
        nokia.put(3, "def");
        nokia.put(4, "ghi");
        nokia.put(5, "jkl");
        nokia.put(6, "mno");
        nokia.put(7, "pqrs");
        nokia.put(8, "tuv");
        nokia.put(9, "wxyz");}




        int button[] = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            button[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        if (input.length() == 1) {
            char[] arr1 = nokia.get(button[0]).toCharArray();
            for (int i = 0; i < arr1.length; i++)
                System.out.print("{" + arr1[i]
                        + "}, ");
        }
        if (input.length() == 2) {
            char[] arr1 = nokia.get(button[0]).toCharArray();
            char[] arr2 = nokia.get(button[1]).toCharArray();

            for (int i = 0; i < arr1.length; i++)
                for (int j = 0; j < arr2.length; j++)
                    System.out.print("{" + arr1[i]
                            + arr2[j] + "}, ");
        }
        if (input.length() == 3) {
            char[] arr1 = nokia.get(button[0]).toCharArray();
            char[] arr2 = nokia.get(button[1]).toCharArray();
            char[] arr3 = nokia.get(button[2]).toCharArray();
            for (int i = 0; i < arr1.length; i++)
                for (int j = 0; j < arr2.length; j++)
                    for (int k = 0; k < arr3.length; k++)
                        System.out.print("{" + arr1[i]
                                + arr2[j] + arr3[k] + "}, ");
        }


    }

}
