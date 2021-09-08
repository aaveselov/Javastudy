package studycenter.student;

import studycenter.student.score.ScoreBook;

public class Student {
    private static int academicDayDuration = 8;
    private String name;
    private ScoreBook scoreBook;

    public Student( String name ) {
        this.name = name;
    }

    @Override public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scoreBook=" + scoreBook +
                '}';
    }
}
