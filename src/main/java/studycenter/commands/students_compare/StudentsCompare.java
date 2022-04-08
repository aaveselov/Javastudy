package studycenter.commands.students_compare;

import studycenter.Student;

import java.util.Comparator;

public interface StudentsCompare extends Comparator<Student> {
    String getName();
}
