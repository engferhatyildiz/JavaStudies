package ferhatttyildiz;

import java.util.HashMap;

public class Management {
    public static void main(String[] args) {
        HashMap<Integer,String> cities = new HashMap<>();
        cities.put(1,"Adana");
        cities.put(21,"Diyarbakir");
        cities.put(31,"Hatay");
        cities.put(35,"Izmir");
        cities.put(34,"Istanbul");

        System.out.println(cities);
        System.out.println(cities.get(34));
        System.out.println(cities.containsKey(45));

    }
}
