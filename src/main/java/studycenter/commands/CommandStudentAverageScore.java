package studycenter.commands;

import studycenter.StudyCenter;
import studycenter.score.ScoreBook;
import studycenter.validation.ILLegalCommandException;

import java.util.Arrays;
import java.util.Optional;

public class CommandStudentAverageScore implements Command{
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
        System.out.println("student " + StudyCenter.getStudent(studentName) + " study report");
        System.out.println(scoreBook);
        System.out.println("average score " + scoreBook.getAverageScore());
        return Optional.empty();
    }

    @Override public String describeCorrectUsage() {
        return name() + " [student_name]  \t\t\t- current average";
    }

    @Override public String name() {
        return "student-average-score";
    }
}
