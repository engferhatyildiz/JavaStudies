package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class anadolu_hayat {

    public static void main(String[] args) {
        List<Integer> network = new ArrayList<>();
        network.add(2);
        network.add(9);
        network.add(6);
        network.add(8);
        network.add(9);
        network.add(12);
        network.add(15);

        int minSpeed = 1;
        int maxComputerCount = 3;
        int totalNetworkCount = 0;


        loop:
        {
            for (int i = 0; i < network.size(); i++) {
                int speed = 0;
                for (int j = 0; j < maxComputerCount; j++) {
                    if (speed >= minSpeed) {
                        totalNetworkCount++;
                        i += j - 1;
                        break loop;
                    }
                    if (i + j < network.size())
                        speed += network.get(i + j);
                }

            }
        }
        System.out.println(totalNetworkCount);

    }

}
