package udemyCoursePlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Student extends Person{
    private ArrayList<Course> attandedCourses;
    private LinkedList<Lecture> watchList;

    public Student(String name, String userName, String info) {
        super(name, userName, info);
        attandedCourses = new ArrayList<>();
        watchList = new LinkedList<>();
    }

    public LinkedList<Lecture> getWatchList() {
        return watchList;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "attandedCourses=" + attandedCourses +
                '}';
    }

    public void attendCourse(Course course) {
        if(course.isCourseActive()){
            course.getCourseStudents().add(this);//this represent who call this method(student)
            attandedCourses.add(course);
            System.out.println(this.getName() + " attended " + course.getCourseName());
        }
        else{
            System.out.println(course.getCourseName() + " Course is not Active! so you can not attend");

        }
    }

    public void addLecturesToWatchList(Lecture lectureToWatchList){
        boolean isLectureFound=false;
        if(attandedCourses.size()>0){
            for(Course temp : attandedCourses){
                if(temp.getCourseLectures().contains(lectureToWatchList)){
                    System.out.println("The " + lectureToWatchList.getLectureTitle() + " added to watchList --> (" +temp.getCourseName()+")");
                    watchList.add(lectureToWatchList);
                    isLectureFound=true;
                    break;
                }
            }
            if(!isLectureFound)
                System.out.println("lecture does not found in attended courses");


        }

    }
}
