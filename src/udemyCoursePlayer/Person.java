package udemyCoursePlayer;

public abstract class Person {
    private String name;
    private String userName;
    private String info;

    public Person(String name, String userName, String info) {
        this.name = name;
        this.userName = userName;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
