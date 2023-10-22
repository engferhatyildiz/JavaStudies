package hackerrank.etstur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Employee {
    abstract void setSalary(int salary);

    abstract int getSalary();

    abstract void setGrade(String grade);

    abstract String getGrade();

}

class Engineer extends Employee {
    private int salary;
    private String grade;

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String getGrade() {
        return grade;
    }

    @Override
    public void setGrade(String grade) {
        this.grade = grade;
    }
}

