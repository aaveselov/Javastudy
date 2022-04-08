package studycenter;

import studycenter.score.ScoreBook;
import studycenter.validation.ILLegalCommandException;

import java.util.Objects;

public class Student {
    private static final int ACADEMIC_HOUR_DURATION = 8;
    private final String name;

    public Student( String name ) {
        this.name = name;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Student))
            return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    @Override public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
