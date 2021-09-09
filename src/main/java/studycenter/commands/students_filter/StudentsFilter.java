package studycenter.commands.students_filter;

import studycenter.Student;

import java.util.function.Predicate;

public interface StudentsFilter extends Predicate<Student> {
    String getName();
}
