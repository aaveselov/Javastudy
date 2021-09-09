package studycenter.commands;

import studycenter.StudyCenter;
import studycenter.validation.ILLegalCommandException;

import java.util.Arrays;

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

    @Override public void execute() {
        StudyCenter.assignStudentToCourse(studentName,courseName);
    }

    @Override public String describeCorrectUsage() {
        return name() + " <studentName> <courseName>";
    }

    @Override public String name() {
        return "student-assign-to-course";
    }
}
