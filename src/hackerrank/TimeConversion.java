package hackerrank;

public class TimeConversion {
    public static void main(String[] args) {
        String s = "05:07:45AM";

        System.out.println(timeConversion(s));


    }

    public static String timeConversion(String s) {
        String result = "";

        if (s.contains("PM")) {
            if (s.startsWith("12")) {
                result = s.substring(0, s.length() - 2);
                return result;
            } else {
                int firstDigit = (Integer.parseInt(s.substring(0, 2)));
                firstDigit += 12;
                result = Integer.toString(firstDigit).concat(s.substring(2, s.length() - 2));
                return result;

            }
        } else {
            if (s.startsWith("12")) {
                result = "00".concat(s.substring(2, s.length() - 2));
                return result;
            } else {
                result = s.substring(0, s.length() - 2);
                return result;
            }
        }

    }
}
