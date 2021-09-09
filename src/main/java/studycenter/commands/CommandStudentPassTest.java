package studycenter.commands;

import studycenter.StudyCenter;
import studycenter.score.Score;
import studycenter.score.ScoreBook;
import studycenter.validation.ILLegalCommandException;

import java.util.Arrays;
import java.util.Optional;

public class CommandStudentPassTest implements Command {
    String studentName;
    Score score;

    @Override public void init(String[] arguments) throws ILLegalCommandException {
        try {
            studentName = arguments[0];
            score = new Score(Integer.valueOf(arguments[1]));
        } catch (IndexOutOfBoundsException e) {
            throw new ILLegalCommandException("no student name, provided " + Arrays.toString(arguments));
        }
    }

    @Override public Optional<Integer> execute() {
        ScoreBook scoreBook = StudyCenter.getScoreBook(studentName);
        scoreBook.testPassed(score);
        System.out.println(StudyCenter.getStudent(studentName));
        return Optional.empty();
    }

    @Override public String describeCorrectUsage() {
        return name() + " [student name] [score 1..100] \t\t\t- register passed test score";
    }

    @Override public String name() {
        return "student-pass-test";
    }
}
