package studycenter.commands.students_compare;

import studycenter.Student;

import java.util.Comparator;


public class StudentsCompareByName implements StudentsCompare, Comparator<Student> {
    public StudentsCompareByName() {}

    @Override public int compare(Student student, Student t1) {
        return student.getName().compareTo(t1.getName());
    }

    @Override public String getName() {
        return "sortByName";
    }
}
