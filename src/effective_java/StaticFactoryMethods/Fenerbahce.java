package effective_java.StaticFactoryMethods;

import java.util.ArrayList;
import java.util.List;

public class Fenerbahce {
    private String name;
    private int age;
    private double salary;
    private static ArrayList<Fenerbahce> players = new ArrayList<>();

    public Fenerbahce(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        players.add(this);

    }

    public static Fenerbahce costlessPlayers(String name, int age) {
        return new Fenerbahce(name, age, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static ArrayList<Fenerbahce> getPlayers() {
        return players;
    }

    public static void setPlayers(ArrayList<Fenerbahce> players) {
        Fenerbahce.players = players;
    }

    @Override
    public String toString() {
        return "Fenerbahce{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
