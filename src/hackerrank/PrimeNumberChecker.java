package hackerrank;

public class PrimeNumberChecker {
    boolean isPrime(int number) {//It returns True if given number is Prime, otherwise:False
        int upperBound = (int) (Math.sqrt(number) + 1); // It's enough check for the square of the number(Maths)
        for (int i = 2; i < upperBound; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
