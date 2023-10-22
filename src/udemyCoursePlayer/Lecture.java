package udemyCoursePlayer;

public class Lecture {
    private int lectureId;
    private String lectureTitle;
    private double duration;

    public Lecture(int lectureId, String lectureTitle, double duration) {
        this.lectureId = lectureId;
        this.lectureTitle = lectureTitle;
        this.duration = duration;
    }

    public int getLectureId() {
        return lectureId;
    }

    public String getLectureTitle() {
        return lectureTitle;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureId=" + lectureId +
                ", lectureTitle='" + lectureTitle + '\'' +
                ", duration=" + duration +
                '}';
    }
}
