package ferhatttyildiz;

import java.util.*;
import java.util.stream.Collectors;

public class Studies {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(26,"Ferhat Yıldız"));
        persons.add(new Person(23,"Özge yoldaş"));
        persons.add(new Person(3,"Defne Yıldız"));

        persons.stream().forEach(person -> person.sayHello("ferhat"));
        List<Person> filteredList =persons.stream().filter(person -> person.age>20).collect(Collectors.toList());
        System.out.println(filteredList);






    }
}
