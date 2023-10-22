package javastream;

import java.util.*;
import java.util.stream.Collectors;


//Rewrite this garbage using Streams and make sure the test still runs
public class UpperCase {
    public static void main(String[] args) {
        System.out.println(mapToUppercase2("ferhat", "özgiş","defne"));
        System.out.println(mapToUppercase("ferhat", "özgiş","defne"));

    }

    public static Collection<String> mapToUppercase(String... names) {
        Collection<String> uppercaseNames = new ArrayList<>();
        for(String name : names) {
            uppercaseNames.add(name.toUpperCase());
        }
        return uppercaseNames;
    }

    public static Collection<String> mapToUppercase2(String... names) {
       return Arrays.stream(names).map(String::toUpperCase).collect(Collectors.toList());
    }
}
