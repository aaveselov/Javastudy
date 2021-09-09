package studycenter.commands;

import studycenter.StudyCenter;
import studycenter.score.ScoreBook;
import studycenter.validation.ILLegalCommandException;

import java.util.Arrays;
import java.util.Optional;

public class CommandCanBeDischargedEarlier implements Command {
    String studentName;

    @Override public void init(String[] arguments) throws ILLegalCommandException {
        try {
            studentName = arguments[0];
        } catch (IndexOutOfBoundsException e) {
            throw new ILLegalCommandException("no student name, provided " + Arrays.toString(arguments));
        }
    }

    @Override public Optional<Integer> execute() {
        ScoreBook scoreBook = StudyCenter.getScoreBook(studentName);
        float maximumPossibleAverage = scoreBook.getMaximumPossibleAverage();
        System.out.println(studentName
                                   + " maximum average " + maximumPossibleAverage
        + ". can be discharged now =" + (maximumPossibleAverage < 75) );
        return Optional.empty();
    }

    @Override public String describeCorrectUsage() {
        return name() + " [student_name]  \t\t\t- is there possibility to reach 75 average.";
    }

    @Override public String name() {
        return "student-can-be-discharged-earlier";
    }
}
