package javastream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DilrubaStreamApi {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Aleyna"));
        users.add(new User(2, "Ahmet"));
        users.add(new User(3, "Zehra"));
        users.add(new User(4, "Murat"));
        users.add(new User(5, "Yıldız"));
        users.add(new User(6, "Levent"));
        users.add(new User(7, "Elvan"));

        users.stream()
                .forEach(user -> {
                    if (user.name.startsWith("A"))
                        System.out.println(user.toString());
                    user.talk();
                });

        // users.stream().forEach(User::talk);//Method reference

        users.stream()
                .filter(user -> user.id > 5)
                .collect(Collectors.toList());


        List<User> mappedList = users.stream()
                .filter(user -> user.id > 5 && user.name.contains("t"))
                .map(user -> new User(user.id + 10, user.name ))
                .collect(Collectors.toList());

        System.out.println(mappedList );

        Map<Integer,String> userMap = users.stream().collect(Collectors.toMap(user ->user.id,user -> user.name));
        System.out.println(userMap.get(3));

    }
}

class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void talk() {
        System.out.println("Hi , I am " + this.name);
    }
}
