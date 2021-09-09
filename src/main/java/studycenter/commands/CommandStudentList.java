package studycenter.commands;

import studycenter.StudyCenter;
import studycenter.validation.ILLegalCommandException;

import java.util.Arrays;

public class CommandStudentList implements Command {

    @Override public void init(String[] arguments) throws ILLegalCommandException {
    }

    @Override public void execute() {
        StudyCenter.listStudents();
    }

    @Override public String describeCorrectUsage() {
        return  name() + "\t\t\t- lists all studied students";
    }

    @Override public String name() {
        return "student-list";
    }
}
