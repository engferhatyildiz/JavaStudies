package effective_java.StaticFactoryMethods;

import java.util.LinkedList;

public class Management {
    public static void main(String[] args) {
        Fenerbahce player1 = Fenerbahce.costlessPlayers("ferhat", 26);
        Fenerbahce player2 = Fenerbahce.costlessPlayers("özge", 23);
        Fenerbahce player3 = Fenerbahce.costlessPlayers("apo", 23);
        Fenerbahce player4 = Fenerbahce.costlessPlayers("defne", 3);

        LinkedList<Fenerbahce> fenerbahceLinkedList = new LinkedList<>(Fenerbahce.getPlayers());
        System.out.println(fenerbahceLinkedList);



    }
}
