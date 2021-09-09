package studycenter.commands;

import studycenter.StudyCenter;
import studycenter.validation.ILLegalCommandException;

import java.util.Arrays;
import java.util.Optional;

public class CommandStudentAdd implements Command {
    String studentName;

    @Override public void init(String[] arguments) throws ILLegalCommandException {
        try {
            studentName = arguments[0];
        } catch (IndexOutOfBoundsException e ) {
            throw new ILLegalCommandException( "no student name, provided " + Arrays.toString(arguments));
        }
    }

    @Override public Optional<Integer> execute() {
        StudyCenter.addStudent(studentName);
        return Optional.empty();
    }

    @Override public String describeCorrectUsage() {
        return  name() + " <student_name> \t\t\t- adds student if it does not exist";
    }

    @Override public String name() {
        return "student-add";
    }
}
