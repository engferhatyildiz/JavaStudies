package javastream;

import java.util.Arrays;
import java.util.List;

public class LetterCount {
    public static void main(String[] args) {

        System.out.println(getTotalNumberOfLettersOfNamesLongerThanFive("ferhat", "özgiş", "defne"));
        List<String> names = Arrays.asList("Ali", "Veli", "Selami");
        System.out.println(names);
    }

    //Array elemanlarını al => stream()
    //5'ten uzun isimleri filtreler => filter()
    // Geri kalan listedeki tüm harflerin sayısını getir => mapToInt
    //harf sayıları topla =sum()

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return Arrays.stream(names).filter(name -> name.length() > 5).mapToInt(String::length).sum();

    }
}
