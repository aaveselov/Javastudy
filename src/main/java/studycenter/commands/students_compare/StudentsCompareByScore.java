package studycenter.commands.students_compare;

import studycenter.Student;
import studycenter.StudyCenter;
import studycenter.score.ScoreBook;

import java.util.Comparator;

public class StudentsCompareByScore implements StudentsCompare, Comparator<Student> {
    public StudentsCompareByScore() {}

    @Override public int compare(Student student, Student t1) {
        ScoreBook scoreBook = StudyCenter.getScoreBook(student);
        ScoreBook scoreBook1 = StudyCenter.getScoreBook(t1);
        if (null == scoreBook && null == scoreBook1) {
            return 0;
        } else if (null == scoreBook && null != scoreBook1) {
            return -1;
        } else if (null != scoreBook && null == scoreBook1) {
            return 1;
        } else {
            return scoreBook.getAverageScore().compareTo(scoreBook1.getAverageScore());
        }
    }

    @Override public String getName() {
        return "sortByScore";
    }
}