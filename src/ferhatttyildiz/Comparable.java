package ferhatttyildiz;

public class Comparable {
    public static void main(String[] args) {
        Person ferhat = new Person(25,"ferhat yildiz");
        Person emin = new Person(24,"emin dic");

        Person [] persons = {ferhat,emin};
        System.out.println("---- before the compare");
        for (Person temp: persons
             ) {
            System.out.println(temp);

        }


    }
}
class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void sayHello(String name){
        System.out.println("Hii guys"+ name) ;
    }
}


