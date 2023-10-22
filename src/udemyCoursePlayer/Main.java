package udemyCoursePlayer;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("student1","student1_udemy","student1's info");
        Instructor emreAltunBilek = new Instructor("Emre","InstructorEmre_udemy","javaCourses");
        Instructor akinKaldiroglu = new Instructor("Akin","Akin_udemy","javaTurk");

        System.out.println(student1);
        System.out.println(emreAltunBilek);

        Lecture lecture1 = new Lecture(1,"Introduction",3.5);
        Lecture lecture2 = new Lecture(2,"What is Java?",9.2);
        Lecture lecture3 = new Lecture(3,"Primitive Types",22.9);
        Lecture lecture4 = new Lecture(4,"Arrays",15.9);
        Lecture lecture5 = new Lecture(5,"Methods",15.7);


        Lecture lecture6 = new Lecture(6,"Objects",15.7);
        Lecture lecture7 = new Lecture(7,"Try Catch",17.4);
        Lecture lecture8 = new Lecture(8,"Recylerview",13.7);
        Lecture lecture9 = new Lecture(9,"Sharedprefences",12.5);
        Lecture lecture10 = new Lecture(10,"Firebase",19.0);

        Course javaCourse = new Course("JAVA FOR ADVANCED",emreAltunBilek);
        javaCourse.addCourseLectures(lecture1);javaCourse.addCourseLectures(lecture2);javaCourse.addCourseLectures(lecture3);javaCourse.addCourseLectures(lecture4);javaCourse.addCourseLectures(lecture5);
        javaCourse.deleteCourseInstructor(emreAltunBilek);
        javaCourse.addCourseInstructors(akinKaldiroglu);
        javaCourse.deleteCourseInstructor(akinKaldiroglu);

        Course androidCourse = new Course("Android Course",emreAltunBilek);
        androidCourse.addCourseLectures(lecture6);androidCourse.addCourseLectures(lecture7);androidCourse.addCourseLectures(lecture8);androidCourse.addCourseLectures(lecture9);androidCourse.addCourseLectures(lecture10);

        student1.attendCourse(javaCourse);
        student1.attendCourse(androidCourse);
        student1.addLecturesToWatchList(lecture6);
        student1.addLecturesToWatchList(lecture2);
        student1.addLecturesToWatchList(lecture8);

        playList(student1.getWatchList());


    }
    public static void playList(LinkedList<Lecture> playListLectures){
        ListIterator<Lecture> iterator = playListLectures.listIterator();
        if(playListLectures.size() == 0)
            System.out.println("there is no lectures in here!");
        else{
            Lecture firstLecture = iterator.next();
            System.out.println("Current Lecture: " +firstLecture.getLectureTitle() + " Duration: "+ firstLecture.getDuration());
        }



    }
}
