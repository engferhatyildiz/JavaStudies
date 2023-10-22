package udemyCoursePlayer;

public class Instructor extends Student{

    public Instructor(String name, String userName, String info) {
        super(name, userName, info);
    }

    @Override
    public String toString() {
        return super.toString()+"Instructor{}";
    }
}
