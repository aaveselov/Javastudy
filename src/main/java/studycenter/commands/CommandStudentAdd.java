package studycenter.commands;

import studycenter.StudyCenter;
import studycenter.validation.ILLegalCommandException;

import java.util.Arrays;

public class CommandStudentAdd implements Command {
    String studentName;

    @Override public void init(String[] arguments) throws ILLegalCommandException {
        try {
            studentName = arguments[0];
        } catch (IndexOutOfBoundsException e ) {
            throw new ILLegalCommandException( "no student name, provided " + Arrays.toString(arguments));
        }
    }

    @Override public void execute() {
        StudyCenter.addStudent(studentName);
    }

    @Override public String describeCorrectUsage() {
        return  "student-add [student name] \t\t\t- adds student if it does not exist";
    }
}
