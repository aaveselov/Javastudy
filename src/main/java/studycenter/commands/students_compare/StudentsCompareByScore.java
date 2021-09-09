package studycenter.commands.students_compare;

import studycenter.Student;
import studycenter.StudyCenter;
import studycenter.score.ScoreBook;


public class StudentsCompareByScore implements StudentsCompare{

    @Override public int compare(Student student, Student t1) {
        ScoreBook scoreBook = StudyCenter.getScoreBook(student);
        ScoreBook scoreBook1 = StudyCenter.getScoreBook(t1);
        if (null == scoreBook && null == scoreBook1) {
            return 0;
        } else if (null == scoreBook) {
            return -1;
        } else if (null == scoreBook1) {
            return 1;
        } else {
            return -1 * scoreBook.getMaximumPossibleAverage().compareTo(scoreBook1.getMaximumPossibleAverage());
        }
    }

    @Override public String getName() {
        return "sortByPossibleScore";
    }
}