package emrealtunbilek;

import java.util.ArrayList;

public class CollelctionsMethodlari {
    public static void main(String[] args) {
        Student student1 = new Student(1, "ferhat");
        Student student2 = new Student(2, "ozge");
        Student student3 = new Student(3, "defne");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

    }


}

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
