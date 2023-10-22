package hackerrank;

import java.util.Scanner;

public class EbobEkok {
    public static void main(String[] args) {
        EbobEkok ebobEkok = new EbobEkok();
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        System.out.println(ebobEkok.findEbob(number1,number2));



    }

    public int findEbob(int number1, int number2) {
        int ebob = 1;
        for (int i = 2; i <= number1 && i <= number2; i++) {
            if (number1 % i == 0 && number2 % i == 0)
                ebob=i;
        }
        return ebob;
    }
}
