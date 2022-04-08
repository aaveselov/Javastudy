package studycenter.commands;

import studycenter.StudyCenter;
import studycenter.validation.ILLegalCommandException;

import java.util.Arrays;
import java.util.Optional;

public class CommandStudentAssignToCourse implements Command {
    String studentName;
    String courseName;

    @Override public void init(String[] arguments) throws ILLegalCommandException {
        try {
            studentName = arguments[0];
            courseName = arguments[1];
        } catch (IndexOutOfBoundsException e) {
            throw new ILLegalCommandException(name() + Arrays.toString(arguments));
        }
    }

    @Override public Optional<Integer> execute() {
        StudyCenter.assignStudentToCourse(studentName,courseName);
        return Optional.empty();
    }

    @Override public String describeCorrectUsage() {
        return name() + " <studentName> <courseName>";
    }

    @Override public String name() {
        return "student-assign-to-course";
    }
}
