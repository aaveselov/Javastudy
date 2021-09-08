package studycenter;

// start with this link
// https://stackoverflow.com/questions/62989576/how-to-read-from-yaml-file-in-java
// the tutorial
//TODO read and follow
// https://www.baeldung.com/java-snake-yaml

import org.yaml.snakeyaml.TypeDescription;
import studycenter.commands.CommandExecutor;
import studycenter.student.Student;
import studycenter.studyprogram.Course;
import studycenter.studyprogram.Topic;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import studycenter.validation.ILLegalCommandException;
import studycenter.validation.IllegalInitialDataException;

import java.io.InputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.lang.System.*;

public class StudyCenter {
    private static final Map<String, Student> studentMap = new HashMap<>();
    private static final Map<String,Course> coursesMap = new HashMap<>();

    public static void main(String[] args) {
        initCourses();
        CommandExecutor commandListener = new CommandExecutor();
        commandListener.listen();
    }

    public static void addStudent( String studentName ) throws ILLegalCommandException {
        if ( studentMap.containsKey(studentName) ) {
            throw new ILLegalCommandException("Error: student " + studentName + " already study here");
        }
        studentMap.put(studentName, new Student(studentName));
    }

    public static void removeStudent( String studentName ) throws IllegalInitialDataException {
        if ( !studentMap.containsKey(studentName) ) {
            throw new ILLegalCommandException("Error: student " + studentName + " does not study here");
        }
        studentMap.remove(studentName);
    }

    public static void listStudents() {
        listStudents( studentMap.values().stream() );
    }
    public static void listStudents(Comparator<Student> comparator, Predicate<Student> filter ) {
        listStudents( studentMap.values().stream().filter(filter).sorted(comparator));
    }

    private static void listStudents( Stream<Student> studentStream ) {
        studentStream.forEach(out::println);
    }

    private static void initCourses() {
        Constructor constructor = new Constructor(Course.class);
        TypeDescription customTypeDescription = new TypeDescription(Course.class);
        customTypeDescription.addPropertyParameters("topics", Topic.class);
        constructor.addTypeDescription(customTypeDescription);
        Yaml yaml = new Yaml(constructor);
        InputStream inputStream = StudyCenter
                .class
                .getClassLoader()
                .getResourceAsStream("courses.yaml");


        for (Object object : yaml.loadAll(inputStream)) {
            if ( object.getClass() == Course.class ) {
                Course course = (Course) object;
                coursesMap.put( course.getName(), course );
            } else {
                throw new IllegalInitialDataException("wrong course description" + object );
            }
        }
        out.println(coursesMap);
    }
}
