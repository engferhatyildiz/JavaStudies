package ferhatttyildiz;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(1));

    }

    public static int solution(int N) {
        int result = 0;
        int sumOfN = sumOfDigits(N);

        for (int i = N + 1; i < 50000; i++) {
            result = i;
            if (sumOfN == sumOfDigits(result))
                break;
        }

        return result;
    }

    public static int sumOfDigits(int N) {
        int digit, sumOfN = 0;
        while (N > 0) {
            digit = N % 10;
            sumOfN = sumOfN + digit;
            N = N / 10;
        }
        return sumOfN;
    }


}