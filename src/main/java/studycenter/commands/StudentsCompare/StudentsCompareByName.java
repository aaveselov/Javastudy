package studycenter.commands.StudentsCompare;

import studycenter.Student;
import studycenter.StudyCenter;
import studycenter.score.ScoreBook;

import java.util.Comparator;


class StudentsCompareByName implements StudentsCompare, Comparator<Student> {
    @Override public int compare(Student student, Student t1) {
        return student.getName().compareTo(t1.getName());
    }

    @Override public String getName() {
        return "sortByName";
    }
}
