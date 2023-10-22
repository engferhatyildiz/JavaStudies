package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterator_Examples {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList();
        names.add("yildiz");
        names.add("ferhat");
        names.add("ozge");
        names.add("yoldas");
        System.out.println(names);


        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()){
            String temp = iterator.next();
            if(temp.startsWith("f") && temp.endsWith("at"))
                iterator.remove();
        }
        System.out.println(names);

    }
}
