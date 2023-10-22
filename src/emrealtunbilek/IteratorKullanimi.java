package emrealtunbilek;

import java.util.ArrayList;
import java.util.ListIterator;

public class IteratorKullanimi {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("yildiz");
        names.add("ferhat");
        names.add("ozge");
        names.add("yoldas");

        ListIterator<String> listIterator = names.listIterator();

        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

    }
}
