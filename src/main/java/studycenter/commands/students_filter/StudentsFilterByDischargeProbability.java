package studycenter.commands.students_filter;

import studycenter.Student;
import studycenter.StudyCenter;
import studycenter.score.Score;
import studycenter.score.ScoreBook;

public class StudentsFilterByDischargeProbability implements StudentsFilter {
    @Override public String getName() {
        return "filterCanPass";
    }

    @Override public boolean test(Student o) {
        ScoreBook scoreBook = StudyCenter.getScoreBook(o.getName());
        if (null == scoreBook)
            return true;
        return scoreBook.getMaximumPossibleAverage() >= Score.PASSING_AVERAGE;
    }
}
