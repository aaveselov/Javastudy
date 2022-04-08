package studycenter.commands;

import studycenter.StudyCenter;
import studycenter.score.Score;
import studycenter.score.ScoreBook;
import studycenter.validation.ILLegalCommandException;

import java.util.Arrays;
import java.util.Optional;

public class CommandStudentTimeRemaining implements Command{
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
        System.out.println(studentName + " has to study for " + scoreBook.getTimeRemaining() + " more hous");
        System.out.print(StudyCenter.getStudent(studentName));
        return Optional.empty();
    }

    @Override public String describeCorrectUsage() {
        return name() + " [student_name]  \t\t\t- time to study remains. in hours";
    }

    @Override public String name() {
        return "student-time-remains";
    }
}
