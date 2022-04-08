package studycenter;

// start with this link
// https://stackoverflow.com/questions/62989576/how-to-read-from-yaml-file-in-java
// the tutorial
// https://www.baeldung.com/java-snake-yaml

import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import studycenter.commands.Executor;
import studycenter.score.ScoreBook;
import studycenter.studyprogram.Course;
import studycenter.studyprogram.Topic;
import studycenter.validation.ILLegalCommandException;
import studycenter.validation.IllegalInitialDataException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.lang.System.out;

/**
 * contains students, courses and scorebooks
 */

public class StudyCenter {
    private static final Map<String, Student> studentMap = new HashMap<>();
    private static final Map<String, Course> coursesMap = new HashMap<>();
    private static final Map<Student, ScoreBook> scoreBooks = new HashMap<>();

    public static void main(String[] args) {
        initCourses();
        Executor commandListener = new Executor();


        try( InputStream fakeIn = StudyCenter
                .class
                .getClassLoader()
                .getResourceAsStream("testCommands.txt") ) {
            InputStream saveSystemIn = System.in;
            System.setIn(fakeIn);
            commandListener.listen();
            System.setIn(saveSystemIn);
        } catch (IOException e ) {
            out.println("no test data load" + e);
        }

        commandListener.listen();
    }

    public static void addStudent(String studentName) throws ILLegalCommandException {
        if (studentMap.containsKey(studentName)) {
            throw new ILLegalCommandException("addStudent " + studentName + " already study here");
        }
        studentMap.put(studentName, new Student(studentName));
    }

    public static Student getStudent(String studentName) {
        return studentMap.get(studentName);
    }

    public static void removeStudent(String studentName) throws IllegalInitialDataException {
        if (!studentMap.containsKey(studentName)) {
            throw new ILLegalCommandException("removeStudent " + studentName + " does not study here");
        }
        studentMap.remove(studentName);
    }

    public static Stream<Student> getStudents() {
        return studentMap.values().stream();
    }

    public static ScoreBook getScoreBook(Student student) {
        return scoreBooks.get(student);
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
            if (object.getClass() == Course.class) {
                Course course = (Course) object;
                coursesMap.put(course.getName(), course);
            } else {
                throw new IllegalInitialDataException("wrong course description" + object);
            }
        }
        out.println(coursesMap);
    }

    public static void assignStudentToCourse(String studentName, String courseName) {
        if (!studentMap.containsKey(studentName)) {
            throw new ILLegalCommandException(studentName + " does not study here");
        }
        if (!coursesMap.containsKey(courseName)) {
            throw new ILLegalCommandException(courseName + " does not held here");
        }
        Student student = studentMap.get(studentName);
        if (scoreBooks.containsKey(student)) {
            throw new ILLegalCommandException(student + "attend course " + scoreBooks.get(student)
                                                      + ". Can't be moved to course " + courseName);
        }

        Course course = coursesMap.get(courseName);
        scoreBooks.put(student, new ScoreBook(course));
    }

    public static ScoreBook getScoreBook(String studentName) {
        if (!studentMap.containsKey(studentName)) {
            throw new ILLegalCommandException("assignStudentToCourse: " + studentName + " does not study here");
        }
        Student student = studentMap.get(studentName);
        if (!scoreBooks.containsKey(student)) {
            throw new ILLegalCommandException("assignStudentToCourse: student " + student
                                                      + " does not attend any course");
        }
        return scoreBooks.get(student);
    }
}
