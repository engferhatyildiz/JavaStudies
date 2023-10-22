/*
package hackerrank;

public class CeaserCipher {
    public static void main(String[] args) {
        String input = "SENgel;me-LANayiEMIN!";
        */
/*System.out.println(caesarCipher(input, 2));
        System.out.println(ceaserSolver(caesarCipher(input, 2), 2));
*//*

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s ="?erhat";
        int index = alphabet.indexOf(s.charAt(0));
        System.out.println(index);


    }

    public static String ceaserSolver(String s, int k) {
        String result = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        k = k % 26;

        for (int i = 0; i < s.length(); i++) {
            // for the "-" charecter

            if (alphabet.contains(s.substring(i, i + 1)) == false)
                result += s.substring(i, i + 1);
            else {
                int index = alphabet.indexOf(s.charAt(i));

                // for the lower letters
                if (index < 26) {
                    index = (index - k);
                    if(index<0)
                        index+=26;
                    result += alphabet.charAt(index);
                }
                //for the upper letters
                else {
                    index = (index - k);
                    if (index < 26)
                        index+=26;
                    result += alphabet.charAt(index);
                }

            }
        }
        return result;

    }


    public static String caesarCipher(String s, int k) {

        String result = "";
        String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        k = k % 26;

        for (int i = 0; i < s.length(); i++) {
            // for the "-" charecter
            if (!lowerLetters.contains(s.substring(i, i + 1)) || !upperLetters.contains(s.substring(i, i + 1)))
                result += s.substring(i, i + 1);

            else {
                int index = lowerLetters.indexOf(s.charAt(i));

                // for the lower letters
                if (index < 26) {
                    index = (index + k) % 26;
                    result += alphabet.charAt(index);
                }
                //for the upper letters
                else {
                    index = (index + k);
                    if (index > 51)
                        index = (index % 51) + 25;
                    result += alphabet.charAt(index);
                }

            }
        }

        return result;
    }
}
*/
