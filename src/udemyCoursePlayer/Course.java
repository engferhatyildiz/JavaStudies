package udemyCoursePlayer;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<Lecture> courseLectures;
    private ArrayList<Instructor> courseInstructors;

    private ArrayList<Student> courseStudents;

    private boolean isActive;//Course must contains at least 5 Lectures and duration>60min

    public Course(String courseName, Instructor mainInstructor) {
        this.courseName = courseName;
        this.courseLectures = new ArrayList<>();
        this.courseInstructors = new ArrayList<>();
        this.courseStudents = new ArrayList<>();
        courseInstructors.add(mainInstructor);
        this.isActive = false;
    }

    public ArrayList<Student> getCourseStudents() {
        return courseStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public ArrayList<Lecture> getCourseLectures() {
        return courseLectures;
    }

    public void addCourseInstructors(Instructor instructor) {
        if (!courseInstructors.contains(instructor)) {
            courseInstructors.add(instructor);
            System.out.println(instructor.getName() + " Added this course");

        } else
            System.out.println("The instructor already in the course");
    }

    public void deleteCourseInstructor(Instructor instructor) {
        if (instructor.getName().equals(courseInstructors.get(0).getName()))
            System.out.println(instructor.getName() + " The main Instructor can not be deleted!");
        else {
            courseInstructors.remove(instructor);
            System.out.println(instructor.getName() + " Deleted this course");

        }
    }

    public void addCourseLectures(Lecture lecture) {
        courseLectures.add(lecture);
    }

    public void deleteCourseLectures(Lecture lecture) {
        courseLectures.remove(lecture);
    }

    public int countOfLestures() {
        return courseLectures.size();
    }

    private int courseTotalHours() {
        double duration = 0;
        for (Lecture lecture : courseLectures) {
            duration += lecture.getDuration();
        }
        return (int) duration;
    }

    public boolean isCourseActive() {
        if (courseTotalHours() > 60 && courseLectures.size() >= 5) {////Course must contains at least 5 Lectures and duration>60min
            isActive = true;
            return true;
        } else return false;
    }

    public void addStudentToCourse(Student courseStudent) {
        if (isCourseActive())
            courseStudents.add(courseStudent);
    }


}
